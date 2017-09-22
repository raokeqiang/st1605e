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
<form action="/yingJiaProfit/Member/listAll" method="post">
		用户名：<input type="text" name="qname" value="${qname }"/>&nbsp;&nbsp;&nbsp;&nbsp;
		真实姓名：<input type="text" name="qmember_name" value="${qmember_name }"/><br>
		手机号：<input type="text" name="qmobile_Phone" value="${qmobile_Phone}"/>&nbsp;&nbsp;&nbsp;&nbsp;
		邀请码：<input type="text" name="qinvitationCode" value="${qinvitationCode }"/><br>
	          创建时间：<input type="text" name="qcreate_date" value="${qcreate_date}"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="查询"/>
</form>
   <table class="table table-bordered table-hover"  width="100%">
       <caption style="text-align: center; font-size:30px; color:red;">member账号管理表</caption>
     <thead>
       <tr>
         <td>序号</td>
         <td>手机号</td>
         <td>用户名</td>
         <td>姓名</td>
         <td>身份证</td>
         <td>邀请码</td>
         <td>注册时间</td>
         <td>操作</td>
       </tr>
     </thead>
     <tbody>
    <c:forEach  items="${listAll }" var="listAll" varStatus="stat" >
      <tr>
        <td>${stat.index+1 }</td>
        <td>${listAll.mobile_Phone }</td>
        <td>${listAll.name }</td>
        <td>${listAll.member_name }</td>
        <td>${listAll.identity }</td>
        <td>${listAll.invitationCode }</td>
        <td>${listAll.create_date }</td>
        <td><a href="/yingJiaProfit/Member/MemberDetails?id=${listAll.id }">查看详情</a></td>
      </tr>
      </c:forEach>
      </tbody>
   </table>
</body>
</html>