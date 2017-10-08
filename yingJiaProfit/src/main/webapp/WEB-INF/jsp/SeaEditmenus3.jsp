<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.min.css">
<script type="text/javascript" src="/yingJiaProfit/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>

<title>编辑</title>
<script type="text/javascript">
 $(document).ready(function(){
	  $("#status").val(${over.status}); 
 });

 $(function(){
 $("#btn2").click(function(){ //返回按钮
	  	$("#form1").attr("action","/yingJiaProfit/over/Seamenus3");
	  	$("#form1").submit();
	  });

	  });

</script>
</head>
<body>
<form action="/yingJiaProfit/over/update"  method="post"  id="form1"    name="form1">
<input type="hidden" name="id" value="${over.id }"> 
<table border="0" cellspacing="0" width="400">
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;标题:</td>
	<td><input type="text" name="title" value="${over.title}" class="form-control"></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;子标题:</td>
	<td><input type="text" name="child_title" value="${over.child_title }" class="form-control"></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;描述:</td>
	<td><input type="text" name="description" value="${over.description }" class="form-control"></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;用户群体:</td>
	<td><input type="text" name="user_type" value="${over.user_type }" class="form-control"></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;排序值:</td>
	<td><input type="text" name="sortColum" value="${over.sortColum }" class="form-control"></td>
	</tr>
	<tr height="60">
	<td>&nbsp;&nbsp;&nbsp;状态:</td>
	<td><select name="status" id="status" class="form-control">
	<option value="0">未募集</option>
	<option value="1">募集中</option>
	<option value="2">已结束</option>
	</select></td>
	</tr>
<tr height="60">
<td colspan="2"  align="center">
<button type="submit" class="btn btn-primary">提交</button>
 <button type="button" class="btn btn-primary" id="btn2">返回</button> 
</td>
</tr>
 	</table>

</form>


</body>
</html>