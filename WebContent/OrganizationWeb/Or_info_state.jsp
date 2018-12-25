<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易支教云平台</title>
<link href="css/index.css" rel="stylesheet">
<link href="css/manage.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/index.js"></script>
</head>
<body>
<!-- Nav -->
	<div class="head">
		<div style="font-size: 20px;color: #fff;margin-left: 30px;font-weight: 600;line-height: 60px;float: left;">易支教云平台</div>
		<ul class="nav">
			<li><a href="Or_index.jsp" >首页</a></li>
			<li><a href="Or_business.jsp">企业中心</a></li>
			<li><a href="Or_manage.jsp" style="color: #fff;">招聘管理</a></li>
		</ul>
		<div class="login-user"><%=session.getAttribute("oname") %>
				<div ><a href="ExitServlet">退出</a></div>
		</div>
	</div>
	<!-- Main -->
	<div style="margin:80px 0px 20px;text-align: center;height: 600px;line-height: 600px;font-size: 24px;font-weight: 700;color: #777;">
		组织信息审核中...
	</div>
	<!-- Link -->
	<div class="link">
		<div class="link-main">
			<ul class="link-nav">
				<li><a href="##">关于我们</a></li>
				<li><a href="##">合作企业</a></li>
				<li><a href="##">联系我们</a></li>
				<li><a href="##">广告服务</a></li>
				<li><a href="##">帮助中心</a></li>
			</ul>
			<p>本站由 阿里云 提供服务和安全支持</p>
			<p>©2015-2018 易支教云平台 京ICP备15058772号 京公网安备11010802022669号 联系电话：010-12345678</p>
		</div>
	</div>
</body>
</html>
