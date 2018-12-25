<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="com.server.dao.*" 
	import="java.util.List"
	import="com.server.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易支教云平台</title>
<link href="css/index.css" rel="stylesheet">
<link href="css/release.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/pikaday.css" />
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/index.js"></script>
<script src="js/pikaday.min.js"></script>
<style type="text/css">
input,textarea {
	border: none !important;
}
</style>
</head>
<body>
	<!-- Nav -->
	<div class="head">
		<div
			style="font-size: 20px; color: #fff; margin-left: 30px; font-weight: 600; line-height: 60px; float: left;">易支教云平台</div>
		<ul class="nav">
			<li><a href="Or_index.jsp">首页</a></li>
			<li><a href="Or_business.jsp">组织中心</a></li>
			<li><a href="Or_manage.jsp" style="color: #fff;">招募管理</a></li>
		</ul>
		<div class="login-user">
			<%=session.getAttribute("oname") %>
			<div ><a href="ExitServlet">退出</a></div>
		</div>
	</div>

	<%
		String rid = new String(request.getParameter("rid").getBytes(
				"ISO-8859-1"), "UTF-8");
		recruit re = new recruitDao().getOneRecruit(Integer.parseInt(rid));
	%>
	<!-- Main -->
	<form class="main">
		<p class="main-title">基本信息</p>
		<div class="main-item">
			<p>活动信息标题</p>
			<input type="text" name="" style="width: 542px;" readonly="readonly"
				value="<%=re.getRe_title()%>">
		</div>
		<div class="main-item">
			<p>报名截止时间</p>
			<input type="text" id="datepicker0" name="" placeholder="选择时间"
				readonly="readonly" value="<%=re.getRe_deadline()%>">
		</div>
		<div class="main-item">
			<p>支教活动时间</p>
			<input type="text" id="datepicker1" name="" placeholder="选择时间"
				readonly="readonly" value="<%=re.getRe_servicetime()%>">

		</div>
		<div class="main-item">
			<p>支教活动地点</p>
			<input type="text" name="" style="width: 542px;" readonly="readonly"
				value="<%=re.getRe_serviceplace()%>">
		</div>
		<div class="main-item">
			<p>支教活动类型</p>
			<input type="text" name="" style="width: 542px;" readonly="readonly"
				value="<%=re.getRe_type()%>">
		</div>
		<div class="main-item">
			<p>支教活动人数</p>
			<input type="text" name="" style="width: 542px;" readonly="readonly"
				value="<%=re.getRe_peopleenumber()%>">
		</div>
		<p class="main-title">详细信息</p>
		<div class="main-item">
			<p>工作内容</p>
			<textarea placeholder="文案提示用户输入用例" readonly="readonly"><%=re.getRe_jobcontent()%></textarea>
		</div>
		<div class="main-item">
			<p>待遇收获</p>
			<textarea placeholder="文案提示用户输入用例" readonly="readonly"><%=re.getRe_treatment()%></textarea>
		</div>
		<div class="main-item">
			<p>报名条件</p>
			<textarea placeholder="文案提示用户输入用例" readonly="readonly"><%=re.getRe_condition()%></textarea>
		</div>
		<p class="main-title">宣传图片</p>
		<div>
			<img style="background: #ccc; width: 500px; height: 300px; margin: 20px 0px 0px 15px;" alt="暂无图片" src="http://localhost:8080/TeacherSupport/upload/<%=re.getRe_img()%>">
		</div>
	</form>
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
			<p>©2015-2018 易支教云平台 京ICP备15058772号 京公网安备11010802022669号
				联系电话：010-12345678</p>
		</div>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>