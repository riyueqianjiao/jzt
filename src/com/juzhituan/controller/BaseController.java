package com.juzhituan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juzhituan.constant.Constants;
import com.juzhituan.domain.Publication;
import com.juzhituan.service.PublicationService;

/*
 * /{base}
 * /{base}.html
 * /index
 * /logout
 * /template/{template}
 * /page
 * /viewComments
 * */

@Controller
public class BaseController
{
	 @Autowired
	 private PublicationService publicationService;
	
	 /*
	  * 分发请求
	  * */
	 @RequestMapping(value="/{base}")
     public String dispacher(@PathVariable String base)
     {
		 return base;
     }
	 
	 @RequestMapping(value="/{base}.html")
	 public String dispacherHtml(@PathVariable String base)
	 {
		 return base;
	 }
	 
	 /*
	  * 首页
	  * */
	 @RequestMapping(value="/index")
	 public String indexDo(String p,String c,String d,HttpServletRequest request)
	 {
		 String area=null;
		 if (p==null||p.length()==0)
		 {
			p="上海";
		 }
		 if (c==null||c.length()==0)
		 {
			c="上海";
		 }
		 if (d==null||d.length()==0)
		 {
		   d=null;	
		   area=p+c;
		 }
		 else
		 {
		   area=p+c+d;	
		 }
		 Long totalNum=publicationService.getPublicationTotalNum(area);
		 List<Publication> publications=publicationService.findByPage(area,1,Constants.ORDER_BY_PUBLICATION_TIME);
		 request.setAttribute("totalNum",totalNum);
		 request.setAttribute("pageNum",1);
		 request.setAttribute("publications",publications);
		 request.setAttribute("p",p);
		 request.setAttribute("c",c);
		 request.setAttribute("d",d);
		 request.setAttribute("orderType",0);
		 return "index";
	 }
	 
	 
	 /*
	  * 退出登录
	  * */
	  @RequestMapping(value="/logout")
	  public String logoutDo(HttpServletRequest request)
	  {
		  HttpSession session=request.getSession();
		  if (session!=null)
		  {
			 session.invalidate();
		  }
		  return "forward:index";
	  }
	  
	 /*
	  * 忘记密码
	  * */
	 
	  
	 /*
	  * 模板
	  * */
	 @RequestMapping(value="/template/{template}")
     public String templateDispacher(@PathVariable String template)
     {
    	 return "template/"+template;
     }
	 
	 /*
	  * 搜索
	  */
	 @RequestMapping(value="/page")
	 public String publicationDo(Integer pageNum, String p,String c,
			 String d,String searchKey, Byte workType,Byte orderType,
			 HttpServletRequest request) throws IOException
	  {		 
		 String area=null;
		 if (p==null||p.length()==0)
		 {
			p="上海";
		 }
		 if (c==null||c.length()==0)
		 {
			c="上海";
		 }
		 if (d==null||d.length()==0)
		 {
		   d=null;	
		   area=p+c;
		 }
		 else
		 {
		   area=p+c+d;	
		 }
		 if (pageNum==null||pageNum<1)
		 {
		    pageNum=1;
		 }
		 if(workType==null)
		 {
			 workType=null;
		 }
		 if(orderType==null)
		 {
			 orderType = 0;
		 }
		 long totalNum = publicationService.getPublicationTotalNum(area, workType, searchKey);
		 List<Publication> publications=publicationService.findByPage(area, workType, searchKey, pageNum, orderType);
		 request.setAttribute("totalNum",totalNum);
		 request.setAttribute("publications",publications);
		 request.setAttribute("p",p);
		 request.setAttribute("c",c);
		 request.setAttribute("d",d);
		 request.setAttribute("workType",workType);
		 request.setAttribute("pageNum",pageNum);
		 request.setAttribute("searchKey",searchKey);
		 request.setAttribute("orderType",orderType);
		 return "index";		 
	 }
		 
}
