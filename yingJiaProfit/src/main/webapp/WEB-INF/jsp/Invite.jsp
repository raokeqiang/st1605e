<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>邀请管理</title>
</head>
<body>
<form action="/yingJiaProfit/Invite/listAll" method="post">
	  姓名：<input type="text" name="qmember_name" value="${qmember_name }"/>&nbsp;
	  手机号：<input type="text" name="qmobile_Phone" value="${qmobile_Phone}"/>&nbsp;
	  邀请码：<input type="text" name="qinvitationCode" value="${qinvitationCode }"/><br>
	  被邀请码：<input type="text" name="qinvitedCode" value="${qinvitedCode }"/>
	  是否已注册奖励：<select name="qenroll" value="${qenroll }">
	               <option value="">全部</option>
	               <option value="2">是</option>
	               <option value="0">否</option>
	             </select>
	  是否已投资奖励：<select name="qinvest" value="${qinvest }">
	              <option value="">全部</option>
	              <option value="2">是</option>
	              <option value="0">否</option> 
	            </select>
	   <input type="submit" value="查询"/>
</form>
   <table class="table table-bordered table-hover"  width="100%">
       <caption style="text-align: center; font-size:30px; color:red;">AwardRecords邀请管理表</caption>
     <thead>
       <tr>
         <td>序号</td>
         <td>手机号</td>
         <td>姓名</td>
         <td>邀请码</td>
         <td>被邀请码</td>
         <td>投资金额</td>
         <td>是否已注册奖励</td>
         <td>是否已投资奖励 </td>
         <td>注册时间</td>
         <td>操作</td>
       </tr>
     </thead>
     <tbody>
    <c:forEach  items="${listAll }" var="e" varStatus="stat" >
      <tr>
        <td>${stat.index+1 }</td>
        <td>${e.mobile_Phone }</td>
        <td>${e.member_name }</td>
        <td>${e.invitationCode }</td>
        <td>${e.invitedCode}</td>
        <td>${e.amount}</td>
        <td>
         <c:choose>
           <c:when test="${e.enroll=='2' }">是</c:when>
           <c:otherwise>否</c:otherwise>
         </c:choose>
        </td>
        <td>
        <c:choose>
           <c:when test="${e.invest=='2' }">是</c:when>
           <c:otherwise>否</c:otherwise>
         </c:choose>
        </td>
        <td>${e.create_date }</td>
        <td></td>
        <td>
         <c:if test="${e.enroll=='2' }">已注册奖励|</c:if>
         <c:if test="${e.invest=='2' }">已投资奖励|</c:if>
<%--          <c:if test="${e.enroll=='1' }"><button><a href="/yingJiaProfit/Invite/Enroll?id=e.id">注册奖励</a></button>|</c:if> --%>
<%--           <c:choose> --%>
<%--            <c:when test="${e.invest=='2' }">已投资奖励|</c:when> --%>
<%--            <c:when test="${e.invest=='1' }"><button><a href="/yingJiaProfit/Invite/Invest?id=e.id">投资奖励</a></button>|</c:when> --%>
<%--            <c:when test="${e.enroll!='0' && e.invest=='0' }">投资金额未达到!</c:when> --%>
<%--            <c:when test="${e.enroll=='0' && e.invest=='0' }">不能奖励|</c:when> --%>
<%--          </c:choose> --%>
         <button><a href="/yingJiaProfit/Invite/Rewardslog?phone=${e.mobile_Phone }">奖励记录</a></button>
        </td>
      </tr>
      </c:forEach>
      </tbody>
   </table>
</body>
</html>