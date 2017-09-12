<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色设置</title>
</head>
	<script type="text/javascript" language="JavaScript" src="/yingJiaProfit/js/jquery.js"></script>
	<script type="text/javascript" language="JavaScript" src="/yingJiaProfit/js/bootstrap.js"></script>
	
<body>

<table class="table">
<caption>基本的表格布局</caption>
   <thead>
      <tr>
         <th>编号</th>
         <th>角色名</th>
         <th>备注</th>
         <th>创建时间</th>
         <th>修改时间</th>
         <th>操作</th>
      </tr>
   </thead>
   <tbody>
   <c:forEach  items="${list }" var="e" varStatus="stat" >
      <tr>
      <td>${stat.index+1 }</td>
      <td>${e.cname }</td>
      <td>${e.remark }</td>
      <td>${e.create_date }</td>
      <td>${e.update_date }</td>
      <td><a>修改权限</a></td>
      </tr>
    </c:forEach>
   </tbody>
</table>

</body>
</html>