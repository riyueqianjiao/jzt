package com.juzhituan.controller.employee;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juzhituan.constant.Constants;
import com.juzhituan.domain.Employee;
import com.juzhituan.service.EmployeeService;
import com.juzhituan.util.JSONUtil;
import com.juzhituan.validator.EmployeeValidator;
import com.juzhituan.vo.User;

/*
 * url
 * 
 * 0) /employee/isExisted                         是否已注册
 * 
 * 1）/employee/register              	  GET     请求用户注册页面
 * 2）/employee/register            	      POST    处理用户注册表单
 * 
 * 3）/employee/login                	  GET     请求登陆页面
 * 4）/employee/login                 	  POST    处理登陆表单
 * 
 * 5）/employee/retrievePass              GET     请求找回密码页面
 * 6）/employee/retrievePass              POST    处理找回密码表单
 * 
 * 7）/employee/updatePass            	  GET     请求修改密码   
 * 8）/employee/updatePass            	  POST    处理修改密码
 * 
 * 9）/employee/update               	  GET     请求修改信息
 * 10）/employee/update               	  POST    处理修改信息
 * 
 * 
 * * */

@Controller
@RequestMapping("/employee/")
public class EmployeeController
{
   @Autowired
   private EmployeeService employeeService;
   
   /*
    * 
    * */
   @RequestMapping(method=RequestMethod.GET)
   public String base()
   {
	   return "employee/login";
   }

   @RequestMapping(value="/isExisted")
   public void isExisted(String cellphone,HttpServletResponse response) throws IOException
   {
	   if(employeeService.isEmployeeExisted(cellphone))
	   {
		   JSONUtil.outputError(Constants.USER_EXIST, response);
	   }
	   else
	   {
		   JSONUtil.outputStatus(true,response);		   
	   }
   }
   /*
    * 用户注册
    * 1）校验手机验证码、两次密码验证、提交数据
    * 2）数据不合法，返回错误信息
    * 3）数据合法，保存信息
    * */
   @RequestMapping(value="/register",method=RequestMethod.GET)
   public String register()
   {
	   return "employee/register";
   }
 
   @RequestMapping(value="/register",method=RequestMethod.POST)
   public void registerDo(Employee employee,String cellphone,String checkCode,HttpServletRequest request,
		   					HttpServletResponse response) throws IOException
   {
	   HttpSession session = request.getSession();
	   if(!session.getAttribute(Constants.CELLPHONE_CODE_SESSION_KEY).equals(checkCode))
	   {
		   JSONUtil.outputError(Constants.ERROR_CELLPHONE_CHECKCODE,response);
		   return;
	   }
	    boolean flag=employeeService.isEmployeeExisted(cellphone);
	    if (flag)
		{ 
	       JSONUtil.outputError(Constants.USER_EXIST, response);
	       return;
		}	     	
	    Map<String, String> error=EmployeeValidator.validation(employee);
	    if (error.size()>0)
		 {  
	    	 JSONUtil.outputError(error, response);
		 }
	     else
	     {  		    	 
			 employeeService.saveEmployee(employee);
			 JSONUtil.outputStatus(true,response);
	     }
   }

   
   /*
    * 用户登陆
    * 1）登陆验证
    * 2）登录信息错误，返回错误信息{"error":"用户不存在或密码错误"}
    * 3）用户存在,取数据库信息，保存至session;
    * */
   @RequestMapping(value="/login",method=RequestMethod.GET)
   public String login()
   {
   	return "employee/login";
   }
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public void loginDo(String cellphone,String password,String imagecode,HttpServletRequest request,HttpServletResponse response) throws IOException
    {
    	String imagecodeInSession = (String)request.getSession().getAttribute(Constants.IMAGE_CODE_SESSION_KEY);
    	//if(imagecode.equals(imagecodeInSession))
    	if(true)
    	{
    	 	   Map<String, String> error=loginValidation(cellphone,password);
    	 	   if (error.size()>0)
    	 	   {
    	 		   JSONUtil.outputError(error, response);
    	 	   }
    	 	   else 
    	 	   {
    	 		  Employee employee = employeeService.getEmployee(cellphone, password);
    	 		  if(employee==null)
    	 		  {
    	 			  JSONUtil.outputError(Constants.USER_NOT_EXIST,response);
    	 		  }
    	 		  else
    	 		  {			  
    	 			  if(employee.getLastLockedTime()!=null)
    	 			  {
    	 				//被锁定至今时间
    	 	 			  Long lockTimeRemain = (new Date()).getTime()-employee.getLastLockedTime().getTime();
    	 	 			  ////如果账号被锁定且解锁时间已到，解锁登录
    	 	 			  if(employee.getIsLocked()==1 && lockTimeRemain> (Constants.LOCK_TIME*24 * 60 * 60 * 1000))//如果账号被锁定
    	 	 			  {
    	 	 				 employee.setIsLocked((byte)(0));
    	 	 				 employeeService.updateEmployee(employee);
    	 					 User user = new User(employee.getEmployeeId(),employee.getEmployeeName(),Constants.USER_TYPE_EMPLOYEE);
    	 					 request.getSession().setAttribute(Constants.USER_SESSION_KEY,user);	
    	 					 JSONUtil.outputStatus(true,response);
    	 	 			  }
    	 	 			  else
    	 	 			  { 				  
    	 	 				  User user = new User(employee.getEmployeeId(),employee.getEmployeeName(),Constants.USER_TYPE_EMPLOYEE);
    	 	 				  request.getSession().setAttribute(Constants.USER_SESSION_KEY,user);	
    	 	 				  JSONUtil.outputStatus(true,response);
    	 	 			  }	
    	 			  }
    	 			  else
    	 			  {
    	 				 User user = new User(employee.getEmployeeId(),employee.getEmployeeName(),Constants.USER_TYPE_EMPLOYEE);
    	 				  request.getSession().setAttribute(Constants.USER_SESSION_KEY,user);	
    	 				  JSONUtil.outputStatus(true,response);
    	 			  }
    	 			  		  
    	 		  }
    	}
 	   }
    	else
    	{
    		JSONUtil.outputError(Constants.ERROR_IMAGE_CHECKCODE, response);
    	}
    }
    /*
     * 数据校验
     */
    private Map<String,String> loginValidation(String cellphone,String password)
    {
 	   Map<String, String> error=new HashMap<String, String>();
 	   if (cellphone==null||cellphone.isEmpty())
 	   {
 		  error.put("cellphone","手机号为空");
 	   }
 	   if (password==null||password.isEmpty())
 	   {
 		 error.put("password", "密码为空");
 	   }
 	   return error;
    } 
   
   
    /*
     * 用户找回密码
     * 1）
     * 2）
     * */
    @RequestMapping(value="/retrievePass",method=RequestMethod.GET)
    public String retrievePass()
    {
    	return "employee/retrievePass";
    }    
    @RequestMapping(value="/retrievePass",method=RequestMethod.POST)
    public void retrievePass(String cellphone,String checkCode,
    		HttpServletRequest request,HttpServletResponse response) throws IOException
    {
    	if(!employeeService.isEmployeeExisted(cellphone))
    	{
    		JSONUtil.outputError(Constants.USER_NOT_EXIST, response);
    		return;
    	}
    	HttpSession session = request.getSession();
 	    if(!session.getAttribute(Constants.CELLPHONE_CODE_SESSION_KEY).equals(checkCode))
 	    {
 		   JSONUtil.outputError(Constants.ERROR_CELLPHONE_CHECKCODE,response);
 		   return;
 	    }
 	    employeeService.updatePass(cellphone, "111111");
 	    JSONUtil.outputStatus(true, response);	    
    }
   
   /*
    * 用户修改密码
    * 1）取session
    * 2）判断旧密码是否正确
    * 3）新密码存入数据库
    * 4）
    * */
    @RequestMapping(value="/updatepass",method=RequestMethod.GET)
    public String updatePass()
    {
    	return "employee/updatepass";
    } 
   
   @RequestMapping(value="/updatepass",method=RequestMethod.POST)
   public void updatePass(HttpServletRequest request,HttpServletResponse response,
		   String oldPassword,String newPassword) throws IOException
   {
	   User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
	   Integer employeeId=user.getUserId();
	   Employee ee = employeeService.getEmployee(employeeId, oldPassword);
	   if(ee == null)
	   {
		   JSONUtil.outputError("密码错误", response);
	   }
	   else
	   {
		   employeeService.updatePass(employeeId, newPassword);
		   JSONUtil.outputStatus(true, response);
	 	}	 	   	   
   }
   
   
   /*
    * 用户修改姓名、支付宝账号、性别
    * 1）取session
    * 2）
    * */
   @RequestMapping(value="/update",method=RequestMethod.GET)
   public String update(HttpServletRequest request,HttpServletResponse response) throws IOException
   {
	   User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
	   Integer employeeId=user.getUserId();
	   Employee employee=employeeService.getEmployee(employeeId);
	   request.setAttribute("employee",employee);
	   return "employee/info";

   }
   @RequestMapping(value="/update",method=RequestMethod.POST)
   public void update(HttpServletRequest request,HttpServletResponse response,String employeeName,
		   String alipayNum,String gender) throws IOException
   {

	   User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
	   Integer employeeId=user.getUserId();
	   Employee employee=employeeService.getEmployee(employeeId);
	   employeeService.updateEmployee(employee, employeeName, alipayNum, gender);
	   User userNew = new User(user.getUserId(),employeeName,Constants.USER_TYPE_EMPLOYEE);
	   request.getSession().setAttribute(Constants.USER_SESSION_KEY,userNew);	
	   JSONUtil.outputStatus(true, response);	 	    			   	   
   }
   
  
   

   @RequestMapping(value="/center",method=RequestMethod.GET) //个人中心
   public String center()
   {
	   return "employee/center";
   }
   
   @RequestMapping(value="/ybmhd",method=RequestMethod.GET) //已报名活动
   public String ysqzw()
   {
	   return "employee/ybmhd";
   }
   
   
}
