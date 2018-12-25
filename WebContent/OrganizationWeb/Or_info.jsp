<%@page import="com.server.dao.OrganizationDao"%>
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
<link href="css/manage.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/pikaday.css"/>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/index.js"></script>
<script src="js/pikaday.min.js"></script>
<script type="text/javascript">
function init(){ 
	
		//判断是否申请
	  <%
	  int oidd=new OrganizationDao().getOneOidBYname(session.getAttribute("oname").toString());
	  if(oidd==0){
		  %>
	      window.location.href="Or_login_register.jsp";
	      <%}%>
	      
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
      <%}%>
	  //判断是否登录
	      <%
      if(session.getAttribute("oid")==""){
      %>
      window.location.href="Or_login_state.jsp";
      <%}%>
      
	}
</script>
</head>
<body onload="init()">
		<%
			int oid=Integer.parseInt(session.getAttribute("oid").toString());
			organization or=new OrganizationDao().getOneOrganization(String.valueOf(oid));
			
		%>
<!-- Nav -->
	<div class="head">
		<div style="font-size: 20px;color: #fff;margin-left: 30px;font-weight: 600;line-height: 60px;float: left;">易支教云平台</div>
		<ul class="nav">
			<li><a href="Or_index.jsp" >首页</a></li>
			<li><a href="Or_business.jsp">组织中心</a></li>
			<li><a href="Or_manage.jsp" style="color: #fff;">招募管理</a></li>
		</ul>
		<div class="login-user"><%=session.getAttribute("oname") %>
				<div ><a href="ExitServlet">退出</a></div>
		</div>
	</div>
	<!-- Main -->
	<div class="main">
		<div class="navbar">
			<a href="release.html" class="release">发布活动</a>
			<div class="menu">
				<a href="##" class="menu-item1"><img src="images/job.png">项目管理</a>
				<a href="Or_jobsh.jsp" class="menu-item2">待审核</a>
				<a href="Or_jobjx.jsp" class="menu-item2">进行中</a>
				<a href="Or_jobjs.jsp" class="menu-item2">已结束</a>
				<a href="Or_jobth.jsp" class="menu-item2">审核退回</a>
				<a href="##" class="menu-item1"><img src="images/user.png">报名管理</a>
				<a href="Or_joinsh.jsp" class="menu-item2">待审核</a>
				<a href="Or_jointg.jsp" class="menu-item2">审核通过</a>
				<a href="Or_jointh.jsp" class="menu-item2">审核退回</a>
				<a href="##" class="menu-item1"  style="color: #69e;"><img src="images/info.png">组织信息</a>
				<a href="Or_info.jsp" class="menu-item2">组织资料</a>
			</div>
		</div>
		<div class="main-r">
			<div class="main-search">
				<p></p>
				<form class="search">
					<input type="text" placeholder="请输入名称或者ID">
					<input type="submit" value="搜索">
				</form>
			</div>
			<div class="main-info">
				<form class="info"  action="Or_updateOrganization" enctype="multipart/form-data" method="post">
					<p class="info-title"></p>
					<div class="info-area" ">
						<p>组织名称</p>
						<input type="text" name="or_name" value="<%=or.getOr_name()%>">
					</div>
					<div class="info-area">
						<p>组织地址</p>
						<input type="text" name="or_place" value="<%=or.getOr_place()%>">
					</div>
					<div class="info-area">
						<p>成立时间</p>
						<input type="text" id="datepicker"  name="fonudingtime" placeholder="选择时间"  value="<%=or.getFonudingtime()%>">
					</div>
					<div class="info-area">
						<p>组织简介</p>
						<textarea type="text" name="information"  ><%=or.getInformation()%></textarea>
					</div>
					
					<div class="info-area">
						<p>咨询电话</p>
						<input type="text" name="seatnumber"  value="<%=or.getSeatnumber()%>">
					</div>
					<div class="info-area">
						<p>邮箱</p>
						<input type="text" name="or_email"  value="<%=or.getOr_email()%>">
					</div>
					<div class="info-area">
						<p>官网</p>
						<input type="text" name="or_officialwebsite"  value="<%=or.getOr_officialwebsite()%>">
					</div>
					<div class="info-area">
						<p>微信公众号</p>
						<input type="text" name="or_wecharnmuber"  value="<%=or.getOr_wecharnumber()%>">
					</div>
					<div class="info-area">
						<p>官方微博</p>
						<input type="text" name="or_blognumber"  value="<%=or.getOr_blognumber()%>">
					</div>
					
					<div class="info-file">
						<p>上传图片</p>
						<input type="file" id="chooseImage" name="file">
					</div>
					<input type="submit" name="" value="修改" class="info-button">
				</form>
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
	<input type="hidden" id="message" value="${message}">
<script type="text/javascript">
	var picker = new Pikaday(
	    {
	        field: document.getElementById('datepicker'),
	        firstDay: 1,
	        minDate: new Date('2010-01-01'),
	        maxDate: new Date('2020-12-31'),
	        yearRange: [2000,2020]
	    });
	 var error=$("#message").attr("value");
	    if(error!=null && error!=""){
	 	   alert(error);
	    }
</script> 
</body>
</html>