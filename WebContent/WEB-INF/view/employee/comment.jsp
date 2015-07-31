<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="center-r-content col-md-12">
 	<div class="title"><h4>评价活动</h4></div>
 	 <form class="form-inline comment-form" name="updatePassForm"  novalidate>
 	 	<div class="form-group">
 			<label>工作环境打分：</label>
 			<i ng-class="{active:vm.workExponent>=1}" ng-click="vm.workExponent=1"></i>
 			<i ng-class="{active:vm.workExponent>=2}" ng-click="vm.workExponent=2"></i>
 			<i ng-class="{active:vm.workExponent>=3}" ng-click="vm.workExponent=3"></i>
 			<i ng-class="{active:vm.workExponent>=4}" ng-click="vm.workExponent=4"></i>
 			<i ng-class="{active:vm.workExponent>=5}" ng-click="vm.workExponent=5"></i>	 	
 	 	</div>
 	 	<div class="rows" style="height:10px;"></div>
 	 	<div class="form-group">
 			<label>工作环境打分：</label>
 			<i ng-class="{active:vm.salaryExponent>=1}" ng-click="vm.salaryExponent=1"></i>
 			<i ng-class="{active:vm.salaryExponent>=2}" ng-click="vm.salaryExponent=2"></i>
 			<i ng-class="{active:vm.salaryExponent>=3}" ng-click="vm.salaryExponent=3"></i>
 			<i ng-class="{active:vm.salaryExponent>=4}" ng-click="vm.salaryExponent=4"></i>
 			<i ng-class="{active:vm.salaryExponent>=5}" ng-click="vm.salaryExponent=5"></i>	
 	 	</div>
 	 	<div class="rows" style="height:10px;"></div>
 	 	<div class="form-group">
 	 		<label>输入评价内容：</label>
 	 		<textarea class="form-control" cols="40" rows="4" name="content" ng-model="vm.content" ng-keyup="vm.commentNum=vm.content.length" placeholder="至少输入两个字符" maxlength="60"></textarea>
	 			还可以写入<span ng-bind="60-vm.commentNum"></span>个汉字
 	 	</div>
 	 	<div class="rows" style="height:10px;"></div>
 	 	<div class="form-group">
 	 		<label style="color:#fff;">确定提交评论：</label>
 	 		<button class="btn btn-primary" ng-click="vm.sumbitComment()" ng-disabled="vm.salaryExponent<1||vm.workExponent<1||vm.content.length<2">提交评论</button>
 	 	</div>
 	 </form>
</div> 
<!-- <div class="content comment">
	 <h2>活动评价</h2>
	 <div class="content-comment">
	 	<div class="content-comment-title">
	 		<h3>评论内容</h3>
	 		<i class="icon-comment"></i>
	 		<a class="to-comment">开始评论</a>
	 	</div>
	 	<div class="content-comment-detail">
	 		<div class="input-out-style">
	 			<label>工作环境打分：</label>
	 			<i ng-class="{active:vm.workExponent>=1}" ng-click="vm.workExponent=1"></i>
	 			<i ng-class="{active:vm.workExponent>=2}" ng-click="vm.workExponent=2"></i>
	 			<i ng-class="{active:vm.workExponent>=3}" ng-click="vm.workExponent=3"></i>
	 			<i ng-class="{active:vm.workExponent>=4}" ng-click="vm.workExponent=4"></i>
	 			<i ng-class="{active:vm.workExponent>=5}" ng-click="vm.workExponent=5"></i>
	 		</div>
	 		<div class="input-out-style">
	 			<label>工资发放打分：</label>
	 			<i ng-class="{active:vm.salaryExponent>=1}" ng-click="vm.salaryExponent=1"></i>
	 			<i ng-class="{active:vm.salaryExponent>=2}" ng-click="vm.salaryExponent=2"></i>
	 			<i ng-class="{active:vm.salaryExponent>=3}" ng-click="vm.salaryExponent=3"></i>
	 			<i ng-class="{active:vm.salaryExponent>=4}" ng-click="vm.salaryExponent=4"></i>
	 			<i ng-class="{active:vm.salaryExponent>=5}" ng-click="vm.salaryExponent=5"></i>	
	 		</div>
	 		<div class="input-out-style">
	 			<label>评价内容：</label>
	 			<textarea cols="50" rows="8" name="content" ng-model="vm.content" ng-keyup="vm.accountNum()"></textarea>
	 			还可以写入<span ng-bind="100-vm.commentNum"></span>个汉字
	 			
	 		</div>
	 		<div class="input-out-style">
	 			<label></label>
	 			<a class="btn btn-primary" ng-click="vm.sumbitComment()">提交内容</a>
	 		</div>
	 	</div>
	 </div>
</div> -->
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