<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/yingJiaProfit/css/bootstrap.min.css"/>
<script type="text/javascript" src="/yingJiaProfit/css/iframeindex_data/jquery.js" ></script>
   <script type="text/javascript" src="/yingJiaProfit/js/bootstrap.min.js" ></script>
  <script type="text/javascript">
  $(function(){
  $("#btn2").click(function(){ //返回按钮
	  	$("#form1").attr("action","/yingJiaProfit/subject/showp2p");
	  	$("#form1").submit();
	  });

	  });
  </script>
</head>
<body>
<form action="/yingJiaProfit/subject/p2pAdd" id="form1" method="post">
名称:<input type="text"  name="name" ><br>
合同编号:<input type="text" name="serial_no" ><br>
起投金额:<input type="text" name="floor_amount" ><br>
年化收益:<input type="text+%" name="year_rate"><br>
投资期限:<input type="text" name="period"><br>
状态:<select name="status">
<option value="0">未募集</option>
<option value="1">募集中</option>
</select><br>
借款人姓名:<input type="text" name="borrowername" ><br>
类型:
<select name="type">
<option value="0">p2p房贷</option>
<option value="1">p2p车贷</option>
</select><br>
借款用途:<input type="text" name="purpose" ><br>
保障方式:
<select name="afetyControl">
<option value="0">企业担保</option>
<option value="1">保障方式</option>
</select><br>
 可使用体验金:
 <select name="exper_status">
<option value="0">否</option>
<option value="1">是</option>
</select><br>
已购人数:<input type="text" name="bought" ><br>
<input type="submit" value="提交">
 <button type="button" class="btn btn-primary" id="btn2">返回</button> 
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