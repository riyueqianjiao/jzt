package com.juzhituan.validator;

import java.util.HashMap;
import java.util.Map;

import com.juzhituan.domain.Comment;

public class CommentValidator {
	public static Map<String,String> validation(Comment instance)
	{
		   Map<String, String> error=new HashMap<String, String>();
		   if (instance.getWorkPoint()==null||"".equals(instance.getWorkPoint()))
		   {
			  error.put("workPoint","请为工作环境打分");
		   }		   
		   if(instance.getSalaryPoint()==null||"".equals(instance.getSalaryPoint()))
		   {
			   error.put("salaryPoint","请为工资发放打分");
		   }
		   if (instance.getOther()==null||"".equals(instance.getOther()))
		   {
			  error.put("other","请填写评价内容");
		   } 		   
		   return error;
	}



}
