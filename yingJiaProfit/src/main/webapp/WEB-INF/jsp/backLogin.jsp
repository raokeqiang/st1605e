<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台登陆界面</title>
<!-- Custom Theme files -->
<link href="/yingJiaProfit/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
</head>
<body>
<div class="login">
	<h2>欢迎进入盈+ 后台管理系统</h2>
	<div class="login-top">
		<h1>超凡理财，首选盈+</h1>
		<form action="/yingJiaProfit/toBackLogin/goToMain" method="post">
			<input type="text" name="user_name" value="User Id" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Id';}">
			<input type="password" name="password" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}">
	     <div class="forgot">
	    	<a href="#">忘记密码</a>
	    	<input type="submit" value="登录" >
	    </div>
	    </form>
	</div>
	<div class="login-bottom">
		<h3>首选 &nbsp;<a href="#">返回前台</a>&nbsp 你好</h3>
	</div>
</div>
</body>
</html>