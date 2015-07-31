package com.juzhituan.dao.impl;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.juzhituan.dao.EmployeeDao;
import com.juzhituan.domain.Employee;

@Repository("employeeDao")
public class EmployeeDaoHibernateImpl extends BaseDaoImpl<Employee> implements EmployeeDao
{

	//根据手机号查询
	@Override
	public Employee findEmployee(final String cellphone) 
	{
		return getHibernateTemplate().execute(new HibernateCallback<Employee>()
				{
					@Override
					public Employee doInHibernate(Session session)throws HibernateException
					{
						String hql="from Employee where cellphone=:cellphone ";
						Query query=session.createQuery(hql);
						query.setString("cellphone",cellphone);
						Employee employee=(Employee) query.uniqueResult();
						return employee;
					}
					
				});
	}
	//根据手机号、密码查询用户
	@Override
	public Employee findEmployeeByCellPhone(final String cellphone, final String password) 
	{
		return getHibernateTemplate().execute(new HibernateCallback<Employee>()
				{
					@Override
					public Employee doInHibernate(Session session)throws HibernateException
					{
						String hql="from Employee where cellphone=:cellphone and password=:password";
						Query query=session.createQuery(hql);
						query.setString("cellphone",cellphone);
						query.setString("password",password);
						Employee employee=(Employee) query.uniqueResult();
						return employee;
					}
					
				});
	}
	
	@Override
	public Employee findEmployee(final Integer employeeId, final String password) {
		return getHibernateTemplate().execute(new HibernateCallback<Employee>()
				{
					@Override
					public Employee doInHibernate(Session session)throws HibernateException
					{
						String hql="from Employee where employeeId=:employeeId and password=:password";
						Query query=session.createQuery(hql);
						query.setInteger("employeeId",employeeId);
						query.setString("password",password);
						Employee employee=(Employee) query.uniqueResult();
						return employee;
					}
					
				});
	}
	@Override
	public void updatePassword(final Integer employeeId, final String password) 
	{
		getHibernateTemplate().execute(new HibernateCallback<Void>()
				{
					@Override
					public Void doInHibernate(Session session) throws HibernateException
					{	
						String hql = "update Employee set password =:password where employeeId =:employeeId";
						Query query = session.createQuery(hql);
						query.setString("password", password);
						query.setInteger("employeeId", employeeId);
						query.executeUpdate();
						return null;
					}						
				});				
	}
	@Override
	public void updatePassword(final String cellphone, final String password) 
	{
		getHibernateTemplate().execute(new HibernateCallback<Void>()
				{
					@Override
					public Void doInHibernate(Session session) throws HibernateException
					{	
						String hql = "update Employee set password =:password where cellphone =:cellphone";
						Query query = session.createQuery(hql);
						query.setString("password", password);
						query.setString("cellphone", cellphone);
						query.executeUpdate();
						return null;
					}						
				});
		
	}

	
}
    
