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
	
	
	

 });
 
 function fun(obj){
	 var money=obj.value;
	 var rate="${finan.fina.year_rate}"/100;
	 var period=${finan.fina.period};
	 var num=((money*rate)/365)*period;
	 $("#interest").val(parseFloat(num).toFixed(2));
 }
 
 
 function fun2(){
		/* $("#btn1").click(function(){ //签署合约
			//$(location).attr('href', '/yingJiaProfit/money/savehe');
	
		});  */
		$("#form1").attr("action","/yingJiaProfit/money/savehe");
		$("#form1").submit();
	 
 }
</script>

</head>
<body>
<form action="/yingJiaProfit/money/sss"  method="post" id="form1"  >
<input type="hidden" name="id" value="${finan.id }">
<table border="0" cellspacing="0" width="400">
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;真实姓名:</td>
<td><input type="text" name="member_name" value="${finan.member.member_name}" readonly="true" class="form-control"></td>
</tr>

</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;身份证信息:</td>
<td><input type="text" name="identity" value="${finan.member.identity}" readonly="true" class="form-control"></td>
</tr>


</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;购买金额:</td>
<td><input type="text" name="amount" onkeyup="fun(this)" class="form-control"></td>
</tr>

</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;利息收益:</td>
<td><input type="text" name="interest" id="interest" readonly="true" class="form-control"></td>
</tr>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;开始时间:</td>
<td><input type="text" name="start" id="start"  readonly="true" class="form-control"></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;截止时间:</td>
<td><input type="text" name="end" id="end" readonly="true"  class="form-control"></td>
</tr>
<tr height="60">
<td colspan="2"  align="center">
  <button  id="btn1"   type="submit" class="btn btn-primary" >签署合同</button>
  </td>
  </tr>
  </table>
</form>
</body>
</html>