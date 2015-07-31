package com.juzhituan.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.juzhituan.constant.Constants;
import com.juzhituan.dao.ActivityDao;
import com.juzhituan.domain.Activity;

@Repository("activityDao")
public class ActivityDaoHibernateImpl  extends BaseDaoImpl<Activity> implements ActivityDao
{
	
	@Override
	public void save(final List<Activity> list)
	{
	   getHibernateTemplate().execute
	   ( new HibernateCallback<Activity>()
		  {
			@Override
			public Activity doInHibernate(Session session)throws HibernateException
			{
				for (Activity activity : list)
				{
				  session.save(activity);
				}
				session.flush();
				session.clear();
				return null;
			}
			   
		  }
	 );
  }
 

	@Override
	public Activity get(Integer activityId) 
	{
		return get(Activity.class,activityId);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> find(Integer publicationId,Byte state)
	{
		String hql="from Activity where publicationId=:publicationId and state=:state order by workDate asc";
		List<Activity> activities=(List<Activity>) getHibernateTemplate().findByNamedParam(hql, new String[]{
		"publicationId","state"},new Object[]{publicationId,state});
		return activities;
	}
	
	
	@Override
	public void update(final Integer publicationId, final Integer[] activityIds,final Byte state)
	{
		
		getHibernateTemplate().execute(new HibernateCallback<Void>()
		{
			@Override
			public Void doInHibernate(Session session) throws HibernateException
			{
				StringBuffer buffer=new StringBuffer();
				buffer.append("(");
				for (int i = 0; i<activityIds.length; i++)
				{
				   buffer.append(activityIds[i]+",");
				}
				int endIndex=buffer.length()-1;
				buffer.replace(endIndex, endIndex, ")");
				
				String hql="update Activity set state=:state where publicationId=:publicationId and activityId in "+buffer.toString();
				Query query=session.createQuery(hql);
				query.setByte("state",state);
				query.setInteger("publicationId", publicationId);
				query.executeUpdate();
				return null;
			}
			
		});
		
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> findByActivityIds(Integer[] activityIds) 
	{
		String sql = "from Activity where activityId =?";
		Object[] object = new Object[activityIds.length];
		object[0] = activityIds[0];
		for(int i=1;i<activityIds.length;i++)
		{
			sql+=" or activityId =?";
			object[i]=activityIds[i];
		}
		return (List<Activity>)getHibernateTemplate().find(sql, object);	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> find(final Integer employeeId, final Integer publicationId) 
	{		
		return getHibernateTemplate().execute(new HibernateCallback<List<Activity>>() {
			@Override
			public List<Activity> doInHibernate(Session session) throws HibernateException {								
				String sql = "select a from Activity a,Participation p" +
						" where p.activity = a.activityId and" +
						" p.employee="+employeeId+" and"+
						" a.publication="+publicationId;
				Query query=session.createQuery(sql);
				List<Activity> avtivities =(List<Activity>)query.list();
				return avtivities;
			}
		});
				
	}

	@Override
	public void update(final Integer activityId,final Short applyNum,final Short applyNumM)
	{
		getHibernateTemplate().execute(new HibernateCallback<Void>()
				{
					@Override
					public Void doInHibernate(Session session) throws HibernateException
					{	
						String hql="update Activity set applyNum=:applyNum,applyNumM=:applyNumM where activityId=:activityId";
						Query query=session.createQuery(hql);	
						query.setShort("applyNum",applyNum);
						query.setShort("applyNumM",applyNumM);
						query.setInteger("activityId",activityId);
						query.executeUpdate();
						return null;
					}						
				});	
	}

	@Override
	public void updateForMan(final Integer[] activityIdInts,final byte type)
	{
		getHibernateTemplate().execute(new HibernateCallback<Void>()
				{
					@Override
					public Void doInHibernate(Session session) throws HibernateException
					{	
						String hql = null;
						if(type == Constants.SIGNUP)
						{
							hql = "update Activity set applyNum=(applyNum+1),applyNumM=(applyNumM+1) where activityId in (";
						}else
						{
							hql = "update Activity set applyNum=(applyNum-1),applyNumM=(applyNumM-1) where activityId in (";
						}		
						for(int i=0;i<activityIdInts.length-1;i++)
						{
							hql+=activityIdInts[i];			
							hql+=",";
						}
						hql+=activityIdInts[activityIdInts.length-1];	
						hql+=")";
						Query query=session.createQuery(hql);	
						query.executeUpdate();
						return null;
					}						
				});	
	}

	@Override
	public void updateForOthers(final Integer[] activityIdInts,final byte type) 
	{
		getHibernateTemplate().execute(new HibernateCallback<Void>()
				{
					@Override
					public Void doInHibernate(Session session) throws HibernateException
					{	
						String hql = null;
						if(type == Constants.SIGNUP)
						{
							hql="update Activity set applyNum=(applyNum+1) where activityId in (";
						}else
						{
							hql="update Activity set applyNum=(applyNum-1) where activityId in (";
						}
						for(int i=0;i<activityIdInts.length-1;i++)
						{
							hql+=activityIdInts[i];			
							hql+=",";
						}
						hql+=activityIdInts[activityIdInts.length-1];	
						hql+=")";
						Query query=session.createQuery(hql);	
						query.executeUpdate();
						return null;
					}						
				});	
		
	}
}
