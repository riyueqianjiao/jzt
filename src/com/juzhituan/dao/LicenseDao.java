package com.juzhituan.dao;


import com.juzhituan.domain.License;

public interface LicenseDao extends BaseDao<License>
{
	public License findLicense(String licenseNum);
	public License findLicense(String licenseNum,String cellphone);
}
