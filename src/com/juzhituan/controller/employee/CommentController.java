package com.juzhituan.controller.employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juzhituan.constant.Constants;
import com.juzhituan.domain.Comment;
import com.juzhituan.service.CommentService;
import com.juzhituan.util.JSONUtil;
import com.juzhituan.validator.CommentValidator;
import com.juzhituan.vo.User;

/*
 * url
 * 
 * 1）/comment/comment              	      GET     用户评论
 * 2）/comment/comment            	      POST    用户评论
 * 
 * 3）/comment/viewComments               GET     查看用户评论
 * 
 * * */
@Controller
@RequestMapping(("/comment"))
public class CommentController
{
	@Autowired
	private CommentService commentService;
	/*
	    * 用户评论
	    * 1）
	    * 2）
	    * */
	   @RequestMapping(value="/comment",method=RequestMethod.GET) 
	   public String comment(HttpServletResponse response) throws IOException
	   {
		   return "employee/comment";
	   }
	   @RequestMapping(value="/comment",method=RequestMethod.POST)
	   public void commentDo(Comment comment,int publicationId,HttpServletRequest request,HttpServletResponse response) throws IOException
	   {
		   Map<String, String> error = CommentValidator.validation(comment);
		   if(error.size()>0)
	 	     {
	 		   JSONUtil.outputError(error, response);
	 	     }
		   else
		   {
			   User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
			   if(commentService.findComment(user.getUserId(), publicationId)==null)
			   {
				   commentService.comment(user.getUserId(),publicationId,comment);
				   JSONUtil.outputStatus(true, response);
			   }
			   else
			   {
				   error.put("repeat", "您已对此职位做过评价");
				   JSONUtil.outputError(error, response);			   
			   }
			   
		   }	   	   
	   }
		 @RequestMapping(value="/viewComments")
		 public void viewComments(Integer employerId,Integer pageNum,boolean flag,HttpServletResponse response) throws IOException
		 {
			 Long pageTotalNum = 0l;
			 Map<String, String> error=new HashMap<String, String>();
			 if(employerId == null ||"".equals(employerId))
			 {
				 error.put("employerIdIsEmpty", "employerId为空");
				 JSONUtil.outputError(error, response);
				 return;
			 }
			 if (pageNum==null||pageNum<1)
			 {
			    pageNum=1;
			 }
			 if(flag)  //flag为true是表示第一次请求，返回总页数
			 {
				 pageTotalNum = commentService.getTotalNum(employerId);
			 }
			 List<Comment> comments = commentService.findCommentByPage(employerId, pageNum);
			 if(comments == null)
			 {
				 error.put("empty","暂无评论");
				 JSONUtil.outputError(error, response);
			 }
			 else
			 {
				 JSONUtil.outputComment(comments, pageTotalNum,response);
			 }
		 }


}
