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
<link href="css/business.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/index.js"></script>
<script type="text/javascript">
function init(){ 
	
		//判断是否申请
	  <%
	 String name=new OrganizationDao().getOneOrganizationByname(session.getAttribute("oname").toString());
	  
	  if(name.equals("1")){
		  %>
	      window.location.href="Or_info_register.jsp";
	      <%}else{%>
	      
	  //判断是否申请通过    
	 <%
	 	int oflat=new OrganizationDao().getOrState(session.getAttribute("oid").toString());
	  if(oflat==0){
	 %>
      window.location.href="Or_info_state.jsp";
      <%}
      if(oflat==2){
   	  %>
      window.location.href="Or_info_refuse.jsp";
      <%}}%>
	  //判断是否登录
	      <%
      if(session.getAttribute("oid")==""){
      %>
      window.location.href="Or_login_state.jsp";
      <%}%>
      
	}
</script>
</head>
		<%
			String oid=session.getAttribute("oid").toString();
			organization or=new OrganizationDao().getOneOrganization(oid);	
		%>
<body onload="init()">
<!-- Nav -->
	<div class="head">
		<div style="font-size: 20px;color: #fff;margin-left: 30px;font-weight: 600;line-height: 60px;float: left;">易支教云平台</div>
		<ul class="nav">
			<li><a href="Or_index.jsp">首页</a></li>
			<li><a href="Or_business.jsp" style="color: #fff;">组织中心</a></li>
			<li><a href="Or_manage.jsp">招募管理</a></li>
		</ul>
		<div class="login-user"><%=session.getAttribute("oname") %>
			<div ><a href="ExitServlet">退出</a></div>
		</div>
	</div>
	<!-- Banner -->
	<div class="banner">
	</div>
	<!-- Main -->
	<div class="main">
		<div class="main-left">
			<div class="main-left-info">
				<div class="main-title">招聘概览</div>
				<div class="info">
					<div class="info-area">
						<p>招募活动待审核</p>
						<div class="info-area-num">
							<b><%=new recruitDao().getFlat0Num() %></b>个
						</div>
						<div class="info-area-link">
							<a href="Or_jobsh.jsp">进入活动管理></a>
						</div>
					</div>
					<div class="info-area">
						<p>招募活动进行中</p>
						<div class="info-area-num">
							<b><%=new recruitDao().getFlat1Num() %></b>个
						</div>
						<div class="info-area-link">
							<a href="Or_jobjx.jsp">进入活动管理></a>
						</div>
					</div>
					<div class="info-area">
						<p>志愿者待审核</p>
						<div class="info-area-num">
							<b><%=new vorecruitDao().getFlat0Num() %></b>个
						</div>
						<div class="info-area-link">
							<a href="Or_joinsh.jsp">进入志愿者管理></a>
						</div>
					</div>
					<div class="info-area">
						<p>志愿者已通过</p>
						<div class="info-area-num">
							<b><%=new vorecruitDao().getFlat1Num() %></b>个
						</div>
						<div class="info-area-link">
							<a href="Or_jointg.jsp">进入志愿者管理></a>
						</div>
					</div>
				</div>
			</div>
			<div class="main-left-new">
				<div class="main-title">最新发布活动</div>
				<div class="new-hr"></div>
				<%
						List<recruit> list2=new recruitDao().getAllRecruit();
						if(list2.isEmpty()){
				%>
				<a href="Or_release.jsp" class="new-button" style="color: #fff;">暂无职位，点击发布</a>
				<%}else{%>
				<div class="main-job">
						<%
							for(recruit re:list2){ 
						%>
				
						<a href="Or_release_info.jsp?rid=<%=re.getRid()%>"><%=re.getRe_title() %>
						<span>
						<%if(re.getRe_flat()==0){ %>	
						状态：待审核<%}else{ %>状态：进行中<%}%></span></a>
						<%} }%>
				</div>
			</div>
		</div>
		<div class="main-right">
			<div class="main-title">组织信息</div>
			<div class="business">
				<div >
				<img style="width: 80px;height: 80px;background: #ccc;margin: 0 auto;" alt="" src="http://localhost:8080/TeacherSupport/upload/<%=or.getOr_logo()%>">
				</div>
				<p><%=or.getOr_name() %></p>
				<a href="Or_manage.jsp">招募管理</a>
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