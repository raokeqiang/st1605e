<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="1">
		<tr>
			<td>序号</td>
			<td>姓名</td>
			<td>联系电话</td>
			<td>地址</td>
			<td>预约时间</td>
		</tr>
		<c:forEach items="${list2 }" var="e" varStatus="stat">
			<tr>

				<td>${stat.index+1 }</td>
	            <td>${e.name }</td>
				<td>${e.phone}</td>
				<td>${e.addr}</td>
				<td>${e.oversea.addTime }</td>
				<td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>