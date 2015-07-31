package com.juzhituan.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.juzhituan.dao.LicenseDao;
import com.juzhituan.domain.License;


@Repository("licenseDao")
public class LicenseDaoHibernateImpl extends BaseDaoImpl<License> implements LicenseDao
{
	
	@Override
	public License findLicense(final String licenseNum)
	{
		return getHibernateTemplate().execute(new HibernateCallback<License>()
				{
					@Override
					public License doInHibernate(Session session)throws HibernateException
					{
						String hql="from License where licenseNum=:licenseNum";
						Query query=session.createQuery(hql);
						query.setString("licenseNum",licenseNum);
						License license=(License) query.uniqueResult();
						return license;
					}
					
				});
	}

	@Override
	public License findLicense(final String licenseNum, final String cellphone)
	{
		return getHibernateTemplate().execute(new HibernateCallback<License>()
				{
					@Override
					public License doInHibernate(Session session)throws HibernateException
					{
						String hql="from License where licenseNum=:licenseNum and cellphone=:cellphone";
						Query query=session.createQuery(hql);
						query.setString("licenseNum",licenseNum);
						query.setString("cellphone",cellphone);
						License license=(License) query.uniqueResult();
						return license;
					}
				});
	}
}
