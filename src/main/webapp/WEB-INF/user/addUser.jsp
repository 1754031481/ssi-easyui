<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- base需要放到head中 --> 
<base href="<%=basePath%>"> 
</head>
<body>
	<form id="userFrom" >
		<input type="hidden" name="id" value="${user.id}">
		用户名:<input  name="name"   class="easyui-validatebox" data-options="required:true,missingMessage:'不能为空'" value="${user.name}" /><br/>  
		密码:<input  name="pwd"   class="easyui-validatebox" data-options="required:true,missingMessage:'不能为空'"  value="${user.pwd}"/><br/>  
		 <!-- <input  type="hidden" name="createdatetime"    onclick="WdatePicker()" ><br/>  -->
		<!-- 修改日期<input  name="modifydatetime"    onclick="WdatePicker()" class="dfinput Wdate"><br/> -->
	
	 <input type="file" name="file" value="${user.imgname}"/><br>
	<div id="huixian">
	</div>
	

</body>
<script type="text/javascript">
	$(function(){
		alert($(user.imgname))
		if($(user.imgname)!=null){
				$('#huixian').html("<img src='"+$(user.imgnam)+"'>");
		}
	})

</script>
</html>