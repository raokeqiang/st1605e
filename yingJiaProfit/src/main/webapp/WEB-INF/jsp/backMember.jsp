<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>账号管理</title>
</head>
<body>

<table width="100%" border="1" class="table-bordered class">
<caption>账号管理</caption>
   <thead>
      <tr>
         <th>编号</th>
         <th>手机号</th>
         <th>用户名</th>
         <th>姓名</th>
         <th>身份证</th>
         <th>邀请码</th>
         <th>注册时间</th>
         <th>操作</th>
      </tr>
   </thead>
   <tbody>
   <c:forEach  items="${list }" var="e" varStatus="stat" >
      <tr>
      <td>${stat.index+1 }</td>
      <td>${e.mobile_Phone }</td>
      <td>${e.name }</td>
      <td>${e.member_name }</td>
      <td>${e.identity }</td>  
      <td>${e.invitationCode }</td> 
      <td>${e.create_date }</td> 
      <td><a href="#">账号详情</a></td>
      </tr>
    </c:forEach>
   </tbody>
</table>

</body>
</html>