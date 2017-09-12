<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公告</title>
</head>
<body>
<table>
<tr><td>序号</td><td>类别</td><td>公告标题</td><td>添加时间</td><td>操作</td></tr>
<c:forEach items="${push }" var="push" varStatus="stat" >
<tr><td>${push+1}</td><td>${push.status }</td><td>push.title</td><td>push.create_date</td><td></td></tr>
</c:forEach>
</table>
</body>
</html>