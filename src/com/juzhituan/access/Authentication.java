package com.juzhituan.access;


/*
 *    记录需要登录验证的URL
 * */
public class Authentication
{
	private static final String[] EMPLOYER_AUTH_MODULE=new String[]
			{
		       "/employer",
		       "/publication"
			};
	
    private static final String[] EMPLOYER_AUTH_URLS=new String[]
    		{
    	      "/employer/center",
    	      "/employer/show",
    	      "/employer/update",
    	      "/employer/updatepwd",
    	      "/publication/add",
    	      "/publication/show",
    	      "/publication/detail",
    	      "/publication/update",
    	      "/publication/applycancel",
    	      "/publication/private"
    		};
    
    private static final String[] EMPLOYEE_AUTH_MODULE=new String[]
			{
		       "/employee",
		       "/signup"
			};
    
    private  static final String[] EMPLOYEE_AUTH_URLS=new String[]
    		{
    	     "/employee/center",
		     "/employee/show",
	  	     "/employee/update",
	  	     "/employee/updatepwd",
	  	     "/employee/remark",
	  	     "/signup/signup",
	  	     "/signup/cancelSignup"    
    		};
    
    
    public static boolean isEmployerAuthModule(String url)
    {
    	boolean isAuth=false;
    	for (int i = 0; i < EMPLOYER_AUTH_MODULE.length; i++)
		{
			if (url.indexOf(EMPLOYER_AUTH_MODULE[i])>=0)
			{
				isAuth=true;
				break;
			}
		}
    	return isAuth;
    }
   
    public static boolean isEmployerAuthUrl(String url)
    {
    	boolean isAuth=false;
    	for (int i = 0; i < EMPLOYER_AUTH_URLS.length; i++)
		{
			if (url.indexOf(EMPLOYER_AUTH_URLS[i])>=0)
			{
			   isAuth=true;
			   break;
			}
		}
    	return isAuth;
    }
    
    public static boolean isEmployeeAuthModule(String url)
    {
    	boolean isAuth=false;
    	for (int i = 0; i < EMPLOYEE_AUTH_MODULE.length; i++)
		{
			if (url.indexOf(EMPLOYEE_AUTH_MODULE[i])>=0)
			{
				isAuth=true;
				break;
			}
		}
    	return isAuth;
    }
    
    public static boolean isEmployeeAuthUrl(String url)
    {
    	boolean isAuth=false;
    	for (int i = 0; i < EMPLOYEE_AUTH_URLS.length; i++)
		{
			if (url.indexOf(EMPLOYEE_AUTH_URLS[i])>=0)
			{
			   isAuth=true;
			   break;
			}
		}
    	return isAuth;
    }
    
    
}
