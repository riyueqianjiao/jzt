package com.juzhituan.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juzhituan.dao.LicenseDao;
import com.juzhituan.domain.License;


@Service
public class LicenseService
{
   @Autowired
   private LicenseDao licenseDao;
   
   /*
    *  查询许可证
    * */
   public License getLicense(String licenseNum)
   {
	   return licenseDao.findLicense(licenseNum);
   }
   public License getLicense(String licenseNum,String cellphone)
   {
	   return licenseDao.findLicense(licenseNum,cellphone);
   }
   
   /*
    * 添加许可证
    * */
   public void saveLicense(License license)
   {
	   long time=System.currentTimeMillis();
	   license.setLicenseNum(Long.toString(time));
	   license.setGenerateTime(new Date(time));
	   license.setIsActived((byte) 0);
	   licenseDao.save(license);
   }
   
}
