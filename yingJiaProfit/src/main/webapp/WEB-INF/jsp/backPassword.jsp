<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>密码设置</title>


    <link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
    <link rel="stylesheet" href="/yingJiaProfit/css/bootstrapValidator.css" />

	<script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/js/bootstrapValidator.js" ></script>
</head>
	
<body>
<div class="container">
    <div class="row">
        <!-- form: -->
        <section>
            <div class="col-lg-8 col-lg-offset-2">
                <div class="page-header">
                    <h2>密码设置</h2>
                </div>

               
                <form id="defaultForm" method="post" class="form-horizontal" action="/yingJiaProfit/backPassword/updatePassword">
                   <input type="hidden" id="oldpassword" value="${password }">
                    <div class="alert alert-success" style="display: none;"></div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">请输入原密码</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" id="password" name="password" placeholder="请输入原密码" onkeyup="checkse()"/>
                            <span style="display: none; color:red" id="ypwd">原密码不正确</span>
                        </div>
                    </div>

                     <div class="form-group">	
                        <label class="col-lg-3 control-label">请输入新密码</label>
                        <div class="col-lg-5">
                            <input type="password" class="form-control" id="password1" name="password1" placeholder="请输入密码"/>
                        </div>
                    </div>

                    <div class="form-group">	
                        <label class="col-lg-3 control-label">请再输入一次</label>
                        <div class="col-lg-5">
                            <input type="password" class="form-control" id="password2" name="password2" placeholder="请输入密码" onkeyup="checksu()" />
                            <span style="display: none; color:red" id="pwd">两次输入密码不一致</span>
                        </div>
                    </div>

                     <div class="form-group">
                            <div class="col-lg-5 col-lg-offset-3">
                                <button type="submit" class="btn btn-primary" id="bt1">提交</button>
                                 <button type="submit" class="btn btn-primary" disabled="disabled" id="bt2">提交</button>
                            </div>
                        </div>
                </form>
            </div>
        </section>
        <!-- :form -->
    </div>
</div>

<script type="text/javascript">
$(function() {
	$("#bt1").hide();
	$("#bt2").show();
});
	
    	function checkse(){
    		var ypwd=$("#oldpassword").val();
    		var xpwd=$("#password").val();
    		if(ypwd==xpwd){
    			$("#ypwd").hide();
    			$("#bt2").hide();
    			$("#bt1").show();
    			
    		}
    		if(ypwd!=xpwd){
    			$("#ypwd").show();
    			$("#bt1").hide();
    			$("#bt2").show();
    		}
    	}
    	
    	function checksu(){
    		var password1=$("#password1").val();
    		var password2=$("#password2").val();
    		if(password1==password2){
    			$("#pwd").hide();
    			$("#bt2").hide();
    			$("#bt1").show();
    		}
    		if(password1!=password2){
    			$("#pwd").show();
    			$("#bt1").hide();
    			$("#bt2").show();
    		}
    	}
    	
     
        
</script>
</body>
</html>