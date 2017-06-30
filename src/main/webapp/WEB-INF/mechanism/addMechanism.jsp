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
<%@ include file="/common/inc.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- base需要放到head中 --> 
<base href="<%=basePath%>"> 
</head>
<body>
	<form id="mechanism_dialogForm" class="form">
	<input type="hidden" name="id" value="${mechanism.id}">
		<fieldset>
			<legend>机构基本信息</legend>
			<table class="table" style="width: 100%;">
				<tr>
					<th>编号</th>
					<td><input name="id" value="${mechanism.id}" readonly="readonly" /></td>
					<th>机构名称</th>
					<td><input name="name" value="${mechanism.name}" class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>机构编码</th>
					<td><input name="code" value="${mechanism.code}" /></td>
					<th>顺序</th>
					<td><input name="seq" value="${mechanism.seq}" class="easyui-numberspinner" data-options="required:true,min:0,max:100000,editable:false" style="width: 155px;" value="10" /></td>
				</tr>
				<tr>
					<th>上级机构</th>
					 <td><select  value="${mechanism.id}" name="parmentid" class="easyui-combotree" data-options="editable:false,idField:'id',textField:'name',parentField:'pid',url:'<%=request.getContextPath()%>/mechanism/showMechanism.do'" style="width: 155px;"></select>
					 <img class="iconImg ext-icon-cross" onclick="$('#syorganization_id').combotree('clear');"  /></td>
					<th>机构图标</th>
					<td><input id="iconCls" name="iconCls" value="${mechanism.iconCls}" readonly="readonly" style="padding-left: 18px; width: 134px;" />
					<img class="iconImg ext-icon-zoom" onclick="showIcons();"  />&nbsp;
					<img class="iconImg ext-icon-cross" onclick="$('#iconCls').val('');$('#iconCls').attr('class','');"  /></td>
				</tr>
				<tr>
					<th>机构地址</th>
					<td><input name="address"  value="${mechanism.address}"/></td>
					<th></th>
					<td></td>
				</tr>
			</table>
		</fieldset>
	</form>
	
	
	<script type="text/javascript">
	function showIcons(){
		var dialog = parent.sy.modalDialog({
			title : '浏览小图标',
			url : '<%=request.getContextPath()%>/icons.jsp',
			buttons : [ {
				text : '确定',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.selectIcon(dialog, $('#iconCls'));
				}
			} ]
		});
	};
	</script>
</body>
</html>