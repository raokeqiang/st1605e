<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>账号管理</title>
	<link rel="stylesheet" href="/yingJiaProfit/css/metro.css"  />	
 	<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
 	<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.min.css">
	<script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="/yingJiaProfit/js/slimtable.min.js"></script>
	<link rel="stylesheet" href="/yingJiaProfit/css/slimtable.css">
	
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
<div class="style16">
<table id="exampletable"  width=100% class="table">
<caption><a  data-toggle="modal"
					data-target="#addRoleModal"
					class="btn btn-primary btn-lg" 
					>✚添加用户</a></caption>
   <thead>
      <tr>
         <th>编号</th>
         <th>用户名</th>
         <th>名称</th>
         <th>手机号</th>
         <th>创建时间</th>
         <th>身份</th>
         <th>操作</th>
      </tr>
   </thead>
   <tbody>
   <c:forEach  items="${list }" var="e" varStatus="stat" >
      <tr>
      <td>${stat.index+1 }</td>
      <td>${e.user_name }</td>
      <td>${e.name }</td>
      <td>${e.mobile_Phone }</td>
      <td>${e.create_date }</td>
      <td>${e.userRole.cname }</td> 
      <td><a  data-toggle="modal"
					data-target="#setRoleModal"
					class="btn btn-primary btn-lg" 
					>编辑</a>
      </td>
      </tr>
    </c:forEach>
   </tbody>
</table>
</div>

<div class="modal" id="addRoleModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"
							style="font-weight: bold;">新增用户</h4>
					</div>
					<form action="/yingJiaProfit/admin/save" method="post">
						<div class="modal-body">
							<label>用户名:</label> 
							<input type="text" required="required" name="user_name"	class="form-control" placeholder="用户名....">
							<label>名称:</label>
							<input type="text" required="required" name="name" class="form-control" placeholder="名称....">
							<label>手机号:</label>
							<input type="text" required="required" name="mobile_Phone" class="form-control" placeholder="手机号....">
							<label>密码:</label>
							<input type="text" required="required" name="password" class="form-control" placeholder="密码....">
							<label>身份:</label>
							<select name="rid">
							<c:forEach items="${rlist }" var="r" >
							<option value="${r.id }">${r.cname }</option>
							</c:forEach>
							</select>
						</div>
						<div class="modal-footer">
							<div style="margin: 0 auto; width: 50%;">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">关闭</button>
								<input type="submit" class="btn btn-primary" value="提交角色" /> <input
									type="reset" class="btn btn-success" value="重置表单" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

<script type="text/javascript">
$(function() {
	$("#exampletable").slimtable();
});
</script>
</body>
</html>