<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>账号管理</title>
</head>
<body>

   <table class="table table-bordered table-hover"  width="100%">
       <caption style="text-align: center; font-size:30px; color:red;">账号详情</caption>
     <thead>
        <tr><a href="/yingJiaProfit/Member/listAll">返回</a></tr>
       <tr>
         <td>用户名</td>
         <td>手机号</td>
         <td>真实姓名</td>
         <td>身份证</td>
         <td>邀请码</td>
         <td>被邀请码</td>
         <td>注册时间</td>
       </tr>
     </thead>
     <tbody>
      <tr>
        <td>${member.name }</td>
        <td>${member.mobile_Phone }</td>
        <td>${member.member_name }</td>
        <td>${member.identity }</td>
        <td>${member.invitationCode }</td>
        <td>${member.invitedCode }</td>
        <td>${member.create_date }</td>
      </tr>
      </tbody>
   </table>
</body>
</html>