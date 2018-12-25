<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" name="viewport" content="width=1440px" >
<title>易支教云平台</title>
<link href="css/index.css" rel="stylesheet">
<link href="css/release.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/index.js"></script>
</head>
<body>
	<!-- Nav -->
	<div class="index-head">
		<div class="index-nav">
			<p id="index_login">登 录</p>
			<p id="index_register">注 册</p>
		</div>
		<div class="index-info">
			<img src="images/title.png" class="info-title">
			<div class="info-content">
				通过微信小程序的形式来完成，能够为了支教志愿者提供一个实现自己公益愿望的平台。为了打破信息壁垒，打通支教和支教志愿的渠道，为山区儿童无偿提供老师。
			</div>
			<img src="images/search.png" class="info-search">
			<img src="images/iphone.png" class="info-iphone">
			<img class="wechat_icon" src="images/wechat.png" alt="">
		</div>
	</div>
	<!-- Main -->
	<div class="index-main">
		<p class="index-main-title1">组织招募服务</p>
		<p class="index-main-title2">具体的服务内容做补充说明</p>
		<div class="index-serve">
			<div class="serve-item">
				<img src="images/icon.png">
				<p>海量志愿者</p>
				<div>以信息网络技术为手段，以商品交换为中心的商务活动；也可理解为在互联网、企业内部网和增值网上以电子交易方式进行交易。</div>
			</div>
			<div class="serve-item" style="margin: 0px 70px;">
				<img src="images/icon.png">
				<p>信息实时发布</p>
				<div>以信息网络技术为手段，以商品交换为中心的商务活动；也可理解为在互联网、企业内部网和增值网上以电子交易方式进行交易。</div>
			</div>
			<div class="serve-item">
				<img src="images/icon.png">
				<p>实时便捷管理</p>
				<div>以信息网络技术为手段，以商品交换为中心的商务活动；也可理解为在互联网、企业内部网和增值网上以电子交易方式进行交易。</div>
			</div>
		</div>
		<div class="index-btn">
		<div class="buttons" >
			<div class="btn btn1" id="index_register2"><span class="circle"></span><span class="text">注册加入</span></div>
		</div>
		</div>
		<p class="index-main-title3">我 们 与 你 共 成 长</p>
		<div class="index-up">
			<img src="images/1.jpg">
			<img src="images/2.jpg">
			<img src="images/3.jpg">
			<img src="images/4.jpg">
		</div>
		<div class="index-area">
			<p>我们一起与众多公益组织为您一同提供优质支教信息发布平台</p>
			<div class="index-block">
				<img src="images/1.png">
				<img src="images/2.png">
				<img src="images/1.png">
				<img src="images/2.png">
				<img src="images/1.png">
				<img src="images/2.png">
				<img src="images/1.png">
			</div>
			<div class="index-block" style="margin-top: 80px;">
				<img src="images/2.png">
				<img src="images/1.png">
				<img src="images/2.png">
				<img src="images/1.png">
			</div>
		</div>
	</div>
	<!-- Link -->
	<div class="link" style="margin-top: 0px;">
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
	<!-- Login -->
	<div class="overlay" id="overlay_l">
		<div class="login">
			<div class="login-head">用户登录
				<div class="login-back">
					×
				</div>
			</div>
			<form class="login-form" action="Or_LoginServlet" method="post">
				<input type="text" name="username" placeholder="请输入用户名">
				<input type="password"  name="password" placeholder="请输入密码">
				<input type="submit" name="" class="login-btn" value="登 录">
			</form>
		</div>
	</div>
	<!-- Register -->
	<div class="overlay" id="overlay_r">
		<div class="register">
			<div class="register-head">用户注册
				<div class="register-back">
					×
				</div>
			</div>
			<form class="register-form" action="Or_RegisterServlet" method="post" onsubmit="return checkForm();">
				<input type="text" name="username" placeholder="用户名">
				<input type="text" name="password" placeholder="密码">
				<input type="text" name="pwdag" placeholder="确认密码">
				<input type="text" name="code" placeholder="验证码">
				<input type="submit" name="" class="login-btn" value="注 册">
				<div class="code" id="test"></div>
			</form>
		</div>
	</div>
		<input type="hidden" id="message" value="${message}">
</body>
</html>
<script>
		       
		       var error=$("#message").attr("value");
		       if(error!=null && error!=""){
		    	   alert(error);
		       };
		       $(document).ready(function(){
		       $(".info-iphone").hover(function(){
		    		$(".wechat_icon").fadeIn(500);
		    	},function(){
		    		$(".wechat_icon").fadeOut(0);
		    	});
		       });
</script>
