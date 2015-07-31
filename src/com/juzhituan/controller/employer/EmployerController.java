package com.juzhituan.controller.employer;

import java.io.IOException;
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
import com.juzhituan.domain.Employer;
import com.juzhituan.domain.License;
import com.juzhituan.service.EmployerService;
import com.juzhituan.service.LicenseService;
import com.juzhituan.util.JSONUtil;
import com.juzhituan.util.StringUtil;
import com.juzhituan.validator.EmployerValidator;
import com.juzhituan.validator.LicenseValidator;
import com.juzhituan.vo.User;

/** 
 *  ************************ 公有操作 ***********************************

 * 0）/employer                             GET           商家登陆请求
 * 
 * 1）/employer/register                    GET           商家注册请求
 * 2）/employer/register                    POST          处理商家注册表单
 * 
 * 3）/employer/login                       GET           商家登陆请求
 * 4）/employer/login                       POST          处理登陆表单
 * 
 * 5）/employer/apply                       GET           商家申请请求
 * 6）/employer/apply                       POST          处理商家申请请求
 * 
 * 
 * ************************ 私有操作 ***********************************
 * 7）/employer/center                      GET           商家中心
 * 8）/employer/show                        GET           查询商家
 * 
 * 9）/employer/update                      GET           商家更新请求
 * 10）/employer/update                     POST          处理更新表单
 * 
 * 11）/employer/delete                     POST          删除某个商家
 * 12）/employer/updatepwd                  GET           请求更新密码
 * 13）/employer/updatepwd                  POST          处理更新密码请求
 * 
 * 14）/employer/retrievePass               GET           请求找回密码
 * 15）/employer/retrievePass               POST          处理找回密码请求
 * *  
 * * */

@Controller
@RequestMapping("/employer")
public class EmployerController
{  
	@Autowired
	private LicenseService licenseService;
    @Autowired
    private EmployerService employerService;
   
  /**
   * 默认为登陆请求
   * */
    
   @RequestMapping(method=RequestMethod.GET)
   public String base()
   {
	   return "employer/login";
   }
      
  /**
   * *********************分发请求**********************************
   * */
   
   
   /**
    * 申请成为商家
    * */
   @RequestMapping(value="/apply",method=RequestMethod.GET)
   public String apply()
   {
	   return "employer/apply";
   }
   
   
   /**
    * 商家登陆
    * */
   @RequestMapping(value="/login",method=RequestMethod.GET)
   public String login()
   {
	   return "employer/login";
   }
   
   
   /**
    * 商家注册
    * */
   @RequestMapping(value="/register",method=RequestMethod.GET)
   public String register()
   {
	   return "employer/register";
   }
   
   
   /**
    * 商家中心
    * */
   @RequestMapping(value="/center",method=RequestMethod.GET)
   public String center()
   {
	   return "employer/center";
   }
   
   /**
    * 修改密码
    * */
   @RequestMapping(value="/updatepwd",method=RequestMethod.GET)
   public String updatepwd(HttpServletResponse response) throws IOException
   {
	   return "employer/updatepwd";
   }
   
   /**
    * 找回密码
    * */
   @RequestMapping(value="/retrievePass",method=RequestMethod.GET)
   public String retrievePass(HttpServletResponse response) throws IOException
   {
	   return "employer/retrievePass";
   }
   
   
   /**
    * 查询商家信息
    * */
   @RequestMapping(value="/show",method=RequestMethod.GET)
   public String showDo(HttpServletRequest request) throws IOException
   {
	    User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
	    Integer employerId=user.getUserId();
	    Employer employer=employerService.getEmployer(employerId);
	    request.setAttribute("employer",employer);
	    return "employer/employerinfo";
  }
  
  
   
   /**
    * 更新
    * */
   @RequestMapping(value="/update",method=RequestMethod.GET)
   public String update(HttpServletRequest request)
   {
	   User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
	   Integer employerId=user.getUserId();
	   Employer employer=employerService.getEmployer(employerId);
	   request.setAttribute("employer", employer);
	   return "employer/update";
   }

   
   /**
    * *********************处理请求********************************************
    * */
    
   
   /**
	 *  处理商家申请请求
	 *
	 *  @param license    许可证     
	 *  @param checkCode  手机验证码  
	 *
	 *  @return  数据格式:JSON。若数据校验成功，返回{"status:ok"}，否则返回错误信息{"error":{}}
	 *  
	 */
   @RequestMapping(value="/apply",method=RequestMethod.POST)
   public void applyDo(License license,String checkCode,HttpServletRequest request,HttpServletResponse response) throws IOException
   {
	   
	   HttpSession session = request.getSession();
	   if(!session.getAttribute(Constants.CELLPHONE_CODE_SESSION_KEY).equals(checkCode))
	   {
		   JSONUtil.outputError(Constants.ERROR_CELLPHONE_CHECKCODE,response);
		   return;
	   }
	   Map<String, String> error=LicenseValidator.validation(license);
	   if(error!=null&&error.size()>0)
	   {
		   JSONUtil.outputError(error, response);
	   }
	   else
	   {
		   licenseService.saveLicense(license);
		   JSONUtil.outputStatus(true, response);
	   }
   }
   
   
   /**
  	 *  商家注册
  	 *
  	 *  @param license        许可证     
  	 *  @param employer       商家
  	 *  @param repassword     重复密码
  	 *  @param cheeckCode     手机验证码
  	 *    
  	 *  @return  数据格式:JSON。若数据校验成功，返回{"status:ok"}，否则返回错误信息{"error":{}}
  	 *  
  	 */
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public void registerDo(License license,Employer employer,String repassword,String checkCode,
 		   HttpServletRequest request,HttpServletResponse response) throws IOException
    {
    	
 	     Map<String, String> error=EmployerValidator.validation(employer);
 	     if (error!=null&&error.size()>0)
 		 {  
 	    	 JSONUtil.outputError(error, response);
 	    	 return;
 		 }
    	 License persistentLicense=licenseService.getLicense(license.getLicenseNum());
	     if (persistentLicense==null)
		 {
	    	 JSONUtil.outputError(Constants.LICENSE_NOT_EXIST, response);
	    	 return;
	 	 }
	     //检测用户名是否存在
	     if (employerService.isEmployerExisted(employer.getEmployerName()))
		 {
	    	 JSONUtil.outputError(Constants.USER_NAME_EXIST, response);
	    	 return;
		 }
	     if(employerService.isExisted(employer.getCellphone()))
	     {
	    	 JSONUtil.outputError(Constants.CELLPHONE_EXIST, response);
	    	 return;
		 }
	     if(employerService.isLicenseNumUsed(license.getLicenseNum()))
	     {
	    	 JSONUtil.outputError(Constants.LICENSE_IS_USED, response);
	    	 return;
		 }
         employerService.saveEmployer(employer,persistentLicense);
		 JSONUtil.outputStatus(true, response);     
 }
    
    
    
    
    /**
   	 *  商家登陆
   	 *
   	 *  @param id         用户名或手机号
   	 *  @param password   密码      
   	 *  @param checkCode  图片验证码  
   	 *
   	 *  @return  数据格式:JSON。若数据校验成功，返回{"status:ok"}，否则返回错误信息{"error":{}}
   	 *  
   	 */
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public void loginDo(String id,String password,String imagecode,HttpServletRequest request,HttpServletResponse response) throws IOException
    {
    	String imagecodeInSession = (String)request.getSession().getAttribute(Constants.IMAGE_CODE_SESSION_KEY);
    	if(imagecode.equals(imagecodeInSession))
    	{
    	 	   Map<String, String> error=loginValidation(id,password);
    	 	   if (error!=null&&error.size()>0)
    	 	   {
    	 		   JSONUtil.outputError(error, response);
    	 		   return;
    	 	   } 
    		   Employer employer=employerService.getEmployerByNameOrCellphone(id, password);
    		   if(employer==null)
    		   {
    			  JSONUtil.outputError(Constants.USER_NOT_EXIST,response);
    			  return;
    		   }
    		   User user=new User(employer.getEmployerId(),employer.getEmployerName(),Constants.USER_TYPE_EMPLOYER);
    		   request.getSession().setAttribute(Constants.USER_SESSION_KEY,user);
    		   JSONUtil.outputStatus(true, response);
    	}
    	else
    	{
    		JSONUtil.outputError(Constants.ERROR_IMAGE_CHECKCODE, response);
    	}
 }
    
   /**
    * 更新
    * */
   @RequestMapping(value="/update",method=RequestMethod.POST)
   public void updateDo(String cellphone,String email,
		   HttpServletRequest request,HttpServletResponse response) throws IOException
   {
	    if (!StringUtil.isCellphone(cellphone))
		{
	    	JSONUtil.outputError("手机号错误", response);
	    	return;
		}
	    if (!StringUtil.isEmail(email))
		{
	    	JSONUtil.outputError("邮箱错误", response);
	    	return;
		}
	    User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
	    employerService.updateEmployer(user.getUserId(),cellphone,email);
		JSONUtil.outputStatus(true, response);
   }
      
  
   /**
    * 修改密码
    * */
   @RequestMapping(value="/updatepwd",method=RequestMethod.POST)
   public void updatePwdDo(String oldPassword,String newPassword,
		   HttpServletRequest request,HttpServletResponse response) throws IOException
   {
	  if (newPassword==null||newPassword.isEmpty())
	  {
		 JSONUtil.outputError("密码为空", response);
		 return;
	  }
	  if (!StringUtil.isSatisfyLenght(newPassword.trim(), 6, 20))
	  {
		JSONUtil.outputError("密码长度为6-20,不包含空格", response);
		return;
	  }
	  User user=(User)request.getSession().getAttribute(Constants.USER_SESSION_KEY);
	  Integer employerId=user.getUserId();
	  Employer employer=employerService.getEmployer(employerId,oldPassword);
	  if (employer==null)
	  {
		JSONUtil.outputError("原密码错误", response);
		return;
	  }
	  employerService.updateEmployer(employerId, newPassword);
	  JSONUtil.outputStatus(true, response);
  }
   
   /**
    * 找回密码
    * */
   @RequestMapping(value="/retrievePass",method=RequestMethod.POST)
   public void retrievePass(String cellphone,String checkCode,
   		HttpServletRequest request,HttpServletResponse response) throws IOException
   {
   	if(!employerService.isExisted(cellphone))
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
	employerService.updateEmployer(cellphone, "111111");
	JSONUtil.outputStatus(true, response);	    
   }
   
   /**
    * 数据校验
    */
   private Map<String,String> loginValidation(String id,String password)
   {
	   Map<String, String> error=new HashMap<String, String>();
	   if (id==null||id.isEmpty())
	   {
		  error.put("id","用户名或手机号为空");
	   }
	   if (password==null||password.isEmpty())
	   {
		 error.put("password", "密码为空");
	   }
	   return error;
   }  
   
}
