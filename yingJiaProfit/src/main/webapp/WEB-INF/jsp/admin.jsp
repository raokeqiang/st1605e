<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>理财管理</title>

	<link rel="stylesheet" href="/yingJiaProfit/backstage/common/css/sccl.css">
	<link rel="stylesheet" type="text/css" href="/yingJiaProfit/backstage/common/skin/qingxin/skin.css" id="layout-skin"/>
	<script type="text/javascript" language="JavaScript" src="/yingJiaProfit/js/jquery.js"></script>
</head>
 <body>
 <!-- 
 <c:if test="${empty admin }">
		<script type="text/javascript">
			location="404/error.jsp";
		</script>
</c:if> 
 -->
	<div class="layout-admin">
		<header class="layout-header">
			<span class="header-logo">理财后台管理</span> 
			<a class="header-menu-btn" href="javascript:;"><i class="icon-font">&#xe600;</i></a>
			<ul class="header-bar">
				<li class="header-bar-role"><a href="javascript:;">超级管理员</a></li>
				<li class="header-bar-nav">
					${admin.userName}<i class="icon-font" style="margin-left:5px;">&#xe60c;</i>
					<ul class="header-dropdown-menu">
						<li><a href="#">刷新</a></li>
						<li><a href="" onclick="return confirm('确定注销?')">切换账户</a></li>
						<li><a href=""   onclick="return confirm('确定退出?')">退出</a></li>
					</ul>
				</li>
				<li class="header-bar-nav"> 
					<a href="javascript:;" title="换肤"><i class="icon-font">&#xe608;</i></a>
					<ul class="header-dropdown-menu right dropdown-skin">
						<li><a href="javascript:;" data-val="qingxin" title="清新">清新</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="molv" title="墨绿">墨绿</a></li>
						
					</ul>
				</li>
			</ul>
		</header>
		<aside class="layout-side">
			<ul class="side-menu">
			  
			</ul>
		</aside>
		
		<div class="layout-side-arrow"><div class="layout-side-arrow-icon"><i class="icon-font">&#xe60d;</i></div></div>
		
		<section class="layout-main">
			<div class="layout-main-tab">
				<button class="tab-btn btn-left"><i class="icon-font">&#xe60e;</i></button>
               <nav class="tab-nav">
                    <div class="tab-nav-content">
                        <a  class="content-tab active" data-id="home.jsp" href="index.jsp">首页</a>
                    </div>
                </nav> 
                <button class="tab-btn btn-right"><i class="icon-font">&#xe60f;</i></button>
			</div>
			<div class="layout-main-body">
				<iframe class="body-iframe" name="iframe0" width="100%" height="99%" src="/yingJiaProfit/WEB-INF/jsp/menus1.jsp" frameborder="0" data-id="home.html" seamless></iframe>
			</div>
		</section>
		<div class="layout-footer"> <div id="jnkc"> </div> 
 <script>setInterval("jnkc.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
 </script> </div>
	</div>
	<script type="text/javascript" src="/yingJiaProfit/backstage/common/lib/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/backstage/common/js/sccl.js"></script>
	<script type="text/javascript" src="/yingJiaProfit/backstage/common/js/sccl-util.js"></script>
  </body>
</html>