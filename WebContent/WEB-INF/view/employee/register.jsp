<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html ng-app="registerMain">
<head lang="en">
    <meta charset="UTF-8">
    <meta name="keywords" content="兼职网,酒店兼职网,聚职团兼职网,聚职团兼职,兼职网站大全,大学生兼职网站,可靠,可信,专业,安全兼职,大学生兼职,上海学生兼职,兼职应用">
    <meta content="聚职团(web.juzhituan.com)是一个真实可靠的找兼职平台。我们的兼职信息都经过多重核查，兼职信息真实度高达99.9%。通过聚职团您可以一手掌握最新的酒店兼职信息，还可以根据个人实际情况来推荐个性化兼职，更高效找到可靠的兼职赚钱方法。赶快加入我们吧" name="description">
    <meta content="聚职团酒店兼职平台" name="application-name">
    <meta content="聚职团酒店兼职平台" name="msapplication-tooltip">
    <meta name="renderer" content="webkit">
    <title>聚职团用户注册--聚天下兼职，我们组团去！</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/images/logo/icon.png" media="screen" />
    <link href="<%=basePath%>/css/main.css" rel="stylesheet" type="text/css"/>
	<script>
		document.createElement('ng-include');
	</script>
</head>
<body ng-controller="employee.register.ctrl">
<div id="logo" class="clear">
    <div class="logo-l">
        <a href="<%=basePath%>"><img src="<%=basePath%>/images/logo/logo.png" alt="Logo"/></a>
        <h2>欢迎注册</h2>
    </div>
    <div class="logo-r">
        <a href="<%=basePath%>/index">返回首页</a>
    </div>
</div>
<div class="underline6"></div>
<div id="container-reg">
    <div class="register-type">
        <a class="active">用户注册</a>
    </div>
    <div class="registerArea">
        <form name="registerForm" action="" method="post" class="employee" novalidate>
            <div class="input-out-style">
                <label>手机号：</label>
                <input type="text" value="" name="phone" ng-model="vm.phone" ng-pattern="/^[0-9]{11}/" maxlength="11" placeholder="请输入有效手机号" autocomplete="off" ng-change="vm.varifyPhone()" required/>
                <span ng-show="registerForm.phone.$invalid&&registerForm.phone.$dirty" class="input-error">请输入11位手机号</span>
            	<span class="input-error" id="phone-is-userful" style="display:none;">手机号已注册过，请登录</span>
            </div>
            <div class="input-out-style">
                <label>短信验证码：</label>
                <input type="text" value="" name="smsVerify" ng-minlength="4" ng-pattern="/^[0-9]{4}/" ng-model="vm.smsVerify" placeholder="请输入短信验证码" class="short" maxlength="4" autocomplete="off" required/>
                <a class="btn btn-send-mess" ng-click="vm.getSMSVerify()" id="sendMessBtn">获取短信验证码</a>
                <span class="input-error" id="Countdown">还剩{{vm.CountdownTip}}秒重新发送</span>
                <span class="input-error" ng-show="registerForm.smsVerify.$invalid&&registerForm.smsVerify.$dirty">请输入4位数字验证码</span>
            </div>
            <div class="input-out-style">
            	<label>姓名：</label>
            	<input type="text" value="" name="name" ng-model="vm.name" ng-minlength="2" maxlength="5" class="min" required/>
            	<span class="input-error" ng-show="registerForm.name.$invalid&&registerForm.name.$dirty">请输入真实姓名</span>
            </div>
            <div class="input-out-style">
                <label>性别：</label>
                <select ng-model="vm.sex" name="sex" ng-init="vm.sex='M'" required>
                    <option ng-selected="true" value="M">男</option>
                    <option value="F">女</option>
                </select>
            </div>
            <div class="input-out-style">
                <label>密码：</label>
                <input type="password" value="" name="password" ng-minlength="6" placeholder="请输入密码" ng-model="vm.password" maxlength="20" autocomplete="off" required/>
                <span ng-show="registerForm.password.$invalid&&registerForm.password.$dirty" class="input-error">密码不能少于6位</span>
            </div>
            <div class="input-out-style">
                <label>确认密码：</label>
                <input type="password" value="" name="confirmPass" ng-model="vm.confirmPass" placeholder="请确认密码"  maxlength="20" autocomplete="off"/>
                <span ng-show="vm.confirmPass!=vm.password && registerForm.confirmPass.$dirty" class="input-error">两次密码输入不一致</span>
            </div>
            <div class="reg-btn"><a class="btn btn-register" ng-click="vm.submitForm()">同意以下协议并注册</a><span>已有账号？<a href="" class="login-href">马上登陆</a></span></div>
            <div class="xieyi"><a href="<%=basePath%>/download/聚职团与用户协议.pdf" target="_blank">《聚职团与用户协议》</a></div>
        </form>
    </div>
</div>
<div class="modal-success-opacity"></div>
<div class="modal-success"></div>
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
<script src="<%=basePath%>/js/common/angular.js"></script>
<script src="<%=basePath%>/js/common/jquery.js"></script>
<script src="<%=basePath%>/js/module/registerMain.js"></script>
<script src="<%=basePath%>/js/service/service.js"></script>
</body>
</html>