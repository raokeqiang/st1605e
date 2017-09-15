<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑</title>
<script type="text/javascript">
$(document).ready(function(){
	  $("#status").val(${over.status}); 
});
</script>
</head>
<body>
<form action="/yingJiaProfit/over/update"  method="post"  id="form1"    name="form1">
<input type="hidden" name="id" value="${over.id }"> 
标题:<input type="text"  name="title" value="${over.title}"><br>
子标题:<input type="text" name="child_title" value="${over.child_title  }"><br>
状态:<select name="status" id="status">
<option value="0">未募集</option>
<option value="1">募集中</option>
</select><br>
排序值:<input type="text" name="sortColum" value="${over.sortColum}"><br>
添加时间:<input type="date" name="addTime" value="${ over.addTime}/"><br>
图标:<input type="file">
<input type="submit" value="提交"  >
</form>


</body>
</html>