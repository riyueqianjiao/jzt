<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html ng-app="applyMain">
<head lang="en">
    <meta charset="UTF-8">
    <title>商家申请--聚天下兼职，我们组团去！</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>/images/logo/icon.png" media="screen" />
    <link href="<%=basePath %>/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="logo" class="clear">
    <div class="logo-l">
        <a href="<%=basePath%>"><img src="<%=basePath%>/images/logo/logo.png" alt="Logo"/></a>
        <h2>商家申请</h2>
    </div>
    <div class="logo-r">
        <a href="<%=basePath%>/index">返回首页</a>
    </div>
</div>
<div id="container-apply" ng-controller="apply.ctrl">
    <div class="apply-lct">
        <div class="lct lct1 active">提交申请</div>
        <div class="lct-line lct-line1" ng-class="vm.line2Active"></div>
        <div class="lct lct2" ng-class="vm.bz2Active">线下认证</div>
    </div>
    <p class="tips">提示：如果您已成功申请，请点击快速注册！<a id="applyNext" href="<%=basePath%>/employer/register" target="_blank">快速注册</a></p>
    <div class="apply-area">
        <form name="applyForm" action="" method="post" class="applyForm" novalidate>
            <div class="input-out-style">
                <label>公司名称：</label>
                <input type="text" value="" autocomplete="off" placeholder="请输入公司名称" name="company" ng-minlength="1" ng-model="vm.company" required/>
                <span ng-show="applyForm.company.$invalid && applyForm.company.$dirty" class="input-error">公司名称不能为空</span>
            </div>
            <div class="input-out-style">
                <label>联系人：</label>
                <input type="text" value="" name="name" autocomplete="off" placeholder="请输入您的真实姓名" ng-minlength="1" ng-model="vm.name" required/>
                <span ng-show="applyForm.name.$invalid && applyForm.name.$dirty" class="input-error">联系人不能为空</span>
            </div>
            <div class="input-out-style">
                <label>手机号：</label>
                <input type="text" value="" name="phone" id="phone" autocomplete="off" ng-model="vm.phone" placeholder="请输入有效的联系电话" ng-pattern="/^[0-9]{11}/" maxlength="11" required/>
                <span ng-show="applyForm.phone.$invalid&&applyForm.phone.$dirty" class="input-error">请输入11位手机号</span>
            </div>
            <div class="input-out-style">
                <label>手机验证：</label>
                <input type="text" value="" name="validCode" ng-minlength="4" ng-model="vm.validCode" placeholder="请输入验证码" ng-pattern="/^[0-9]{4}/" class="short"  ng-keyup="vm.verifyValidCode()" autocomplete="off" maxlength="4" required/>
                <a class="btn btn-send-mess" ng-click="vm.getSMSVerify()"  id="sendMessBtn">获取短信验证码</a>
                 <span class="input-error" id="Countdown">还剩{{vm.CountdownTip}}秒重新发送</span>
                <span class="input-error" ng-show="applyForm.validCode.$invalid&&applyForm.validCode.$dirty">请输入4位手机验证码</span>
            </div>
            <div class="input-out-style">
                <label>座机号：</label>
                <input type="text" value="" name="telHeader" autocomplete="off" ng-model="vm.telHeader" ng-pattern="/^[0-9]{3,}/" maxlength="4" class="min" required/>-
                <input type="text" name="telTail" autocomplete="off" ng-model="vm.telTail" ng-pattern="/^[0-9]{7,}/" maxlength="8" class="short" required/>
                <span ng-show="applyForm.telHeader.$invalid&&applyForm.telHeader.$dirty" class="input-error">请输入座机区号</span>
                <span ng-show="applyForm.telTail.$invalid&&applyForm.telTail.$dirty" class="input-error">请输入座机尾号</span>
            </div>
            <div class="input-out-style">
                <label>公司地址：</label>
                <select ng-model="vm.province" name="province" ng-options="province.label for province in vm.provinces" ie-select-fix="options" required>
                    <option value="">-- 请选择省 --</option>
                </select>
                <select  ng-if="vm.province.cities" ng-model="vm.city" name="city"
                        ng-options="city.label for city in vm.province.cities" required>
                    <option value="">-- 请选择市 --</option>
                </select>
                <select ng-if="vm.city.areas" ng-model="vm.area" name="area" ng-options="area.label for area in vm.city.areas" required>
                    <option value="">-- 请选择区 --</option>
                </select>
                <span class="input-error" ng-show="applyForm.province.$invalid&&applyForm.province.$dirty">请选择地区</span>
            </div>
            <div class="input-out-style">
                <label>详细地址：</label>
                <input type="text" value="" placeholder="请输入公司详细地址" name="detail" ng-model="vm.detail" ng-minlength="1" required/>
            	<span class="input-error" ng-show="applyForm.detail.$invalid && applyForm.detail.$dirty">详细地址不能为空</span>
            </div>
            <div class="input-out-style">
                <label>公司介绍：</label>
                <textarea cols="32" rows="5" placeholder="随便说点什么呗..." name="summary" ng-model="vm.summary" ng-minlength="1" required></textarea>
            	<span class="input-error" ng-show="applyForm.summary.$invalid && applyForm.summary.$dirty">介绍不能为空</span>
            </div>
            <div class="btn-group"><a class="applyBtn" ng-click="vm.submitApply()">提 交 申 请</a></div>
        </form>
        <div class="waitVerify">
            我们将马上和你联系，请稍后！
        </div>
    </div>
</div>
<script src="<%=basePath %>/js/common/jquery.js"></script>
<script src="<%=basePath %>/js/common/angular.js"></script>
<script src="<%=basePath %>/js/module/applyMain.js"></script>
<script src="<%=basePath %>/js/directive/applydirective.js"></script>
<script src="<%=basePath %>/js/service/cityData.js"></script>
<script src="<%=basePath %>/js/directive/ie.select.js"></script>
</body>
</html>