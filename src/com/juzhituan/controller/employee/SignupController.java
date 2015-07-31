package com.juzhituan.controller.employee;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juzhituan.constant.Constants;
import com.juzhituan.domain.Activity;
import com.juzhituan.domain.Employee;
import com.juzhituan.domain.Publication;
import com.juzhituan.service.EmployeeService;
import com.juzhituan.util.JSONUtil;
import com.juzhituan.validator.ActivityValidator;
import com.juzhituan.vo.User;

/*
 * 
 * 
 * /signup/signup						 POST      处理报名请求
 * /signup/cancelSignup           	     POST      处理取消报名请求
 * /signup/show					  	     GET  	      查看已报名兼职
 * /signup/showActivity					 GET       查看报名publication中各activity
 * /signup/show/page/{pagenum}   		 GET	      分页查看
 * /signup/show/finished				 GET  	      查看已结束的兼职
 * /signup/show/finished/page/{pagenum}	 GET	      分页已结束的兼职查看
 */



@Controller
@RequestMapping("/signup")
public class SignupController 
{
	@Autowired
	private EmployeeService employeeService;
			
	/*
	   * 用户报名
	   * 1）从session取	   
	   * 2）验证是否人数已满（本性别已满）
	   * 3）报名
	   * */	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String signup(String activityIds,String workDates, 
			HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		System.out.println(workDates);
		Map<String, String> error=new HashMap<String, String>();
		if(activityIds == null || activityIds.isEmpty())
		{
			error.put("empty", "请选择报名日期");
		}
		if (error.size()>0)
		{
			  JSONUtil.outputError(error, response);
			  return null;
		}
		User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		Integer employeeId = user.getUserId();
		Employee employee = employeeService.getEmployee(employeeId);
		if (employee.getIsLocked() == 0) 
		{
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
			String [] actvities = activityIds.split(",");
			String [] workDates1 = workDates.split(",");
			Integer[] activityIdInts = new Integer[actvities.length];
			Date[] workDates2 = new Date[workDates1.length];
			try {
				for (int i = 0; i < actvities.length; i++) 
				{
					Integer actvityIdInt = Integer.parseInt(actvities[i]);
					activityIdInts[i] = actvityIdInt;
					Date workDate = formatDate.parse(workDates1[i]);
					workDates2[i] = workDate;
				}
			} catch (Exception e)
			{
				return null;
			}
			Long participations = employeeService.getParticipationByWorkDates(employeeId,workDates2);
			System.out.println(participations);
			if (participations > 0) 
			{
				error.put("repeat", "您当天已在其他兼职中有报名");
			}
			if (error.size() > 0) 
			{
				JSONUtil.outputError(error, response);
				return null;
			}
			request.setAttribute("activityIdInts", activityIdInts);
			request.setAttribute("employee", employee);
			return "forward:signupStep2";
		}
		else
		{
			Long lockTimeRemain = (new Date()).getTime()
					- employee.getLastLockedTime().getTime();
			String time = employeeService
					.formatDuring((Constants.LOCK_TIME * 24 * 60 * 60 * 1000)
							- lockTimeRemain);
			error.put("locked", time);
			JSONUtil.outputError(error, response);
			return null;
		}
	}
	
	@RequestMapping(value="/signupStep2")
	public void signupStep2(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		Integer[] activityIdInts = (Integer[])request.getAttribute("activityIdInts");
		Employee employee = (Employee)request.getAttribute("employee");
		Map<String, String> error=new HashMap<String, String>();
		List<Activity> activities = employeeService.getActivities(activityIdInts);
		for (Activity activity : activities)
		{	
			//校验人数是否已满（男/女人数）、是否对应性别（比如只招女而报名者为男）
			error = ActivityValidator.validation(error, activity,employee);					
			if (error.size() > 0) 
			{
				JSONUtil.outputError(error, response);
				return;
			}
		}
		if(employee.getGender().equals("M") && activities.get(0).getIsGenderRequired() != 0)
		{
			employeeService.signupForMan(employee, activities,activityIdInts);
		}
		else
		{
			employeeService.signupForOthers(employee,activities, activityIdInts);
		}
		JSONUtil.outputStatus(true, response);
	}
	
	
	/*
	   * 用户取消报名登陆
	   * 1）
	   * */	
	@RequestMapping(value="/cancelSignup",method=RequestMethod.POST)
	public void cancelSignup(String activityIds,HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		Map<String, String> error=new HashMap<String, String>();
		if(activityIds == null || activityIds.isEmpty())
		{
			error.put("empty", "请选择要取消的兼职");
		}
		if (error.size()>0)
		{
			  JSONUtil.outputError(error, response);
		}
		String []actvities = activityIds.split(",");
		Integer[] activityIdInts = new Integer[actvities.length];
		try {
			for (int i = 0; i < actvities.length; i++) 
			{
				Integer actvityIdInt = Integer.parseInt(actvities[i]);
				activityIdInts[i] = actvityIdInt;
			}
		} catch (Exception e) {
			return ;
		}
		User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		Integer employeeId = user.getUserId();
		Employee employee=employeeService.getEmployee(employeeId);
		Activity activity = employeeService.getActivity(activityIdInts[0]);
		if(employee.getGender().equals("M") && activity.getIsGenderRequired() != 0)
		{
			employeeService.cancelSignupForMan(employee,activityIdInts);
		}
		else
		{
			employeeService.cancelSignupForOthers(employee,activityIdInts);
		}
		JSONUtil.outputStatus(true, response);
	}
		
	/*
	    * 用户查询已报名信息
	    * 1）
	    * 2）
	    * */
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
	 public String pageDo(HttpServletRequest request,HttpServletResponse response) throws IOException
	  {
		 
		 User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		 Integer employeeId=user.getUserId();
		 Long totalNum=employeeService.getPublicationTotalNum(employeeId);
		 if (totalNum>0)
		  {
			 List<Publication> publications=employeeService.findByPage(employeeId,1);
			  request.setAttribute("totalNum",totalNum);
			  request.setAttribute("publications",publications);
		  }
		 return "employee/ybmhd";
	 }
    
	/*
	    * 分页查询
	    * 1）
	    * 2）
	    * */   
	@RequestMapping(value="/show/page/{pageNum}",method=RequestMethod.GET)
	 public void pageDo(@PathVariable Integer pageNum,
			 HttpServletRequest request,HttpServletResponse response) throws IOException
	  {
		 
		 User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		 Integer employeeId=user.getUserId();
		 List<Publication> publications=employeeService.findByPage(employeeId,pageNum);
		 if (publications==null||publications.size()==0)
		 {
			JSONUtil.outputError(Constants.RESULT_IS_EMPTY,response);
		 }
		 else
		 {
			 JSONUtil.outputPublication(publications, false,response);
		 }
	 }
	/*
	    * 用户查询已完成报名中各activity
	    * 1）
	    * 2）
	    * */
	@RequestMapping(value="/showActivity",method=RequestMethod.GET)
	public void showActivity(Integer publicationId,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);		 
		List<Activity> activities = employeeService.find(user.getUserId(), publicationId);
		if (activities==null||activities.size()==0)
		{
			JSONUtil.outputError(Constants.RESULT_IS_EMPTY,response);
		}
		else
		{
			JSONUtil.outputActivitySimple(activities, response);
		}
	}
	/*
	    * 用户查询已完成报名信息以发表评价
	    * 1）
	    * 2）
	    * */
	@RequestMapping(value="/showRemarkable",method=RequestMethod.GET)
	 public String ShowRemarkable(HttpServletRequest request,HttpServletResponse response) throws IOException
	  {
		 
		 User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		 Integer employeeId=user.getUserId();
		 Long totalNum=employeeService.getIsDonePublicationTotalNum(employeeId);
		 if (totalNum>0)
		  {
			 List<Publication> publications=employeeService.findIsDoneByPage(employeeId, 1);
			  request.setAttribute("totalNum",totalNum);
			  request.setAttribute("publications",publications);
		  }
		 return "employee/pjhd";
	 }
 
	/*
	    * 分页查询
	    * 1）
	    * 2）
	    * */   
	@RequestMapping(value="/showRemarkable/page/{pageNum}",method=RequestMethod.GET)
	 public void ShowRemarkable(@PathVariable Integer pageNum,
			 HttpServletRequest request,HttpServletResponse response) throws IOException
	  {
		 
		 User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		 Integer employeeId=user.getUserId();
		 List<Publication> publications=employeeService.findIsDoneByPage(employeeId, pageNum);
		 if (publications==null||publications.size()==0)
		 {
			JSONUtil.outputError(Constants.RESULT_IS_EMPTY,response);
		 }
		 else
		 {
			JSONUtil.outputPublication(publications,false,response);
		 }
		 
	 }
	   

}
