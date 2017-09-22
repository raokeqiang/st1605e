<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>固收类</title>
	<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
	<script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="/yingJiaProfit/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/js/slimtable.min.js"></script>
	<link rel="stylesheet" href="/yingJiaProfit/css/slimtable.css">
	

<script type="text/javascript">
$(function(){
$("#sum").slimtable();
$("#btn1").click(function(){ //模糊查询按钮
		$("#form1").attr("action","/yingJiaProfit/subject/showp2p");
		$("#form1").submit();
	});
$("#btn2").click(function(){ //新增按钮
	$("#form1").attr("action","/yingJiaProfit/subject/p2ptoAdd");
	$("#form1").submit();
});
$("#btn3").click(function(){ //查看投资
	$("#form1").attr("action","/yingJiaProfit/subject/selectp2p");
	$("#form1").submit();
});
});
function test1(id){//button传id
 window.location.href = '/yingJiaProfit/subject/selectSub?id='+id;
}
</script>
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
<div  class="style16">
<form method="post" id="form1">
 名称:<input type="text" placeholder="名称" name="name" value="${name}">
状态:<select name="status">
							<option value="">全部</option>
							<option value="0">未发布</option>
							<option value="1">募集中</option>
							<option value="2">回款中</option>
							<option value="3">还款完成</option>
					</select>
				类型:<select name="stype">
							<option value="">全部</option>
							<option value="0">固收类</option>
							<option value="1">P2P车贷</option>
							<option value="2">P2P房贷</option>
			</select>
<button type="button" class="btn btn-primary" id="btn1">查询</button>
<button type="reset" class="btn btn-primary">重置</button>
<button type="button" class="btn btn-primary" id="btn2">新增</button> 

	<table id="sum"  width=100% class="table">	
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
					document.write("￥"+num1);
				</script></td>
				<td>${e.period}天</td>
				<td>￥${e.floor_amount }</td>
				<td>${e.year_rate}</td>
				<td><c:if test="${e.status==0}">募集中</c:if> <c:if
						test="${e.status==1}">未募集</c:if></td>
				<%-- 				<td>${e.exper_status} </td> --%>
				<td><c:if test="${e.exper_status==0}">否</c:if> <c:if
						test="${e.exper_status==1}">是</c:if></td>
				<td>${e.create_date}</td>
				<td>
		<button type="button" class="btn btn-primary" onclick="test1(${e.id})">编辑查看</button> 
		<button type="button" class="btn btn-primary" id="btn3" >查看投资</button>  </td>
			</tr>
		</c:forEach>
	</table>
</form>
</div>
</body>
</html>