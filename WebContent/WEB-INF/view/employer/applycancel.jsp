<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="center-r-content col-md-12" id="apply-cancel">
 	<div class="title"><h4>申请取消</h4></div>
 	<table class="table table-striped">
 		<thead>
 			<tr>
 				<th>活动时间</th>
 				<th>已招人数</th>
 				<th>操作</th>
 			</tr>
 		</thead>
 		<tbody>
 			<tr ng-repeat="list in vm.activityList">
				<td class="none">{{list.time}}</td>
				<td>招聘人数{{list.recruiteNum}}，已报{{list.number}}人</td>
				<td ng-if="list.isCancle"><input type="checkbox" value="{{list.id}}"/></td>
				<td ng-hide="list.isCancle">不能取消（已过取消时间）</td>
			</tr>
 		</tbody>
 	</table>
 	<form class="form-inline applycancel-form" name="applyCancleForm">
  		<div class="form-group">
		    <label for="title">申请理由：</label>
		    <textarea class="form-control" rows="3" cols="40" placeholder="不能为空" name="content" ng-model="vm.content" ng-minlength="4" maxlength="100" required></textarea>
  		</div>
  		<div class="rows" style="height:10px;"></div>
  		<div class="form-group">
  			 <label style="color:#fff">提交申请：</label>
  			 <button ng-click="vm.submitApply()" class="btn btn-primary" ng-disabled="applyCancleForm.content.$invalid">提交申请</button>
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
<div class="modal-opacity"></div>
<div class="modal-out">
	<div class="my-modal modal-confirm">
		<h1>是否确认取消订单？已收取的费用将不会退还，请仔细考虑！</h1>
		<div class="my-modal-content">
			<p class="modal-confirm-content">如果取消整个活动可以在已取消活动中找到，如果仅取消一天或若干天则不能再已取消活动中找到。</p>
		</div>
		<div class="my-modal-bottom">
			<a class="btn closeBtn" ng-click="vm.closeModal()">否</a>
            <a class="btn confirmBtn" ng-click="vm.confirmCancle()">确定</a>
		</div>
	</div>
</div>