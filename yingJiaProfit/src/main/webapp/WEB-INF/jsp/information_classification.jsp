<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.min.css">
<script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function fun1(id,name,sort,supType,info,addTime){
	document.getElementById("id").value=id;
		document.getElementById("name").value=name;
		document.getElementById("sort").value=sort;
		document.getElementById("supType").value=supType;
		document.getElementById("info").value=info;
		document.getElementById("Time").value=addTime;
	}
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>咨询分类</title>
</head>
<body>
<button type="button" style="width: 100px" data-toggle="modal"
								data-target="#addRoleModal"
								class="btn btn-primary" id="saveBtn">新增</button>
<table class="table">
<thead>
<tr><td>序号</td><td>名称</td><td>简介</td><td>上级类别</td><td>类别</td><td>排序</td><td>添加时间</td><td>操作</td></tr>
<c:forEach items="${types }" var="types" varStatus="stat" >
<tr><td>${stat.index+1} </td><td>${types.name}</td><td>${types.info}</td><td>${types.supType }</td><td>${types.id  }</td><td>${types.sort  }</td><td>${types.addTime }</td>
<td>
<button type="button" style="width: 100px" data-toggle="modal"
				data-target="#addRoleModa2"
								class="btn btn-primary" id="updareBtn" onclick="fun1('${types.id  }','${types.name  }','${types.sort}','${types.supType }','${types.info }','${types.addTime }')">编辑</button>
								</td>
								</tr>
</c:forEach>
</thead>
</table>
<div class="modal" id="addRoleModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"
							style="font-weight: bold;">添加分类</h4>
					</div>
					<form action="/yingJiaProfit/T/savetype" method="post">
						<div class="modal-body">
						上级类别：<select name="supType" class="form-control"><option value="0">根类别</option><c:forEach items="${types }" var="types" ><option value="${types.id }">${types.name}</option></c:forEach></select>
							<label>名称：</label> <input type="text" name="name" required="required"
								class="form-control" placeholder="标题名称....">
								<input type="hidden" name="id" value="-1">
							排序:<input type="text" name="sort" class="form-control" >
							简介:<input type="text" name="info" class="form-control">
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
				<div class="modal" id="addRoleModa2" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"
							style="font-weight: bold;">编辑分类</h4>
					</div>
					<form action="/yingJiaProfit/T/updatenewstype" method="post">
						<div class="modal-body">
						上级类别：<select name="supType" class="form-control" id="supType"><option value="0">根类别</option><c:forEach items="${types }" var="types" ><option value="${types.id }">${types.name}</option></c:forEach></select>
							<label>名称：</label> <input type="text" name="name" required="required"
								class="form-control" placeholder="标题名称...." id="name">
								<input type="hidden" name="id"  id="id">
							排序:<input type="text" name="sort" class="form-control"  id="sort">
							简介:<input type="text" name="info" class="form-control" id="info">
							<input type="hidden" name="Time" id="Time">
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