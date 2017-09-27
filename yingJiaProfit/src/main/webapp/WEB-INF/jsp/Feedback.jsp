<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.min.css">
<script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>反馈意见</title>
</head>
<body>
<table class="table">
<thead>
<tr><td>序号</td><td>反馈人</td><td>反馈意见</td><td>反馈类型</td><td>反馈时间</td></tr>
<c:forEach items="${Bb }" var="bb" varStatus="stat" >
<tr><td>${stat.index+1} </td><td>${bb.member.member_name}</td><td>${bb.content}</td><td>${bb.type}</td><td>${bb.create_date  }</td>
</tr>
</c:forEach>
</thead>
</table>
</body>
</html>