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
</head>
<body>
	<table id="mechanism_treeGrid"></table>
	<div id="mechanism_dialog"></div>
	<div id="tb" style="padding:2px 5px;">
	<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true"  onclick="dialog('<%=request.getContextPath()%>/mechanism/toAddMechanism.do')">添加</a>
	<a onclick="redoFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'ext-icon-resultset_next'">展开</a>
	<a onclick="undoFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'ext-icon-resultset_previous'">折叠</a>
	<a onclick="grid.treegrid('reload');" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'ext-icon-arrow_refresh'">刷新</a>
</div>
</body>
<script type="text/javascript">

/* 修改机构 */
function updateMechanism(){
	var rowsArray= $('#mechanism_treeGrid').treegrid("getSelections");
	if(rowsArray.length>1){
		$.messager.alert('我的消息','只能选择一个！','error');
	}else{
	var id=rowsArray[0].id;
	dialog("<%=request.getContextPath()%>/mechanism/toAddMechanism.do?id="+id);  //  调用  dialog  
	}
}
/* 查看机构*/
function  findOneId(id){
	$("#mechanism_dialog").dialog({
		title: '查看机构',
		 width: 900,    
		 height: 500, 
		 href:'<%=request.getContextPath()%>/mechanism/toAddMechanism.do?id='+id,
		 closed: false, 
		 modal: true,
		 iconCls:"icon-save",
		 buttons:[{
			text:'关闭',
			iconCls:"icon-no",
			handler:function(){
				$("#mechanism_dialog").dialog("close");	
			}
		}]
	});
}
/* 添加机构 */
function  dialog(url){
	$("#mechanism_dialog").dialog({
		title: '新增机构',
		 width: 900,    
		 height: 500, 
		 href:url,
		 closed: false, 
		 modal: true,
		 iconCls:"icon-save",
		 buttons:[{
				text:'OK',
				iconCls:"icon-ok",
				handler:function(){
				$.ajax({
					type:"post",
					url:"<%=request.getContextPath()%>/mechanism/addMechanism.do",
					data:$("#mechanism_dialogForm").serialize(),
					success:function (msg){
						$.messager.alert('我的消息','提交成功！','info');
						$("#mechanism_dialog").dialog("close");	
						$('#mechanism_treeGrid').treegrid("load");
					} 
				});
				}
			},{
				text:'关闭',
				iconCls:"icon-no",
				handler:function(){
					$("#mechanism_dialog").dialog("close");	
				}
			}],
	});
}

	$(function(){
		grid =  $('#mechanism_treeGrid').treegrid({    
		    url:'<%=request.getContextPath()%>/mechanism/showMechanism.do',  
		    title:'资源列表',
		    idField:'id',    
		    treeField:'name', 
		    parentField :'pid',
		    toolbar:'#tb',
			ctrlSelect:true,
			fit:true,
			sortName:'seq',
			sortOrder:'asc',
		    columns:[[    
		        {field:'id',title:'序号',width:50},    
		        {field:'name',title:'机构名称',width:200},    
		        {field:'iconCls',title:'图标名称',width:150},    
		        {field:'code',title:'机构编码',width:150},
		        {field:'address',title:'机构地址',width:100},
		        {field:'操作',title:'操作',width:80,
		        	formatter : function(value, row) {
						var str = '';
						str +=('<img class="iconImg ext-icon-note"  onclick="findOneId('+row.id+');"/>');
						str +=('<img class="iconImg ext-icon-note_edit"  onclick="updateMechanism(\'{0}\');"/>');
						str +=('<img class="iconImg ext-icon-key"  onclick="grantFun(\'{0}\');"/>');
						str +=('<img class="iconImg ext-icon-note_delete"  onclick="deleteMechanism('+row.id+');"/>');
						return str;
					}		        	
		        }
		    ]]    
		});  
		
	})
	
	/* 单删 */
	var deleteMechanism = function(id) {
		$.messager.confirm('确认对话框','您想要删除吗？',function(r){
			if(r){
				$.ajax({
					url:'<%=request.getContextPath()%>/mechanism/deleteMechanism.do',
					type:'post',
					data:{
						id:id
					},success:function(msg){
						grid.treegrid('load');
					}
				})
			}
		})
	}
	
	
	
	
		/* 展开 */
	var redoFun = function() {
		var node = grid.treegrid('getSelected');
		if (node) {
			grid.treegrid('expandAll', node.id);
		} else {
			grid.treegrid('expandAll');
		}
	};
	/* 折叠 */
	var undoFun = function() {
		var node = grid.treegrid('getSelected');
		if (node) {
			grid.treegrid('collapseAll', node.id);
		} else {
			grid.treegrid('collapseAll');
		}
	};
</script>
</html>