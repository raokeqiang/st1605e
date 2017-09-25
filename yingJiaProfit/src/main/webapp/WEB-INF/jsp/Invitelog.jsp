<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>奖励记录表详情</title>
</head>
<body>
<table class="datatable table table-striped" cellspacing="0" width="100%">
    <caption style="text-align: center; font-size:30px; color:red;">奖励记录表</caption>
    <tbody align="center">
         <c:forEach items="${awardRecordsList }" var="award" varStatus="stat">
            <tr>
               <th>                         
		   邀请手机号：<font color="red">${award.byinvitingid.mobile_Phone }</font>&nbsp;&nbsp;&nbsp;&nbsp;
		   邀请码：<font color="red">${award.byinvitingid.invitationCode }</font>
             </th>
         </tr>
         <tr style="font-size:15px; color:black;">
		 	<th>序号</th><th>邀请人手机号</th><th>被邀请人手机号</th>
			 <th>奖励类型</th><th>奖励金额</th><th>奖励时间</th><th>邀请码</th>
         </tr>
		 <tr>
		     <td>${stat.index+1}</td>
			 <td>${award.invitingid.mobile_Phone }</td>
			 <td>${award.byinvitingid.mobile_Phone }</td>
			 <td>
			 <c:if test="${award.type==0 }">注册</c:if>
			 <c:if test="${award.type==1 }">投资</c:if>
			</td>
			<td>${award.amount }</td>
			<td>${award.addTime }</td>
			<td>${award.invitingid.invitationCode }</td>
			</tr>
		 <th></th>
		 </c:forEach>
		 </tbody>
      </table>
</body>
</html>