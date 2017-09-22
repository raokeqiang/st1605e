<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>付息管理=>付息列表</title>
</head>
<body>
   <table class="table table-bordered table-hover"  width="100%">
       <caption style="text-align: center; font-size:30px; color:red;">SubjectPurchassRecord付息列表</caption>
     <thead>
       <tr> 
         <td>序号</td>
         <td>流水号</td>
         <td>投资人手机号</td>
         <td>投资人姓名</td>
         <td>投资人身份证</td>
         <td>本息</td>
         <td>还款时间</td>
         <td>还款状态</td>
         <td>操作</td>
       </tr>
     </thead>
     <c:forEach  items="${list }" var="subjectPurchaseRecord" varStatus="stat" >
      <tbody>
         <td>${subjectPurchaseRecord.id }</td>
         <td>${subjectPurchaseRecord.serial_number }</td>
         <td>${subjectPurchaseRecord.member_id.mobile_Phone }</td>
         <td>${subjectPurchaseRecord.member_id.member_name }</td>
         <td>${subjectPurchaseRecord.member_id.identity }</td>
         <td>
             <script type="text/javascript">
                var am=${subjectPurchaseRecord.amount };
                var count=${subjectPurchaseRecord.pay_interest_times };
                var inter=${subjectPurchaseRecord.interset };
                var sum=(am+inter)*count;
                document.write(sum);
             </script>
         </td>
         <td>${subjectPurchaseRecord.last_profit_day }</td>
         <td>
           <c:if test="${subjectPurchaseRecord.ispayment==0 }">待还款</c:if> 
           <c:if test="${subjectPurchaseRecord.ispayment==1 }">已还款</c:if>
         </td>
         <td>
           <c:if test="${subjectPurchaseRecord.ispayment==0 }">
              <button><a href="/yingJiaProfit/Payint/Ppary?id=${subjectPurchaseRecord.id }&&sid=${subject_id }">还款</a></button> 
           </c:if> 
           <c:if test="${subjectPurchaseRecord.ispayment==1 }">已还款</c:if> 
         </td>
         </tbody>
      </c:forEach>
      
   </table>
</body>
</html>