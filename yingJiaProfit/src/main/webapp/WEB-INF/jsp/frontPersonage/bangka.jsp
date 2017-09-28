<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width,maximum-scale=1.0,user-scalable=yes">
<meta name="Keywords"
	content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50">
<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。">
<title>绑卡</title>
<link href="/yingJiaProfit/css/person_css/common.css" rel="stylesheet">
<link href="/yingJiaProfit/css/person_css/iconfont.css" rel="stylesheet">
<link href="/yingJiaProfit/css/person_css/jw.css" rel="stylesheet">
<script src="/yingJiaProfit/css/person_css/jquery.js"></script>
<script src="/yingJiaProfit/js/bootstrap.js"></script>
<script src="/yingJiaProfit/css/person_css/hm.js"></script>
<script src="/yingJiaProfit/css/person_css/echarts.js"></script>
<!-- 校验 -->


<body>
<!-- 顶部iframe -->
	<div style="width: 1002px; height: 94px; margin: 0 auto;">
		<iframe src="/yingJiaProfit/show/frontTopIframe" scrolling="no"
			width="1002" height="94" frameborder="0"></iframe>
	</div>
	
	
			<div class="jwNav">
		<div class="container">
			<div class="row">
				<ul class="topNav">
					<li class="active"><a class="item first"
						href="/yingJiaProfit/show/frontHome"> 首页 </a></li>
					<li><a class="item" href="/yingJiaProfit/show/frontExploration">
							网上体验中心 </a></li>
					<li><a class="item" href="/yingJiaProfit/subjectqian/showsubject"> 产品中心 </a>
					</li>
					<li><a class="item"
						href="/yingJiaProfit/show/frontJournalism"> 新闻中心 </a></li>
					<li><a class="item"
						href="/yingJiaProfit/show/frontLoad"> 下载中心 </a></li>
					<li><a class="item " href="/yingJiaProfit/show/frontCollege">
							盈+商学院 </a></li>
					<li><a class="item"
						href="/yingJiaProfit/show/frontStudy"> 投研中心
					</a></li>
					<c:if test="${member.id==null }"><li><a class="item last"
						href="/yingJiaProfit/toFrontLogin/login">
							我的加法库 </a></li></c:if>
							<c:if test="${member.id!=null }">
					<li><a class="item last"
						href="/yingJiaProfit/MemberAccount/select?member_id=${member.id }">
							我的加法库 </a></li></c:if>
				</ul>
			</div>
		</div>
	</div>
	<!-- -----------------------------------------分割线---------------------------------- -->
	<!-- -----------------------------------------分割线---------------------------------- -->
	<!-- -----------------------------------------分割线---------------------------------- -->
	<!-- -----------------------------------------分割线---------------------------------- -->

<table class="peopleInfo" width="970" height="160" cellspacing="0"
		cellpadding="0" border="0">
		<tbody>
			<tr>
				<td class="info" valign="middle" align="left"><a
					href="http://pro.ying158.com/account/security">
						<div class="img">
							<img src="/yingJiaProfit/img/userPic.jpg">
						</div>
						<h2>
							${member.member_name}，<span>您好!</span>
						</h2>
				</a>
					<div class="safe">
						账户安全&nbsp;&nbsp;<span class="scroll"><em style="width: 50%"></em></span>
					</div>
					<ul class="listIco iconfont">
						<li class=""><a href="#1"></a><em></em></li>
						<li class="active"><a href="#1"></a><em></em></li>
						<li class="active"><a href="#1"></a><em></em></li>
						<li class=""><a href="#1"></a><em></em></li>
					</ul></td>
				<td align="right"><a href="/yingJiaProfit/toFrontLogin/logout"
					class="loginOut"><span class="iconfont"></span>安全退出</a></td>
			</tr>
		</tbody>
	</table>
		<div class="countBox">
		<ul>
			<li><h2>${memberAccount.useable_balance }</h2>
				<p>
					账户可用余额(元)<a href="javascript:;" class="iconfont"><span>账户可用余额</span><i></i></a>
				</p></li>
			<li><h2>${memberAccount.useable_balance+memberAccount.invest_amount+memberAccount.total_profit }</h2>
				<p>
					账户总资产(元)<a href="javascript:;" class="iconfont"><span>可用余额+投资金额+累计收益</span><i></i></a>
				</p></li>
			<li><h2 style="color: #9d8440">${memberAccount.invest_amount }</h2>
				<p>
					投资金额(元)<a href="javascript:;" class="iconfont"><span>投资中资金</span><i></i></a>
				</p></li>
			<li><h2 style="color: #9d8440">${memberAccount.total_profit }</h2>
				<p>
					累计收益(元)<a href="javascript:;" class="iconfont"><span>累计收益</span><i></i></a>
				</p></li>
			<li><h2 style="color: #9d8440">${memberAccount.imuseale_balance }</h2>
				<p>
					冻结金额(元)<a href="javascript:;" class="iconfont"><span>提现冻结金额</span><i></i></a>
				</p></li>
		</ul>
		<c:if test="${empty memberBankcards }">
			<a href="/yingJiaProfit/shopping/tocongzhi" class="cz">充值</a> 
		</c:if>
		<c:if test="${memberBankcards.id>0 }">
			<a href="/yingJiaProfit/shopping/tocongzhi" class="cz">充值</a> 
		</c:if>
		<c:if test="${empty memberBankcards }">
			<a href="/yingJiaFinancing/frontMemberCenter/toBankCard" class="tk">提款</a>
		</c:if>
		<c:if test="${memberBankcards.id>0 }">
			<a href="#" class="tk">提款</a> 
			</c:if>
	</div>
	<div class="proMain clearfix">
		<div class="adminLeft">
			<h2>我的投资</h2>
			<ul>
				<li><a id="member_center_menu_invests"
					href="/yingJiaProfit/toFrontPersonage/touzi"><em
						class="iconfont red"></em>投资记录</a></li>
				<li><a 
					href="/yingJiaProfit/toFrontPersonage/shouyi"><em
						class="iconfont red"></em>收益记录</a></li>
				<li><a id="member_center_menu_deposit_record"
					href="/yingJiaProfit/toFrontPersonage/chongzhi"><em
						class="iconfont red"></em>充值记录</a></li>
				<li><a id="member_center_menu_withdraw_record"
					href="/yingJiaProfit/toFrontPersonage/tikuan"><em
						class="iconfont red"></em>提款记录</a></li>
				<li><a id="member_center_menu_bbinInfo_record"
					href="/yingJiaProfit/toFrontPersonage/tiyanjin"><em
						class="iconfont red"></em>体验金记录</a></li>
			</ul>
			<h2>我的账户</h2>
			<ul>
				<li><a id="member_center_menu_deposit" href="/yingJiaProfit/jilian/sheng" class="select"><em
						class="iconfont"></em>账户充值</a></li>
				<li><a id="member_center_menu_security"
					href="/yingJiaProfit/toFrontPersonage/anquan" ><em
						class="iconfont"></em>安全信息</a></li>
				<li><a id="member_center_menu_withdraw"
					href="/yingJiaProfit/toFrontPersonage/woyaotikuan"><em
						class="iconfont"></em>我要提款</a></li>
			</ul>
		</div>
		<script>
			var menu_item = "member_center_menu_profit_record";
			$("#" + menu_item).addClass("select");
		</script>
		
<div class="admin-right">
        	<div class="tbConBox">
                <div class="tab">
                    <a class="select" href="javascript:;">银行卡管理</a>
                </div>
                <div id="conBox">
                    <div class="box"  style="display:block">
                        <div class="myBankCards clearfix">
                                <div class="title">绑定银行卡</div>
                                <form  method="post" action="/yingJiaProfit/jilian/cardBound" >
                                <table class="txTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                                   <input type="hidden" value="${member.id }" name="member_id" >
                                    <tr>
                                        <td align="right">姓名：</td>
                                        <td><input type="text" class="tytxt" id="name" name="name"  placeholder="姓名"></td>
                                        <td style="color:#ff6a00">实名信息提交后不可修改，请务必认真填写真实资料</td>
                                          <td><div id="d1"></div></td>
                                    </tr>
                                    <tr>
                                        <td width="140" align="right">身份证：</td>
                                        <td><input type="text" class="tytxt" id="identity" name="identity" placeholder="身份证"></td>
                                        <td style="color:#ff6a00">一个身份证只能绑定一个帐号</td>
                                          <td><div id="d2"></div></td>
                                    </tr>

                                    <tr>
                                        <td align="right">开户银行：</td>
                                        <td colspan="2"><select class="form-control" id="type" name="type">
                                            <option value="GSYH">工商银行</option>
                                            <option value="JSYH">建设银行</option>
                                            <option value="NYYH">农业银行</option>
                                            <option value="YZCX">邮政储蓄</option>
                                            <option value="ZSYH">招商银行</option>
                                            <option value="ZGYH">中国银行</option>
                                        </select></td>
                                    </tr>
                                    <tr>
                                        <td align="right">开户地：</td>
                                        <td colspan="2"><div style="float:left;">
                                      	   <select name="province" id="loc_province" style="width:80px;">
                                           <option>选择省</option>
                                           <c:forEach items="${shengList }" var="e">
                                           <option value="${e.ID }">${e.name }</option>
                                           </c:forEach>
                                           
                                           </select>
                                        	 <select name="shi" id="loc_city" style="width:100px;">
                                            	<option value="">地级市</option>
                                            </select>
                                               <select name="xiang" id="loc_town" style="width:120px;"><option value="">市、县、区</option></select>
                                        </div>
                                        </td>
                                        <td></td>
                                    </tr>
                                   
                                    <tr>
                                        <td align="right">银行卡号：</td>
                                        <td><input type="text" class="tytxt" id="card_no" name="card_no" placeholder="银行卡号"></td>
                                          <td><div id="d3"></div></td>
                                    </tr>
                                    <tr>
                                        <td align="right">确认卡号：</td>
                                        <td>
                                            <input type="text" class="tytxt" id="card_no2" name="card_no2" placeholder="确认卡号">
                                        </td>
                                        <td><div id="d4"></div></td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td><button class="tybutton" type="submit" id="buttonsubmit">保存</button></td>
                                        <td></td>
                                    </tr>
                                </table>
                                </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
						<script type="text/javascript">
							function getJsonInfo(url) {
								$.get(url, 'json', function(data) {
									$(".ajaxContainer").empty();
									$(".ajaxContainer").append(data);
								});
							}
						</script>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- -----------------------------------------分割线---------------------------------- -->
	<!-- -----------------------------------------分割线---------------------------------- -->
	<!-- -----------------------------------------分割线---------------------------------- -->
	<!-- -----------------------------------------分割线---------------------------------- -->

	<div class="container index">
		<div class="row">
			<div class="security">
				<div class="item">
					<img src="/yingJiaProfit/img/indexSecurity1.png">
					<div class="detail">
						资金银行监管
						<div class="desc">平台资金由第三方银行监管</div>
					</div>
				</div>
				<div class="item">
					<img src="/yingJiaProfit/img/indexSecurity2.png">
					<div class="detail">
						交易证监会监管
						<div class="desc">投资交易由证监会监管</div>
					</div>
				</div>
				<div class="item">
					<img src="/yingJiaProfit/img/indexSecurity3.png">
					<div class="detail">
						风控盈+监管
						<div class="desc">盈+全自动风控系统为您保驾护航</div>
					</div>
				</div>
			</div>


		</div>
	</div>
	</div>



	<div class="foot">
		<div class="container">
			<div class="row">
				<div class="hzhb_box">
					<div class="title"
						style="padding-left: 10px; font-weight: normal; font-size: 20px; color: #ccc;">
						主要合作机构</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.picc.com/"><img
							onmouseout="this.src = '/yingJiaProfit/img/1.jpg'"
							src="/yingJiaProfit/img/1.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.fuioupay.com/"><img
							onmouseout="    this.src = '/yingJiaProfit/img/2.jpg'"
							src="/yingJiaProfit/img/2.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.nanhua.net/"><img
							onmouseout="    this.src = 'yingJiaProfit/img/3.jpg'"
							src="/yingJiaProfit/img/3.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank"
							href="http://www.zttrust.com.cn/stations/526623d20a/index.php/5268e6b50a"><img
							onmouseout="    this.src = '/yingJiaProfit/img/4.jpg'"
							src="/yingJiaProfit/img/4.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank"
							href="http://sc.hkex.com.hk/TuniS/www.hkex.com.hk/eng/index.htm/"><img
							onmouseout="    this.src = '/yingJiaProfit/img/5.jpg'"
							src="/yingJiaProfit/img/5.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.cmegroup.com/cn-s/"><img
							onmouseout="    this.src = '/yingJiaProfit/img/6.jpg'"
							src="/yingJiaProfit/img/6.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank"
							href="http://www.sgx.com/wps/portal/sgxweb_ch/home/%21ut/p/a1/04_Sj9CPykssy0xPLMnMz0vMAfGjzOKNHB1NPAycDSz9wwzMDTxD_Z2Cg8PCDANdjYEKIoEKDHAARwNC-sP1o8BK8JhQkBthkO6oqAgAzDYPQQ%21%21/dl5/d5/L2dBISEvZ0FBIS9nQSEh/"><img
							onmouseout="    this.src = '/yingJiaProfit/img/7.jpg'"
							src="/yingJiaProfit/img/7.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.neeq.com.cn/index/"><img
							onmouseout="    this.src = '/yingJiaProfit/img/8.jpg'"
							src="/yingJiaProfit/img/8.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.cmbchina.com/"><img
							onmouseout="    this.src = '/yingJiaProfit/img/9.jpg'"
							src="/yingJiaProfit/img/9.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank"
							href="http://www.bankcomm.com/BankCommSite/default.shtml"><img
							onmouseout="this.src = '/yingJiaProfit/img/10.jpg'"
							src="/yingJiaProfit/img/10.jpg"></a>
					</div>

					<div class="hzhb_item">
						<a target="_blank" href="http://www.ccb.com/cn/home/index.html"><img
							onmouseout="    this.src = '/yingJiaProfit/img/11.jpg'"
							src="/yingJiaProfit/img/11.jpg"></a>
					</div>
					<div class="hzhb_item">
						<a target="_blank" href="http://www.icbc.com.cn/icbc/"><img
							onmouseout="    this.src = '/yingJiaProfit/img/12.jpg'"
							src="/yingJiaProfit/img/12.jpg"></a>
					</div>
				</div>

				<div class="ft_item ft_item_sns">
					<div class="ft_item_tit">关注我们</div>
					<ul style="margin-bottom: 0px;" class="ft_sns_list clearfix">
						<li>
							<div class="wx_tips j_tips">
								<div class="tips_hd">
									<em class="ico_sns ico_weixin"></em> <span class="txt">微信公众号</span>
								</div>
								<div class="tips_bd">
									<em class="arrow"></em> <img src="/yingJiaProfit/img/yj.jpg"
										alt="微信公共平台">
								</div>
							</div>
						</li>
						<li><a href="" target="_blank" rel="nofollow"> <em
								class="ico_sns ico_sinawb"></em> <span class="txt">新浪微博</span>
						</a></li>
						<li><a href="" target="_blank" rel="nofollow"> <em
								class="ico_sns ico_txwb"></em> <span class="txt">腾讯微博</span>
						</a></li>
					</ul>

					<div class="contactUs">
						<div class="title"
							style="padding-left: 10px; font-weight: normal; font-size: 20px; color: #ccc;">
							联系我们</div>
						<div class="contactInfo" style="padding-left: 30px;">
							<a
								style="display: inline-block; height: 50px; width: 50px; text-align: center;"
								target="_blank"
								href="http://wpa.qq.com/msgrd?v=3&amp;uin=508886246&amp;site=qq&amp;menu=yes"><img
								src="/yingJiaProfit/img/qqIcon.png"
								onmouseover="$(this).css('height', '52px');"
								onmouseout="    $(this).css('height', '48px');"></a> <span
								class="kefu">在线客服</span><span class="time">08:30 - 21:00</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="foot3">
		<div class="container">
			<div class="row">
				Copyright © 2010 - 2015 www.ying158.com All Rights Reserverd
				杭州吉威投资管理有限公司 版权所有<br> 浙ICP备14030807号-3 杭州市江干区钱江新城迪凯银座19F
				4000-999-158
			</div>
		</div>
	</div>
	
	<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?06cf97732baac1a65bed8ae95f2384aa";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
    
    $(function(){
    	
        $("#loc_province").change(function(){
              var provinceId=$("#loc_province").val();
              $.post("/yingJiaProfit/jilian/boundShi",{sid:provinceId},function(data){
                   $("#loc_city").empty();
                     for(var i=0;i<data.length;i++){
                           $("#loc_city").append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
                   }
              });
        });
        
        $("#loc_city").change(function(){
            var provinceId=$("#loc_city").val();
            $.post("/yingJiaProfit/jilian/boundXiang",{shid:provinceId},function(data){
                 $("#loc_town").empty();
                   for(var i=0;i<data.length;i++){
                         $("#loc_town").append('<option value="'+data[i].name+'">'+data[i].name+'</option>');
                 }
            });
        });
        
        $("#username").change(function(){
        	var username=$("#username").val();
        	var user_name=$("#user_name").val();
        	if(username==user_name){
        		$(".errorInfoName").html("").hide();
        		$("#errorInfoName").html("").hide();
        	}else{
        		$(".errorInfoName").html("请填写实名信息").show();
        		$("#errorInfoName").html("").hide();
        		return ;
        	}
      	});
        
        $("#identity").change(function(){
        	var idcard=$("#identity").val();
        	if(idcard.length!=18){
        		$(".errorInfoIdCard").html("请输入正确的身份证号").show();
        		$("#errorInfoIdCard").html("").hide();
        		return ;
        	}else{
        		$(".errorInfoIdCard").html("").hide();
        	}
        	$.post("/yingJiaProfit/jilian/idcardcheck",{idcard:idcard},function(msg){
        		if(msg=='no'){
        			$(".errorInfoIdCard").html("此证件已被绑定,请更换").show();
        			$("#errorInfoIdCard").html("").hide();
        		}else{
        			$(".errorInfoIdCard").html("").hide();
        			$("#errorInfoIdCard").html("").hide();
        		}
        	})
      	});
        
        $("#bankCardNum").change(function(){
        	var bankCard=$("#bankCardNum").val();
        	if(bankCard.length!=19){
        		$(".bankCardNum").html("请输入正确的银行卡号").show();
        		return ;
        	}else{
        		$(".bankCardNum").html("").hide();
        	}
        	$.post("/yingJiaProfit/jilian/bankCardCheck",{bankCard:bankCard},function(msg){
        		if(msg=='no'){
        			$(".bankCardNum").html("此证件已被绑定,请更换").show();
        		}else{
        			$(".bankCardNum").html("").hide();
        		}
        	})
      	});
        
        $("#rebankCardNum").change(function(){
        	var bankCard=$("#bankCardNum").val();
        	var rebankCard=$("#rebankCardNum").val();
        	if(rebankCard!=bankCard){
        		$(".rebankCardNum").html("请输入正确的银行卡号").show();
        		return ;
        	}else{
        		$(".rebankCardNum").html("").hide();
        	}
      	});
        
    });
    
</script>

</body>
</html>