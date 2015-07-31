package com.juzhituan.validator;

import java.util.HashMap;
import java.util.Map;

import com.juzhituan.domain.Employer;
import com.juzhituan.util.StringUtil;

public class EmployerValidator
{
	
	public static Map<String,String> validation(Employer instance)
	{
		  Map<String,String> error=new HashMap<String, String>();
		  String companyName=instance.getCompanyName();
		  String contactName=instance.getContactName();
		  String companyPhone=instance.getCompanyPhone();
		  String cellphone=instance.getCellphone();
		  String city=instance.getCity();
		  String companyAddress=instance.getCompanyAddress();
		  String companyInfo=instance.getCompanyInfo();
		  String employerName=instance.getEmployerName();
		  String password=instance.getPassword();
		  
		  
		  //公司名称
		  if(companyName==null||companyName.isEmpty())
		   {
			  error.put("companyName","公司名称不能为空");
		   }
		  else
		  {
			  companyName=companyName.trim();
			  if (companyName.isEmpty())
			  {
				 error.put("companyName","公司名称不能为空");
			  }
		  }
		  //联系人
		  if (contactName==null||contactName.isEmpty())
		  {
			  error.put("contactName", "联系人不能为空");
		  }
		  else
		  {
			 contactName=contactName.trim();
			 if(contactName.isEmpty())
			 {
			    error.put("contactName", "联系人不能为空");
			 }
		  }
		  
		  //座机
		 if (companyPhone==null)
		 {
			 error.put("companyPhone", "联系电话为空");
		 }
		 else
		 {
		    companyPhone=companyPhone.trim();
		    if (companyPhone.isEmpty())
			{
		       error.put("companyPhone", "联系电话为空");
			}
		    else
		    {
		       int length=companyPhone.length();
			   if (length<12||length>13)
			    {
				   error.put("companyPhone", "联系电话错误,请检查格式是否正确，正确的格式如:021-12345678");
				}
			   else
			    {
				   int index=companyPhone.indexOf('-');
				   int zoneCodeLen=companyPhone.substring(0,index).length();
				   int numberLen=companyPhone.substring(index+1).length();
				   if (zoneCodeLen<3||zoneCodeLen>4||numberLen<7||numberLen>8)
				   {
					   error.put("companyPhone", "联系电话错误,请检查格式是否正确，正确的格式如:021-12345678");
				   }
			    }
			}
		}
		 
		 //手机号
		 if (cellphone==null||!StringUtil.isCellphone(cellphone))
		 {
			  error.put("cellPhone","手机号错误");
		 }
		 
		 //城市
		 if(city==null||city.isEmpty())
		  {
			 error.put("city","公司所在城市为空");   
		  }
		 else 
		 {
			city=city.trim();
			if (city.isEmpty())
			{
			  error.put("city","公司所在城市为空");   
			}
		 }
		 //公司地址
		 if (companyAddress==null||companyAddress.isEmpty())
		 {
			error.put("companyAddress","公司地址为空");
		 }
		 else 
		 {
		    companyAddress=companyAddress.trim();
		    if (companyAddress.isEmpty())
			{
		    	error.put("companyAddress","公司地址为空");
			}
	   	 }
		 //公司简介
		 if (companyInfo==null||companyInfo.isEmpty())
		 {
			  error.put("companyInfo","公司介绍不能为空");
		 }
		 else
		 {
		     companyInfo=companyInfo.trim();
		     if (companyInfo.isEmpty())
			 {
		    	 error.put("companyInfo","公司介绍不能为空");
			 }
		 }
		 
		 //用户名
		 if(employerName==null||employerName.isEmpty())
		  {
			   error.put("employerName","用户名为空");
		  }
		 else
		 {
		     employerName=employerName.trim();
		     if (employerName.isEmpty())
			 {
		    	 error.put("employerName","用户名为空");
			 }
		 }
		 //密码
		 if (password==null)
		 {
			error.put("password","密码长度为6-20位");
		 }
		 else
		 {
			password=password.trim();
			if(!StringUtil.isSatisfyLenght(password, 6, 20))
			{
				error.put("password","密码长度为6-20位,不能包含空格");
			}
		 }
		 return error;
	}
   
}
