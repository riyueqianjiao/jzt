package com.juzhituan.validator;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.juzhituan.domain.Activity;
import com.juzhituan.domain.Publication;
import com.juzhituan.util.StringUtil;

public class PublicationValidator
{
	
	public static Map<String,String> parsePublication(Publication publication,
			String startTime, Short recruitNum,Short recruitNumM,String mes)
	  {
		 SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
 		 Date startDate=null;
 		 try
		 {
		   startDate = formatDate.parse(startTime);
		 } 
		 catch (ParseException e)
		 {
		   startDate=null;
		 }
 		 publication.setStartDate(startDate);
 		 
 		 Map<String, String> error=PublicationValidator.validation(publication);
   	     if(recruitNum==null||recruitNum.shortValue()<=0)
		 {
		    error.put("recruitNum","请输入有效的招聘人数");
		 }
   	     if (recruitNumM==null||recruitNumM.shortValue()<0||(recruitNum!=null&&recruitNum<recruitNumM))
   	     {
   		   error.put("recruitNumM","请输入有效的招聘人数");
   	     }
   	    //数据有误
   	    if (error.size()>0)
   	    {
   	    	return error;
   	    }
   	    //长期
		if (publication.getIsLong()==1)
		{
		    Activity activity=new Activity();
		    activity.setRecruitNum(recruitNum);
			activity.setRecruitNumM(recruitNumM);
			activity.setSalary(publication.getSalary());
			activity.setWorkAddress(publication.getWorkAddress());
		    activity.setDetail(publication.getWorkTimeInfo()+","+publication.getDetail());
			activity.setIsGenderRequired(publication.getIsGenderRequired());
			activity.setWorkDate(publication.getStartDate());
			activity.setPublication(publication);
			
			List<Activity> activities=new ArrayList<Activity>(1);
			activities.add(activity);
			publication.setWorkDuration((byte)0);
			publication.setActivities(activities);
			return null;
		}
		//短期
	    List<JSONObject> list=null;
	    if (mes!=null)
	    {
		  list=JSONObject.parseArray(mes, JSONObject.class);
	    }
	   /*
	    * 解析Activity
	    * */
	    String workAddress=publication.getWorkAddress();
		short workDuration=publication.getWorkDuration();
		for (short i = 0; i<workDuration; i++)
		{
			String detail=publication.getDetail();
			Activity activity=new Activity();
			activity.setRecruitNum(recruitNum);
			activity.setRecruitNumM(recruitNumM);
			activity.setSalary(publication.getSalary());
			activity.setWorkAddress(workAddress);
			if (detail!=null)
			{
			  activity.setDetail(publication.getWorkTimeInfo()+","+publication.getDetail());
			}
			else
			{
			  activity.setDetail(publication.getWorkTimeInfo());	
			}
			activity.setIsGenderRequired(publication.getIsGenderRequired());
			Date workDate=new Date(publication.getStartDate().getTime()+i*24*60*60*1000);
			activity.setWorkDate(workDate);
			activity.setPublication(publication);
			//更新
			if(list!=null)
			{
			   for(JSONObject jsonObj:list)
			   {
				   String time=jsonObj.getString("time");
				   workDate=null;
				   try
				   {
					   workDate= formatDate.parse(time);
				   } 
				   catch (ParseException e)
				   {
					   workDate=null;
				   }
				   if(activity.getWorkDate().compareTo(workDate)==0)
				   {
					 Short   totalNum=jsonObj.getShort("totalNum");
					 Short   maleNum=jsonObj.getShort("maleNum");
					 String  address=jsonObj.getString("address");
					 String  timeInfo=jsonObj.getString("jsTime");
					 Integer salary=jsonObj.getInteger("salary");
					 if (totalNum==null||totalNum<0||
						maleNum==null||maleNum<0||totalNum<maleNum||
						address==null||address.isEmpty()||
						timeInfo==null||timeInfo.isEmpty()||
						salary==null||salary<0)
					 {
						error.put("mes", "更新信息有误");
						return error;
					 }
					 activity.update(totalNum,maleNum, address, timeInfo+","+publication.getDetail(),salary);
					 break;
				   }
			   }
			}
			publication.getActivities().add(activity);
		}
		return null;
	}
   	
	
	public static Map<String,String> validation(Publication instance)
	{
		Map<String,String> error=new HashMap<String, String>();
		String title=instance.getTitle();
		String detail=instance.getDetail();
		String workAddres=instance.getWorkAddress();
		String workTimeInfo=instance.getWorkTimeInfo();
		String contactName=instance.getContactName();
		String cellphone=instance.getCellphone();
		//标题
		if (title==null||!StringUtil.isSatisfyLenght(title.trim(),4, 12))
		{
			error.put("title","标题为4-12个汉字");
		}
		//工资
		if (instance.getSalary()<0)
		 {
			error.put("salary", "请输入有效的工资");
		 }
		//详情
		if(detail!=null&&detail.length()>100)
		{
			error.put("detail", "工作详情须小于100个汉字");	
		}
		//工作地址
	    if (workAddres==null||instance.getWorkAddress().isEmpty())
		{
		    error.put("workAddress", "请输入工作地点");	
		}
	    else
	    {
			if (workAddres.trim().isEmpty())
			{
				error.put("workAddress", "请输入工作地点");	
			}
		}
	    //长短期
	    if(instance.getIsLong()!=0&&instance.getIsLong()!=1)
		{
			error.put("isLong", "请选择兼职类型(短期/长期)");
		}
	    //工作时间
		if(workTimeInfo==null||workTimeInfo.isEmpty())
		{
			error.put("workTimeInfo", "工作时间描述为空");
		}
		else
		{
		    if (workTimeInfo.trim().isEmpty())
			{
		    	error.put("workTimeInfo", "工作时间描述为空");
			}	
		}
		//工作天数
		if (instance.getIsLong()==0&&(instance.getWorkDuration()<=0||instance.getWorkDuration()>7))
		{
		     error.put("workDuration", "短期兼职工作天数应为1-7天");	
		}
		//联系人名称
		if (contactName==null||contactName.isEmpty())
		{
			error.put("contactName","联系人为空");
		}
		else
		{
			if (contactName.trim().isEmpty())
			{
				error.put("workTimeInfo", "工作时间描述为空");
			}
		}
		//联系电话
		if (cellphone==null||!StringUtil.isCellphone(cellphone))
		{
			error.put("cellphone", "手机号码不正确");
		}
		if (instance.getIsGenderRequired()<0||instance.getIsGenderRequired()>3)
		{
			error.put("isGenderRequired","请选择工作性质(是否分男女)");
		}
		if(instance.getPaymentWay()!=0&&instance.getPaymentWay()!=1)
		{
			error.put("paymentWay", "前选择支付方式");
		}
		if(instance.getSettlementWay()!=0&&instance.getSettlementWay()!=1)
		{
			error.put("settlementWay", "请选择工资结算方式");
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate=instance.getStartDate(); 
		Date today=null;
		try
		{
	       today=dateFormat.parse(dateFormat.format(new Date()));
		} 
		catch (ParseException e)
		{
			
		}
		if(startDate==null||startDate.before(today))
		{
			error.put("startDate", "工作日期不正确");
		}
		return error;
	}
   
}
