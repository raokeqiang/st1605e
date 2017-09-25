<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>账号管理</title>
	<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
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
<caption><input type="button" value="添加" class="btn btn-primary" /></caption>
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
      <td><input type="button" value="编辑" class="btn btn-primary" />
      </td>
      </tr>
    </c:forEach>
   </tbody>
</table>
</div>
<script type="text/javascript">
$(function() {
	$("#exampletable").slimtable();
});
</script>
</body>
</html>