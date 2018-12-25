<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.server.dao.*"
    import="java.util.List"
    import="com.server.entity.*"
    %>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<legend>组织信息</legend>
			</fieldset>
			<% 
			String oid=new String(request.getParameter("oid").getBytes(
					"ISO-8859-1"), "UTF-8");
			organization or=new OrganizationDao().getOneOrganization(oid);
			%>
			<form class="layui-form" action="ExamineOrganizationServlet">
				<div class="layui-form-item">
					<label class="layui-form-label">组织名称</label>
					<label class="layui-input-block layui-textarea"><%=or.getOr_name()%></label>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">组织地址</label>
					<label class="layui-input-block layui-textarea"><%=or.getOr_place()%></label>
				</div>
				<div class="layui-form-item">
						<label class="layui-form-label">成立时间</label>
						<label class="layui-input-block layui-textarea"><%=or.getFonudingtime()%></label>
					</div>
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">组织简介</label>
					<label class="layui-input-block layui-textarea"><%=or.getInformation()%></label>
				</div>
				
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>联系方式</legend>
			</fieldset>
				<div class="layui-form-item">
					<label class="layui-form-label">咨询电话</label>
					<label class="layui-input-block layui-textarea"><%=or.getSeatnumber()%></label>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">邮箱</label>
					<label class="layui-input-block layui-textarea"><%=or.getOr_email()%></label>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">官网</label>
					<label class="layui-input-block layui-textarea"><%=or.getOr_officialwebsite()%></label>
				</div>
					<div class="layui-form-item">
					<label class="layui-form-label">微信公众号</label>
					<label class="layui-input-block layui-textarea"><%=or.getOr_wecharnumber()%></label>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">官方微博</label>
					<label class="layui-input-block layui-textarea"><%=or.getOr_blognumber()%></label>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">组织logo</label>
					<img alt="作业" src="<%=basePath %>upload/<%=or.getOr_logo()%>" style="height:129px;width: 129px;">
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">审核</label>
					<div class="layui-input-block">
						<input type="radio" name="check" value="1" title="通过" checked="">
						<input type="radio" name="check" value="2" title="未通过">
					</div>
				</div>
				<input type="hidden" name="oid" value="<%=oid %>">
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
						
					</div>
				</div>
			</form>
		</div>
		<input type="hidden" id="message" value="${message}">
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