<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>付息管理</title>
</head>
<body>
<form action="/yingJiaProfit/Payint/listAll" method="post">
	   名称：<input type="text" name="qname" value="${qname}"/>&nbsp;&nbsp;&nbsp;&nbsp;
	   状态：<select name="qstatus" value="${qstatus }">
	               <option value="">全部</option>
	               <option value="1">募集中</option>
	               <option value="0">已完成</option>
	             </select>
	   类型：<select name="qtype" value="${qtype }">
	               <option value="">全部</option>
	               <option value="0">固收类</option>
	               <option value="1">P2P车贷</option>
	               <option value="2">海外配置</option>
	               <option value="3">股权基金</option>
	             </select>
	 <input type="submit" value="查询"/>
  </form>
   <table class="table table-bordered table-hover"  width="100%">
       <caption style="text-align: center; font-size:30px; color:red;">Subject付息计划管理表</caption>
     <thead>
       <tr>
         <td>序号</td>
         <td>合同编号</td>
         <td>标的类别</td>
         <td>标的名称</td>
         <td>标的总金额</td>
         <td>已投金额</td>
         <td>已投人数</td>
         <td>标的期限</td>
         <td>年化收益</td>
         <td>标的状态</td>
         <td>可体验金购买</td>
         <td>操作</td>
       </tr>
     </thead>
     <tbody>
    <c:forEach  items="${listAll }" var="a" varStatus="stat" >
      <tr>
        <td>${stat.index+1 }</td>
        <td>${a.subject.serial_no }</td>
        <td>
         <c:if test="${a.subject.type==0 }">固收类</c:if>
         <c:if test="${a.subject.type==1 }">P2P车贷</c:if>
         <c:if test="${a.subject.type==2 }">海外配置</c:if>
         <c:if test="${a.subject.type==3 }">股权基金</c:if>
        </td>
        <td>${a.subject.name }</td>
        <td>￥${a.subject.amount } </td>
        <td>￥${a.amount }.00元</td>
        <td>${a.subject.bought }人</td>
        <td>${a.subject.period }天</td>
        <td>${a.subject.year_rate }%</td>
        <td>
          <c:if test="${a.subject.status==1 }">募集中</c:if>
          <c:if test="${a.subject.status==0 }">已完成</c:if>
        </td>
        <td>
          <c:if test="${a.subject.exper_status==1 }">是</c:if> 
          <c:if test="${a.subject.exper_status==0 }">否</c:if> 
        </td>
        <td>
         <c:if test="${a.subject.exper_status==1 }">
           <button><a href="/yingJiaProfit/Payint/Bbin?id=${a.subject.id }">体验金付息</a></button>
         </c:if>
        <button><a href="/yingJiaProfit/Payint/Payment?id=${a.subject.id }">付息列表</a></button>
        </td>
      </tr>
      </c:forEach>
      </tbody>
   </table>
</body>
</html>