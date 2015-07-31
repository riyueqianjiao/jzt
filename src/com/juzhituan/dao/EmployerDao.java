package com.juzhituan.dao;


import com.juzhituan.domain.Employer;

public interface EmployerDao extends BaseDao<Employer>
{
	public boolean  existEmployer(String employerName);
	public Employer findEmployer(Integer employerId,String password);
	public Employer findEmployer(String employerName,String password);
	public Employer findEmployerByCellPhone(String cellphone,String password);
	public boolean findEmployerByLicenseNum(String licenseNum);
	public boolean  existEmployerByCellphone(String cellphone);
	
	public void updateEmployer(Integer employerId,String password);
	public void updateEmployer(String cellphone,String password);
	public void updateEmployer(Integer employerId,String cellphone,String email);
}
