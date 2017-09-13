<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
 	<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.min.css">
   <script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>	
	
	<style type="text/css">
		.style16{
		width: 100%;
		height:800px;	
		margin: 0px auto;
		margin-bottom:20px;
		border:1px solid #CEE3E9;
		background-color: #F1F7F9
		}
	</style>
</head>
<body>
<table border="1" width="100%" class="table">
<tr>
				<td>序号</td>
				<td>合同编号</td>
				<td>类型</td>
				<td>名称</td>
				<td>标的总金额</td>
				<td>已投总金额</td>
				<td>投资期限</td>
				<td>起投金额</td>
				<td>年化利益</td>
				<td>状态</td>
				<td>可使用体验金</td>
				<td>添加时间</td>
				<td>操作</td>
  </tr>
   <c:forEach items="${list}" var="e" varStatus="stat">
			<tr>

				<td>${stat.index+1 }</td>
	           <td>${e.serial_no}</td>
	           <td>${e.type}</td>
				<td>${e.name}</td>
				<td>${e.amount}</td>
				<td >
				 <script type="text/javascript">
				  var id='${e.id}';
				  $.ajaxSetup({  
					    async : false  
					}); 
				  var num1=0;
				  $.post("/yingJiaProfit/subject/getTotalMoney",{id:id},function(data){
					  //alert(data);
					 //document.getElementById(id).innerHTML=data;
					 num1=data;
				  });
				  document.write(num1);
				 </script>
				</td>
				<td>${e.end_date }-${e.start_date }</td>
				<td>${e.floor_amount }</td>
				<td>${e. year_rate/100}</td>
				<td><c:if test="${e.status==0}">募集中</c:if>
				<c:if test="${e.status==1}">未募集</c:if></td>
<%-- 				<td>${e.exper_status} </td> --%>
				<td><c:if test="${e.exper_status==0}">否</c:if>
				<c:if test="${e.exper_status==1}">是</c:if></td>
			  <td>${e.create_date}</td>
			  <button  data-toggle="modal"
								data-target="#addRoleModal"
								class="btn btn-lg btn-success active btn-block" id="saveBtn">编辑查看</button>
<!-- 				<td><a href="/yingJiaProfit/subject/selectSub">编辑查看</a> -->
				<a href="">查看投资</a></td>
				<td>
			</tr>
		</c:forEach>
</table>

<div class="modal" id="addRoleModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"
							style="font-weight: bold;">编辑查看</h4>
					</div>
					<form action="" method="post">
						<div class="modal-body">
							<label>角色名称:</label> <input type="text" required="required"
								class="form-control" placeholder="角色名称...."> <label>角色描述:</label>
							<input type="text" required="required" class="form-control"
								placeholder="角色描述....">
						</div>
						<div class="modal-footer">
							<div style="margin: 0 auto; width: 50%;">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">关闭</button>
								<input type="submit" class="btn btn-primary" value="提交更改" /> <input
									type="reset" class="btn btn-success" value="重置表单" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>