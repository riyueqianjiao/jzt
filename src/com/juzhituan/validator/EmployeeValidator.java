package com.juzhituan.validator;

import java.util.HashMap;
import java.util.Map;

import com.juzhituan.domain.Employee;
import com.juzhituan.util.StringUtil;

public class EmployeeValidator
{

	public static Map<String,String> validation(Employee instance)
	{
		   Map<String, String> error=new HashMap<String, String>();
		   if (instance.getCellphone()==null||!StringUtil.isCellphone(instance.getCellphone()))
		   {
			  error.put("cellPhone","手机号错误");
		   }		   
		   if(instance.getEmployeeName()==null||instance.getEmployeeName().isEmpty())
		   {
			   error.put("employeeName","用户名为空");
		   }
		   if (instance.getPassword()==null||!StringUtil.isSatisfyLenght(instance.getPassword(), 6, 20))
		   {
			  error.put("password","密码长度为6-20位");
		   } 
		   /*if(instance.getAlipayNum()==null||instance.getAlipayNum().isEmpty())
		   {
			   error.put("alipayNum","支付宝账号为空");
		   }*/
		   if(instance.getGender()==null||instance.getGender().isEmpty())
		   {
			   error.put("gender","性别为空");
		   }
		   return error;
	}
   
}
