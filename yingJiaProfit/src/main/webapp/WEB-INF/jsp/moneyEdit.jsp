<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	
	</script>
</head>
<body>
<form action="/yingJiaProfit/money/update"  method="post" id="form1" name="form1">
<input type="hidden" name="id" value="${finance.id }"> 
类型:
<select name="type" id="type">
<option value="SIMU">私募类</option>
<option value="GUQUAN">股权类</option>
</select><br>
名称:<input type="text"  name="name" value="${finance.name}"><br>
起投金额:<input type="text" name="amount" value="${finance.amount }"><br>
年化收益:<input type="text" name="year_rate" value="${finance. year_rate}"><br>
返佣比例:<input type="text" name="ratio" value="${finance.ratio }">
状态:<select name="status">
							<option value="">全部</option>
							<option value="0">募集中</option>
							<option value="1">未募集</option>
							<option value="2">回款中</option>
	</select>
<br>
<input type="submit" value="提交">
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