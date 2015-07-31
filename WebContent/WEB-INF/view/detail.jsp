<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE html>
<html  ng-app="detailMain">
<head lang="en">
    <meta charset="UTF-8">
    <meta name="keywords" content="兼职网,酒店兼职网,聚职团兼职网,聚职团兼职,兼职网站大全,大学生兼职网站,可靠,可信,专业,安全兼职,大学生兼职,上海学生兼职,兼职应用">
    <meta content="聚职团(web.juzhituan.com)是一个真实可靠的找兼职平台。我们的兼职信息都经过多重核查，兼职信息真实度高达99.9%。通过聚职团您可以一手掌握最新的酒店兼职信息，还可以根据个人实际情况来推荐个性化兼职，更高效找到可靠的兼职赚钱方法。赶快加入我们吧" name="description">
    <meta content="聚职团酒店兼职平台" name="application-name">
    <meta content="聚职团酒店兼职平台" name="msapplication-tooltip">
    <meta name="renderer" content="webkit">
    <title>聚职团工作详情信息--聚天下兼职，我们组团去！</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/images/logo/icon.png" media="screen" />
    <link href="<%=basePath%>/css/main.css" rel="stylesheet" type="text/css"/>
	<script>
		document.createElement('ng-include');
	</script>
<body>
<div id="nav" class="nav-default">
    <div id="nav-content" class="clear">
        <div class="nav-content-l nav-default-content-l"></div>
        <div class="nav-content-r nav-default-content-r">
            <ul>
                <li><span>您好&nbsp;${sessionScope.user.userName} ，欢迎来到聚职团！</span><c:if test="${user!=null}">[<a href="<%=basePath%>/logout">退出</a>]</c:if></li>
                <c:if test="${user==null}">
                	<li><a href="<%=basePath%>/employee/login">用户登录</a></li>
                	<li><a href="<%=basePath%>/employee/register">用户注册</a></li>
                </c:if>
                <c:if test="${user!=null&&user.userType==0}">
                	<li><a href="<%=basePath%>/employee/center">个人中心</a></li>
                </c:if>
              <%--   <li><i class="nav-icon-phone"></i><a href="">手机端下载</a></li>
                <li><a href="<%=basePath%>/about">关于我们</a></li> --%>
            </ul>
        </div>
    </div>
</div>
<div class="marginTop3"></div>
<div id="content" class="content-detail clear">
	<input type="hidden" value="${publication.publicationId}" id="publicationId"/>
    <div class="content-detail-l">
        <p class="tips">
            <marquee direction="left" scrolldelay="200">
            <font color="#cc0000">提示：</font>
            聚职团承诺所有商家均经线下认证，由此确保信息的真实可靠性，不收取求职者报名费，欢迎监督！
            </marquee>
        </p>
        <h1>
        	${publication.title}+<c:if test="${publication.isLong==0}">工作${publication.workDuration}天+${publication.salary}/天</c:if><c:if test="${publication.isLong==1}">${publication.salary}/月</c:if>
        </h1>
        <h2>公司名称：<span>${publication.employer.companyName}</span></h2>
        <p>工作时间：<span>${publication.startDate}&nbsp;${publication.workTimeInfo}</span></p>
        <c:if test="${publication.isLong==0}">
        	<p>工作天数：<span>${publication.workDuration}天</span><font color="#cc0000">（ps:可以选择报名其中任何一天，具体操作请点击选择某天报名按钮）</font></p>
        </c:if>
        <c:if test="${publication.isLong==1}">
        	<p>工作天数：<span>该活动属于长期兼职</span></p>
        </c:if>
        <p>工作地址：<span>${publication.workAddress}</span></p>
        <c:if test="${publication.isGenderRequired==1}">
        	<p>人数要求：<span>分男女比例，共需${publication.activities[0].recruitNum}人，男生${publication.activities[0].recruitNumM}人，女生${publication.activities[0].recruitNum-publication.activities[0].recruitNumM}人<font color="#cc0000">（当前已报${publication.activities[0].applyNum}人，男生已报${publication.activities[0].applyNumM}人，女生已报${publication.activities[0].applyNum-publication.activities[0].applyNumM}人）</font></span></p>
        </c:if>
         <c:if test="${publication.isGenderRequired==0}">
        	<p>人数要求：<span>不分男女，共需${publication.activities[0].recruitNum}人</span></p>
        </c:if>
        <c:if test="${publication.isGenderRequired==2}">
        	<p>人数要求：<span>限招女生，共需${publication.activities[0].recruitNum}人</span></p>
        </c:if>
        <c:if test="${publication.isGenderRequired==3}">
        	<p>人数要求：<span>限招男生，共需${publication.activities[0].recruitNum}人</span></p>
        </c:if>
        <p>其他信息：<span>${publication.detail}</span></p>
        <h2>工作要求：</h2>
        <p>    <span>${publication.requirement}
            </span>
        </p>
        <div class="btn-group" ng-controller="detail.signUp.ctrl">
            <a class="btn btn-signup" ng-click="vm.showConfirm()">报名所有天数</a>
            <a class="btn btn-signup" ng-click="vm.chooseSignUpDay()">选择某天报名</a>
        </div>
        <div id="comment" ng-controller="detail.loaderMess.ctrl">
        	<a ng-class="{active:vm.type==1}" ng-click="vm.changeType(1,${publication.employer.employerId})">报名信息</a><a ng-class="{active:vm.type==2}" ng-click="vm.changeType(2,${publication.employer.employerId})">公司评价</a>
        	<div class="bm-mess">
        		<table>
        		<c:forEach var="list" items="${publication.activities}">
        		<tr>
                    <td class="first">时间：${list.workDate}</td>
                    <c:if test="${publication.isGenderRequired==1}">
	                    <td>薪资：${list.salary}/天，男生${list.recruitNum}人，女生${list.recruitNum-list.recruitNumM}人，</td>
	                    <td>男生已报${list.applyNumM}人，女生已报${list.applyNum-list.applyNumM}人</td>
                   </c:if>
                   <c:if test="${publication.isGenderRequired!=1}">
	                   <td>薪资：${list.salary}/天，需人数${list.recruitNum}人，</td>
	                   <td>已报${list.applyNum}人</td>
                   </c:if>
	                </tr>
        			</c:forEach>
        		</table>
        	</div>
        	<div id="loading" class="loader-gif"></div>
        	<div class="comment-list">
        		<div class="comment-list-page" ng-show="vm.totalPage!=0">
        			<span>共{{vm.totalPage}}页</span><span class="active" ng-show="vm.currPage!=1" ng-click="vm.changePage(true)">上一页</span><span class="active" ng-show="vm.currPage!=vm.totalPage" ng-click="vm.changePage(false)">下一页</span>
        		</div>
        		<div class="comment-list-none" ng-if="vm.dataList.length==0">还没有任何评论...</div>
        		<ul>        
        			<li ng-repeat="list in vm.dataList">
        				<div class="touxiang"><img src="<%=basePath%>/images/morentouxiang.png" width="50" height="50"/></div>
        				<div class="title"><span ng-bind="list.phone"></span><span ng-bind="list.pointer"></span><span ng-bind="list.time"></span></div>
        				<div class="content" ng-bind="list.content"></div>
        			</li>
        		</ul>
        		<div class="comment-list-page" ng-show="vm.totalPage!=0">
        			<span>共{{vm.totalPage}}页</span><span class="active" ng-show="vm.currPage!=1" ng-click="vm.changePage(true)">上一页</span><span class="active" ng-show="vm.currPage!=vm.totalPage" ng-click="vm.changePage(false)">下一页</span>
        		</div>
        	</div>
        </div>
    </div>
    <div class="content-detail-r">
        <div class="companyMess">
           <i class="flag">认证</i>
           <p class="name">${publication.employer.companyName}</p>  
        </div>
        <p class="zpTimes"><a href="#">已招聘${publication.employer.recruitmentTime}次</a></p>
        <p class="credit">信誉：<i></i><i></i><i></i><i></i><i></i></p>
    </div>
</div>
<ng-include src="'<%=basePath%>/template/footer'"></ng-include>
<div class="modal-opacity"></div>
<div class="modal-out">
	<div class="my-modal modal-signUp">
		<h1>请至少选择一天进行报名</h1>
		<div class="my-modal-content">
			<table>
				<thead>
					<tr>
						<td class="first" width="140">时间</td>
	                    <td>工资/人数/地点</td>
	                    <td width="120">已报人数</td>
	                    <td width="60">操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${publication.activities}">
	                <tr>
	                    <td class="first">${list.workDate}</td>
	                    <c:if test="${publication.isGenderRequired==1}">
		                    <td>${list.salary}/天，需男生${list.recruitNum}人，女生${list.recruitNum-list.recruitNumM}人，${fn:substring(list.workAddress,0,15)}...</td>
		                    <td>男生${list.applyNumM}人，女生${list.applyNum-list.applyNumM}人</td>
	                   </c:if>
	                   <c:if test="${publication.isGenderRequired!=1}">
		                   <td>${list.salary}/天，需人数${list.recruitNum}人，${fn:substring(list.workAddress,0,15)}...</td>
		                    <td>已报${list.applyNum}人</td>
	                   </c:if>
	                    <td>
	                        <input type="checkbox" value="${list.activityId}" class="checkbox"/>
	                    </td>
	                </tr>
               		</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="my-modal-bottom" ng-controller="detail.confirmModal.ctrl">
			<a class="btn closeBtn" ng-click="vm.hideDailog()">关闭</a>
            <a class="btn confirmBtn" ng-click="vm.confirmUpdate()">确认报名</a>
		</div>
	</div>
</div>
<div class="modal-opacity"></div>
<div class="modal-out">
	<div class="my-modal modal-tip-error">
		<h1>提示</h1>
		<div class="my-modal-content">
			<p class="modal-confirm-content"></p>
		</div>
		<div class="my-modal-bottom" ng-controller="detail.error.ctrl">
            <a class="btn confirmBtn" ng-click="vm.closeModal()">确定</a>
		</div>
	</div>
</div>
<div class="modal-opacity"></div>
<div class="modal-out">
	<div class="my-modal modal-confirm">
		<h1>是否确认报名所有天数？</h1>
		<div class="my-modal-content">
			<p class="modal-confirm-content">我们支持对报名天数进行选择，您可以只报名其中一天或几天哦...</p>
		</div>
		<div class="my-modal-bottom" ng-controller="detail.confirmAllDay.ctrl">
			<a class="btn closeBtn" ng-click="vm.closeModal()">否</a>
            <a class="btn confirmBtn" ng-click="vm.signUpAllDay()">确定</a>
		</div>
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
<script src="<%=basePath%>/js/module/detailMain.js"></script>
<script src="<%=basePath%>/js/service/service.js"></script>
</body>
</html>