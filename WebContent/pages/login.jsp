<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<%
	String errorType = request.getAttribute("errorType")==null?"":(String)request.getAttribute("errorType");
	String msg = request.getAttribute("msg")==null?"":(String)request.getAttribute("msg");
	String username = request.getAttribute("username")==null?"":(String)request.getAttribute("username");
	String password = request.getAttribute("password")==null?"":(String)request.getAttribute("password");
	%>
    <link rel="stylesheet" href="<%=path%>/css/login.css">
    <script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
	<title>后台登陆</title>
	<script type="text/javascript">
	function reset_checkcode(){
		//document.getElementById("selfaa").src = "<%=path%>/systemBase/resetCheckCode.do?"+Math.random(); 
		$("#selfaa").attr("src","<%=path%>/security/resetCheckCode?"+Math.random());
	}
	<%if(!"".equals(msg)){%>
		alert('<%=msg%>');
	<%}%>

        function formSubmit()
	{
		var password=$("#password").val();
		var username=$("#username").val();
		var checkcode=$("#checkcode").val();
		
		if(username=='')
		{
			window.alert("请输入用户名");
			return false;
		}
		
		if(password=='')
		{
			window.alert("请输入密码");
			return false;
		}
		
		if(checkcode=='')
		{
			window.alert("请输入 验证码");
			return false;
		}
		
		
		window.location.href="<%=path%>/security/login?username="+username+"&password="+password+"&checkcode="+checkcode;
		
		
	
	}
	
	</script>
</head>
<body>
	<div id="login_top">
		
		<div id="back">
		</div>
	</div>
	<div id="login_center">
		<div id="login_area">
			<div id="login_form">
				<form action="<%=path%>/security/login" method="post">
					<div id="login_tip">
						用户登录&nbsp;&nbsp;UserLogin
					</div>
					<div><input type="text" class="username" id="username" name="username" value="<%=username %>"></div>
					<div><input type="password" class="pwd"  id="password" name="password" value="<%=password %>"></div>
					<div id="btn_area">
						<input type="button" name="submit" id="sub_btn" value="登&nbsp;&nbsp;录" onclick="formSubmit();">&nbsp;&nbsp;
						<input type="text" class="verify" id="checkcode" name="checkcode">
						<img src="<%=path%>/security/resetCheckCode?date=<%=new Date()%>" id="selfaa" alt="看不清点我" width="80" height="40" onclick="reset_checkcode()">
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="login_bottom">
		公司员工绩效考核管理系统
	</div>
</body>
</html>