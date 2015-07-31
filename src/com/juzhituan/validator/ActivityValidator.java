package com.juzhituan.validator;

import java.util.Map;

import com.juzhituan.domain.Activity;
import com.juzhituan.domain.Employee;

public class ActivityValidator
{

	public static Map<String, String> validation(Map<String, String> error,Activity activity,Employee employee)
	{
	//	Map<String, String> error=new HashMap<String, String>(); 	
		if(activity.getIsGenderRequired()==2 && employee.getGender().equals("M"))
		{
			error.put("gender","该职位只招女生");
		}
		if(activity.getIsGenderRequired()==3 && employee.getGender().equals("F"))
		{
			error.put("gender","该职位只招男生");
		}
 		if(activity.getApplyNum()>=activity.getRecruitNum())
 		{
 			error.put("recruitNum","招聘人数已满");
 		}
 		if(employee.getGender() == "M" && activity.getApplyNumM()>=activity.getRecruitNumM())
 		{
 			error.put("recruitNumM","招聘男生已满");
 		}
 		if(employee.getGender() == "F" && 
 				(activity.getApplyNum()-activity.getApplyNumM())>=(activity.getRecruitNumM()-activity.getRecruitNumM()))
 		{
 			error.put("recruitNumF","招聘女生已满");
 		}
 		return error;
	}

	
}
