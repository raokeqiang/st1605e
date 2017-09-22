<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>绑卡管理</title>
</head>
<body>
<form action="/yingJiaProfit/Card/listAll" method="post">
	   手机号：<input type="text" name="qmobile_Phone" value="${qmobile_Phone}"/>&nbsp;&nbsp;&nbsp;&nbsp;
	    绑卡姓名：<input type="text" name="qmember_name" value="${qmember_name }"/><br>
	   绑卡卡号：<input type="text" name="qcard_no" value="${qcard_no}"/>&nbsp;&nbsp;&nbsp;&nbsp;
	    注册时间：<input type="text" name="qcreate_date" value="${qcreate_date }"/><br>
	 <input type="submit" value="查询"/>
  </form>
   <table class="table table-bordered table-hover"  width="100%">
       <caption style="text-align: center; font-size:30px; color:red;">MemberBankcards绑卡管理表</caption>
     <thead>
       <tr>
         <td>序号</td>
         <td>手机号</td>
         <td>绑卡人姓名</td>
         <td>绑卡身份证</td>
         <td>绑卡类型</td>
         <td>绑卡卡号</td>
         <td>绑卡地址</td>
         <td>状态</td>
         <td>添加时间</td>
         <td>操作</td>
       </tr>
     </thead>
     <tbody>
    <c:forEach  items="${listAll }" var="listAll" varStatus="stat" >
      <tr>
        <td>${stat.index+1 }</td>
        <td>${listAll.member.mobile_Phone }</td>
        <td>${listAll.member.member_name }</td>
        <td>${listAll.member.identity }</td>
        <td>${listAll.type } </td>
        <td>${listAll.card_no }</td>
        <td>${listAll.cardaddress }</td>
        <td>
         <c:if test="${listAll.delflag==0 }">正常</c:if>
         <c:if test="${listAll.delflag==2 }">被删除</c:if>
        </td>
        <td>${listAll.create_date }</td>
        <td>
        <c:if test="${listAll.delflag==0 }">
        <a href="/yingJiaProfit/Card/updatedelflag?id=${listAll.id }">解除绑定</a>
        </c:if>
        <c:if test="${listAll.delflag==2 }"><a>已解除</a></c:if>
        </td>
      </tr>
      </c:forEach>
      </tbody>
   </table>
</body>
</html>