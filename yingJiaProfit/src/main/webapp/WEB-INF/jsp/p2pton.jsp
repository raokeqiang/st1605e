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
<script type="text/javascript" src="/yingJiaProfit/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>
<script type="text/javascript">
function fun(obj){

}

</script>
</head>
<body>
<table border="1" width="100%">
<tr>
<td>序号</td>
<td>流水号</td>
<td>会员姓名</td>
<td>购买金额</td>
<td>结算利息</td>
<td>是否还款</td>
<td>购买时间</td>
</tr>
<c:forEach items="${list2 }" var="e" varStatus="stat">
<tr>
<td>${stat.index+1 }</td>
<td>${e.serial_number }</td>
 <td>${e.member.member_name}</td> 
<td>${e.amount }</td>
<td>
${ e.subject.year_rate}
,,,,
${e.subject.period}


		
</td>


<td>
<c:if test="${e.ispayment==0 }">是</c:if>
<c:if test="${e.ispayment==1}">否</c:if>
</td>
<td>${e.subject.create_date}</td>
</tr>
</c:forEach>
</table>


<!--  <script type="text/javascript"> 

 var first='$(e.amount)';
 var date='$(e.subject.year_rate)';
 var t='$(e.subject.period)';
 var shou='((first * date) / 365) * t';
 alert(shou); 

 
					//document.write(shou);
				//	document.write((($(e.amount)*$(e.subject.year_rate))/365)*$(e.subject.period));
		</script>  -->
</body>
</html>