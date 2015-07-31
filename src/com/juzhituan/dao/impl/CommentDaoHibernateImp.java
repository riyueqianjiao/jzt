package com.juzhituan.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.juzhituan.constant.Constants;
import com.juzhituan.dao.CommentDao;
import com.juzhituan.domain.Comment;

@Repository("commentDao")
public class CommentDaoHibernateImp extends BaseDaoImpl<Comment> implements CommentDao
{

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
     * 分页查找
     * */
	    @SuppressWarnings("unchecked")
		public List<Comment> findByPage(final String hql,final Integer pageNum)
		{
			return getHibernateTemplate().execute
					(
					   new HibernateCallback<List<Comment>>()
					   {
						  @Override
						  public List<Comment> doInHibernate(Session session) throws HibernateException
						  {
							  Query query = session.createQuery(hql);
							  query.setCacheable(true);
						      query.setFirstResult((pageNum-1)*Constants.PAGE_Size);
						      query.setMaxResults(Constants.PAGE_Size);
						      return (List<Comment>)query.list();
						  }
					   }
				    );
		}
	    @SuppressWarnings("unchecked")
		public List<Object[]> findByPageNum(final String hql,final Integer pageNum)
		{
			return getHibernateTemplate().execute
					(
					   new HibernateCallback<List<Object[]>>()
					   {
						  @Override
						  public List<Object[]> doInHibernate(Session session) throws HibernateException
						  {
							  Query query = session.createQuery(hql);
							  query.setCacheable(true);
						      query.setFirstResult((pageNum-1)*Constants.PAGE_Size);
						      query.setMaxResults(Constants.PAGE_Size);
						      return (List<Object[]>)query.list();
						  }
					   }
				    );
		}
	@Override
	public Comment findComment(final Integer employeeId,final Integer publicationId)
	{
		return getHibernateTemplate().execute(new HibernateCallback<Comment>()
				{
					@Override
					public Comment doInHibernate(Session session)throws HibernateException
					{
						String hql="from Comment where employee=:employeeId and publication=:publicationId";
						Query query=session.createQuery(hql);
						query.setInteger("employeeId",employeeId);
						query.setInteger("publicationId",publicationId);
						Comment comment=(Comment) query.uniqueResult();
						return comment;
					}					
				});
	}

	@Override
	public Long getTotalNum(Integer employerId) 
	{
		String hql = "select count(*) from Comment c,Publication p where c.publication = p.publicationId" +
				" and p.employer = "+employerId;
		return getNum(hql);
	}

	@Override
	public List<Comment> fingCommentBypage(Integer employerId, Integer pageNum) 
	{
		String hql = "select c from Comment c,Publication p where c.publication = p.publicationId" +
				" and p.employer = "+employerId;
		return findByPage(hql, pageNum);
	}
	@Override
	public List<Object[]> findCommentByEmployeeId(Integer employerId, Integer pageNum) 
	{
		String hql = "select e.cellphone,c.workPoint,c.salaryPoint,c.other from Comment c,Publication p,Employee e where c.publication = p.publicationId" +
				" and e.employeeId =c.employee and p.employer = "+employerId;
		return findByPageNum(hql, pageNum);
	}
}
