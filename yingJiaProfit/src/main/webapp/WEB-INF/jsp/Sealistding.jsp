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
   <script type="text/javascript">
  $(function(){
  $("#btn2").click(function(){ //返回按钮
	  	$("#form1").attr("action","/yingJiaProfit/over/Seamenus3");
	  	$("#form1").submit();
	  });

	  });
  </script>
</head>
<body>
<form method="post" id="form1">
 <button type="button" class="btn btn-primary" id="btn2">返回</button> 
	<table width="100%" border="1" class="table">
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
	</form>
</body>
</html>