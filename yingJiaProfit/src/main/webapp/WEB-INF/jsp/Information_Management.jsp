<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>咨询管理</title>
</head>
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.min.css">
<script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>
<script type="text/javascript"  src="/yingJiaProfit/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript"  src="/yingJiaProfit/utf8-jsp/ueditor.all.min.js"> </script>
<script type="text/javascript"  src="/yingJiaProfit/utf8-jsp/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
	function fun1(id,sort,info,addTie,title,text,typeid){
	document.getElementById("id").value=id;
		document.getElementById("sort").value=sort;
		document.getElementById("info").value=info;
		document.getElementById("addtie").value=addTie;
		document.getElementById("title").value=title;
		document.getElementById("typeid").value=typeid;
		 ue2.setContent(text);
	}
	function fun2(id){
		window.location.href="/yingJiaProfit/N/delect?id="+id;
	}
	</script>
<body>
<form action="/yingJiaProfit/N/listnews" method="post">
标题：<input type="text" name="title" class="width=200px" placeholder="标题名称....">所属类别：<select name="typeid" ><option value="">全部</option><c:forEach items="${types }" var="types" ><option value="${types.id }">${types.name}</option></c:forEach></select>
<input type="submit" value="搜索"  class="btn btn-primary">
<button type="button" style="width: 100px" data-toggle="modal"
								data-target="#addRoleModal"
								class="btn btn-primary" id="saveBtn">新增</button>
								</form>
<table class="table">
<thead>
<tr><td>序号</td><td>标题</td><td>所属类别</td><td>排序</td><td>添加时间</td><td>操作</td></tr>
<c:forEach items="${news }" var="news" varStatus="stat" >
<tr><td>${stat.index+1} </td><td>${news.title}</td><td>${news.type.name}</td><td>${news.sort  }</td><td>${news.addTie }</td>
<td>
<button type="button" style="width: 100px" data-toggle="modal"
				data-target="#addRoleModa2"
								class="btn btn-primary" id="updareBtn" onclick="fun1('${news.id  }','${news.sort  }','${news.info}','${news.addTie }','${news.title }','${news.text }','${news.type.id }')">编辑</button>
								<button type="button" style="width: 100px" data-toggle="modal"
				data-target="#addRoleModa3"
								class="btn btn-primary" id="deleteBtn" onclick="fun2('${news.id}')">删除</button>
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
							style="font-weight: bold;">添加资讯</h4>
					</div>
					<form action="/yingJiaProfit/N/savenews" method="post">
						<div class="modal-body">
						所属类别：<select name="type.id" class="form-control" ><c:forEach items="${types }" var="types" ><option value="${types.id }">${types.name}</option></c:forEach></select>
							<label>标题：</label> <input type="text" name="title" required="required"
								class="form-control" placeholder="标题名称....">
								<input type="hidden" name="id" value="-1">
							排序:<input type="text" name="sort" class="form-control" >
							简介:<input type="text" name="info" class="form-control">
<!-- 加载编辑器的容器 -->  
标题内容
<script id="container" name="text" type="text/plain">请输入标题内容！</script>  
<!-- 配置文件 -->  
<!-- 编辑器源码文件 -->  
<!-- 实例化编辑器 -->  
<script type="text/javascript">  
    var ue = UE.getEditor('container');  
</script>  
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
							style="font-weight: bold;">修改资讯</h4>
					</div>
					<form action="/yingJiaProfit/N/updatenews" method="post">
						<div class="modal-body">
						所属类别：<select name="type.id" class="form-control" id="typeid" ><c:forEach items="${types }" var="types" ><option value="${types.id }">${types.name}</option></c:forEach></select>
							<label>标题：</label> <input type="text" name="title" required="required"
								class="form-control" placeholder="标题名称...." id="title">
								<input type="hidden" name="id" id="id" >
							排序:<input type="text" name="sort" class="form-control" id="sort" >
							简介:<input type="text" name="info" class="form-control" id="info">
							<input type="hidden" name="time" id="addtie">
<!-- 加载编辑器的容器 -->  
<script id="container2" name="text" type="text/plain"></script>  
<!-- 配置文件 -->  
<!-- 编辑器源码文件 -->  
<!-- 实例化编辑器 -->  
<script type="text/javascript">  
    var ue2 = UE.getEditor('container2');  
</script>  
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