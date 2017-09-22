<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
	<script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="/yingJiaProfit/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/js/slimtable.min.js"></script>
	<link rel="stylesheet" href="/yingJiaProfit/css/slimtable.css">



<script type="text/javascript">
$(function(){
$("#btn1").click(function(){ //模糊查询按钮
		$("#form1").attr("action","/yingJiaProfit/money/showmoney");
		$("#form1").submit();
	});

$("#btn2").click(function(){ //新增按钮
	$("#form1").attr("action","/yingJiaProfit/money/toAddmoney");
	$("#form1").submit();
});

});
//编辑查看
function test1(id){//button传id
	 window.location.href = '/yingJiaProfit/money/moneyEdit?id='+id;
	}
	//签署状态
//function test3(id){//button传id
 	 //window.location.href = '/yingJiaProfit/money/moneyding?id='+id;
	//}
	function test3(id){//签署状态
	alert(id);
	$(location).attr('href', '/yingJiaProfit/money/moneyding/'+id);
	// $("#form1").attr("action",""+id);
//$("#form1").submit();
}
</script>
</head>
<body>
<form method="post" id="form1" name="form1">
<div>
 名称:<input type="text" placeholder="名称" name="name" value="${name}">
状态:<select name="status">
							<option value="">全部</option>
							<option value="0">募集中</option>
							<option value="1">未募集</option>
							<option value="2">回款中</option>
					</select>
				类型:<select name="type">
							<option value="">全部</option>
							<option value="SIMU">私募类</option>
							<option value="GUQUAN">股权类</option>
							
			</select> 
<button type="button" class="btn btn-primary" id="btn1">查询</button>
<button type="reset" class="btn btn-primary">重置</button>
<button type="button" class="btn btn-primary" id="btn2">新增</button> 
</div>
<table id="exampletable" width="100%" class="table">
 <thead>
<tr>
<th>序号</th>
<th>名称</th>
<th>类型</th>
<th>状态</th>
<th>年化收益</th>
<th>返佣比例</th>
<th>投资期限</th>
<th>起头金额</th>
<th>添加时间</th>
<th>操作</th>
</tr>
 <thead>
<c:forEach items="${list }" var="e" varStatus="stat">
<tr>
<td>${stat.index+1 }</td>
<td>${e.name }</td>
<td>
<c:if test="${e.type==0}">私募类</c:if> <c:if
test="${e.type==1}">股权类</c:if>
</td>

<td><c:if test="${e.status==0}">募集中</c:if> <c:if
						test="${e.status==1}">未募集</c:if></td>
			<td>${e.year_rate}%</td>
			<td>${e.ratio }</td>
			<td>${e.period }天</td>
			<td>${e.floor_amount }</td>
			<td>${e.create_date }</td>

		<td>
<button type="button" class="btn btn-primary" onclick="test1(${e.id})">编辑查看</button> 
<button type="button" class="btn btn-primary" onclick="test3(${e.id})">签署状态</button> 
			</td>
</tr>
</c:forEach>
</table>
</form>
<script type="text/javascript">
$(function() {
	$("#exampletable").slimtable();
});
</script>
</body>
</html>