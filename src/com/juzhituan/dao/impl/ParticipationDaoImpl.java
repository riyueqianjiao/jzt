package com.juzhituan.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.juzhituan.dao.ParticipationDao;
import com.juzhituan.domain.Participation;

@Repository("ParticipationDao")
public class ParticipationDaoImpl extends BaseDaoImpl<Participation> implements ParticipationDao
{

	@SuppressWarnings("unchecked")
	@Override
	public List<Participation> findParticipationByEmployeeId(Integer employeeId) 
	{
		String sql="from Participation where employeeId=:employeeId ";
		List<Participation> participations=(List<Participation>) getHibernateTemplate().
				findByNamedParam(sql,"employeeId",employeeId);
		return participations;
	}

	
	public Participation findParticipationByActivityId(final Integer employeeId,final Integer activityId) 
	{
		return getHibernateTemplate().execute(new HibernateCallback<Participation>()
				{
					@Override
					public Participation doInHibernate(Session session)throws HibernateException
					{
						String hql="from Participation where employeeId=:employeeId and activityId=:activityId ";
						Query query=session.createQuery(hql);
						query.setInteger("employeeId",employeeId);
						query.setInteger("activityId",activityId);
						Participation participation=(Participation) query.uniqueResult();
						return participation;
					}
					
				});
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Participation> findParticipationByWorkDate(Date workDate) 
	{
		String sql="select p from Participation p,Activity a where p.activity = a.activityId and workDate=?";
		return (List<Participation>) getHibernateTemplate().find(sql,workDate);		
	}


	@Override
	public Long findParticipationByWorkDates(final Integer employeeId,final Date[] workDates) 
	{
		return getHibernateTemplate().execute
				(
				   new HibernateCallback<Long>()
				   {
					  @Override
					  public Long doInHibernate(Session session) throws HibernateException
					  {
						  String hql = "select count(p) from Participation p,Activity a where p.activity = a.activityId and p.employee = "+employeeId+ " and (workDate=?"; 
						  for(int i=1;i<workDates.length;i++)
							{
							  	hql+=" or workDate =?";
							}
						  	hql+=")";
						  Query query=session.createQuery(hql);						  
						  for(int i=0;i<workDates.length;i++)
						  {
							  query.setDate(i, workDates[i]);
						  }
						  query.setCacheable(true);						  
						  return (Long) query.uniqueResult();
					  }
				   }
			    );

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Participation> findParticipationByActivityId(
			final Integer employeeId, final Integer[] activityIds) 
	{
		return getHibernateTemplate().execute(new HibernateCallback<List<Participation>>()
				{
					@Override
					public List<Participation> doInHibernate(Session session)throws HibernateException
					{
						String hql="from Participation where employeeId=:employeeId and activityId in (";
						for(int i=0;i<activityIds.length-1;i++)
						{
							hql+=activityIds[i];
							hql+=",";
						}
						hql+=activityIds[activityIds.length-1];	
						hql+=")";
						Query query=session.createQuery(hql);
						query.setInteger("employeeId",employeeId);
						List<Participation> participations=(List<Participation>)query.list();
						return participations;
					}
					
				});
	}


	@Override
	public void save(final List<Participation> participations)
	{
		getHibernateTemplate().execute
		   ( new HibernateCallback<Void>()
			  {

				@Override
				public Void doInHibernate(Session session)throws HibernateException
				{
					for (Participation participation : participations)
					{
					  session.save(participation);
					}
					session.flush();
					session.clear();
					return null;
				}				   
			  }
		 );
		
	}


	@Override
	public void deleteAll(final List<Participation> participations) 
	{
		getHibernateTemplate().deleteAll(participations);
		
	}

	

}
