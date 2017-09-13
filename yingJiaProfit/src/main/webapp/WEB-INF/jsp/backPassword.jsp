<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>密码设置</title>
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
	<script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>
</head>
	<style type="text/css">
		.style16{
		width: 100%;
		height:800px;
		margin: 0px auto;
		margin-bottom:20px;
		border:1px solid #CEE3E9;
		background-color: #F1F7F9
		}
	</style>
<body>
<form class="form-horizontal" role="form">
   <div class="form-group">
      <label for="firstname" class="col-sm-2 control-label">原密码</label>
      <div class="col-sm-10">
         <input type="password" class="form-control" id="user_name" 
            placeholder="请输入密码"><font face="狂草" size="1" color="red">至少6位！</font>
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">新密码</label>
      <div class="col-sm-10">
         <input type="password" class="form-control" name="user_name1" 
            placeholder="请输入密码"><font face="狂草" size="1" color="red">至少6位！</font>
      </div>
   </div>
      <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">重复输入</label>
      <div class="col-sm-10">
         <input type="password" class="form-control" id="user_name2" 
            placeholder="请输入密码"><font face="狂草" size="1" color="red">密码不一致！！！</font>
      </div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
         <button type="submit" class="btn btn-default">登录</button>
      </div>
   </div></form>
<script type="text/javascript">
 $('input[name==user_name]').blur(function(){
	 val=this.value;
	 if(val.length<6){
		 $(this).next().show();
	 }else{
		 $(this).next().hide();
	 }
 });
 $('input[name==user_name1]').blur(function(){
	 val1=$('input[name==user_name2]').val();
		val2 =this.value;
		if(val1==val2){
			 $(this).next().show();
		 }else{
			 $(this).next().hide();
		 }
 });
 

</script>
</body>
</html>