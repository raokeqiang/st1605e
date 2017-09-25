<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>提现管理账号详情</title>
</head>
<body>
	 <table class="table table-bordered table-hover"  width="100%">
      <caption style="text-align: left; font-size:20px;"><button><a href="/yingJiaProfit/Withdraw/listAll"><font color="blue">返回</font></a></button></caption>
      <caption style="text-align: center; font-size:20px; color:red;">账号信息</caption>
         <thead>
		<tr style="color:black;font-size: 15px">
		    <td>用户名</td>
			<td>${membeWithdrawRecord.member.name}</td>
		    <td>手机号</td>
			<td>${membeWithdrawRecord.member.mobile_Phone}</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>真实姓名</td>
             <td>${membeWithdrawRecord.member.member_name }</td>
             <td>身份证</td>
             <td>${membeWithdrawRecord.member.identity }</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>邀请码</td>
             <td>${membeWithdrawRecord.member.invitationCode }</td>
             <td>被邀请码</td>
             <td>${membeWithdrawRecord.member.invitedCode }</td>
        </tr>
        <tr style="color:black;font-size: 15px">
        <td>添加时间</td>
        <td>${membeWithdrawRecord.member.create_date }</td>
        </tr>
			 </thead>
        </table>
		 <table class="table table-bordered table-hover"  width="100%">
         <caption style="text-align: center; font-size:20px; color:red;">资金信息</caption>
         <thead>
		<tr style="color:black;font-size: 15px">
		    <td>可用余额</td>
			<td>${memberAccount.useable_balance}</td>
		    <td>冻结金额</td>
			<td>${memberAccount.imuseale_balance}</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>累计收益</td>
             <td>${memberAccount.total_profit }</td>
             <td>投资总额</td>
             <td>${memberAccount.invest_amount }</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>红包金额</td>
             <td>${memberAccount.bonus_amount }</td>
             <td>体验金</td>
             <td>${memberAccount.bbin_amount }</td>
        </tr>
			 </thead>
        </table>
        <c:choose>
           <c:when test="${index==0}">
           </c:when>
           <c:otherwise> 
           <table class="table table-bordered table-hover"  width="100%">
         <caption style="text-align: center; font-size:20px; color:red;">理财师信息</caption>
         <thead>
		<tr style="color:black;font-size: 15px">
		    <td>真实姓名</td>
			<td>${financiaPlanner.name}</td>
		    <td>机构名称</td>
			<td>${financiaPlanner.orgname}</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>我的名片</td>
             <td>${financiaPlanner.mycard }</td>
             <td>邮寄地址</td>
             <td>${financiaPlanner.address }</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>添加时间</td>
             <td>${financiaPlanner.create_date }</td>
        </tr>
			 </thead>
        </table>
           </c:otherwise>
        </c:choose>
        
        <table class="table table-bordered table-hover"  width="100%">
         <caption style="text-align: center; font-size:20px; color:red;">投资记录</caption>
         <thead>
		<tr style="color:black;font-size: 15px">
		    <td>序号</td>
			<td>${subjectPurchaseRecord.id}</td>
		    <td>投资编号</td>
			<td>${subjectPurchaseRecord.serial_number}</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>投资金额</td>
             <td>
             ${subjectPurchaseRecord.amount }
             </td>
             <td>投资状态</td>
             <td>
                <c:if test="${subjectPurchaseRecord.subject.status==1 }">募集中</c:if>
                <c:if test="${subjectPurchaseRecord.subject.status==0 }">已结束</c:if>
             </td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>投资标的名称</td>
             <td>${subjectPurchaseRecord.subject.name }</td>
              <td>投资收益(/周期)</td>
             <td>
             <script type="text/javascript">
                var am=${subjectPurchaseRecord.amount };
                var count=${subjectPurchaseRecord.pay_interest_times };
                var per=${subjectPurchaseRecord.subject.period };
                var year=${subjectPurchaseRecord.subject.year_rate};
                var shou=am*count*(year/100)/365*per;
                document.write(shou);
             </script>
             
             </td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>投资时间</td>
             <td>${subjectPurchaseRecord.create_date }</td>
        </tr>
			 </thead>
        </table>
         <table class="table table-bordered table-hover"  width="100%">
         <caption style="text-align: center; font-size:20px; color:red;">提现记录</caption>
         <thead>
		<tr style="color:black;font-size: 15px">
		    <td>序号</td>
			<td>${membeWithdrawRecord.id}</td>
		    <td>提现编号</td>
			<td>${membeWithdrawRecord.serial_number}</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>提现金额</td>
             <td>${membeWithdrawRecord.amount }</td>
             <td>提现状态</td>
             <td>
                <c:if test="${membeWithdrawRecord.status==0 }">待审核</c:if>
                <c:if test="${membeWithdrawRecord.status==1 }">已打款</c:if>
                <c:if test="${membeWithdrawRecord.status==2 }">打款中</c:if>
                <c:if test="${membeWithdrawRecord.status==3 }">打款失败</c:if>
                <c:if test="${membeWithdrawRecord.status==4 }">打款中</c:if>
                <c:if test="${membeWithdrawRecord.status==5 }">打款失败</c:if>
             </td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>提现银行</td>
             <td>${membeWithdrawRecord.bank_name }</td>
              <td>提现卡号</td>
             <td>${membeWithdrawRecord.bank_card }</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>提现时间</td>
             <td>${membeWithdrawRecord.create_date }</td>
        </tr>
			 </thead>
        </table>
        <table class="table table-bordered table-hover"  width="100%">
         <caption style="text-align: center; font-size:20px; color:red;">充值记录</caption>
         <thead>
		<tr style="color:black;font-size: 15px">
		    <td>充值编号</td>
			<td>${memberDepositRecord.serial_number}</td>
		    <td>充值金额</td>
			<td>${memberDepositRecord.amount}</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>充值状态</td>
             <td>
                <c:if test="${memberDepositRecord.status==0 }">待付款</c:if>
                <c:if test="${memberDepositRecord.status==1 }">完成</c:if>
              </td>
             <td>充值渠道</td>
             <td>${memberDepositRecord.pay_channel_name }</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>充值渠道编号</td>
             <td>${memberDepositRecord.pay_channel_order_no }</td>
              <td>充值时间</td>
             <td>${memberDepositRecord.create_date }</td>
        </tr>
			 </thead>
        </table>
         <table class="table table-bordered table-hover"  width="100%">
         <caption style="text-align: center; font-size:20px; color:red;">钱包信息</caption>
         <thead>
		<tr style="color:black;font-size: 15px">
		    <td>序号</td>
			<td>${memberTradeRecord.id}</td>
		    <td>交易编号</td>
			<td>${memberTradeRecord.trade_no}</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>交易金额</td>
             <td>${memberTradeRecord.amount }</td>
             <td>交易状态</td>
             <td>${memberTradeRecord.trade_status }</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>交易分类</td>
             <td>${memberTradeRecord.trade_type }</td>
             <td>交易名称</td>
             <td>${memberTradeRecord.trade_name }</td>
        </tr>
        <tr style="color:black;font-size: 15px">
             <td>交易时间</td>
             <td>${memberTradeRecord.create_date }</td>
        </tr>
			 </thead>
        </table>
</body>
</html>