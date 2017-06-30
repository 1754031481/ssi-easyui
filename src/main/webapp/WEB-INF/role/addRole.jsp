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
</head>
<body>
	<form id="role_form" >
	<input type="hidden" name="id" value="${role.id} ">
		<fieldset>
			<legend>角色基本信息</legend>
			<table class="table" style="width: 100%;">
				<tr>
					<th>编号</th>
					<td><input  name="id" readonly="readonly" /></td>
					<th>角色名称</th>
					<td><input name="name" value="${role.name}" class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>顺序</th>
					<td><input name="seq" value="${role.seq}" class="easyui-numberspinner" data-options="required:true,min:0,max:100000,editable:false" style="width: 155px;" value="100" /></td>
					<th>角色描述</th>
					<td><textarea value="${role.description}" name="description"></textarea></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>