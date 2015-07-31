<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title>聚职团商家注册--聚天下兼职，我们组团去！</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/images/logo/icon.png" media="screen" />
    <link href="<%=basePath%>/css/main.css" rel="stylesheet" type="text/css"/>
	<script>
		document.createElement('ng-include');
	</script>
</head>
<body ng-controller="employer.register.ctrl">
<div id="logo" class="clear">
    <div class="logo-l">
        <a href="<%=basePath%>"><img src="<%=basePath%>/images/logo/logo.png" alt="Logo"/></a>
        <h2>商家注册</h2>
    </div>
    <div class="logo-r">
        <a href="<%=basePath%>/index">返回首页</a>
    </div>
</div>
<div id="container-reg">
    <div class="register-type">
        <a class="active">商家注册</a>
    </div>
    <div class="apply-lct">
        <div class="lct lct1 active">信息核对</div>
        <div class="lct-line lct-line1" ng-class="vm.line2Active"></div>
        <div class="lct lct2" ng-class="vm.bz2Active">注册成功</div>
    </div>
    <div class="registerArea">
        <form name="registerForm" action="" method="post" class="employer" ng-class="{hideForm:vm.hideForm}" novalidate>
            <div class="input-out-style" ng-hide="vm.showFormList">
            	<label>手机号：</label>
            	<input type="text" value="" name="phone" ng-model="vm.phone" maxlength="11" ng-pattern="/^[0-9]{11}/" autocomplete="off" required/>
            	<span class="input-error" ng-show="registerForm.phone.$invalid&&registerForm.phone.$dirty">请输入手机号</span>
            	<span class="input-error" ng-show="registerForm.key.$invalid&&registerForm.key.$dirty">请输入13许可证号</span>
            </div>
            <div class="input-out-style"  ng-hide="vm.showFormList">
                <label>许可证：</label>
                <input type="text" value="" name="key" ng-model="vm.key" ng-pattern="/^[0-9]{13}/" ng-minlength="13" ng-maxlength="13" maxlength="13" placeholder="请输入我们已给您发送的许可证号" autocomplete="off" required/>
                <span class="input-error">*如果还没有许可证号请先申请</span>
                <a href="<%=basePath%>/employer/apply" class="">点击申请</a>
            </div>
            <div class="input-out-style"  ng-hide="vm.showFormList">
            	<label></label>
            	<a class="btn btn-send-mess" ng-click="vm.sendKey()">验证许可证</a>
            </div>
            <div ng-show="vm.showFormList">
            <div class="input-out-style">
                <label>公司名称：</label>
                <input type="text" value="" autocomplete="off" name="company" ng-model="vm.company" ng-disabled="true"/>
            </div>
            <div class="input-out-style">
                <label>联系人：</label>
                <input type="text" value="" name="name" autocomplete="off" ng-model="vm.name" ng-disabled="true"/>
            </div>
            <div class="input-out-style">
                <label>座机号：</label>
                <input type="text" value="" name="tel" autocomplete="off" ng-model="vm.tel" ng-disabled="true"/>
            </div>
            <div class="input-out-style">
                <label>公司地址：</label>
                <input type="text" value="" name="address" autocomplete="off" ng-model="vm.address" ng-disabled="true"/>
            </div>
            <div class="input-out-style">
                <label>详细地址：</label>
                <input type="text" value="" name="detail" autocomplete="off" ng-model="vm.detail" ng-disabled="true"/>
            </div>
            <div class="input-out-style">
                <label>用户名：</label>
                <input type="text" value="" name="username" autocomplete="off" ng-model="vm.username" ng-minlength="4" placeholder="请输入登陆用户名" required/>
                <span ng-show="registerForm.username.$invalid&&registerForm.username.$dirty" class="input-error">用户名不能少于4位</span>
            </div>
            <div class="input-out-style">
                <label>密码：</label>
                <input type="password" value="" name="password" ng-minlength="6" placeholder="请输入密码" ng-model="vm.password" maxlength="20" autocomplete="off" required/>
                <span ng-show="registerForm.password.$invalid&&registerForm.password.$dirty" class="input-error">密码不能少于6位</span>
            </div>
            <div class="input-out-style">
                <label>确认密码：</label>
                <input type="password" value="" name="confirmPass" ng-model="vm.confirmPass" placeholder="请确认密码"  autocomplete="off" maxlength="20" required/>
                <span ng-show="vm.confirmPass!=vm.password && registerForm.confirmPass.$dirty" class="input-error">两次密码输入不一致</span>
            </div>
            <div class="reg-btn"><a class="btn btn-register" ng-click="vm.submitForm()">同意以下协议并注册</a><span>已有账号？<a href="" class="login-href">马上登陆</a></span></div>
            <div class="xieyi"><a href="<%=basePath%>/download/聚职团与商家协议.pdf" target="_blank   ">《聚职团与商家协议》</a></div>
            </div>
        </form>
         <div class="waitVerify">
    		<a href="login">点击登录</a>
   		 </div>
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