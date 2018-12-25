<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>

<!-- Nav -->
	<div class="head">
		<div style="font-size: 20px;color: #fff;margin-left: 30px;font-weight: 600;line-height: 60px;float: left;">易支教云平台</div>
		<ul class="nav">
			<li><a href="Or_index.jsp">首页</a></li>
			<li><a href="Or_business.jsp">企业中心</a></li>
			<li><a href="Or_manage.jsp">招聘管理</a></li>
		</ul>
		<div class="login-user">
				<div ><a href="ExitServlet">退出</a></div>
		</div>
	</div>
	<!-- Main -->
	<div style="width: 980px;margin: 70px auto 20px;overflow: hidden;">
		<div class="main-r">
			<div class="main-info">
				<p style="text-align: center;font-weight: 700;font-size: 20px;margin-bottom: 20px;">组织资料填写</p>
				<form class="info" action="Or_AddOrganizationServlet" method="post" enctype="multipart/form-data">
					<p class="info-title">组织信息</p>
					<div class="info-area">
						<p>组织名称</p>
						<input type="text" name="or_name">
					</div>
					<div class="info-area">
						<p>组织地址</p>
						<input type="text" name="or_place">
					</div>
					<div class="info-area">
						<p>成立时间</p>
						<input type="text" id="datepicker"  name="fonudingtime" placeholder="选择时间">
					</div>
					<div class="info-area">
						<p>组织简介</p>
						<textarea type="text" name="information"></textarea>
					</div>
					<p class="info-title">联系方式</p>
					<div class="info-area">
						<p>咨询电话</p>
						<input type="text" name="seatnumber">
					</div>
					<div class="info-area">
						<p>邮箱</p>
						<input type="text" name="or_email">
					</div>
					<div class="info-area">
						<p>官网</p>
						<input type="text" name="or_officialwebsite">
					</div>
					<div class="info-area">
						<p>微信公众号</p>
						<input type="text" name="or_wicharnumber">
					</div>
					<div class="info-area">
						<p>官方微博</p>
						<input type="text" name="or_blognumber">
					</div>
					<p class="info-title">企业Logo</p>
					<div class="info-file">
						<p>上传图片</p>
						<input type="file" id="chooseImage" name="file">
					</div>
					<input type="submit" name="" value="提交" class="info-button">
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
