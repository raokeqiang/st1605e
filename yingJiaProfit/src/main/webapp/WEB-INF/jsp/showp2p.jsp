<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.min.css">
<script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>
</head>
<body>
<a href="/yingJiaProfit/subject/p2ptoAdd">新增</a>
	<table border="1" width="100%" class="table">
		<tr>
			<td>序号</td>
			<td>合同编号</td>
			<td>类型</td>
			<td>名称</td>
			<td>标的总金额</td>
			<td>已投总金额</td>
			<td>投资期限</td>
			<td>起投金额</td>
			<td>年化利益</td>
			<td>状态</td>
			<td>可使用体验金</td>
			<td>添加时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="e" varStatus="stat">
			<tr>

				<td>${stat.index+1 }</td>
				<td>${e.serial_no}</td>
				<td><c:if test="${e.type==0}">p2p房贷</c:if> <c:if
						test="${e.type==1}">p2p车贷</c:if></td>
				<td>${e.name}</td>
				<td>${e.amount}</td>
				<td><script type="text/javascript">
					var id = '${e.id}';
					$.ajaxSetup({
						async : false
					});
					var num1 = 0;
					$.post("/yingJiaProfit/subject/getTotalMoney", {
						id : id
					}, function(data) {
					});
					document.write(num1);
				</script></td>
				<td>${e.period}</td>
				<td>${e.floor_amount }</td>
				<td><script type="text/javascript">
					var id = '${e.id}';
					$.ajaxSetup({
						async : false
					});
					var shou = 0;
					$.post("/yingJiaProfit/subject/getdate", {
						id : id
					}, function(data) {
						shou = data;
					});
					document.write(date);
				</script></td>
				<td><c:if test="${e.status==0}">募集中</c:if> <c:if
						test="${e.status==1}">未募集</c:if></td>
				<%-- 				<td>${e.exper_status} </td> --%>
				<td><c:if test="${e.exper_status==0}">否</c:if> <c:if
						test="${e.exper_status==1}">是</c:if></td>
				<td>${e.create_date}</td>
				<td>
				<td><a href="/yingJiaProfit/subject/selectSub?id=${e.id }">编辑查看</a>
					<a href="/yingJiaProfit/subject/selectp2p">查看投资</a></td>
					
				<td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>