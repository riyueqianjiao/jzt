package com.juzhituan.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import com.juzhituan.domain.Activity;
import com.juzhituan.domain.Comment;
import com.juzhituan.domain.License;
import com.juzhituan.domain.Publication;

public class JSONUtil
{
	  /*
	   * 无实体
	   * */
	  private JSONUtil()
	  {
		  
	  }
	  
	  /*
	   * 输出license
	   * */
	  public static void outputLicense(License license,HttpServletResponse response) throws IOException
	  {
		 StringBuffer buffer=new StringBuffer();
		 buffer.append("{");
		 buffer.append("\"status\":\"ok\",\"license\":{");
		 buffer.append("\"licenseNum\":"+license.getLicenseNum()+",")
		       .append("\"companyName\":\""+license.getCompanyName()+"\",")
		       .append("\"contactName\":\""+license.getContactName()+"\",")
		       .append("\"cellphone\":\""+license.getCellphone()+"\",")
		       .append("\"companyPhone\":\""+license.getCompanyPhone()+"\",")
		       .append("\"city\":\""+license.getCity()+"\",")
		       .append("\"companyAddress\":\""+license.getCompanyAddress()+"\",")
		       .append("\"companyInfo\":\""+license.getCompanyInfo()+"\"}");
		 buffer.append("}");
		 response.setContentType("application/json;charset=UTF-8");
		 response.getWriter().write(buffer.toString());
		 response.getWriter().flush();
	  }
	  
	  /*
	   *  输出publication
	   * */
	  public static void outputPublication(List<Publication> publications,Boolean isSimple,HttpServletResponse response) throws IOException
	  {
		 SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat formatTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 StringBuffer buffer=new StringBuffer();
		 buffer.append("{");
		 buffer.append("\"status\":\"ok\",\"publications\":[");
		 int size=publications.size()-1;
		 if (isSimple)
		 {
			 for (int i = 0; i <=size; i++)
			 {
				Publication publication=publications.get(i);
			    buffer.append("{")
			          .append("\"isLong\":"+publication.getIsLong()+",")
			          .append("\"publicationId\":"+publication.getPublicationId()+",")
			          .append("\"recruitmentTime\":"+publication.getRecruitmentTime()+",")
			          .append("\"publicationTime\":\""+formatTime.format(publication.getPublicationTime())+"\",")
			          .append("\"salary\":"+publication.getSalary()+",")
			          .append("\"startDate\":\""+formatDate.format(publication.getStartDate())+"\",")
			          .append("\"workTimeInfo\":\""+publication.getWorkTimeInfo()+"\",")
			          .append("\"title\":\""+publication.getTitle()+"\",")
			          .append("\"companyName\":\""+publication.getCompanyName()+"\",")
			          .append("\"workAddress\":\""+publication.getWorkAddress()+"\"}");
			    if (i!=size)
				{
					buffer.append(",");
				}
			 }
		 }
		 else
		 {
			 for (int i = 0; i <=size; i++)
			 {
				Publication publication=publications.get(i);
			    buffer.append("{")
			          .append("\"publicationId\":"+publication.getPublicationId()+",")
			          .append("\"isLong\":"+publication.getIsLong()+",")
			          .append("\"state\":"+publication.getState()+",")
			          .append("\"recruitmentTime\":"+publication.getRecruitmentTime()+",")
			          .append("\"publicationTime\":\""+formatTime.format(publication.getPublicationTime())+"\",")
			          .append("\"salary\":"+publication.getSalary()+",")
			          .append("\"startDate\":\""+formatDate.format(publication.getStartDate())+"\",")
			          .append("\"workTimeInfo\":\""+publication.getWorkTimeInfo()+"\",")
			          .append("\"title\":\""+publication.getTitle()+"\",")
			          .append("\"contactName\":\""+publication.getContactName()+"\",")
			          .append("\"cellphone\":\""+publication.getCellphone()+"\",")
			          .append("\"companyName\":\""+publication.getCompanyName()+"\",")
			          .append("\"workAddress\":\""+publication.getWorkAddress()+"\"}");
			    if (i!=size)
				{
					buffer.append(",");
				}
			 }
		 }
		 buffer.append("]}");
		 response.setContentType("application/json;charset=UTF-8");
		 response.getWriter().write(buffer.toString());
		 response.getWriter().flush();
	  }
	  
	  
	  /*
	   * 输出activity
	   * */
	  public static void outputActivity(List<Activity> activities,HttpServletResponse response) throws IOException
	  {
		 SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		 StringBuffer buffer=new StringBuffer();
		 buffer.append("{");
		 buffer.append("\"status\":\"ok\",\"activities\":[");
		 int size=activities.size()-1;
		 for (int i = 0; i <=size; i++)
		 {
			Activity activity=activities.get(i);
		    buffer.append("{")
		          .append("\"activityId\":"+activity.getActivityId()+",")
		          .append("\"recruitNum\":"+activity.getRecruitNum()+",")
		          .append("\"recruitNumM\":"+activity.getRecruitNumM()+",")
		          .append("\"applyNum\":"+activity.getApplyNum()+",")
		          .append("\"applyNumM\":"+activity.getApplyNumM()+",")
		          .append("\"salary\":"+activity.getSalary()+",")
		          .append("\"workAddress\":\""+activity.getWorkAddress()+"\",")
		          .append("\"workDate\":\""+formatDate.format(activity.getWorkDate())+"\",")
		          .append("\"detail\":\""+activity.getDetail()+"\",")
		          .append("\"isGenderRequired\":"+activity.getIsGenderRequired()+"}");
		    if (i!=size)
			{
				buffer.append(",");
			}
		 }
		 buffer.append("]}");
		 response.setContentType("application/json;charset=UTF-8");
		 response.getWriter().write(buffer.toString());
		 response.getWriter().flush();
	  }
	  
	  public static void outputActivitySimple(List<Activity> activities,HttpServletResponse response) throws IOException
	  {
		 SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		 StringBuffer buffer=new StringBuffer();
		 buffer.append("{");
		 buffer.append("\"status\":\"ok\",\"activities\":[");
		 int size=activities.size()-1;
		 for (int i = 0; i <=size; i++)
		 {
			Activity activity=activities.get(i);
		    buffer.append("{")
		          .append("\"activityId\":"+activity.getActivityId()+",")
		          .append("\"salary\":"+activity.getSalary()+",")
		          .append("\"workDate\":\""+formatDate.format(activity.getWorkDate())+"\"}");
		    if (i!=size)
			{
				buffer.append(",");
			}
		 }
		 buffer.append("]}");
		 response.setContentType("application/json;charset=UTF-8");
		 response.getWriter().write(buffer.toString());
		 response.getWriter().flush();
	  }
	  
	 
	  
	  /*
	   * 输出comment
	   * */
	  //手机号处理
	  public static String changeCellphone(String cellphone)
	  {
		  return cellphone.substring(0,3)+"****"+cellphone.substring(7);
	  }
	  public static void outputComment(List<Comment> comments,Long pageTotalNum,HttpServletResponse response) throws IOException
	  {
		 StringBuffer buffer=new StringBuffer();
		 SimpleDateFormat formatTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 buffer.append("{");
		 buffer.append("\"status\":\"ok\",\"totalNum\":"+pageTotalNum+",\"comments\":[");
		 int size=comments.size()-1;
		 for (int i = 0; i <=size; i++)
		 {
			 Comment comment=comments.get(i);
		    buffer.append("{")
		          .append("\"cellphone\":\""+changeCellphone(comment.getEmployee().getCellphone())+"\",")
		          .append("\"time\":\""+formatTime.format(comment.getTime())+"\",")
		          .append("\"workPoint\":"+comment.getWorkPoint()+",")
		          .append("\"salaryPoint\":"+comment.getSalaryPoint()+",")
		          .append("\"other\":\""+comment.getOther()+"\"}");
		    if (i!=size)
			{
				buffer.append(",");
			}
		 }
		 buffer.append("]}");
		 response.setContentType("application/json;charset=UTF-8");
		 response.getWriter().write(buffer.toString());
		 response.getWriter().flush();
	  }
	  
	  /*
	   * 输出状态
	   * */
	  public static void outputStatus(boolean isSuccess,HttpServletResponse response) throws IOException
	  {
		  response.setContentType("application/json;charset=UTF-8");
		  if (isSuccess)
		  { 
			response.getWriter().write("{\"status\":\"ok\"}");
		  }
		  else 
		  {
			  response.getWriter().write("{\"status\":\"error\"}");
		  }
		  response.getWriter().flush();
	  }
	  
	  /*
	   *  输出信息
	   * */
	   public static void outputInfo(String key,String value,HttpServletResponse response) throws IOException
	   {
		   response.setContentType("application/json;charset=UTF-8");
		   response.getWriter().write("{\"status\":\"ok\",\""+key+"\":"+"\""+value+"\"}");
		   response.getWriter().flush();
	   }
	   
	   /*
	    *  返回错误信息,JSON格式，如
	    *  {
	    *      "status":"error",
	    *      "error":{"错误字段":"错误描述"...}
	    *  }
	    * */
	   public static void outputError(Map<String, String> error,HttpServletResponse response) throws IOException
	   {
		   response.setContentType("application/json;charset=UTF-8");
		   StringBuffer buffer=new StringBuffer();
		   buffer.append("{\"status\":\"error\",\"error\":{");
		   if (error!=null)
		   {
			   Iterator<Entry<String, String>> iterator=error.entrySet().iterator();
			   while (iterator.hasNext())
			   {
				 Entry<String, String> entry =iterator.next();
				 buffer.append("\""+entry.getKey()+"\":"+"\""+entry.getValue()+"\",");
			   }
			   buffer.deleteCharAt(buffer.length()-1);
		   }
		   buffer.append("}}");
		   response.getWriter().write(buffer.toString());
		   response.getWriter().flush();
	   }
	   
	   
	   public static void outputError(String errorInfo,HttpServletResponse response) throws IOException
	   {
		   response.setContentType("application/json;charset=UTF-8");
		   response.getWriter().write("{\"status\":\"error\",\"error\":"+"\""+errorInfo+"\"}");
		   response.getWriter().flush();
	   }
}
