<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>充值管理</title>
</head>
<body>
<form action="/yingJiaProfit/Recharge/listAll" method="post">
	 订单编号：<input type="text" name="qorderno" value="${qorderno }"/>&nbsp;
	  手机号：<input type="text" name="qmobile_Phone" value="${qmobile_Phone }"/>&nbsp;
	  订单状态：<select name="qstatus">
	           <option value="">全部</option>
	           <option value="0">待付款</option>
	           <option value="1">完成</option>
	        </select>&nbsp;
           富友订单：<input type="text" name="qfuiouno" value="${qfuiouno }"/>&nbsp;
	 订单时间：<input type="text" name="qtime" value="${qtime}"/>
	 <input type="submit" value="查询"/>
 </form>
   <table class="table table-bordered table-hover"  width="100%">
       <caption style="text-align: center; font-size:30px; color:red;">MemberBankcards充值管理表</caption>
     <thead>
       <tr>
         <td>序号</td>
         <td>订单编号</td>
         <td>手机号</td>
         <td>订单金额</td>
         <td>订单状态 </td>
         <td>充值渠道</td>
         <td>富友手机充值订单</td>
         <td>订单时间</td>
         <td>操作</td>
       </tr>
     </thead>
     <tbody>
    <c:forEach  items="${listAll }" var="listAll" varStatus="stat" >
      <tr>
        <td>${stat.index+1 }</td>
        <td>${listAll.pay_channel_order_no }</td>
        <td>${listAll.member.mobile_Phone }</td>
        <td>${listAll.amount }</td>
        <td>
         <c:if test="${listAll.status==0 }">待付款</c:if>
         <c:if test="${listAll.status==1 }">完成</c:if>
        </td>
        <td>
           <c:if test="${listAll.pay_channel_name=='FUIOU' }">富友</c:if>
        </td>
        <td>
          <c:if test="${listAll.pay_channel_name=='FUIOU' }">${listAll.pay_channel_order_no}</c:if>
        </td>
        <td>${listAll.create_date }</td>
        <td><a href="/yingJiaProfit/Recharge/listAll">更新订单</a></td>
      </tr>
      </c:forEach>
      </tbody>
   </table>
</body>
</html>