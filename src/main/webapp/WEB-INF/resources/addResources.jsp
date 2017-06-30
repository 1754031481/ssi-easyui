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
<title>资源列表添加</title>
<!-- base需要放到head中 --> 
<base href="<%=basePath%>"> 
</head>
<body>
<div id="resources_toimg"></div>
		<form id="resources_add" class="form">
		<input type="hidden" name="id" value="${resources.id} ">
		<fieldset>
			<legend>资源基本信息</legend>
			<table class="table" style="width: 100%;">
				<tr>
					<th>编号</th>
					<td><input name="id" value="${resources.id}" readonly="readonly" /></td>
					<th>资源名称</th>
					<td><input name="text" value="${resources.text}"  class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>资源路径</th>
					<td><input name="url" value="${resources.url}"/></td>
					<th>资源类型</th>
					 <td><select name="resoType"   class="easyui-combobox" data-options="required:true,editable:false,valueField:'ID',textField:'NAME',url:'<%=request.getContextPath()%>/tree/queryResourcesType.do',panelHeight:'auto'" style="width: 155px;"></select></td>
				</tr>
				<tr>
					<th>上级资源</th>
						<td><select id="parmentid"  name="parmentid" class="easyui-combotree" data-options="editable:false,idField:'id',textField:'text',parentField:'pid',url:'<%=request.getContextPath()%>/tree/showResourcesRight.do'" style="width: 155px;"></select><img class="iconImg ext-icon-cross" onclick="$('#syresource_id').combotree('clear');"  /></td>
					<th>资源图标</th>
					<td><input id="iconCls" value="${resources.iconCls}" name="iconCls" readonly="readonly" style="padding-left: 18px; width: 134px;" />
						<img class="iconImg ext-icon-zoom" onclick="showIcons();"  />&nbsp;
						<img class="iconImg ext-icon-cross" onclick="$('#iconCls').val('');$('#iconCls').attr('class','');"  />
					</td>
				</tr>
				<tr>
					<th>顺序</th>
					<td><input name="seq" class="easyui-numberspinner" data-options="required:true,min:0,max:100000,editable:false" style="width: 155px;" value="100" /></td> 
					<th>目标</th>
					<td><input name="resoGoal" value="${resources.resoGoal}"/></td>
				</tr>
				<tr>
					<th>资源描述</th>
					<td><textarea name="resoTest" value="${resources.resoTest}"></textarea></td>
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