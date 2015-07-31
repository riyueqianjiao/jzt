<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="center-r-content col-md-12 hd-detail">
 	<div class="title"><h4>活动详情</h4></div>
 	<ul class="list-unstyled hd-detail-list">
 		<li>活动标题：<span ng-bind="vm.dataList.title"></span>+<span ng-hide="vm.dataList.isLong">工作<span ng-bind="vm.dataList.workDuration"></span>天+<span ng-bind="vm.dataList.salary"></span>/天</span></li>
 		<li>发布时间：<span ng-bind="vm.dataList.publicationTime"></span></li>
 		<li>工作地址：<span ng-bind="vm.dataList.workAddress"></span></li>
 		<li>工作时间：<span ng-bind="vm.dataList.startDate"></span>&nbsp;<span ng-bind="vm.dataList.workTimeInfo"></span></li>
 		<li>工作要求：<span ng-bind="vm.dataList.requirement"></span></li>
 		<li>报名情况：
 			<table class="table table-striped">
	 			<thead>
		  			<tr>
		  				<th>工作时间</th>
		  				<th>共招人数</th>
		  				<th>已招人数</th>
		  			</tr>
	  			</thead>
	  			<tbody>
	  				<tr ng-repeat="list in vm.dataList.activities">
	  					<td ng-bind="list.date"></td>
	  					<td ng-bind="list.recruitNum"></td>
	  					<td ng-bind="list.applyNum"></td>
	  				</tr>
	  			</tbody>
  			</table>
 		</li>
 	</ul>
</div>