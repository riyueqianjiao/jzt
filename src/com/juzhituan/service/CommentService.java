package com.juzhituan.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juzhituan.dao.CommentDao;
import com.juzhituan.dao.EmployeeDao;
import com.juzhituan.dao.PublicationDao;
import com.juzhituan.domain.Comment;
import com.juzhituan.domain.Employee;
import com.juzhituan.domain.Publication;


@Service
public class CommentService 
{
	@Autowired
  	private EmployeeDao employeeDao;
	@Autowired
	private PublicationDao publicationDao;
	@Autowired
	private CommentDao commentDao;
	//查看发表的评论
  	public Comment findComment(int employeeId,int publicationId) 
  	{
  		return commentDao.findComment(employeeId, publicationId);
  	}
  	//发表评论
  	public void comment(int employeeId,int publicationId,Comment comment)
  	{
  		Employee employee = employeeDao.get(Employee.class, employeeId);
  		Publication publication = publicationDao.get(Publication.class, publicationId);
  		comment.setEmployee(employee);
  		comment.setPublication(publication);
  		comment.setTime(new Date());
  		commentDao.save(comment); 		
  	}
  	//查看对某商家的所有评论数量
  	public Long getTotalNum(Integer employerId)
  	{
  		return commentDao.getTotalNum(employerId);
  	}

  	//分页查看对某商家的所有评论
  	public List<Comment> findCommentByPage(Integer employerId,Integer pageNum)
  	{
  		return commentDao.fingCommentBypage(employerId, pageNum);
  	}


}
