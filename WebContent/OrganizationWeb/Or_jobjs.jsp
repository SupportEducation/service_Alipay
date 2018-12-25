<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.text.DateFormat"
	import="java.text.SimpleDateFormat" import="java.util.Date"
	import="com.server.dao.*" import="java.util.List"
	import="com.server.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易支教云平台</title>
<link href="css/index.css" rel="stylesheet">
<link href="css/manage.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/index.js"></script>
<script type="text/javascript">
window.onload=function(){
    init();
}

function init(){ 
	  <%
      if(session.getAttribute("oid")==""){
      %>
      window.location.href="Or_login_state.jsp";
      <%}%>
	}
</script>
</head>
<body onload="init()">
	<!-- Nav -->
	<div class="head">
		<div
			style="font-size: 20px; color: #fff; margin-left: 30px; font-weight: 600; line-height: 60px; float: left;">LOGO预留位</div>
		<ul class="nav">
			<li><a href="Or_index.jsp">首页</a></li>
			<li><a href="Or_business.jsp">企业中心</a></li>
			<li><a href="Or_manage.jsp" style="color: #fff;">招聘管理</a></li>
		</ul>
		<div class="login-user">
			<%=session.getAttribute("oname") %>
				<div ><a href="ExitServlet">退出</a></div>
		</div>
	</div>
	<!-- Main -->
	<div class="main">
		<div class="navbar">
			<a href="Or_release.jsp" class="release">发布活动</a>
			<div class="menu">
				<a href="##" class="menu-item1"><img src="images/job.png">项目管理</a>
				<a href="Or_jobsh.jsp" class="menu-item2">待审核</a> <a
					href="Or_jobjx.jsp" class="menu-item2">进行中</a> <a
					href="Or_jobjs.jsp" class="menu-item2" style="color: #69e;">已结束</a>
				<a href="Or_jobth.jsp" class="menu-item2">审核退回</a> <a href="##"
					class="menu-item1"><img src="images/user.png">报名管理</a> <a
					href="Or_joinsh.jsp" class="menu-item2">待审核</a> <a
					href="Or_jointg.jsp" class="menu-item2">审核通过</a> <a
					href="Or_jointh.jsp" class="menu-item2">审核退回</a> <a href="##"
					class="menu-item1"><img src="images/info.png">组织信息</a> <a
					href="Or_info.jsp" class="menu-item2">组织资料</a>
			</div>
		</div>
		<div class="main-r">
			<div class="main-search">
				<p>全部职位</p>
				<form class="search">
					<input type="text" placeholder="请输入职位名称或者ID"> <input
						type="submit" value="搜索">
				</form>
			</div>
			<div class="main-job">
				<table class="main-table">
					<tr>
						<th>ID</th>
						<th>活动标题</th>
						<th>活动时间</th>
						<th>报名截止时间</th>
						<th>活动地点</th>
						<th>状态</th>
					</tr>
					<%
						List<recruit> list2 = new recruitDao().getOneOrRecruit(Integer.parseInt(session.getAttribute("oid").toString()));
						for (recruit re : list2) {
							//比较时间
							int flat = 0;
							Date d = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
							try {
								Date dt1 = df.parse(sdf.format(d).toString());
								Date dt2 = df.parse(re.getRe_deadline());
								if (dt1.getTime() > dt2.getTime()) {
									flat = 1;
								} else if (dt1.getTime() < dt2.getTime()) {
									flat = -1;
								} else {
									flat = 0;
								}
							} catch (Exception exception) {
								exception.printStackTrace();
							}
							if (flat ==1) {
					%>
					<tr>
						<td><%=re.getRid()%></td>
						<td><a class="table-title"
							href="Or_release_info.jsp?rid=<%=re.getRid()%>"><%=re.getRe_title()%></a></td>
						<td><%=re.getRe_servicetime()%></td>
						<td><%=re.getRe_deadline()%></td>
						<td><div class="table-place"><%=re.getRe_serviceplace()%></div></td>
						<td>已结束</td>
					</tr>
					<%
						}
						}
					%>
				</table>
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
			<p>©2015-2018 易支教云平台 京ICP备15058772号 京公网安备11010802022669号
				联系电话：010-12345678</p>
		</div>
	</div>
</body>
</html>