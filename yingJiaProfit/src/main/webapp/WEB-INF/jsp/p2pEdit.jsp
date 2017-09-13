<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑查看盘p2p</title>
	<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
 	<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.min.css">
 	<script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>	
</head>
<body>
<form action="/yingJiaProfit/subject/update"  method="post">
<input type="hidden" name="id" value="${sub.id }"> 
名称:<input type="text"  name="name" value="${sub.name}"><br>
合同编号:<input type="text" name="serial_no" value="${sub.serial_no  }"><br>
起投金额:<input type="text" name="floor_amount" value="${sub.floor_amount }"><br>
年化收益:<input type="text" name="year_rate" value="${sub. year_rate}"><br>
状态:<input type="text" name="status" value="${sub.status}/"><br>
<%-- 投资期限:<input type="text" name="" value="${ }"> --%><br>
借款人姓名:<input type="text" name="borrowername" value="${sub.borrowername }"><br>
类型:<input type="text" name="type" value="${sub.type}"><br>
借款用途:<input type="text" name="purpose" value="${sub.purpose }"><br>
保障方式:<input type="text" name="safetyControl" value="${sub.safetyControl }"><br>
<%-- 可使用体验金:<input type="text" name="exper_status" value="${sub.exper_status }"><br> --%>
已购人数:<input type="text" name="bought" value="${sub.bought }"><br>
<input type="submit" value="提交">
</form> 
</body>
</html>