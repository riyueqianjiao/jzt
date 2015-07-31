package com.juzhituan.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.juzhituan.constant.Constants;
import com.juzhituan.dao.ActivityDao;
import com.juzhituan.dao.EmployerDao;
import com.juzhituan.dao.PublicationDao;
import com.juzhituan.domain.Employer;
import com.juzhituan.domain.Publication;

@Repository("publicationDao")
public class PublicationDaoHibernateImpl extends BaseDaoImpl<Publication> implements PublicationDao
{
	@Autowired
	private EmployerDao employerDao;
	@Autowired
	private ActivityDao activityDao;
	
  
	/*
	 * 根据Id值来获取某条记录
	 * */
	@Override
	public Publication get(Integer publicationId, Boolean isLazy)
	{
		if (isLazy)
		{
			return get(Publication.class, publicationId);
		}
		else
		{
			Publication publication=get(Publication.class, publicationId);
			publication.setEmployer(employerDao.get(Employer.class, publication.getEmployer().getEmployerId()));
			publication.setActivities(activityDao.find(publicationId,Constants.PUBLICATION_STATE_ACTIVE));
			return publication;	
		}
	}

	

	@Override
	public Boolean update(final Integer publibcationId, final Byte state)
	{
	      return getHibernateTemplate().execute
				(
				   new HibernateCallback<Boolean>()
				   {
					  @Override
					  public Boolean doInHibernate(Session session) throws HibernateException
					  {
						 String hql="update Publication set state=:state where publicationId=:publicationId";
						 Query query=session.createQuery(hql);
						 query.setByte("state",state);
						 query.setInteger("publicationId",publibcationId);
						 int count=query.executeUpdate();
						 if (count==1)
						 {
						   return true;
						 }
						 return false;
					  }
				   }
			    );
	}


	@Override
	public Boolean update(final Integer[] publibcationIds, final Byte state)
	{

	      return getHibernateTemplate().execute
				(
				   new HibernateCallback<Boolean>()
				   {
					  @Override
					  public Boolean doInHibernate(Session session) throws HibernateException
					  {
						 String hql="update Publication set state=:state where publicationId in (";
						 StringBuffer buffer=new StringBuffer();
						 for (int i = 0; i < publibcationIds.length; i++)
						 {
						    buffer.append(publibcationIds+",");	
						 }
						 int index=buffer.length()-1;
						 buffer.replace(index,index,")");
						 hql+=buffer.toString();
						 Query query=session.createQuery(hql);
						 query.setByte("state",state);
						 int count=query.executeUpdate();
						 if (count==publibcationIds.length)
						 {
						   return true;
						 }
						 return false;
					  }
				   }
			    );
	}

	
    
	/*
	 * 获取符合指定条件的记录总数 
	 * */
	private Long getNum(final String hql)
	{
		return getHibernateTemplate().execute
				(
				   new HibernateCallback<Long>()
				   {
					  @Override
					  public Long doInHibernate(Session session) throws HibernateException
					  {
						 Query query=session.createQuery(hql);
						 query.setCacheable(true);
						 return (Long) query.uniqueResult();
					  }
				   }
			    );
	}
	
	
	/*
	 * 获取指定地区、工作类型和关键字的记录总数
	 * */
	@Override
	public Long getTotalNum(final String area, final Byte workType, final String searchKey)
	{
		
		return getHibernateTemplate().execute
				(
				   new HibernateCallback<Long>()
				   {
					  @Override
					  public Long doInHibernate(Session session) throws HibernateException
					  {
						  String hql= "select count(*) from Publication where state=0 and workAddress like :workAddress";
						  if (workType!=null)
						  {
								hql="select count(*) from Publication where state=0 and workAddress like :workAddress and workType=:workType";
						  }
						  if (searchKey!=null)
						  {
								hql="select count(*) from Publication where state=0 and workAddress like :workAddress and (title like :title or companyName like :companyName)";
						  }
						  if (workType!=null && searchKey!=null)
						  {
							  	hql="select count(*) from Publication where state=0 and workAddress like :workAddress and workType=:workType and (title like :title or companyName like :companyName)";
						  }
						 Query query=session.createQuery(hql);
						 query.setString("workAddress", area+"%");
						 if (workType!=null)
						 {
							query.setByte("workType",workType);
						 }
						 if (searchKey!=null)
						 {
						   query.setString("title", "%"+searchKey+"%");
						   query.setString("companyName","%"+searchKey+"%");
						 }
						 if (workType!=null && searchKey!=null)
						 {
							 query.setByte("workType",workType);
							 query.setString("title", "%"+searchKey+"%");
							 query.setString("companyName","%"+searchKey+"%");
						 }
						 query.setCacheable(true);
						 return (Long) query.uniqueResult();
					  }
				   }
			    );
	  }	
	
     /*
      * 分页查找
      * */
	    @SuppressWarnings("unchecked")
		public List<Publication> findByPage(final String hql,final Integer pageNum)
		{
			return getHibernateTemplate().execute
					(
					   new HibernateCallback<List<Publication>>()
					   {
						  @Override
						  public List<Publication> doInHibernate(Session session) throws HibernateException
						  {
							  Query query = session.createQuery(hql);
							  query.setCacheable(true);
						      query.setFirstResult((pageNum-1)*Constants.PAGE_Size);
						      query.setMaxResults(Constants.PAGE_Size);
						      return (List<Publication>)query.list();
						  }
					   }
				    );
		}

	
	/*
	 * 分页查找指定地区、工作类型和关键字的记录
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<Publication> findByPage(final String area, final Byte workType,final String searchKey, final Integer pageNum, final Byte orderType)
	{
		
		return getHibernateTemplate().execute
				(
				   new HibernateCallback<List<Publication>>()
				   {
					@Override
					  public List<Publication> doInHibernate(Session session) throws HibernateException
					  {
						  String hql="from Publication where state=0 and workAddress like :workAddress";
						  if (workType!=null)
						  {
							  hql="from Publication where state=0 and workAddress like :workAddress and workType=:workType";
						  }
						  if (searchKey!=null)
						  {
							  hql="from Publication where state=0 and workAddress like :workAddress and (title like :title or companyName like :companyName)";
						  }
						  if (workType!=null && searchKey!=null)
						  {
							  hql="from Publication where state=0 and workAddress like :workAddress and workType=:workType and (title like :title or companyName like :companyName)";
						  }
						  if (orderType==Constants.ORDER_BY_PUBLICATION_TIME)
						  {
							hql+=" order by publicationTime desc";
						  }
						  else if (orderType==Constants.ORDER_BY_START_DATE)
						  {
							 hql+=" order by startDate asc";
						  }
						  else if (orderType==Constants.ORDER_BY_SALARY)
						  {
							 hql+=" order by salary desc";
						  }
						  else if (orderType==Constants.ORDER_BY_WORKDURATION)
						  {
							 hql+="order by workDuration asc";
						  }
						  else
						  {
							  hql+=" order by publicationTime desc";
						  }
						  Query query = session.createQuery(hql);
						  query.setString("workAddress",area+"%");
						  if (workType!=null)
						  {
							 query.setByte("workType",workType);
						  }
						  if (searchKey!=null)
						  {
							 query.setString("title", "%"+searchKey+"%");
							 query.setString("companyName","%"+searchKey+"%");
						  }
						  if (workType!=null && searchKey!=null)
						  {
							  query.setByte("workType",workType);
							  query.setString("title", "%"+searchKey+"%");
							  query.setString("companyName","%"+searchKey+"%");
						  }
						  query.setCacheable(true);
					      query.setFirstResult((pageNum-1)*Constants.PAGE_Size);
					      query.setMaxResults(Constants.PAGE_Size);
					      return (List<Publication>)query.list();
					  }
				   }
			    );
	}

	
	
	
	/*
	 * 获取指定用户和发布状态的记录总数
	 * */
	@Override
	public Long getTotalNum(Integer employerId,Byte state)
	{
		String hql=null;
		if (state==Constants.PUBLICATION_STATE_CANCELED)
		{
		   hql="select count(*) from Publication where employerId="+employerId+" and state in (2,3)";
		}
		else
		{
			hql = "select count(*) from Publication where employerId="+employerId+" and state="+state;
		}
		return getNum(hql);
	}

	
	/*
	 * 分页获取指定用户和发布状态的记录
	 * */
	@Override
	public List<Publication> findByPage(Integer employerId, Integer pageNum,Byte orderType, Byte state)
	{
	    String order=null;
	    if (orderType==Constants.ORDER_BY_START_DATE)
		{
	    	order=" order by startDate asc ";
		}
	    if (orderType==Constants.ORDER_BY_PUBLICATION_TIME)
		{
	    	order=" order by publicationTime desc ";
		}
	    else if (orderType==Constants.ORDER_BY_SALARY)
		{
			order=" order by salary asc";
		}
		else if (orderType==Constants.ORDER_BY_WORKDURATION)
		{
			order=" order by workDuration asc";
		}
		else
		{
			order=" order by startDate asc ";
		}
	    
	    String hql=null;
	    if (state==Constants.PUBLICATION_STATE_CANCELED)
		{
		    hql="from Publication where employerId="+employerId+" and state in (2,3)"+order;	
		}
	    else
	    {
	    	hql="from Publication where employerId="+employerId+" and state="+state+order;
		}
		return findByPage(hql, pageNum);
	}
	
	
	/*
	 * 根据publicationId和employerId来获取发布记录
	 * */
	@Override
	public Publication get(final Integer employerId, final Integer publicationId,final Boolean isLazy)
	{
		
		return getHibernateTemplate().execute(new HibernateCallback<Publication>()
		{

			@Override
			public Publication doInHibernate(Session session)throws HibernateException
			{
				String hql="from Publication where publicationId=:publicationId and employerId=:employerId ";
				Query query=session.createQuery(hql);
				query.setInteger("publicationId", publicationId);
				query.setInteger("employerId", employerId);
				Publication publication=(Publication) query.uniqueResult();
				if (!isLazy&&publication!=null)
				{
				   publication.setActivities(activityDao.find(publicationId,Constants.PUBLICATION_STATE_ACTIVE));
				}
				return publication;
			}
		});
	} 
	
	
	@Override
	public Long getTotalNum(Integer employeeId) {
		String hql = "select count(distinct pu) from Publication pu,Activity a,Participation pa" +
				" where pa.activity = a.activityId and" +
				" a.publication = pu.publicationId and" +
				" pa.employee ="+employeeId;
		return getNum(hql);
	}


	@Override
	public List<Publication> findByPage(Integer employeeId, Integer pageNum) {
		String hql = "select distinct pu from Publication pu,Activity a,Participation pa" +
				" where pa.activity = a.activityId and" +
				" a.publication = pu.publicationId and" +
				" pa.employee ="+employeeId+
				" order by a.workDate desc";
		return findByPage(hql, pageNum);
	}


	@Override
	public Long getIsDoneTotalNum(Integer employeeId) {
		String hql = "select count(distinct pu) from Publication pu,Activity a,Participation pa" +
				" where pa.activity = a.activityId and" +
				" a.publication = pu.publicationId and" +
				" pa.employee ="+employeeId +
				" and pu.state = 4";
		return getNum(hql);
	}
	
	
	@Override
	public List<Publication> findIsDoneByPage(Integer employeeId,
			Integer pageNum) {
		String hql = "select distinct pu from Publication pu,Activity a,Participation pa" +
				" where pa.activity = a.activityId and" +
				" a.publication = pu.publicationId and" +
				" pa.employee ="+employeeId +
				" and pu.state = 4"+
				" order by a.workDate desc";
		return findByPage(hql, pageNum);
	}

	

}
