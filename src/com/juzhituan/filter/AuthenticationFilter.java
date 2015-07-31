package com.juzhituan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juzhituan.access.Authentication;
import com.juzhituan.constant.Constants;
import com.juzhituan.vo.User;



/**
 * 
 * 用户认证
 *
 */
public class AuthenticationFilter implements Filter
{
	/*
	 *  登录验证
	 *  
	 *  url:请求的URL
	 *  authURLS:需要登录验证的URL
	 *  redirectURL：如果url为登录验证的URL,且用户没有登录，则redirectURL为重定向的URL
	 *  sessionAttrName：session中保存的属性名
	 * */
	private void doAuthentication(String redirectURL,Byte userType,
			HttpServletRequest request, HttpServletResponse response,FilterChain filterChain) throws IOException, ServletException
	{
		
	       String referer=request.getHeader("Referer");
	       User user=(User)request.getSession().getAttribute(Constants.USER_SESSION_KEY);
	       if (user==null)
		   {
	    	  //session失效
	    	  if (referer!=null&&(referer.indexOf("employer/center")>=0||referer.indexOf("employee/center")>=0))
			  {
	    		  response.sendRedirect(request.getContextPath()+"/invalid");
			  }
	    	  else
	    	  {
	    		  response.sendRedirect(redirectURL);
			  }
		   }
	       else if (user.getUserType()!=userType)
		   {
			  response.sendRedirect(redirectURL);
		   }
		   else
		   {
			  filterChain.doFilter(request,response);
		   }
 }
	  
	
	
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException
	{
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		HttpServletResponse response=(HttpServletResponse)servletResponse;
		String path = request.getContextPath();
		//获取请求的URL
		String url=request.getRequestURI();
		System.out.println("URL: "+url);
		if (Authentication.isEmployerAuthModule(url)&&Authentication.isEmployerAuthUrl(url))
		{
			String redirectURL=path+"/employer/login";
			doAuthentication(redirectURL,Constants.USER_TYPE_EMPLOYER, request, response, filterChain);
		}
		else if(Authentication.isEmployeeAuthModule(url)&&Authentication.isEmployeeAuthUrl(url))
		{
			String redirectURL=path+"/employee/login";
			doAuthentication(redirectURL,Constants.USER_TYPE_EMPLOYEE, request, response, filterChain);
		}
		else
		{
			filterChain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		
	}
	@Override
	public void destroy()
	{
	   	
	}


}
