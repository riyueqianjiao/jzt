<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="center-r-content col-md-12">
 	<div class="title"><h4>公司信息</h4></div>
 	<ul class="list-unstyled ul-info">
 		<li>
 			公司名称：<label>${employer.companyName}</label>
 		</li>
 		<li>入住时间：<label>${fn:substring(employer.registerTime,0,19)}</label></li>
 		<li>联系方式：<label>${employer.cellphone}</label></li>
 		<li>联系人名：<label>${employer.contactName}</label></li>
 		<li>公司地址：<label>${employer.companyAddress}</label></li>
 		<li>公司邮箱：<label><c:if test="${employer.email==null}">未填写</c:if><c:if test="${employer.email!=null}">${employer.email}</c:if></label><button class="btn btn-link" ng-click="vm.changeType()" ng-bind="vm.clickUpdate"></button></li>
 	</ul>
 	<form class="form-inline updateinfo-form" name="updatePassForm" ng-show="vm.isShow" novalidate>
 		<div class="form-group" ng-class="{'has-error':updatePassForm.phone.$invalid&&updatePassForm.phone.$dirty}">
 			<label>联系方式：</label>
 			<input type="text" value="" class="form-control" name="phone" ng-model="vm.phone" ng-pattern="/^[0-9]{11}/" maxlength="11" autocomplete="off" required/>
 		</div>
 		<div class="rows" style="height:10px;"></div>
 		<div class="form-group" ng-class="{'has-error':updatePassForm.email.$invalid&&updatePassForm.email.$dirty}">
 			<label>公司邮箱：</label>
 			<input type="email" value="" class="form-control" name="email" ng-model="vm.email" autocomplete="off" required/>
 		</div>
 		<div class="rows" style="height:10px;"></div>
 		<div class="form-group">
 			<label style="color:#fff">提交表单：</label>
 			<button class="btn btn-primary" ng-disabled="updatePassForm.$invalid" ng-click="vm.updateInfo()">确定修改</button>
 		</div>
 	</form>
</div>
<div class="modal-opacity"></div>
<div class="modal-out">
	<div class="my-modal modal-tip-error">
		<h1>错误提示</h1>
		<div class="my-modal-content">
			<p class="modal-confirm-content"></p>
		</div>
		<div class="my-modal-bottom">
            <a class="btn confirmBtn" ng-click="vm.closeModal()">确定</a>
		</div>
	</div>
</div>