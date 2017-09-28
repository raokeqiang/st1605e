<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.min.css">
<script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>
<script type="text/javascript"  src="/yingJiaProfit/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript"  src="/yingJiaProfit/utf8-jsp/ueditor.all.min.js"> </script>
<script type="text/javascript"  src="/yingJiaProfit/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公告</title>
</head>
		<script type="text/javascript">
		function fun1(id,status,title,create_date,content){
			document.getElementById("ii").value=id;
			document.getElementById("ss").value=status;
			document.getElementById("tt").value=title;
			document.getElementById("time").value=create_date;
			 ue2.setContent(content);
		}
		function fun2(title,content){
			document.getElementById("ttt").value=title;
			ue3.setContent(content);
		}
		</script>
<body>
<form action="/yingJiaProfit/Push/toAnnouncements">
标题：<input type="text" name="title">
<button type="submit" style="width: 100px" data-toggle="modal"
								class="btn btn-primary"  >查询</button>
						<button type="button" style="width: 100px" data-toggle="modal"
								data-target="#addRoleModal"
								class="btn btn-primary" id="saveBtn">新增</button>		
								
								
</form>
<table class="table">
<thead>
<tr><td>序号</td><td>标题</td><td>所属类别</td><td>添加时间</td><td>操作</td></tr>
<c:forEach items="${push }" var="push" varStatus="stat" >
<tr><td>${stat.index+1} </td><td>${push.title}</td><td>${push.status}</td><td>${push.create_date  }</td>
<td>
<button type="button" style="width: 100px" data-toggle="modal"
				data-target="#addRoleModa2"
								class="btn btn-primary" id="updareBtn" onclick="fun1('${push.id}','${push.status}','${push.title}','${push.create_date}','${push.content}')">编辑</button>
							<button type="button" style="width: 100px" data-toggle="modal"
							data-target="#addRoleModa3"
								class="btn btn-primary" onclick="fun2('${push.title}','${push.content}')" >查看</button>
								</td>
								</tr>
</c:forEach>
</thead>
</table>
<div class="modal" id="addRoleModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"
							style="font-weight: bold;">添加公告</h4>
					</div>
					<form action="/yingJiaProfit/Push/savepushNotice" method="post">
						<div class="modal-body">
						所属类别：<select name="status" class="form-control" >
						<option value="1">新闻</option>
						<option value="2">娱乐</option>
						</select>
							<label>标题：</label> <input type="text" name="title" required="required"
								class="form-control" placeholder="标题名称....">
								<input type="hidden" name="id" value="-1">
						<!-- 加载编辑器的容器 -->  
						标题内容
						<script id="container" name="content" type="text/plain">请输入标题内容！</script>  
						<!-- 配置文件 -->  
						<!-- 编辑器源码文件 -->  
						<!-- 实例化编辑器 -->  
						<script type="text/javascript">  
						    var ue = UE.getEditor('container');  
						</script>  
												</div>
												<div class="modal-footer">
													<div style="margin: 0 auto; width: 50%;">
														<button type="button" class="btn btn-danger"
															data-dismiss="modal">关闭</button>
														<input type="submit" class="btn btn-primary" value="提交更改" /> <input
															type="reset" class="btn btn-success" value="重置表单" />
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
			<div class="modal" id="addRoleModa2" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabe2" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"
							style="font-weight: bold;">修改公告</h4>
					</div>
					<form action="/yingJiaProfit/Push/updatepushNotice" method="post">
						<div class="modal-body">
						所属类别：<select name="status" class="form-control" id="ss">
						<option value="1">新闻</option>
						<option value="2">娱乐</option>
						</select>
							<label>标题：</label> <input type="text" name="title" required="required"
								class="form-control" placeholder="标题名称...." id="tt">
								<input type="hidden" name="id" id="ii">
								<input type="hidden" name="time" id="time"> 
						<!-- 加载编辑器的容器 -->  
						标题内容
					<!-- 加载编辑器的容器 -->  
					<script id="container2" name="content" type="text/plain"></script>  
					<!-- 配置文件 -->  
					<!-- 编辑器源码文件 -->  
					<!-- 实例化编辑器 -->  
					<script type="text/javascript">  
					    var ue2 = UE.getEditor('container2');  
					</script>  
												</div>
												<div class="modal-footer">
													<div style="margin: 0 auto; width: 50%;">
														<button type="button" class="btn btn-danger"
															data-dismiss="modal">关闭</button>
														<input type="submit" class="btn btn-primary" value="提交更改" /> <input
															type="reset" class="btn btn-success" value="重置表单" />
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
								<div class="modal" id="addRoleModa3" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabe2" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"
							style="font-weight: bold;">查看公告</h4>
					</div>
							<label>标题：</label> <input type="text" name="title" required="required"
								class="form-control" placeholder="标题名称...." id="ttt">
						<!-- 加载编辑器的容器 -->  
						标题内容
					<!-- 加载编辑器的容器 -->  
					<script id="container3" name="content" type="text/plain"></script>  
					<!-- 配置文件 -->  
					<!-- 编辑器源码文件 -->  
					<!-- 实例化编辑器 -->  
					<script type="text/javascript">  
					    var ue3 = UE.getEditor('container3');  
					</script>  
												</div>
										</div>
									</div>
</body>
</html>