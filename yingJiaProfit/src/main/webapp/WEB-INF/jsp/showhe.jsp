<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
    <%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.min.css">
<script type="text/javascript" src="/yingJiaProfit/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	var date=new Date();
	var d=date.toLocaleDateString();
	$("#start").val(d);
	var perior=${finan.fina.period};
	date.setDate(date.getDate()+perior);
	$("#end").val(date.toLocaleDateString());
	$("#btn1").click(function(){ //签署合约
		$("#form1").attr("action","/yingJiaProfit/money/savehe");
		$("#form1").submit();
	});
 });
 function fun(obj){
	 var money=obj.value;
	 var rate=${finan.fina.year_rate}/100;
	 var period=${finan.fina.period};
	 var num=((money*rate)/365)*period;
	 $("#interest").val(parseFloat(num).toFixed(2));
 }
</script>

</head>
<body>
<form action="/yingJiaProfit/money/savehe"  method="post" id="form1">
真实姓名:<input type="text" name="member_name" value="${finan.member.member_name}" readonly="true"> <br>
身份证信息:<input type="text" name="identity" value="${finan.member.identity}" readonly="true"> <br>
购买金额:<input type="text" name="amount" onkeyup="fun(this)"><br>
利息收益:<input type="text" name="interest" id="interest" readonly="true"><br>
开始时间:<input type="text" name="start" id="start"  readonly="true"/><br>
截止时间:<input type="text" name="end" id="end" readonly="true" ><br>
私募合同:<input type="file"><br>

风险揭示书:<input type="file"><br>
  <button type="submit" class="btn btn-primary">签署合同</button>
</form>
</body>
</html>