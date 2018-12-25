<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.server.dao.*"
    import="java.util.List"
    import="com.server.entity.*"
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
			
			<% 
			String rid=new String(request.getParameter("rid").getBytes(
					"ISO-8859-1"), "UTF-8");
			recruit re=new recruitDao().getOneRecruit(Integer.parseInt(rid));
			%>
			<form class="layui-form" action="ExRecruitServlet">
			<fieldset class="layui-elem-field">
  			<legend><%=re.getRe_title() %></legend>
  			<div class="layui-field-box">
    			截止时间：<%=re.getRe_deadline() %>
    			<br>
    			服务时间：<%=re.getRe_servicetime() %>
    			<br>
    			服务地点:<%=re.getRe_serviceplace() %>
  			</div>
			</fieldset>
			<fieldset class="layui-elem-field">
  			<legend>工作内容</legend>
  			<div class="layui-field-box">
    		<textarea rows="10" cols="110" readonly="readonly" style="border:none">
  			<%=re.getRe_jobcontent() %>
  			</textarea>
  			</div>
			</fieldset>
			<fieldset class="layui-elem-field">
  			<legend>待遇收获</legend>
  			<div class="layui-field-box">
  			<textarea rows="10" cols="110" readonly="readonly" style="border:none">
  			<%=re.getRe_treatment() %>
  			</textarea>
  			</div>
			</fieldset>
			<fieldset class="layui-elem-field">
  			<legend>报名条件</legend>
  			<div class="layui-field-box">	
    		<textarea rows="10" cols="110" readonly="readonly" style="border:none">
  			<%=re.getRe_condition() %>
  			</textarea>
  			</div>
			</fieldset>
				
				<div class="layui-form-item">
					<label class="layui-form-label">审核</label>
					<div class="layui-input-block">
						<input type="radio" name="check" value="1" title="通过" checked="">
						<input type="radio" name="check" value="2" title="未通过">
					</div>
				</div>
				<input type="hidden" name="rid" value="<%=rid %>">
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