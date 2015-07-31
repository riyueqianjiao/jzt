<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html ng-app="main">
<head lang="en">
    <meta charset="UTF-8">
    <meta name="keywords" content="兼职网,酒店兼职网,聚职团兼职网,聚职团兼职,兼职网站大全,大学生兼职网站,可靠,可信,专业,安全兼职,大学生兼职,上海学生兼职,兼职应用">
    <meta content="聚职团(web.juzhituan.com)是一个真实可靠的找兼职平台。我们的兼职信息都经过多重核查，兼职信息真实度高达99.9%。通过聚职团您可以一手掌握最新的酒店兼职信息，还可以根据个人实际情况来推荐个性化兼职，更高效找到可靠的兼职赚钱方法。赶快加入我们吧" name="description">
    <meta content="聚职团酒店兼职平台" name="application-name">
    <meta content="聚职团酒店兼职平台" name="msapplication-tooltip">
    <meta name="renderer" content="webkit">
    <title>聚职团--聚天下兼职，我们组团去！</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/images/logo/icon.png" media="screen" />
    <link href="<%=basePath%>/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<script>
	document.createElement('ng-include');
	document.createElement('ng-bind');
</script>
<body ng-controller="main.ctrl">
<div id="change-area" ng-controller="main.changeArea.ctrl">
	<p>目前只在上海、江苏南通、苏州等地推广，如有不便请见谅！[<span ng-click="vm.hideChangeArea()">取消切换</span>]</p>
	<ul class="province-list">
		<li>选择省：</li>
		<li ng-click="vm.province='上海'">上海</li>
		<li ng-click="vm.province='江苏'">江苏</li>
	</ul>
	<ul class="city-list">
		<li>选择市：</li>
		<li ng-repeat="city in (vm.cityData|filter:vm.province)[0].cities"><a ng-bind="city.label" href="<%=basePath%>/page/?p={{vm.province}}&c={{city.label}}"></a></li>
	</ul>
		
</div>
<div id="nav" class="nav-default" ng-controller="main.nav.ctrl">
    <div id="nav-content" class="clear">
        <div class="nav-content-l nav-default-content-l">
            <i class="nav-icon-address"></i><span id="nav-content-province">${c}</span>[<span class="nav-change-city" id="nav-content-change-city" ng-click="vm.changeCity()">切换城市</span>]
        </div>
        <div class="nav-content-r nav-default-content-r">
            <ul>
                <li><span>您好<c:if test="${user!=null}">，</c:if>&nbsp;${sessionScope.user.userName} ，欢迎来到聚职团！</span><c:if test="${user!=null}">[<a href="<%=basePath%>/logout">退出</a>]</c:if></li>
                <c:if test="${user==null}">
                	<li><a href="<%=basePath%>/employee/login">用户登录</a></li>
                	<li><a href="<%=basePath%>/employee/register">用户注册</a></li>
                </c:if>
                <c:if test="${user!=null&&user.userType==0}">
                	<li><a href="<%=basePath%>/employee/center">个人中心</a></li>
                </c:if>
               <%--  <li><i class="nav-icon-phone"></i><a href="">手机端下载</a></li>
                <li><a href="<%=basePath%>/about">关于我们</a></li> --%>
            </ul>
        </div>
    </div>
</div>
<div id="logo" class="clear">
    <div class="logo-l">
        <a href="<%=basePath%>"><img src="<%=basePath%>/images/logo/logo.png" alt="Logo"/></a>
        <div class="search_group">
        	<form action="<%=basePath%>/page/?p=${p}&d=${d}&c=${c}&workType=${workType}&orderType=${orderType}" method="get">
            <input type="hidden" value="${p}" name="p" id="province"/>
			<input type="hidden" value="${c}" name="c" id="city"/>
			<input type="hidden" value="${d}" name="d" id="district"/>
			<input type="hidden" value="${workType}" name="workType" id="workType"/>
			<input type="hidden" value="${orderType}" name="orderType" id="orderType"/>
            <input type="text" value="${searchKey}" name="searchKey" ng-model="vm.searchKey" placeholder="" autocomplete="off"/>
            <a href="<%=basePath%>/page/?p=${p}&d=${d}&c=${c}&workType=${workType}&orderType=${orderType}&searchKey={{vm.searchKey}}">搜索</a>
        	</form>
        </div>
    </div>
    <div class="logo-r">
   	 	<c:if test="${user.userType!=0}">
    		<a href="<%=basePath%>/employer/center">商家入口</a>
    	</c:if>
    </div>
</div>
<div id="banner" class="banner-default" main.directive.move>
    <ul>
        <li><img src="<%=basePath%>/images/banner/banner4.png" alt="图片1"/></li>
        <li><img src="<%=basePath%>/images/banner/1.jpg" alt="图片2" height="152" width="1000"/></li>
    </ul>
    <div id="banner-btn-group">
        <a href="javascript:;" class="active"></a>
        <a href="javascript:;"></a>
    </div>
</div>
<div id="area" class="clear" ng-controller="main.areaCtrl">
    <span class="area-title">选择区域：</span><a class="area-addresss" href="<%=basePath%>/page?p=${p}&c=${c}&workType=${workType}&orderType=${orderTyp}" ng-class="{active:${d==null}}">全市</a>
    <ul class="area-list">
        <li ng-repeat="area in ((vm.cityData|filter:vm.province)[0].cities|filter:vm.city)[0].areas"><a ng-bind="area.label" class="area-addresss" href="<%=basePath%>/page?p=${p}&c=${c}&d={{area.label}}&workType=${workType}&orderType=${orderTyp}" ng-class="{active:area.label=='${d}'}"></a></li>
    </ul>
 	<span class="area-title">职位类型：</span><a class="area-addresss" href="<%=basePath%>/page?p=${p}&c=${c}&d=${d}&orderType=${orderType}" ng-class="{active:${workType==null}}">全部</a>
    <ul class="area-list">
        <li ng-repeat="list in vm.workTypeList"><a class="area-addresss" href="<%=basePath%>/page?p=${p}&c=${c}&d=${d}&workType={{list.value}}&orderType=${orderType}" ng-class="{active:list.value=='${workType}'&&${workType!=null}}" ng-bind="list.name"></a></li>
    </ul>
</div>
<div id="sort">
    <span>排序：</span><a href="<%=basePath%>/page?p=${p}&c=${c}&d=${d}&workType=${workType}&searchKey=${searchKey}&orderType=0" ng-class="{active:${orderType==0}}">发布时间</a>&nbsp;<a  ng-class="{active:${orderType==1}}" href="<%=basePath%>/page?p=${p}&c=${c}&d=${d}&workType=${workType}&searchKey=${searchKey}&orderType=1">工作时间</a>&nbsp;<a href="<%=basePath%>/page?p=${p}&c=${c}&d=${d}&workType=${workType}&searchKey=${searchKey}&orderType=2" ng-class="{active:${orderType==2}}">薪资高低</a>
</div>
<div id="content" class="content-index">
	<c:choose>
		<c:when test="${fn:length(publications)==0}">
			<ul class="no-list">
				<li>对不起，没找到匹配的职位，请换个搜索条件重新试一下吧...</li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul class="content-list">
			<c:forEach var="data" items="${publications}">
				<li>
		            <i class="name-icon name-icon1">聚职团</i>
		            <p class="employer-mess">${data.companyName}<i class="flag">认证</i><span>第<strong>${data.recruitmentTime}</strong>次招聘</span><span>&nbsp;&nbsp;发布时间：${fn:substring(data.publicationTime,0,19)}</span></p>
		            <p class="detail">
		                <span class="detail-l"><a href="<%=basePath%>/publication/${data.publicationId}" target="_blank">${fn:substring(data.title,0,20)}</a></span>
		                <span class="detail-c">工作时间：${data.startDate}&nbsp;|&nbsp;工作区域：${fn:substring(data.workAddress,0,3)}...&nbsp;|&nbsp;薪资：${data.salary}/天</span>
		            	<span><a href="<%=basePath%>/publication/${data.publicationId}" class="btn-default-link" target="_blank">查看详情</a></span>
		            </p>
	       		 </li>
	        </c:forEach>
	</ul>
		</c:otherwise>
	</c:choose>
</div>
<div id="loading" class="loader-gif"></div>
<input type="hidden" value="${totalNum}" name="totalNum" id="totalNum"/>
<input type="hidden" value="${pageNum}" name="pageNum" id="pageNum"/>
<input type="hidden" value="${searchKey}" name="searchKey" id="searchKey"/>
<div id="page">
	<ul class="page-list">
		<li ng-repeat="list in vm.pageList"><a ng-class="{active:list.value=='${pageNum}'}" href="<%=basePath%>/page/?p=${p}&d=${d}&c=${c}&workType=${workType}&orderType=${orderType}&searchKey=${vm.searchMatch}&pageNum={{list.value}}" ng-bind="list.name"></a></li>
	</ul>
</div>
<ng-include src="'<%=basePath%>/template/footer'"></ng-include>
<script src="<%=basePath%>/js/common/angular.js"></script>
<script src="<%=basePath%>/js/common/jquery.js"></script>
<script src="<%=basePath%>/js/module/main.js"></script>
<script src="<%=basePath%>/js/directive/directive.js"></script>
<script src="<%=basePath%>/js/service/cityData.js"></script>
<script src="<%=basePath%>/js/service/service.js"></script>
</body>
</html>