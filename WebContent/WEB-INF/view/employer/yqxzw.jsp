<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="center-r-content col-md-12">
 	<div class="title"><h4>已取消职位</h4></div>
	<div class="rows" style="height:4px;"></div>
 	<table class="table table-striped">
  		<thead>
  			<tr>
  				<th>活动标题</th>
  				<th>发布时间</th>
  				<th>工作时间</th>
  				<th>联系方式</th>
  				<th>工作地点</th>
  				<th>当前状态</th>
  			</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="list" items="${publications}">
	  			<tr>
	  				<td>${fn:substring(list.title,0,11)}</td>
	  				<td><c:out value="${fn:substring(list.publicationTime,0,19)}"></c:out></td>
	  				<td>${list.startDate}</td>
	  				<td>${list.contactName}（${list.cellphone}）</td>
	  				<td><abbr title="${list.workAddress}">${fn:substring(list.workAddress,0,19)}</abbr></td>
	  				<td>
	  					<c:if test="${list.state==2}">取消等待中</c:if>
	  					<c:if test="${list.state==3}">已取消</c:if>
	  				</td>
	  			</tr>
  			</c:forEach>
  		</tbody>
	</table>
</div>
<input type="hidden" value="${totalNum}" id="totalNum"/>
<c:if test="${totalNum==null}"><div class="no-record col-md-12 alert alert-danger" role="alert">您还没有取消过活动！</div></c:if>
<div id="page2" class="col-md-12">
	<ul class="page-list">
		<li ng-repeat="list in vm.pageList" ng-bind="list" ng-class="{active:list==vm.currPage}" ng-click="vm.changePage(list)"></li>
	</ul>
</div>
<div class="modal-opacity"></div>
<div class="modal-out">
	<div class="my-modal modal-tip-error">
		<h1>提示</h1>
		<div class="my-modal-content">
			<p class="modal-confirm-content"></p>
		</div>
		<div class="my-modal-bottom">
            <a class="btn confirmBtn" ng-click="vm.closeModal()">确定</a>
		</div>
	</div>
</div>