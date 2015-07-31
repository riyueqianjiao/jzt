<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="center-r-content col-md-12">
 	<div class="title"><h4>已报名活动</h4></div>
	<div class="rows" style="height:4px;"></div>
	<table class="table table-striped">
  		<thead>
  			<tr>
  				<th>活动标题</th>
  				<th>工作时间</th>
  				<th>薪资</th>
  				<th>工作地点</th>
  				<th>当前状态</th>
  				<th>操作</th>
  			</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="list" items="${publications}">
	  			<tr>
	  				<td><a href="../publication/${list.publicationId}" target="_blank">${fn:substring(list.title,0,11)}</a></td>
	  				<td>${list.startDate}&nbsp;${list.workTimeInfo}</td>
	  				<td>${list.salary}
	  				<c:choose>
	  					<c:when test="${list.isLong==0}">/天</c:when>
	  					<c:otherwise>/月 </c:otherwise>
	  				</c:choose>
	  				<td><abbr title="${list.workAddress}">${fn:substring(list.workAddress,0,19)}</abbr></td>
	  				<td>
	  					报名成功，
	  					<c:choose>
						   <c:when test="${list.state==0}">报名未截止</c:when>
						   <c:when test="${list.state==1}">报名已结束</c:when>
						   <c:when test="${list.state==2}">商家申请取消中</c:when>
						   <c:when test="${list.state==3}">活动已取消</c:when>
						   <c:otherwise>活动已结束 </c:otherwise>
						</c:choose>
					</td>
	  				<td>
	  					<a ng-click="vm.getDetail(${list.publicationId})">报名详情</a>
	  					<c:if test="${list.state!=3&&list.state!=4}"><a ng-click="vm.showConfirmModal(${list.publicationId})">取消报名</a></c:if>	
	  				</td>
	  			</tr>
  			</c:forEach>
  		</tbody>
  	</table>
</div>
<input type="hidden" value="${totalNum}" id="totalNum"/>
<c:if test="${totalNum==null}"><div class="no-record col-md-12 alert alert-danger" role="alert">你还未参加过任何工作，赶快去首页找找吧！</div></c:if>
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
<div class="modal-opacity"></div>
<div class="modal-out">
	<div class="my-modal modal-cancle-signUp">
		<h1>请至少选择一天进行取消</h1>
		<div class="my-modal-content">
			<table>
				<thead>
					<tr>
						<td class="none">时间</td>
						<td width="140">薪资</td>
						<td width="100"><span ng-click="vm.selectAll()" ng-bind="vm.isSelectType" class="operator"></span></td>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="list in vm.acitivitiesList">
						<td class="none">
							<p class="int">{{list.time}}</p>
						</td>
						<td>{{list.salary}}</td>
						<td ng-if="list.isCancle"">
							<input type="checkbox" value="{{list.id}}" ng-checked="vm.checked"/>
						</td>
						<td ng-hide="list.isCancle">过取消时间</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="my-modal-bottom">
			<a class="btn closeBtn" ng-click="vm.closeModal()">关闭</a>
			<a class="btn confirmBtn" ng-click="vm.confirmCancle()">确定取消</a>
		</div>
	</div>
</div>
<div class="modal-opacity"></div>
<div class="modal-out">
	<div class="my-modal modal-confirm">
		<h1>是否确认取消报名？</h1>
		<div class="my-modal-content">
			<p class="modal-confirm-content">取消报名一天之内将不能再报名任何活动，请仔细考虑...</p>
		</div>
		<div class="my-modal-bottom">
			<a class="btn closeBtn" ng-click="vm.closeModal()">否</a>
            <a class="btn confirmBtn" ng-click="vm.showDataModal()">确定</a>
		</div>
	</div>
</div>
<div class="modal-opacity"></div>
<div class="modal-out">
	<div class="my-modal modal-detail-signUp">
		<h1>报名详情</h1>
		<div class="my-modal-content">
			<table>
				<thead>
					<tr>
						<td class="none">时间</td>
						<td width="140">薪资</td>
						<td width="100">状态</td>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="list in vm.acitivitiesList">
						<td class="none">
							<p class="int">{{list.time}}</p>
						</td>
						<td>{{list.salary}}</td>
						<td>已报名</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="my-modal-bottom">
			<a class="btn closeBtn" ng-click="vm.closeModal()">关闭</a>
		</div>
	</div>
</div>