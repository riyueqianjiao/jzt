package com.juzhituan.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juzhituan.dao.EmployerDao;
import com.juzhituan.dao.LicenseDao;
import com.juzhituan.domain.Employer;
import com.juzhituan.domain.License;
import com.juzhituan.util.EncryptionUtil;
import java.util.Date;

@Service
public class EmployerService
{
   @Autowired
   private LicenseDao licenseDao;
   @Autowired
   private EmployerDao employerDao;
   
  
    /*
     * 查询商家是否存在
     * */
   public boolean isEmployerExisted(String employerName)
   {
	   return employerDao.existEmployer(employerName);
   }
   public boolean isLicenseNumUsed(String licenseNum)
   {
	   return employerDao.findEmployerByLicenseNum(licenseNum);
   }
   public boolean isExisted(String cellphone)
   {
	   return employerDao.existEmployerByCellphone(cellphone);
   }
   
   /*
    * 查询商家
    * */
   public Employer getEmployer(Integer employerId)
   {
	   return employerDao.get(Employer.class,employerId);
   }
   
   public Employer getEmployer(Integer employerId,String password)
   {
	   return employerDao.findEmployer(employerId,EncryptionUtil.MD5(password));
   }
   
   /*
    * 按商家名或手机查询
    * */
   public Employer getEmployerByNameOrCellphone(String id,String password)
   {
	   Employer employer=employerDao.findEmployer(id, EncryptionUtil.MD5(password));
	   if(employer==null)
	   {
		   employer=employerDao.findEmployerByCellPhone(id, EncryptionUtil.MD5(password));
	   }
	   return employer;
   }
   
   /*
    * 添加商家
    * */
   public void saveEmployer(Employer employer,License license)
   {
	   //注册时间、密码加密、更新许可证
	   long time=System.currentTimeMillis();
	   employer.setRegisterTime(new Date(time));
	   employer.setPassword(EncryptionUtil.MD5(employer.getPassword()));
	   employer.setRecruitmentTime(0);
	   employerDao.save(employer);
	   license.setIsActived((byte) 1);
	   licenseDao.update(license);
   }
   
   /*
    * 更新商家
    * */
   public void updateEmployer(Employer employer)
   {
	   employerDao.update(employer);
   }
   
   public void updateEmployer(Integer employerId,String password)
   {
	   employerDao.updateEmployer(employerId, EncryptionUtil.MD5(password));
   }
   public void updateEmployer(String cellphone,String password)
   {
	   employerDao.updateEmployer(cellphone, EncryptionUtil.MD5(password));
   }
   public void updateEmployer(Integer employerId,String cellphone,String email)
   {
	   employerDao.updateEmployer(employerId,cellphone,email);
   }
}
