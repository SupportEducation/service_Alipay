<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="com.server.dao.*"
    import="java.util.List"
    import="com.server.entity.*"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>表单</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">

		<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
	</head>

	<body>
		<div style="margin: 15px;">
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>新闻编辑</legend>
			</fieldset>
				<form method="post"  action="AddNewsServlet" enctype="multipart/form-data">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">新闻标题</label>
						<div class="layui-input-inline">
							<input type="text" name="news_title"  autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">发布日期</label>
						<div class="layui-input-block">
							<input type="text" name="news_time"  id="date" lay-verify="date" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})">
						</div>
					</div>
				</div>

				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">新闻内容</label>
					<div class="layui-input-block">
						<textarea style="height: 300px" name="news_content" placeholder="请输入内容" class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">图片</label>
					<div class="layui-input-block">
						<input type="file" id="chooseImage" name="file">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
			<input type="hidden" id="message" value="${message}">
		</div>
		<script type="text/javascript" src="plugins/layui/layui.js"></script>
		<script>
			layui.use(['form', 'layedit', 'laydate'], function() {
				var form = layui.form(),
					layer = layui.layer,
					layedit = layui.layedit,
					laydate = layui.laydate;
			});
			
			layui.use('layer',function(){
			    var layer=layui.layer,$=layui.jquery;
			    
			    var error=$("#message").attr("value");
			    if(error!=null && error!=""){
			 	   layer.msg(error);
			    }
			});
		</script>
	</body>
</html>