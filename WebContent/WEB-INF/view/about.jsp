<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="keywords" content="兼职网,酒店兼职网,聚职团兼职网,聚职团兼职,兼职网站大全,大学生兼职网站,可靠,可信,专业,安全兼职,大学生兼职,上海学生兼职,兼职应用">
    <meta content="聚职团(web.juzhituan.com)是一个真实可靠的找兼职平台。我们的兼职信息都经过多重核查，兼职信息真实度高达99.9%。通过聚职团您可以一手掌握最新的酒店兼职信息，还可以根据个人实际情况来推荐个性化兼职，更高效找到可靠的兼职赚钱方法。赶快加入我们吧" name="description">
    <meta content="聚职团酒店兼职平台" name="application-name">
    <meta content="聚职团酒店兼职平台" name="msapplication-tooltip">
    <meta name="renderer" content="webkit">
    <title>聚职团--聚天下兼职，我们组团去！</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/logo/logo.png" media="screen" />
    <link href="css/main.css" rel="stylesheet" type="text/css"/>
    <link href="css/common.css" rel="stylesheet" type="text/css"/>
    <script>
        document.createElement('section');
    </script>
</head>
<body style="height:2000px;">
    <div id="nav-inverse">
        <div class="navContent clear">
            <div class="nav-left"><a href="#">聚职团</a></div>
            <ul class="nav-right">
                <li>主页</li>
                <li class="active">关于我们</li>
                <li>服务</li>
                <li>申请流程</li>
                <li>联系我们</li>
            </ul>
        </div>
    </div>
    <!--aboutUs start-->
    <section id="aboutUs">
        <div id="slogan">
            <ul>
                <li class="qianColor1">W</li>
                <li class="qianColor2">E</li>
                <li class="qianColor3">L</li>
                <li class="qianColor4">C</li>
                <li class="qianColor5">O</li>
                <li class="qianColor6">M</li>
            </ul>
        </div>
        asdfasfsadf
    </section>
    <!--aboutUs end-->
<script src="js/common/sea.js"></script>
<script type="text/javascript">
    seajs.config({
        alias:{
            move:'./js/fun/moveElem'
        }
    });
    seajs.use(['move'],function(ex){
        ex.MoveElem('slogan');
    });
</script>
</body>
</html>