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
    <title>聚职团用户密码找回--聚天下兼职，我们组团去！</title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/images/logo/icon.png" media="screen" />
    <link href="<%=basePath%>/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="logo" class="clear">
    <div class="logo-l">
        <a href="<%=basePath%>"><img src="<%=basePath%>/images/logo/logo.png" alt="Logo"/></a>
        <h2>密码找回</h2>
    </div>
    <div class="logo-r">
        <a href="<%=basePath%>/index">返回首页</a>
    </div>
</div>
<div class="underline6"></div>
<div id="container-reg">
    <div class="register-type">
        <a class="active">密码找回</a>
    </div>
    <div class="registerArea">
        <form name="registerForm" action="" method="post" class="employee">
            <div class="input-out-style">
            	<label>手机号：</label>
            	<input type="text" value="" name="phone" id="phone" autocomplete="off" maxlength="11"/>
            	<span class="input-error" id="phone-tip" style="display:none;">请输入正确手机号</span>
            </div>
             <div class="input-out-style">
            	<label>验证码：</label>
            	<input type="text" value="" name="varifyCode" class="min" id="varifyCode" maxlength="4"/>
            	<a class="btn btn-send-mess" id="varifyCodeBtn">发送验证码</a>
            	<span class="input-error" id="varifyCode-tip" style="display:none;">请输入验证码</span>
            	<span class="input-error" id="timer-tip" style="display:none;">60s后重新发送</span>
            </div>
            <div class="input-out-style">
            	<label></label>
            	<a class="btn btn-danger" id="submitBtn">确定提交</a>
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
            <a class="btn confirmBtn" id="confirmModal">确定</a>
		</div>
	</div>
</div>
<script src="<%=basePath%>/js/common/jquery.js"></script>
<script>
	$(function(){
		var oVarifyCode = $("#varifyCodeBtn");
		var varifyCodeBtn = true;
		oVarifyCode.click(function(){
			if(isPhone()){
				if(varifyCodeBtn){
					varifyCodeBtn = false;
					showTimer();
					$.ajax({
						url:'../sendCheckCode',
						method:'get',
						data:{cellphone:$("#phone").val()},
						success:function(data){
							if('error'==data.status){
								$("#phone-tip").show();
							}
						},
						complete:function(){
							varifyCodeBtn = true;
						}
					});
					
				}
			}else{
				$("#phone-tip").show();
			}
			
		});
		$('#phone').on('keyup',function(){
			if(isPhone()){
				$("#phone-tip").hide();
			}else{
				$("#phone-tip").show();
			}
		});
		$('#varifyCode').on('keyup',function(){
			if(isVarifyCode()){
				$("#varifyCode-tip").hide();
			}else{
				$("#varifyCode-tip").show();
			}
		});
		$("#submitBtn").click(function(){
			if(isPhone()){
				if(isVarifyCode()){
					//提交表单
					var data = {cellphone:$("#phone").val(),checkCode:$("#varifyCode").val()};
					$.ajax({
						url:'retrievePass',
						type:'post',
						data:data,
						success:function(data){
							if('ok'==data.status){
								$("#phone").val('');
								$("#varifyCode").val('');
								$(".modal-tip-error .modal-confirm-content").text('您的密码已初始为:111111，登录可进个人中心修改');
								showModal();
							}else{
								var str = "";
	                    		for(obj in data.error){
	                    			str += data.error[obj];
	                    		}
	                    		$(".modal-tip-error .modal-confirm-content").text(str);
								showModal();
							}
						},
						error:function(){
							//;
						}
						
					});
				}else{
					$("#varifyCode-tip").show();
				}
			}else{
				$("#phone-tip").show();
			}
		});
		function isVarifyCode(){
			var varifyCode = $("#varifyCode").val();
			if(varifyCode.length==4&&!isNaN(varifyCode)){
				return true;
			}
			return false;
		}
		function isPhone(){
			var phone = $("#phone").val();
			if(phone.length==11&&!isNaN(phone)){
				return true;
			}
			return false;
		}
		function showTimer(){
			var otimerTip = $("#timer-tip");
			oVarifyCode.hide();
			otimerTip.show();
			var seconds = 60;
			var timer = setInterval(function(){
				seconds--;
				otimerTip.text(seconds+'s后重新发送');
				if(seconds==1){
					clearInterval(timer);
					oVarifyCode.show();
					otimerTip.hide();
				}
			},1000);
			
		}
		function showModal(){
			$(".modal-opacity").fadeIn(500);
			$(".modal-out").fadeIn(500);
		}
		function hideModal(){
			$(".modal-opacity").fadeOut(500);
			$(".modal-out").fadeOut(500);
		}
		$("#confirmModal").click(function(){
			location.href="login";
		});
	});
</script>
</body>
</html>