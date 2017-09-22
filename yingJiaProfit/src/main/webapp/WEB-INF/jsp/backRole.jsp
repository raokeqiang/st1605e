<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色设置</title>
	<link rel="stylesheet" href="/yingJiaProfit/css/metro.css"  />	
 	<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
 	<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.min.css">
 	
	<script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>	
	<script type="text/javascript" src="/yingJiaProfit/js/jquery.ztree.all-3.5.min.js"></script>
	
</head>
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
	<script>

	 var cid=0;
	 function cc(id) {  
	 cid=id;
     var setting = {  
        check: {  
            enable: true,  
            chkStyle: "checkbox",  
            chkboxType : { "Y" : "ps", "N" : "ps" }  
        },  
        //获取json数据  
        async : {    
            enable : true,   
            url : "Ztree", // Ajax 获取数据的 URL 地址    
            autoParam : [ "id", "name" ], //ajax提交的时候，传的是id值  
            otherParam: { "id":id}
        },    
        data:{ // 必须使用data    
            simpleData : {    
                enable : true,    
                idKey : "id", // id编号命名     
                pIdKey : "pId", // 父id编号命名      
                rootId : 0  
            }    
            },    
        // 回调函数    
        callback : {    
            onClick : function(event, treeId, treeNode, clickFlag) { 
            },    
            //捕获异步加载出现异常错误的事件回调函数 和 成功的回调函数    
            onAsyncSuccess : function(event, treeId, treeNode, msg){    
            },  
        }   
            
    };  
 $.fn.zTree.init($("#treeDemo"), setting); 
 }
 //获取所有选中节点的值
 function GetCheckedAll() {
     var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
     var nodes = treeObj.getCheckedNodes(true);
     var msg = "";
     for (var i = 0; i < nodes.length; i++) {
         msg += nodes[i].id+",";
     }
     $.ajax({
         async : false,
         cache : false,
         timeout: 1000,
         url: '/yingJiaProfit/backSystemRoleSettings/addPers?id='+cid,
         type: "post",
         data:{"msg":msg,"id":cid}
     });
     window.close();     
      
 }    
</script>
	
<body>
<div class="style16" >
	<shiro:hasPermission name="添加角色">
				<button type="button" style="width: 120px;height: 40px" data-toggle="modal"
				data-target="#addRoleModal"
				class="btn btn-lg btn-success active btn-block" id="saveBtn">✚新增角色</button>
	</shiro:hasPermission>
							
<table width="100%" class="table">
   <thead>
      <tr>
         <th>编号</th>
         <th>角色名</th>
         <th>备注</th>
         <th>创建时间</th>
         <th>操作</th>
      </tr>
   </thead>
   <tbody>
   <c:forEach  items="${list }" var="e" varStatus="stat" >
      <tr>
      <td>${stat.index+1 }</td>
      <td>${e.cname }</td>
      <td>${e.remark }</td>
      <td>${e.create_date }</td>
      <td><a  data-toggle="modal"
					data-target="#setRoleModal"
					class="btn btn-lg btn-primary active btn-block" 
					onclick="cc(${e.id})">权限配置</a></td>
      </tr>
    </c:forEach>
   </tbody>
</table>
</div>

<div class="modal" id="addRoleModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"
							style="font-weight: bold;">新增角色</h4>
					</div>
					<form action="/yingJiaProfit/backSystemRoleSettings/saveUserRole" method="post">
						<div class="modal-body">
							<label>角色名称:</label> 
							<input type="text" required="required" name="cname"	class="form-control" placeholder="角色名称....">
							<label>角色描述:</label>
							<input type="text" required="required" name="remark" class="form-control" placeholder="角色描述....">
						</div>
						<div class="modal-footer">
							<div style="margin: 0 auto; width: 50%;">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">关闭</button>
								<input type="submit" class="btn btn-primary" value="提交角色" /> <input
									type="reset" class="btn btn-success" value="重置表单" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		
<!-- 		//ztree -->
			<div class="modal" id="setRoleModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">权限分配</h4>
					</div>
					<div class="modal-body">
						<!-- ztree 树形菜单-->
						<ul id="treeDemo" class="ztree" style="width:560px; overflow:auto;"></ul>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary"   data-dismiss="modal" onclick="GetCheckedAll();">提交</button>
					</div>
				</div>
			</div>
		</div>

</body>
</html>