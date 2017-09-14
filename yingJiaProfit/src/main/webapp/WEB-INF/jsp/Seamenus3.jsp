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
   <style type="text/css">
		.imged{
		width:50px;
		height:50px;	
		}
	</style>
<!--    <script type="text/javascript"> -->
<!-- // 	$(function(){ -->
<!-- // 		$("#btn1").click(function() { -->
<!-- // 			document.forms[0].action = "/yingJiaProfit/over/toAdd"; -->
<!-- // 			document.forms[0].submit(); -->
<!-- // 		}); -->
<!-- // 		$("#btn2").click(function() { -->
<!-- // 			document.forms[0].action = "/yingJiaProfit/over/inData"; -->
<!-- // 			document.forms[0].submit(); -->
<!-- // 		}); -->
<!-- // 	}); -->
<!-- </script> -->
</head>
<body>
<form action="/yingJiaProfit/over/Seamenus3">
<table  class="table" width="100%" border="1">

<!--   <input type="button" value="新增" id="btn1" /> -->
<a href="/yingJiaProfit/over/SeaoverAdd">新增</a>
<tr>
              <th>编号</th>
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
				<td>${e.status}</td>
				<td>${e.sortColum }</td>
				<td>${e.addTime}</td>
			<td> 
<!-- <input type="button" class="btn btn-primary btn-sm" value="查看预约" /> -->
<!-- <input type="button" class="btn btn-success btn-sm" value="编辑查看" id="btn2"/> -->
			
				<a href="/yingJiaProfit/over/listding">查看预约</a> 
 					<a href="/yingJiaProfit/over/inData?id=${e.id }">编辑查看</a></td> 
				</tr>

			</c:forEach>
</table>
</form>
</body>
</html>