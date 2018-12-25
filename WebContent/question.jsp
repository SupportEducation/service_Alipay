<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="com.server.dao.*"
    import="java.util.List"
    import="com.server.entity.*"%>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Table</title>
		<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="css/global.css" media="all">
		<link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="css/table.css" />
</head>
<body>
<div class="admin-main">
			<fieldset class="layui-elem-field">
				<legend>数据列表</legend>
				<div class="layui-field-box layui-form">
					<table class="layui-table admin-table">
						<thead>
							<tr>
								
								<th>编号</th>
								<th>标题</th>
								<th>时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="content">
							<%
							List<question> list2=new questionDao().getAllNews();
							for(question qu:list2){ 
						%>
						<tr>
							<td><%=qu.getQ_id()%></td>
							<td><%=qu.getQ_title()%></td>
							<td><%=qu.getQ_time()%></td>
							<td id="layer">
								<button  id="bianji" data-method="edit" data-path="<%=basePath %>" data-type="<%=qu.getQ_id()%>" class="layui-btn layui-btn-mini">查看</button>
								
							</td>
						</tr>
						<%} %>
					</tbody>
						
					</table>
				</div>
			</fieldset>
			</div>
			<input type="hidden" id="message" value="${message}">
		<script type="text/javascript" src="plugins/layui/layui.js"></script>
		<script>
		

layui.use('layer', function(){ //独立版的layer无需执行这一句
  var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
//触发事件
  var active = {
		  
  edit: function(othis){
      var type = othis.data('type');
      var path=othis.data('path');
      text = othis.text();
      
      layer.open({
    	   type: 2
    	   ,offset:'auto' 
   	        ,content:''+path+'questionCheck.jsp?q_id='+type+''
   	        ,shade: [0.8, '#393D49'] //显示遮罩
   	        ,area: ['800px', '600px']
	      });
  }
};

$('#layer .layui-btn').on('click', function(){
  var othis = $(this), method = othis.data('method');
  active[method] ? active[method].call(this, othis) : '';

});

});

layui.use('layer', function(){ //独立版的layer无需执行这一句
	  var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
	  
layui.use(['form', 'layedit', 'laydate'], function() {
	var form = layui.form(),
		layer = layui.layer,
		layedit = layui.layedit,
		laydate = layui.laydate;

});
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