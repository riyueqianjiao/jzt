<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html ng-app="employeeMain">
<head lang="en">
    <meta charset="UTF-8">
    <meta name="keywords" content="兼职网,酒店兼职网,聚职团兼职网,聚职团兼职,兼职网站大全,大学生兼职网站,可靠,可信,专业,安全兼职,大学生兼职,上海学生兼职,兼职应用">
    <meta content="聚职团(web.juzhituan.com)是一个真实可靠的找兼职平台。我们的兼职信息都经过多重核查，兼职信息真实度高达99.9%。通过聚职团您可以一手掌握最新的酒店兼职信息，还可以根据个人实际情况来推荐个性化兼职，更高效找到可靠的兼职赚钱方法。赶快加入我们吧" name="description">
    <meta content="聚职团酒店兼职平台" name="application-name">
    <meta content="聚职团酒店兼职平台" name="msapplication-tooltip">
    <meta name="renderer" content="webkit">
    <title>聚职团用户中心--聚天下兼职，我们组团去！</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>/images/logo/icon.png" media="screen" />
     <link href="<%=basePath %>/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath %>/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<script>
	document.createElement('ng-include');
</script>
<body>
<div id="center" class="clearfix">
	<div id="center-l" class="pull-left col-md-2">
		<div id="center-l-logo">
			<a href="<%=basePath%>/index"><img src="<%=basePath%>/images/logo/logo.gif" alt="logo" title="logo"/></a>
		</div>
		<ul class="ul-out list-unstyled" ng-controller="employee.ctrl">
			<li>
				<p ng-click="vm.unfold(0)">用户功能</p>
				<ul class="ul-inner list-unstyled">
					<li ng-class="{active:vm.iNow==0}" ng-click="vm.iNow=0"><a ng-href="#ybmhd">已报名活动</a></li>
		            <li ng-class="{active:vm.iNow==1}" ng-click="vm.iNow=1"><a ng-href="#pjhd">评价结束活动</a></li>
		            <li ng-class="{active:vm.iNow==2}" ng-click="vm.iNow=2"><a href="#info">完善个人信息</a></li>
				</ul>
			</li>
			<li>
				<p ng-click="vm.unfold(1)">系统设置</p>
				<ul class="ul-inner list-unstyled">
					 <li ng-class="{active:vm.iNow==3}" ng-click="vm.iNow=3"><a ng-href="#updatepass">修改密码</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<div id="center-r" class="pull-left col-md-10">
		<ng-include src="'<%=basePath%>/template/info'"></ng-include>
		<div ng-view></div>
	</div>
</div>
<div class="modal-loader-opacity"></div>
<div class="modal-loader"></div>
<div class="modal-success-opacity"></div>
<div class="modal-success"></div>
<div class="modal-session-opacity"></div>
<div class="modal-session"></div>
<script src="<%=basePath%>/js/common/angular.js"></script>
<script src="<%=basePath%>/js/common/jquery.js"></script>
<script src="<%=basePath%>/js/common/angular-route.js"></script>
<script src="<%=basePath%>/js/module/employeeMain.js"></script>
<script src="<%=basePath%>/js/service/service.js"></script>
<script src="<%=basePath%>/js/route/eeroute.js"></script>
<script src="<%=basePath%>/js/directive/employeedirective.js"></script>

</body>
</html>