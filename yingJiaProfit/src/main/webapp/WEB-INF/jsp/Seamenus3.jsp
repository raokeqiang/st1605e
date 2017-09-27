<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/yingJiaProfit/css/bootstrap.min.css"/>
<script type="text/javascript" src="/yingJiaProfit/css/iframeindex_data/jquery.js" ></script>
   <script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js" ></script>
   <script type="text/javascript" src="yingJiaProfit/js/jquery-3.2.0.min.js"></script>
   <script type="text/javascript">
   $(function(){
//   $("#btn3").click(function(){ //查看预约
// 	   	$("#form1").attr("action","/yingJiaProfit/over/listding");
// 	   	$("#form1").submit();
// 	   });
  $("#btn2").click(function(){ //新增按钮
		$("#form1").attr("action","/yingJiaProfit/over/SeaoverAdd");
		$("#form1").submit();
	});
	   });
   function fun(id){//button传id
	   window.location.href = '/yingJiaProfit/over/inData?id='+id;
	  }
   function fun2(id){//button传id
	   window.location.href = '/yingJiaProfit/over/listding?id='+id;
            alert(id);
	  }
   </script>
   <style type="text/css">
		.imged{
		width:50px;
		height:50px;	
		}
	</style>
</head>
<body>
<form action="/yingJiaProfit/over/Seamenus3" id="form1">
<table  class="table-striped" width="100%" border="1" >

<!--   <input type="button" value="新增" id="btn1" /> -->
<button type="button" class="btn btn-primary" id="btn2">新增</button> 
<tr align="center">
              <th align="center"><font size="+1">编号</font></th>
		      <th>标题</th>
			   <th>子标题</th>
			    <th>状态</th>
			    <th>排序值</th>
			    <th>添加时间</th>
			    <th>操作</th>
			  
</tr>
<c:forEach items="${list }" var="e" varStatus="stat">
				<tr>
				<td><img src="/yingJiaProfit/img/1.jpg" class="imged"></img></td>
				<td>${e.title }</td>
				<td>${e.child_title }</td>
				<td>
				<c:if test="${e.status==0}">募集中</c:if>
				 <c:if test="${e.status==1}">未募集</c:if></td>
				<td>${e.sortColum }</td>
				<td>${e.addTime}</td>
			<td> 
			<button type="button" class="btn btn-warning" id="btn3" onclick="fun2(${e.id})">查看预约<button>
			<button type="button" class="btn btn-success" onclick="fun(${e.id})">编辑查看<button>
			</tr>

			</c:forEach>
</table>
</form>
</body>
</html>