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
                    <div class="alert alert-success" style="display: none;"></div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">请输入原密码</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" name="password" />
                        </div>
                    </div>

                     <div class="form-group">	
                        <label class="col-lg-3 control-label">请输入新密码</label>
                        <div class="col-lg-5">
                            <input type="password" class="form-control" name="password1" />
                        </div>
                    </div>

                    <div class="form-group">	
                        <label class="col-lg-3 control-label">请再输入一次</label>
                        <div class="col-lg-5">
                            <input type="password" class="form-control" name="password2" />
                        </div>
                    </div>

                     <div class="form-group">
                            <div class="col-lg-5 col-lg-offset-3">
                                <button type="submit" class="btn btn-primary">提交</button>
                            </div>
                        </div>
                </form>
            </div>
        </section>
        <!-- :form -->
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $('#defaultForm').bootstrapValidator({
        	    message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh',
            },
         
            fields: {
            	password: {
                    validators: {
                        notEmpty: {
                            message: '原密码不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: '密码长度不能小于6或者大于30'
                        },
                        remote: {             //ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
	                         url: '/yingJiaProfit/backPassword/lober',//验证地址
	                         message: '原密码输入错误!',
	                         delay :  2000,   //每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
	                         type: 'POST',
	                        	
                    }
                   }
                },
                password1: {
                    validators: {
                        notEmpty: {
                            message: '新密码不能为空！'
                        },
                       indentical:{
                        	field: 'password2',
                        	  message: '·密码不一致'
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: '·密码长度不能小于6或者大于30'
                        }
                    }
                },
                password2: {
                    validators: {
                        notEmpty: {
                            message: '新密码不能为空！'
                        },
                        indentical:{
                        	field: 'password1',
                        	  message: '·密码不一致'
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: '·密码长度不能小于6或者大于30'
                        },
                    }
                },
            }
        });
    });
        
</script>
</body>
</html>