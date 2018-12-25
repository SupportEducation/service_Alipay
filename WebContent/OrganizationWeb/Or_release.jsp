<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易支教云平台</title>
<link href="css/index.css" rel="stylesheet">
<link href="css/release.css" rel="stylesheet">
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
			<li><a href="Or_index.jsp" >首页</a></li>
			<li><a href="Or_business.jsp">组织中心</a></li>
			<li><a href="Or_manage.jsp" style="color: #fff;">招募管理</a></li>
		</ul>
		<div class="login-user"><%=session.getAttribute("oname") %>
				<div ><a href="ExitServlet">退出</a></div>
		</div>
	</div>
	<!-- Main -->
	<form class="main"  enctype="multipart/form-data"  action="Or_addRecruit" method="post">
		<p class="main-title">基本信息</p>
		<div class="main-item">
			<p>活动信息标题</p>
			<input type="text" name="re_title" style="width: 542px;">
		</div>
		<div class="main-item">
			<p>报名截止时间</p>
			<input type="text" id="datepicker0" name="re_deadline" placeholder="选择时间">
		</div>
		<div class="main-item">
			<p>支教开始时间</p>
			<input type="text" id="datepicker1" name="re_start" placeholder="选择时间">  
			<p>支教结束时间</p>
			<input type="text" id="datepicker2" name="re_end" placeholder="选择时间">  
		</div>
		<div class="main-item">
			<p>支教活动地点</p>
			<input type="text" name="re_serviceplace" style="width: 542px;">
		</div>
		<div class="main-item">
			<p>支教活动类型</p>
			<select name="re_type">
				<option value="长期支教">长期支教</option>
				<option value="短期支教">短期支教</option>
				<option value="其他支教">其他支教</option>
			</select>
			<p>支教需要人数</p>
			<input type="text" name="re_peoplenumber">
		</div>
		<p class="main-title">详细信息</p>
		<div class="main-item">
			<p>工作内容</p>
			<textarea placeholder="文案提示用户输入用例" name="re_jobcontent"></textarea>
		</div>
		<div class="main-item">
			<p>待遇收获</p>
			<textarea placeholder="文案提示用户输入用例" name="re_treatment"></textarea>
		</div>
		<div class="main-item">
			<p>报名条件</p>
			<textarea placeholder="文案提示用户输入用例" name="re_condition"></textarea>
		</div>
		<p class="main-title">宣传图片</p>
		<div class="main-file">
			<p>上传图片</p>
			<input type="file" id="chooseImage" name="file">
		</div>
		<input type="submit" name="" value="提交" class="main-button">
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
			<p>©2015-2018 易支教云平台 京ICP备15058772号 京公网安备11010802022669号 联系电话：010-12345678</p>
		</div>
	</div>
	<input type="hidden" id="message" value="${message}">
<script type="text/javascript">
	var picker0 = new Pikaday(
    {
        field: document.getElementById('datepicker0'),
        firstDay: 1,
        minDate: new Date('2010-01-01'),
        maxDate: new Date('2020-12-31'),
        yearRange: [2000,2020]
    });
    var picker1 = new Pikaday(
    {
        field: document.getElementById('datepicker1'),
        firstDay: 1,
        minDate: new Date('2010-01-01'),
        maxDate: new Date('2020-12-31'),
        yearRange: [2000,2020]
    });
    var picker2 = new Pikaday(
    {
        field: document.getElementById('datepicker2'),
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