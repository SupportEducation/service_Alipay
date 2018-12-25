<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>登录</title>
		<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="css/login.css" />
	</head>

	<body class="beg-login-bg">
		<div class="beg-login-box">
			<header>
				<h1>后台登录</h1>
			</header>
			<div class="beg-login-main">
				<form action="LoginServlet" class="layui-form" method="post">
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe612;</i>
                    </label>
						<input type="text" id="username" name="userName" lay-verify="userName" autocomplete="off" placeholder="这里输入登录名" class="layui-input">
					</div>
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe642;</i>
                    </label>
						<input type="password" id="password" name="password" lay-verify="password" autocomplete="off" placeholder="这里输入密码" class="layui-input">
					</div>
					<div class="layui-form-item">
						<div class="beg-pull-left beg-login-remember">
							<label>记住帐号？</label>
							<input type="checkbox" name="rememberMe" value="true" lay-skin="switch" checked title="记住帐号">
						</div>
						<div class="beg-pull-right">
							<button class="layui-btn layui-btn-primary" lay-submit lay-filter="login" onclick="checkuser()">
                            <i class="layui-icon">&#xe650;</i> 登录
                        </button>
						</div>
						<div class="beg-clear"></div>
					</div>
				</form>
			</div>
			<footer>
				<p>Beginner © www.zhengjinfan.cn</p>
			</footer>
		</div>
		
		<input type="hidden" id="message" value="${message}">
		<script type="text/javascript" src="plugins/layui/layui.js"></script>
		<script>
		 layui.use('layer',function(){
		       var layer=layui.layer,$=layui.jquery;
		       
		       var error=$("#message").attr("value");
		       if(error!=null && error!=""){
		    	   layer.msg(error);
		       }
		       
		       var username=$("#username").val();
			   var password=$("#password").val();
			   
				 function checkuser(){
					  if(username==null&&username=="")
					     layer.msg("用户名不能为空！");
					  if(password==null&&password=="")
					     layer.msg("密码不能为空！");
			      }
		  });
		</script>
	</body>

</html>