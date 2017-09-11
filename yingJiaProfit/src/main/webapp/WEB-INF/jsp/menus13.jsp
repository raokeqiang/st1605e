<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账号管理</title>
<link rel="stylesheet" type="text/css" href="/yingJiaProfit/css/bootstrap.min.css"/>
<script type="text/javascript" src="/yingJiaProfit/css/iframeindex_data/jquery.js" ></script>
   <script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js" ></script>
   <script type="text/javascript">
	$(function(){
		$("#btn1").click(function() {
			document.forms[0].action = "/yingJiaProfit/over/toAdd";
			document.forms[0].submit();
		});
		$("#btn2").click(function() {
			document.forms[0].action = "/yingJiaProfit/over/edit";
			document.forms[0].submit();
		});
	});
</script>
</head>
<body>
    <form action="/yingJiaProfit/over/list">
<table  class="table" width="100%" border="1">

  <input type="button" value="新增" id="btn1" />
<tr>
              <th>编号</th>
		      <th>标题</th>
			    <th>子标题</th>
			    <th>状态</th>
			    <th>排序值</th>
			    <th>图标</th>
			    <th>添加时间</th>
			    <th>操作</th>
</tr>
<c:forEach items="${list }" var="e" varStatus="stat">
				<tr>
				
				<td class="active">${stat.index+1 }</td>
				<td class="success">${e.title }</td>
				<td class="success">${e.child_title }</td>
				<td class="warning">${e.status}</td>
				<td class="warning">${e.sortColum }</td>
				<td class="warning">${e.oversea_icon}</td>
				<td class="warning">${e.addTime}</td>
				<td>
<input type="button" class="btn btn-primary btn-sm" value="删除" />
			</tr>
			</c:forEach>
</table>
</form>

</body>
</html>