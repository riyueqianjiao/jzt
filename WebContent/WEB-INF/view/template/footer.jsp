<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div id="footer">
    <ul class="clear">
        <li><a>关于聚职团</a></li>
        <li><a>我们的团队</a></li>
        <li><a>友情链接</a></li>
        <li><a href="<%=basePath%>/employer/apply" target="_blank">商家申请</a></li>
        <li class="none"><a href="<%=basePath%>/employer/register" target="_blank">商家注册</a></li>
    </ul>
    <p>CopyRight@2015聚职团juzhituan.com版权所有&nbsp;|&nbsp;沪ICP备15001335号-1&nbsp;|&nbsp;电话:021-37784226(工作日)&nbsp;|&nbsp;邮箱：zhifei@juzhituan.com</p>
	<p id="link"><a href='https://www.sgs.gov.cn/lz/licenseLink.do?method=licenceView&entyId=dov73ne26zbqq0il7c6kbe69so9d2yrggl' target="_blank" title="工商认证"><img src='<%=basePath%>/images/link/gs.png' border=0></a><a href="http://weibo.com/juzhituan" target="_blank" class="wb-icon" title="进入聚职团微博"></a></p>
</div>
