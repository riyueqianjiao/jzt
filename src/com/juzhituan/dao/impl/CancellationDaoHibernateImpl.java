package com.juzhituan.dao.impl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.juzhituan.dao.CancellationDao;
import com.juzhituan.domain.Cancellation;

@Repository("cancellationDao")
public class CancellationDaoHibernateImpl  extends BaseDaoImpl<Cancellation> implements CancellationDao
{

	@Override
	public void save(final List<Cancellation> list)
	{
		 getHibernateTemplate().execute
		   ( 
			  new HibernateCallback<Void>()
			  {
				@Override
				public Void doInHibernate(Session session)throws HibernateException
				{
					for (Cancellation cancellation :list)
					{
					  session.save(cancellation);
					}
					session.flush();
					session.clear();
					return null;
				}
				   
			  }
		 );
	}
   
}
