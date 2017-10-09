<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width,maximum-scale=1.0,user-scalable=yes">
<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
<title>用来显示首页中部界面的iframe</title>

<meta name="keywords"
	content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50">
<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。">
<link href="http://pro.ying158.com/resources/web/images/icon.ico"
	type="image/x-icon" rel="shortcut icon">

<link href="/yingJiaProfit/css/iframeindex_data/iconfont.css" rel="stylesheet"
	type="text/css">
<link href="/yingJiaProfit/css/iframeindex_data/common.css" rel="stylesheet">
<link href="/yingJiaProfit/css/iframeindex_data/jw.css" rel="stylesheet">

<script src="/yingJiaProfit/css/iframeindex_data/jquery.js"></script>
<script type="text/javascript" src="/yingJiaProfit/css/iframeindex_data/layer.js"></script>
<link rel="stylesheet" href="/yingJiaProfit/css/iframeindex_data/layer.css"
	id="layui_layer_skinlayercss" >
<script src="/yingJiaProfit/css/iframeindex_data/echarts.js"></script>
</head>
<body>
	<div class="gjList clearfix">
	  <c:forEach items="${list}" var="s">
		<ul>
			<li>
<!-- 			<a class="all" target="_blank" -->
<!-- 				href="http://pro.ying158.com/finance/financeView/28"> -->
					<h2 class="tit">
					
						<span>募</span>${s.name }
					</h2> <span class="fenl">股权</span>
					<div class="count">
						<span class="s1"><b>${s.year_rate }</b>%</span> <span class="s2"><b></b></span>
						<span class="s3">年化收益</span> <span class="s4"></span> <span
							class="s5">/</span>
					</div>
					<p class="safe">
						起购金额：￥${s.floor_amount }<br>
					</p>
					<p class="txt" style="height: 72px;">管理人：深圳市凯丰投资管理有限公司</p>
					<p class="abox">
						<span class="abtn"><a class="abtn" href="/yingJiaProfit/shopping/toBuy?id=${s.id }">购买</a></span>
					</p>
			</a></li>
			
		</ul>
		</c:forEach>
	</div>
</body>
</html>