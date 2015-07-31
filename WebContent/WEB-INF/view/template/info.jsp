<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<%
   
	response.setHeader("Pragma","No-cache");      
	response.setHeader("Cache-Control","no-cache");      
	response.setDateHeader("Expires", -10);   
	
%>
<div id="header">
	<h2>您好，<a class="name">${user.userName}</a>，欢迎登陆聚职团<c:if test="${user.userType==1}">商家</c:if><c:if test="${user.userType==0}">个人</c:if>管理中心<a href="<%=basePath%>/logout">[退出]</a><a href="<%=basePath%>/index">[首页]</a></h2>
</div>