<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="center-r-content col-md-12">
 	<div class="title"><h4>个人信息</h4></div>
 	<ul class="list-unstyled ul-info">
 		<li>
 			电话：<label>${employee.cellphone}</label>
 		</li>
 		<li>姓名：<label>${employee.employeeName}</label></li>
 		<li>性别：<label><c:if test="${employee.gender=='M'}">男</c:if><c:if test="${employee.gender=='F'}">女</c:if></label><button class="btn btn-link" ng-click="vm.changeType()" ng-bind="vm.clickUpdate"></button></li>
 	</ul>
 	<form class="form-inline updateinfo-form" name="updatePassForm" ng-show="vm.isShow" novalidate>
 		<div class="form-group" ng-class="{'has-error':updatePassForm.name.$invalid&&updatePassForm.name.$dirty}">
 			<label>姓名：</label>
 			<input type="text" value="" class="form-control" name="name" ng-model="vm.name" ng-minlength="2" maxlength="5" autocomplete="off" required/>
 		</div>
 		<div class="rows" style="height:10px;"></div>
 		<div class="form-group">
 			<label>性别：</label>
 			<select class="form-control" name="sex" ng-model="vm.sex">
				<c:if test="${employee.gender=='M'}"><option ng-selected="true" value="M">男</option><option value="F">女</option></c:if>
				<c:if test="${employee.gender=='F'}"><option  value="M">男</option><option ng-selected="true" value="F">女</option></c:if>
			</select>
 		</div>
 		<div class="rows" style="height:10px;"></div>
 		<div class="form-group">
 			<label style="color:#fff">表单：</label>
 			<button class="btn btn-primary" ng-disabled="updatePassForm.$invalid" ng-click="vm.updateInfo()">确定修改</button>
 		</div>
 	</form>
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