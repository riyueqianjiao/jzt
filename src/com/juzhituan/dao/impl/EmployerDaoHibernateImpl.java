package com.juzhituan.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.juzhituan.dao.EmployerDao;
import com.juzhituan.domain.Employer;


@Repository("employerDao")
public class EmployerDaoHibernateImpl extends BaseDaoImpl<Employer> implements EmployerDao
{
	
    /*
     *   查询字段:用户名、密码
     * */
	@Override
	public Employer findEmployer(final String employerName, final String password)
	{
	
		return getHibernateTemplate().execute(new HibernateCallback<Employer>()
				{
					@Override
					public Employer doInHibernate(Session session)throws HibernateException
					{
						String hql="from Employer where employerName=:employerName and password=:password";
						Query query=session.createQuery(hql);
						query.setString("employerName",employerName);
						query.setString("password",password);
						Employer employer=(Employer) query.uniqueResult();
						return employer;
					}
				});
	}
   
	@Override
	public Employer findEmployerByCellPhone(final String cellphone, final String password)
	{
		  return getHibernateTemplate().execute(new HibernateCallback<Employer>()
				{
					@Override
					public Employer doInHibernate(Session session)throws HibernateException
					{
						String hql="from Employer where cellphone=:cellphone and password=:password";
						Query query=session.createQuery(hql);
						query.setString("cellphone",cellphone);
						query.setString("password",password);
						Employer employer=(Employer) query.uniqueResult();
						return employer;
					}
				});
	}

	@Override
	public Employer findEmployer(final Integer employerId, final String password)
	{
		
		 return getHibernateTemplate().execute(new HibernateCallback<Employer>()
				 {
					@Override
					public Employer doInHibernate(Session session)throws HibernateException
					{
						String hql="from Employer where employerId=:employerId and password=:password";
						Query query=session.createQuery(hql);
						query.setInteger("employerId",employerId);
						query.setString("password",password);
						Employer employer=(Employer) query.uniqueResult();
						return employer;
					}
				});
	}
	@Override
	public boolean findEmployerByLicenseNum(final String licenseNum) 
	{
		return getHibernateTemplate().execute(new HibernateCallback<Boolean>()
				{
					@Override
					public Boolean doInHibernate(Session session)throws HibernateException
					{
						String hql="select count(*) from Employer where licenseNum=:licenseNum";
						Query query=session.createQuery(hql);
						query.setString("licenseNum",licenseNum);
						Long count=(Long)query.uniqueResult();
					    if (count==1)
						{
							return true;
						}
						return false;
					}
				});
	}
	
	@Override
	public void updateEmployer(final Integer employerId, final String cellphone,final String email)
	{
		 getHibernateTemplate().execute(new HibernateCallback<Employer>()
				  {
						@Override
						public Employer doInHibernate(Session session)throws HibernateException
						{
							String hql="update Employer set cellphone=:cellphone,email=:email where employerId=:employerId";
							Query query=session.createQuery(hql);
							query.setInteger("employerId",employerId);
							query.setString("cellphone",cellphone);
							query.setString("email",email);
							query.executeUpdate();
							return null;
					   }
				});
	}

	
	@Override
	public void updateEmployer(final Integer employerId, final String password)
	{
		 getHibernateTemplate().execute(new HibernateCallback<Employer>()
			  {
					@Override
					public Employer doInHibernate(Session session)throws HibernateException
					{
						String hql="update Employer set password=:password where employerId=:employerId";
						Query query=session.createQuery(hql);
						query.setInteger("employerId",employerId);
						query.setString("password",password);
						query.executeUpdate();
						return null;
				   }
			});
	}

	@Override
	public boolean existEmployer(final String employerName)
	{
		return getHibernateTemplate().execute(new HibernateCallback<Boolean>()
		{

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException
			{
				String hql = "select count(*) from Employer where employerName=:employerName";
				Query query=session.createQuery(hql);
				query.setString("employerName",employerName);
			    Long count=(Long)query.uniqueResult();
			    if (count==1)
				{
					return true;
				}
				return false;
			}
		});
	}

	@Override
	public boolean existEmployerByCellphone(final String cellphone) 
	{
		return getHibernateTemplate().execute(new HibernateCallback<Boolean>()
		{

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException
			{
				String hql = "select count(*) from Employer where cellphone=:cellphone";
				Query query=session.createQuery(hql);
				query.setString("cellphone",cellphone);
			    Long count=(Long)query.uniqueResult();
			    if (count==1)
				{
					return true;
				}
				return false;
			}
		});
	}

	@Override
	public void updateEmployer(final String cellphone,final String password) 
	{
		 getHibernateTemplate().execute(new HibernateCallback<Employer>()
				  {
						@Override
						public Employer doInHibernate(Session session)throws HibernateException
						{
							String hql="update Employer set password=:password where cellphone=:cellphone";
							Query query=session.createQuery(hql);
							query.setString("cellphone",cellphone);
							query.setString("password",password);
							query.executeUpdate();
							return null;
					   }
				});
		}



	
	
}
