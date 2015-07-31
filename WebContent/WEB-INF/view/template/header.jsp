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

<div id="nav" class="nav-default">
    <div id="nav-content" class="clear">
        <div class="nav-content-l nav-default-content-l">
            <i class="nav-icon-address"></i><span id="nav-content-province"></span>[<span class="nav-change-city" id="nav-content-change-city">切换城市</span>]
        </div>
        <div class="nav-content-r nav-default-content-r">
            <ul>
                <li><span>您好&nbsp;${sessionScope.user.userName} ，欢迎来到聚职团！</span><c:if test="${user!=null}">[<a href="<%=basePath%>/logout">退出</a>]</c:if></li>
                <c:if test="${user==null}">
                	<li><a href="<%=basePath%>/employee/login">用户登录</a></li>
                	<li><a href="<%=basePath%>/employee/register">用户注册</a></li>
                </c:if>
                <c:if test="${user!=null&&user.userType==0}">
                	<li><a href="<%=basePath%>/employee/center">个人中心</a></li>
                </c:if>
                <%-- <li><i class="nav-icon-phone"></i><a href="">手机端下载</a></li>
                <li><a href="<%=basePath%>/about">关于我们</a></li> --%>
            </ul>
        </div>
    </div>
</div>