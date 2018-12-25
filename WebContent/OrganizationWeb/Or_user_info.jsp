<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.server.dao.*" 
	import="java.util.List"
	import="com.server.entity.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易支教云平台</title>
<link href="css/index.css" rel="stylesheet">
<link href="css/userinfo.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/index.js"></script>
</head>
<body>
<!-- Nav -->
	<div class="head">
		<div style="font-size: 20px;color: #fff;margin-left: 30px;font-weight: 600;line-height: 60px;float: left;">LOGO预留位</div>
		<ul class="nav">
			<li><a href="Or_index.jsp" >首页</a></li>
			<li><a href="Or_business.jsp">企业中心</a></li>
			<li><a href="Or_manage.jsp" style="color: #fff;">招聘管理</a></li>
		</ul>
		<div class="login-user"><%=session.getAttribute("oname") %>
			<div ><a href="ExitServlet">退出</a></div>
		</div>
	</div>
	<%
		String  aid = new String(request.getParameter("aid").getBytes(
				"ISO-8859-1"), "UTF-8");
		user us=new userDao().getOneUser(Integer.parseInt(aid));
	%>
	
	<!-- Main -->
	<div class="main">
		<p class="main-title">基本信息</p>
		<div class="main-item">
			<div class="main-item-info">姓名
				<span><%=us.getName() %></span>
			</div>
			<div class="main-item-info">性别
				<span><%=Integer.parseInt(us.getSex())==0?"男":"女"%></span>
			</div>
		</div>
		<div class="main-item">
			<div class="main-item-info">民族
				<span><%=Integer.parseInt(us.getNation())==0?"汉":"其他"%></span>
			</div>
			<div class="main-item-info">出生年月
				<span><%=us.getBorndate() %></span>
			</div>
		</div>
		<div class="main-item">
			<div class="main-item-info">现居住地
				<span><%=us.getHomeaddress() %></span>
			</div>
			<div class="main-item-info">手机号
				<span><%=us.getPhonenumber() %></span>
			</div>
		</div>
		<div class="main-item">
			<div class="main-item-info">身份证号码
				<span><%=us.getIdnumber() %></span>
			</div>
			<div class="main-item-info">邮箱号
				<span><%=us.getEmail() %></span>
			</div>
		</div>
		<div class="main-item">
			<div class="main-img">
			<img alt="生活照片" src="../upload/<%= us.getLifephoto()%>">
			</div>
		</div>
		<p class="main-title">联系方式</p>
		<div class="main-item">
			<div class="main-item-info">工作地址
				<span><%=us.getWorkaddress()%></span>
			</div>
			<div class="main-item-info">家庭住址
				<span><%=us.getHomeaddress() %></span>
			</div>
		</div>
		<div class="main-item">
			<div class="main-item-info">紧急联系人
				<span><%=us.getEmergancyrelationship() %></span>
			</div>
			<div class="main-item-info">紧急联系人电话
				<span><%=us.getEmergancycontact() %></span>
			</div>
		</div>
		<%
			teaexprience teae=new teaexprienceDao().getOneteae(Integer.parseInt(aid));
		%>
		<p class="main-title">工作经历</p>
		<div class="main-item">
			<div class="main-item-info">组织名
				<span><%=teae.getOrganizationname() %></span>
			</div>
			<div class="main-item-info">活动名称
				<span><%=teae.getActivityname() %></span>
			</div>
		</div>
		<div class="main-item">
			<div class="main-item-info">教育地点
				<span><%=teae.getTeaplace() %></span>
			</div>
		</div>
		<div class="main-item">
			<div class="main-item-text">
				<p>职位描述</p>
				<span><%=teae.getTeadescribe() %>
				</span>
			</div>
		</div>
		<%
			eduexp edu=new EduExpDao().getOneEduExp(Integer.parseInt(aid));
		%>
		<p class="main-title">教育经历</p>
		<div class="main-item">
			<div class="main-item-info">学校
				<span><%=edu.getSchoolname() %></span>
			</div>
			<div class="main-item-info">学历
				<span><%=edu.getDegree() %></span>
			</div>
		</div>
		<div class="main-item">
			<div class="main-item-info">专业
				<span><%=edu.getMajor() %></span>
			</div>
		</div>
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