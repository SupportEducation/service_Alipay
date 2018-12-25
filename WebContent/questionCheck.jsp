<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="com.server.dao.*"
    import="java.util.List"
    import="com.server.entity.*"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>问题反馈</title>
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
				<legend>问题反馈</legend>
			</fieldset>
			<% 
				String q_id=request.getParameter("q_id");
			  	question qu=new questionDao().getOneQuestion(Integer.parseInt(q_id));
			  	
			
			%>
			
				<form method="post" enctype="multipart/form-data" action="NewsManageServlet">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">标题</label>
						<div class="layui-input-inline">
							<input type="text" name="news_title" readonly="readonly" value="<%=qu.getQ_title() %>" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">反馈日期</label>
						<div class="layui-input-block">
							<input type="text" name="news_time" readonly="readonly" value="<%=qu.getQ_time() %>" id="date" lay-verify="date" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})">
						</div>
					</div>
				</div>

				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">问题内容</label>
					<div class="layui-input-block">
						<textarea style="height: 300px" name="news_content" readonly="readonly" placeholder="请输入内容" class="layui-textarea"><%=qu.getQ_content() %></textarea>
					</div>
				</div>
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">图片</label>
					<div class="layui-input-block">
						<img alt="" style="height: 200px;width: 300px;margin: 0 auto" src="<%=basePath+"upload/"+qu.getQ_img()%>">
					</div>
				</div>
			</form>
		</div>
		<script type="text/javascript" src="plugins/layui/layui.js"></script>
		<script>
			layui.use(['form', 'layedit', 'laydate'], function() {
				var form = layui.form(),
					layer = layui.layer,
					layedit = layui.layedit,
					laydate = layui.laydate;
			});

		</script>
	</body>
</html>