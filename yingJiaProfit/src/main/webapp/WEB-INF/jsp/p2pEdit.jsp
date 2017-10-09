 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑查看盘p2p</title>
	<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.css">
 	<link rel="stylesheet" href="/yingJiaProfit/css/bootstrap.min.css">
 	<script type="text/javascript" src="/yingJiaProfit/js/jquery.min.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js"></script>	
	<script type="text/javascript">
	  $(document).ready(function(){
		  $("#status").val(${sub.status}); 
	  });
	  $(document).ready(function(){
		  $("#type").val(${sub.type}); 
	  });
	  $(document).ready(function(){
		  $("#exper_status").val(${sub.exper_status}); 
	  });
	
	  $(function(){
	  $("#btn2").click(function(){ //返回按钮
		  	$("#form1").attr("action","/yingJiaProfit/subject/showp2p");
		  	$("#form1").submit();
		  });

		  });
	  
	</script>
</head>
<body>
<form action="/yingJiaProfit/subject/update"  method="post" id="form1"> 
<input type="hidden" name="id" value="${sub.id}"/>
<table border="0" cellspacing="0" width="400">
<tr height="60">
<td>名称:</td>
<td><input type="text" size="30" name="name" class="form-control" value="${sub.name}" ></td>
</tr>
<tr height="60">
<td>合同编号:</td>
<td><input type="text" size="30" name="serial_no" class="form-control" value="${sub.serial_no}" ></td>
</tr>
<tr height="60">
<td>起投金额(元):</td>
<td><input type="text" name="floor_amount" class="form-control" value="${sub.floor_amount}"></td>
</tr>
<tr height="60">
<td>年化收益(%):</td>
<td><input type="text" name="year_rate" class="form-control" value="${sub.year_rate}"></td>
</tr>
<tr height="60">
<td>状态:</td>
<td>	<select name="status" id="status">
		<option value="0">未发布</option>
		<option value="1">募集中</option>
		<option value="2">回款中</option>
		</select>
</td>
</tr>
<tr height="60">
<td>投资期限:</td>
<td><input type="text" name="period" class="form-control" value="${sub.period}"></td>
</tr>	
<tr height="60">
<td>借款人姓名:</td>
<td><input type="text" name="borrowername" class="form-control" value="${sub.borrowername}"></td>
</tr>
<tr height="60">
<td>类型:</td>
<td><select name="type" id="type">
		<option value="0">固收类</option>
		<option value="1">P2P车贷</option>
		<option value="2">P2P房贷</option>
		</select>
</td>
</tr>
<tr height="60">
<td>借款用途:</td>
<td><input type="text" name="purpose" class="form-control" value="${sub.purpose}"></td>
</tr>
<tr height="60">
<td>保障方式:</td>
<td><select name="safeGuard_way" id="safeGuard_way">
		<option value="0">企业担保</option>
		<option value="1">银行监管</option>
		</select>
</td>
</tr>
<tr height="60">
<td>可使用体验金:</td>
<td><select name="exper_status" id="exper_status">
		<option value="0">否</option>
		<option value="1">是</option>
		</select>
</td>
</tr>
<tr height="60">
<td>已购人数:</td>
<td><input type="text" name="bought" class="form-control" value="${sub.bought}"></td>
</tr>	
<tr>
<td colspan="2"><button type="submit" class="btn btn-primary">提交</button>
<button type="button" class="btn btn-primary" id="btn2">返回</button></td>
</tr>	
</table>
</form> 
<script type="text/javascript" charset="utf-8" src="/yingJiaProfit/editor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/yingJiaProfit/editor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="/yingJiaProfit/editor/lang/zh-cn.js"></script>
    
    <div style="width: 100%;height: 100%;">
       <script id="editor"  name="themeBody"  type="text/plain" style="width:100%;height:270px;"></script>
    </div>
<script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
    ue.setHeight(300);
    function  fun(){
    	 var t = document.getElementById("themeTitle").value;
    	 var  num = t.length;
    	 if(num==0){
    		 alert("标题不能为空!");
    		 return;
    	 }
    
    	if(num>20){
    		alert("标题长度超过了20个字符!");
    		return;
    	}
    	if(!UE.getEditor('editor').hasContents()){
    		alert("请先回复内容!");
    		return;
    	}
    	
    	  document.getElementById("form1").submit();
    	
    }
  </script>
</body>
</html>