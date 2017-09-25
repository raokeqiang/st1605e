<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>付息管理=>体验金付息</title>
</head>
<body>
   <table class="table table-bordered table-hover"  width="100%">
       <caption style="text-align: center; font-size:30px; color:red;">SubjectBbinPurchassRecord体验金付息</caption>
     <thead>
       <tr> 
         <td>序号</td>
         <td>流水号</td>
         <td>投资人手机号</td>
         <td>投资人姓名</td>
         <td>投资人身份证</td>
         <td>投资体验金还款利息</td>
         <td>还款时间</td>
         <td>还款状态</td>
         <td>操作</td>
       </tr>
     </thead>
       <c:forEach  items="${list }" var="subjectBbinPurchassRecord" varStatus="stat" >
       <tbody>
         <td>${stat.index+1 }</td>
         <td>${subjectBbinPurchassRecord.serial_number }</td>
         <td>${subjectBbinPurchassRecord.member.mobile_Phone }</td>
         <td>${subjectBbinPurchassRecord.member.member_name }</td>
         <td>${subjectBbinPurchassRecord.member.identity }</td>
         <td>${subjectBbinPurchassRecord.interest }</td>
         <td>${subjectBbinPurchassRecord.last_profit_day }</td>
         <td>
           <c:if test="${subjectBbinPurchassRecord.ispayment==0 }">待还款</c:if> 
           <c:if test="${subjectBbinPurchassRecord.ispayment==1 }">已还款</c:if>
         </td>
         <td>
           <c:if test="${subjectBbinPurchassRecord.ispayment==0 }">
              <button><a href="/yingJiaProfit/Payint/Bpary?id=${subjectPurchaseRecord.id }&& sid=${subject_id }">还款</a></button> 
           </c:if> 
           <c:if test="${subjectBbinPurchassRecord.ispayment==1 }">已还款</c:if> 
         </td>
         </tbody>
      </c:forEach>
   </table>
</body>
</html>