<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html ng-app="loginMain">
<head lang="en">
    <meta charset="UTF-8">
    <meta name="keywords" content="兼职网,酒店兼职网,聚职团兼职网,聚职团兼职,兼职网站大全,大学生兼职网站,可靠,可信,专业,安全兼职,大学生兼职,上海学生兼职,兼职应用">
    <meta content="聚职团(web.juzhituan.com)是一个真实可靠的找兼职平台。我们的兼职信息都经过多重核查，兼职信息真实度高达99.9%。通过聚职团您可以一手掌握最新的酒店兼职信息，还可以根据个人实际情况来推荐个性化兼职，更高效找到可靠的兼职赚钱方法。赶快加入我们吧" name="description">
    <meta content="聚职团酒店兼职平台" name="application-name">
    <meta content="聚职团酒店兼职平台" name="msapplication-tooltip">
    <meta name="renderer" content="webkit">
    <title>登陆聚职团--聚天下兼职，我们组团去！</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/images/logo/icon.png" media="screen" />
    <link href="<%=basePath%>/css/main.css" rel="stylesheet" type="text/css"/>
	<script>
		document.createElement('ng-include');
	</script>
</head>
<body ng-controller="login.employer.ctrl">
<div id="logo" class="clear">
    <div class="logo-l">
        <a href="<%=basePath%>"><img src="<%=basePath%>/images/logo/logo.png" alt="Logo"/></a>
        <h2>商家登陆</h2>
    </div>
    <div class="logo-r">
        <a href="<%=basePath%>/index">返回首页</a>
    </div>
</div>
<div id="login-bg">
    <div id="login-out">
    <form method='post' name="loginForm" novalidate>
        <div class="login-form">
            <span>手机号/用户名</span>
            <div class="input-out">
               <i class="icon-account"></i>
               <input type="text" class="inputClass" value="" name="account" ng-minlength="1" ng-model="vm.account" placeholder="手机号/用户名" autocomplete="off" ng-keyup="vm.keyUp($event)" required/>
            </div>
            <span>密码</span>
            <div class="input-out">
                <i class="icon-key"></i>
                <input type="password" class="inputClass" value="" name="password" ng-minlength="6" ng-maxlength="20" ng-model="vm.password" placeholder="密码" autocomplete="off" maxlength="20" ng-keyup="vm.keyUp($event)" required/>
            </div>
            <div class="verifyCode">
            	<input type="text" value="" class="verifyCodeInput" name="verifyCode" ng-model="vm.verifyCode" ng-minlength="4" maxlength="4" autocomplete="off" required/>
            	<a onclick="changeImageCode()"><img src="<%=basePath%>/imagecode" alt="验证码" id="imageCode"/></a>
            </div>
            <div class="autoLogin">
                <a href="<%=basePath%>/employer/apply">注册</a>|<a href="<%=basePath%>/employer/retrievePass">忘记密码？</a>
            </div>
            <a href="javascript:;" class="btn btn-login" ng-click="vm.login()">登&nbsp;&nbsp;&nbsp;&nbsp;录</a>
        </div>
        </form>
    </div>
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
<ng-include src="'<%=basePath%>/template/footer'"></ng-include>
<script>
    //change background image position
    window.onload = function(){
        var oImg = new Image();
        oImg.src= "<%=basePath%>/images/bg.jpg";
        oImg.onload = function(){
            var oDiv = document.getElementById("login-bg");
            oDiv.style.background = "url(<%=basePath%>/images/bg.jpg) no-repeat 0 0";
            var veiwWidth,iLeft;
            oImg = null;
            veiwWidth = document.documentElement.clientWidth;
            if(veiwWidth>1000){
                iLeft = (1920 - veiwWidth)/2;
                oDiv.style.backgroundPosition = -iLeft+ "px 0";
            }
        }
    }
    //改变image src
	function changeImageCode(){
		var verify=document.getElementById('imageCode');
		verify.setAttribute('src','<%=basePath%>/imagecode/?'+Math.random());
	}
</script>
<script src="<%=basePath%>/js/common/angular.js"></script>
<script src="<%=basePath%>/js/common/jquery.js"></script>
<script src="<%=basePath%>/js/module/loginMain.js"></script>
<script src="<%=basePath%>/js/service/service.js"></script>
</body>
</html>