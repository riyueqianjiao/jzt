<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="center-r-content col-md-12">
 	<div class="title"><h4>修改密码</h4></div>
    <form class="form-inline updatepass-form" name="updatePassForm"  novalidate>
        <div class="form-group" ng-class="{'has-error':updatePassForm.oldPass.$invalid&&updatePassForm.oldPass.$dirty}">
        	<label>当前密码：</label>
        	<input type="password" value="" name="oldPass" class="form-control" ng-minlength="6" ng-model="vm.oldPass" maxlength="20" required/>
        </div>
        <div class="rows" style="height:10px;"></div>
         <div class="form-group" ng-class="{'has-error':vm.password.length<6&&updatePassForm.password.$dirty}">
        	<label>输新密码：</label>
        	<input type="password" value="" name="password" class="form-control" ng-model="vm.password" maxlength="20" required/>
        </div>
         <div class="rows" style="height:10px;"></div>
         <div class="form-group">
        	<label>确认密码：</label>
        	<input type="text" value="" name="confirmPass" class="form-control" ng-model="vm.password" ng-disabled="true" required/>
        </div>
        <div class="rows" style="height:10px;"></div>
        <div class="form-group">
        	<label style="color:#fff;">提交密码：</label>
        	<button ng-click="vm.updatePass()" class="btn btn-primary" ng-disabled="updatePassForm.$invalid">确定修改</button>
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