<%@page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>钱包管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<!--     Fonts -->
<!--     <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400' rel='stylesheet' type='text/css'> -->
<!--     <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'> -->
<!--     CSS Libs -->
<!--     <link rel="stylesheet" type="text/css" href="/financingProject/hou/lib/css/bootstrap.min.css"> -->
<!--     <link rel="stylesheet" type="text/css" href="/financingProject/hou/lib/css/font-awesome.min.css"> -->
<!--     <link rel="stylesheet" type="text/css" href="/financingProject/hou/lib/css/animate.min.css"> -->
<!--     <link rel="stylesheet" type="text/css" href="/financingProject/hou/lib/css/bootstrap-switch.min.css"> -->
<!--     <link rel="stylesheet" type="text/css" href="/financingProject/hou/lib/css/checkbox3.min.css"> -->
<!--     <link rel="stylesheet" type="text/css" href="/financingProject/hou/lib/css/jquery.dataTables.min.css"> -->
<!--     <link rel="stylesheet" type="text/css" href="/financingProject/hou/lib/css/dataTables.bootstrap.css"> -->
<!--     <link rel="stylesheet" type="text/css" href="/financingProject/hou/lib/css/select2.min.css"> -->
<!--     CSS App -->
<!--     <link rel="stylesheet" type="text/css" href="/financingProject/hou/css/style.css"> -->
<!--     <link rel="stylesheet" type="text/css" href="/financingProject/hou/css/themes/flat-blue.css"> -->
</head>

<body class="flat-blue">
<!--     <div class="app-container"> -->
<!--         <div class="row content-container"> -->
<!--             <nav class="navbar navbar-default navbar-fixed-top navbar-top"> -->
<!--                 <div class="container-fluid"> -->
<!--                     <div class="navbar-header"> -->
<!--                         <button type="button" class="navbar-expand-toggle"> -->
<!--                             <i class="fa fa-bars icon"></i> -->
<!--                         </button> -->
<!--                         <ol class="breadcrumb navbar-breadcrumb"> -->
<!--                             <li class="active">钱包管理</li> -->
<!--                         </ol> -->
<!--                         <button type="button" class="navbar-right-expand-toggle pull-right visible-xs"> -->
<!--                             <i class="fa fa-th icon"></i> -->
<!--                         </button> -->
<!--                     </div> -->
<!--                     <ul class="nav navbar-nav navbar-right"> -->
<!--                         <button type="button" class="navbar-right-expand-toggle pull-right visible-xs"> -->
<!--                             <i class="fa fa-times icon"></i> -->
<!--                         </button> -->
<!--                         <li class="dropdown"> -->
<!--                             <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-comments-o"></i></a> -->
<!--                             <ul class="dropdown-menu animated fadeInDown"> -->
<!--                                 <li class="title"> -->
<!--                                     Notification <span class="badge pull-right">0</span> -->
<!--                                 </li> -->
<!--                                 <li class="message"> -->
<!--                                     No new notification -->
<!--                                 </li> -->
<!--                             </ul> -->
<!--                         </li> -->
<!--                         <li class="dropdown danger"> -->
<!--                             <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-star-half-o"></i> 4</a> -->
<!--                             <ul class="dropdown-menu danger  animated fadeInDown"> -->
<!--                                 <li class="title"> -->
<!--                                     Notification <span class="badge pull-right">4</span> -->
<!--                                 </li> -->
<!--                                 <li> -->
<!--                                     <ul class="list-group notifications"> -->
<!--                                         <a href="#"> -->
<!--                                             <li class="list-group-item"> -->
<!--                                                 <span class="badge">1</span> <i class="fa fa-exclamation-circle icon"></i> new registration -->
<!--                                             </li> -->
<!--                                         </a> -->
<!--                                         <a href="#"> -->
<!--                                             <li class="list-group-item"> -->
<!--                                                 <span class="badge success">1</span> <i class="fa fa-check icon"></i> new orders -->
<!--                                             </li> -->
<!--                                         </a> -->
<!--                                         <a href="#"> -->
<!--                                             <li class="list-group-item"> -->
<!--                                                 <span class="badge danger">2</span> <i class="fa fa-comments icon"></i> customers messages -->
<!--                                             </li> -->
<!--                                         </a> -->
<!--                                         <a href="#"> -->
<!--                                             <li class="list-group-item message"> -->
<!--                                                 view all -->
<!--                                             </li> -->
<!--                                         </a> -->
<!--                                     </ul> -->
<!--                                 </li> -->
<!--                             </ul> -->
<!--                         </li> -->
<!--                         <li class="dropdown profile"> -->
<!--                             <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Emily Hart <span class="caret"></span></a> -->
<!--                             <ul class="dropdown-menu animated fadeInDown"> -->
<!--                                 <li class="profile-img"> -->
<!-- 							      <img src="/financingProject/hou/img/profile/picjumbo.com_HNCK4153_resize.jpg" class="profile-img"> -->
<!--                                 </li> -->
<!--                                 <li> -->
<!--                                     <div class="profile-info"> -->
<!--                                         <h4 class="username">Emily Hart</h4> -->
<!--                                         <p>emily_hart@email.com</p> -->
<!--                                         <div class="btn-group margin-bottom-2x" role="group"> -->
<!--                                             <button type="button" class="btn btn-default"><i class="fa fa-user"></i> Profile</button> -->
<!--                                             <button type="button" class="btn btn-default"><i class="fa fa-sign-out"></i> Logout</button> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </li> -->
<!--                             </ul> -->
<!--                         </li> -->
<!--                     </ul> -->
<!--                 </div> -->
<!--             </nav> -->
<!--             <div class="side-menu sidebar-inverse"> -->
<!--                 <nav class="navbar navbar-default" role="navigation"> -->
<!--                     <div class="side-menu-container"> -->
<!--                         <div class="navbar-header"> -->
<!--                             <a class="navbar-brand" href="#"> -->
<!--                                 <div class="icon fa fa-paper-plane"></div> -->
<!--                                 <div class="title">后台管理模块</div> -->
<!--                             </a> -->
<!--                             <button type="button" class="navbar-expand-toggle pull-right visible-xs"> -->
<!--                                 <i class="fa fa-times icon"></i> -->
<!--                             </button> -->
<!--                         </div> -->
<!--                         <ul class="nav navbar-nav"> -->
<!--                         	 <li> -->
<!--                                 <a href="/financingProject/main"> -->
<!--                                     <span class="icon fa fa-thumbs-o-up"></span><span class="title">欢迎</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             理财产品 -->
<!--                              <li class="panel panel-default dropdown"> -->
<!--                                 <a data-toggle="collapse" href="#component-example"> -->
<!--                                     <span class="icon fa fa-cubes"></span><span class="title">理财产品</span> -->
<!--                                 </a> -->
<!--                                 Dropdown level 1 -->
<!--                                 <div id="component-example" class="panel-collapse collapse"> -->
<!--                                     <div class="panel-body"> -->
<!--                                         <ul class="nav navbar-nav"> -->
<!--                                             <li><a href="/financingProject/fixing">固收类</a> -->
<!--                                             </li> -->
<!--                                             <li><a href="/financingProject/stock">私募股权类</a> -->
<!--                                             </li> -->
<!--                                             <li><a href="/financingProject/overseas">海外配置</a> -->
<!--                                             </li> -->
<!--                                         </ul> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </li> -->
<!--                        		 钱包管理 -->
<!--                             <li class="active"> -->
<!--                                 <a href="/financingProject/wallet"> -->
<!--                                     <span class="icon fa fa-tachometer"></span><span class="title">钱包管理</span> -->
<!--                                 </a> -->
<!--                             </li> -->
					
<!-- 							 会员管理 -->
<!--                             <li class="panel panel-default dropdown"> -->
<!--                                 <a data-toggle="collapse" href="#dropdown-element"> -->
<!--                                     <span class="icon fa fa-desktop"></span><span class="title">会员管理</span> -->
<!--                                 </a> -->
<!--                                 Dropdown level 1 -->
<!--                                 <div id="dropdown-element" class="panel-collapse collapse"> -->
<!--                                     <div class="panel-body"> -->
<!--                                         <ul class="nav navbar-nav"> -->
<!--                                             <li><a href="/financingProject/member">账号管理</a> -->
<!--                                             </li> -->
<!--                                             <li><a href="/financingProject/manage">理财师审核</a> -->
<!--                                             </li> -->
<!--                                             <li><a href="/financingProject/card">绑卡管理</a> -->
<!--                                             </li> -->
<!--                                             <li><a href="/financingProject/interest">付息计划</a> -->
<!--                                             </li> -->
<!--                                             <li><a href="/financingProject/recharge">充值管理</a> -->
<!--                                             </li> -->
<!--                                             <li><a href="/financingProject/reflect">提现管理</a> -->
<!--                                             </li> -->
<!--                                             <li><a href="/financingProject/invitation">邀请奖励</a> -->
<!--                                             </li> -->
<!--                                         </ul> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </li> -->
<!-- 						学员管理 -->
<!--                             <li class="panel panel-default dropdown"> -->
<!--                                 <a data-toggle="collapse" href="#dropdown-table"> -->
<!--                                     <span class="icon fa fa-table"></span><span class="title">学员管理</span> -->
<!--                                 </a> -->
<!--                                 Dropdown level 1 -->
<!--                                 <div id="dropdown-table" class="panel-collapse collapse"> -->
<!--                                     <div class="panel-body"> -->
<!--                                         <ul class="nav navbar-nav"> -->
<!--                                             <li><a href="/financingProject/consultation">资讯分类</a> -->
<!--                                             </li> -->
<!--                                             <li><a href="/financingProject/dataConsultation">咨询管理</a> -->
<!--                                             </li> -->
<!--                                         </ul> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </li> -->
<!--                              盈+统计 -->
<!--                             <li class="panel panel-default dropdown"> -->
<!--                                 <a data-toggle="collapse" href="#dropdown-form"> -->
<!--                                     <span class="icon fa fa-file-text-o"></span><span class="title">盈+统计</span> -->
<!--                                 </a> -->
<!--                                 Dropdown level 1 -->
<!--                                 <div id="dropdown-form" class="panel-collapse collapse"> -->
<!--                                     <div class="panel-body"> -->
<!--                                         <ul class="nav navbar-nav"> -->
<!--                                             <li><a href="/financingProject/finance">财务统计</a> -->
<!--                                             </li> -->
<!--                                             <li><a href="/financingProject/synthesize">用户综合统计</a> -->
<!--                                             </li> -->
<!--                                         </ul> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </li> -->
<!--                                 盈+设置 -->
<!--                             <li class="panel panel-default dropdown"> -->
<!--                                 <a data-toggle="collapse" href="#dropdown-example"> -->
<!--                                     <span class="icon fa fa-slack"></span><span class="title">盈+设置</span> -->
<!--                                 </a> -->
<!--                                 Dropdown level 1 -->
<!--                                 <div id="dropdown-example" class="panel-collapse collapse"> -->
<!--                                     <div class="panel-body"> -->
<!--                                         <ul class="nav navbar-nav"> -->
<!--                                             <li><a href="/financingProject/notice">公告管理</a> -->
<!--                                             </li> -->
<!--                                             <li><a href="/financingProject/opinion">意见反馈</a> -->
<!--                                             </li> -->
<!--                                         </ul> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </li> -->
                           
                            
                        
<!--                             系统设置 -->
<!--                             <li class="panel panel-default dropdown"> -->
<!--                                 <a data-toggle="collapse" href="#dropdown-icon"> -->
<!--                                     <span class="icon fa fa-archive"></span><span class="title">系统设置</span> -->
<!--                                 </a> -->
<!--                                 Dropdown level 1 -->
<!--                                 <div id="dropdown-icon" class="panel-collapse collapse"> -->
<!--                                     <div class="panel-body"> -->
<!--                                         <ul class="nav navbar-nav"> -->
<!--                                             <li><a href="/financingProject/account">账户设置</a></li> -->
<!--                                              <li><a href="/financingProject/role">角色设置</a></li> -->
<!--                                             <li><a href="/financingProject/ps">密码设置</a></li> -->
<!--                                         </ul> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </li> -->
<!--                         </ul> -->
<!--                     </div> -->
<!--                     /.navbar-collapse -->
<!--  <!--           -------------------------------------------sssssss---------------- -->
<!--                 </nav> -->
<!--             </div> -->
<!--             <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >免费网站模板</a></div> -->
<!--             Main Content -->
            
            
<!--             <div class="container-fluid"> -->
<!--                 <div class="side-body"> -->
                   
<!--                     <div class="row"> -->
                    
<!--                    <div class="col-xs-12"> -->
<!--                             <div class="card"> -->
<!--                                 <div class="card-header"> -->
<!--                                     <div class="card-title"> -->
<!--                                     <div class="title">Table</div> -->
<!--                                     </div> -->
<!--                                 </div> -->
                                
                                <form action="/yingJiaProfit/wallet/listAll" method="post">
                                	交易号：<input type="text" name="qtrade_no">
                                	手机号：<input type="text" name="qmobile_Phone">
                                	交易类型：<select name="qtrade_type">
                                		<option value="-1">全部</option>
                                		<option value="MOBILE_RECHARGE">手机充值</option>
                                		<option value="SINOPEC_RECHARGE">石化充值</option>
                                		<option value="FINANCE">购买记录</option>
                                	</select>
                                	交易状态：<select name="qtrade_status">
                                		<option value="-1">全部</option>
                                		<option value="0">等待付款</option>
                                		<option value="2">处理中</option>
                                	</select>
                                	<input type="submit" value="查询">
                                </form>
                                
                                 <div class="card-body">
                                     <table class="datatable table table-striped" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>序号</th>
                                                <th>交易号</th>
                                                <th>交易人手机号</th>
                                                <th>交易类型</th>
                                                <th>交易名称</th>
                                                <th>交易金额</th>
                                                <th>交易状态</th>
                                                <th>交易时间</th>
                                            </tr>
                                        </thead>
                                    
                                    	
                                        <tbody>
                                        <c:forEach items="${memberTradeRecordList }" var="memberTradeRecord" varStatus="stat">
                                            <tr>
                                                <td>${stat.index+1 }</td>
                                                <td>${memberTradeRecord.trade_no }</td>
                                                <td>${memberTradeRecord.member.mobile_Phone }</td>
                                                <td><c:if test="${memberTradeRecord.trade_type=='MOBILE_RECHARGE' }">手机充值</c:if>
                                                	<c:if test="${memberTradeRecord.trade_type=='SINOPEC_RECHARGE' }">石化充值</c:if>
                                                	<c:if test="${memberTradeRecord.trade_type=='FINANCE' }">购买记录</c:if>
                                                </td>
                                                <td>${memberTradeRecord.trade_name }</td>
                                                <td>${memberTradeRecord.amount }</td>
                                                <td><c:if test="${memberTradeRecord.trade_status==0 }">等待付款</c:if>
                                                	<c:if test="${memberTradeRecord.trade_status==2 }">处理中</c:if>
                                                </td>
                                                <td>${memberTradeRecord.create_date }</td>
                                            </tr>
                                             </c:forEach>
                                        </tbody>
                                       
                                    </table>
                                </div>
                                
<!--                                 </div> -->
<!--                         </div>  -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
            
            
<!--             </div> -->
<!--         </div> -->
<!--         <footer class="app-footer"> -->
<!--             <div class="wrapper"> -->
<!--                 <span class="pull-right">2.1 <a href="#"><i class="fa fa-long-arrow-up"></i></a></span> © 2015 Copyright. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a> -->
<!--             </div> -->
<!--         </footer> -->
<!--         <div> -->
<!--             Javascript Libs -->
<!--             <script type="text/javascript" src="/financingProject/hou/lib/js/jquery.min.js"></script> -->
<!--             <script type="text/javascript" src="/financingProject/hou/lib/js/bootstrap.min.js"></script> -->
<!--             <script type="text/javascript" src="/financingProject/hou/lib/js/Chart.min.js"></script> -->
<!--             <script type="text/javascript" src="/financingProject/hou/lib/js/bootstrap-switch.min.js"></script> -->
<!--             <script type="text/javascript" src="/financingProject/hou/lib/js/jquery.matchHeight-min.js"></script> -->
<!--             <script type="text/javascript" src="/financingProject/hou/lib/js/jquery.dataTables.min.js"></script> -->
<!--             <script type="text/javascript" src="/financingProject/hou/lib/js/dataTables.bootstrap.min.js"></script> -->
<!--             <script type="text/javascript" src="/financingProject/hou/lib/js/select2.full.min.js"></script> -->
<!--             <script type="text/javascript" src="/financingProject/hou/lib/js/ace/ace.js"></script> -->
<!--             <script type="text/javascript" src="/financingProject/hou/lib/js/ace/mode-html.js"></script> -->
<!--             <script type="text/javascript" src="/financingProject/hou/lib/js/ace/theme-github.js"></script> -->
<!--             Javascript -->
<!--             <script type="text/javascript" src="/financingProject/hou/js/app.js"></script> -->
</body>

</html>
