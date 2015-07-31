<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="center-r-content col-md-12">
 	<div class="title"><h4>已发布职位</h4></div>
	<div class="rows" style="height:4px;"></div>
 	<table class="table table-striped">
  		<thead>
  			<tr>
  				<th>活动标题</th>
  				<th>工作时间</th>
  				<th>招聘次数</th>
  				<th>联系方式</th>
  				<th>工作地点</th>
  				<th>当前状态</th>
  				<th>操作</th>
  			</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="list" items="${publications}">
	  			<tr>
	  				<td><a href="../publication/${list.publicationId}" target="_blank">${fn:substring(list.title,0,11)}</a></td>
	  				<td><c:out value="${fn:substring(list.publicationTime,0,19)}"></c:out></td>
	  				<td>第${list.recruitmentTime}次招聘</td>
	  				<td>${list.contactName}（${list.cellphone}）</td>
	  				<td><abbr title="${list.workAddress}">${fn:substring(list.workAddress,0,19)}</abbr></td>
	  				<td>
	  					<c:if test="${list.state==0}">正在报名中</c:if>
	  					<c:if test="${list.state==2}">申请取消中</c:if>
	  				</td>
	  				<td>
	  					<c:if test="${list.state==0}"><a ng-href="#/applycancel/${list.publicationId}">申请取消</a></c:if>
	  					<c:if test="${list.state==1}"><a>报名结束</a></c:if>
	  					<a ng-href="#detail/${list.publicationId}">查看详情</a>
	  				</td>
	  			</tr>
  			</c:forEach>
  		</tbody>
	</table>
</div>
<input type="hidden" value="${totalNum}" id="totalNum"/>
<c:if test="${totalNum==null}"><div class="no-record col-md-12 alert alert-danger" role="alert">您还未发布过职位，马上去发布吧！</div></c:if>
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