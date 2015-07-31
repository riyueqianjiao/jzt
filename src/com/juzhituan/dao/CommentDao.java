package com.juzhituan.dao;

import java.util.List;

import com.juzhituan.domain.Comment;

public interface CommentDao extends BaseDao<Comment>
{
	public Comment findComment(Integer employeeId,Integer publicationId);
	public Long getTotalNum(Integer employerId);
	public List<Comment> fingCommentBypage(Integer employerId,Integer pageNum);
	public List<Object[]> findCommentByEmployeeId(Integer employerId,Integer pageNum);

}
