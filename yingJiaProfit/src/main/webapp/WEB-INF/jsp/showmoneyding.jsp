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
//签署合约
function test3(id){
	alert(id);
	$(location).attr('href', '/yingJiaProfit/money/heyue/'+id);
        //$("#form1").attr("action","/yingJiaProfit/money/heyue/"+id);
		//$("#form1").submit();
}
</script>
</head>
<body>
<form method="post" id="form1">
<table border="1" width="100%">
<tr>
<th>序号</th>
<th>姓名</th>
<th>联系电话</th>
<th>地址</th>
<th>状态</th>
<th>预约时间</th>
<th>操作</th>
</tr>
<c:forEach items="${list }" var="e" varStatus="stat">
<tr>
<td>${stat.index+1 }</td>
<td>${e.member.name }</td>
<td>${e.member.mobile_Phone }</td>
<td>${e.addr}</td>
<td>
<c:if test="${e.status==0}"><font color="red">签署拍照</font></c:if>
<c:if test="${e.status==1}"><font color="green">已签约</font></c:if>
<c:if test="${e.status==2}"><font color="red">审核中</font></c:if>
<c:if test="${e.status==3}"><font color="red">签署失败</font></c:if>
</td>
<td>${e.create_date}</td>
<td>
<c:if test="${e.status==0}">
<button type="button">签署拍照</button>
</c:if>
<c:if test="${e.status==1}">
<button type="button">已签署</button>
</c:if>
<c:if test="${e.status==2}">
<button type="button" class="btn btn-primary" onclick="test3(${e.id})">签署</button>
</c:if>
<c:if test="${e.status==3}">
<button type="button">签署失败</button>
</c:if>
</td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>