<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>提现管理</title>
</head>
<body>
	<form action="/yingJiaProfit/Withdraw/listAll" method="post">
		姓名：<input type="text" name="qmember_name" value="${qmember_name }" />&nbsp;
		手机号：<input type="text" name="qmobile_Phone" value="${qmobile_Phone}" />&nbsp;
		绑卡卡号：<input type="text" name="qbank_card "value="${qbank_card  }" />&nbsp;
		状态：<input type="text" name="qstatus" value="${qstatus }" /><br>	
		提现时间：<input type="text" name="qcreate_date" value="${qcreate_date}" />&nbsp;
		<input type="submit" value="查询" />
	</form>
	<table class="table table-bordered table-hover"  width="100%">
       <caption style="text-align: center; font-size:30px; color:red;">MembeWithdrawRecord提现管理表</caption>
     <thead>
       <tr>
         <td>序号</td>
         <td>手机号</td>
         <td>姓名</td>
         <td>身份证</td>
         <td>提现金额</td>
         <td>提现银行</td>
         <td>提现卡号</td>
         <td>提现开户行地址</td>
         <td>提现状态</td>
         <td>提现时间</td>
         <td>账号详情</td>
         <td>操作</td>
       </tr>
     </thead>
     <tbody>
    <c:forEach  items="${listAll }" var="listAll" varStatus="stat" >
      <tr>
        <td>${stat.index+1 }</td>
        <td>${listAll.member.mobile_Phone }</td>
        <td>${listAll.member.member_name }</td>
        <td>${listAll.member.identity}</td>
        <td>${listAll.amount }</td>
        <td>${listAll.bank_name }</td>
        <td>${listAll.bank_card }</td>
        <td>${listAll.cardaddress }</td>
        <td>
         <c:if test="${listAll.status==0 }">待审核</c:if>
         <c:if test="${listAll.status==1 }">已打款</c:if>
         <c:if test="${listAll.status==2 }">打款中</c:if>
         <c:if test="${listAll.status==3 }">打款失败</c:if>
         <c:if test="${listAll.status==4 }">已冻结</c:if>
         <c:if test="${listAll.status==5 }">已解冻</c:if>
        </td>
        <td>${listAll.create_date }</td>
        <td><a href="/yingJiaProfit/Withdraw/Accdetails?id=${listAll.id }&&member_id=${listAll.member.id}">账号详细</a></td>
        <td>
          <c:if test="${listAll.status==0 }"><butten><a href="/yingJiaProfit/Withdraw/Audit?id=${listAll.id }">审核</a></butten></c:if>
          <c:if test="${listAll.status==1 && listAll.channel_name=='BEIFU' }">贝付付款</c:if>
          <c:if test="${listAll.status==1 && listAll.channel_name=='FUIOU' }">富友付款</c:if>
          <c:if test="${listAll.status==2 && listAll.channel_name=='BEIFU' }">贝付付款</c:if>
          <c:if test="${listAll.status==2 && listAll.channel_name=='FUIOU' }">富友付款</c:if>
          <c:if test="${listAll.status==3 && listAll.channel_name=='BEIFU' }">贝付付款</c:if>
          <c:if test="${listAll.status==3 && listAll.channel_name=='FUIOU' }">富友付款</c:if>
          <c:if test="${listAll.status==4 }"><butten><a href="/yingJiaProfit/Withdraw/Thaw?id=${listAll.id }">解冻</a></butten></c:if>
          <c:if test="${listAll.status==5 }">已解冻</c:if>
        </td>
      </tr>
      </c:forEach>
      </tbody>
   </table>
</body>
</html>