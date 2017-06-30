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
<title>资源管理展示页面</title>
<!-- base需要放到head中 --> 
<base href="<%=basePath%>"> 
</head>
<body>
	<table id="resources_treegrid"></table>  
	<div id="resources_dialog"></div>
<div id="tb" style="padding:2px 5px;">
	<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true"  onclick="dialog('<%=request.getContextPath()%>/tree/toAddResources.do')">添加</a>
	<a onclick="redoFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'ext-icon-resultset_next'">展开</a>
	<a onclick="undoFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'ext-icon-resultset_previous'">折叠</a>
	<a onclick="grid.treegrid('reload');" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'ext-icon-arrow_refresh'">刷新</a>
</div>
</body>
<script type="text/javascript">
	$(function(){
	grid =  $('#resources_treegrid').treegrid({    
		    url:'<%=request.getContextPath()%>/tree/showResourcesRight.do',  
		    title:'资源列表',
		    idField:'id',    
		    treeField:'text', 
		    parentField :'pid',
		    toolbar:'#tb',
			ctrlSelect:true,
			fit:true,
			sortName:'seq',
			sortOrder:'asc',
		    columns:[[    
		        {field:'id',title:'序号',width:50},    
		        {field:'text',title:'资源名称',width:200},    
		        {field:'iconCls',title:'图标名称',width:150},    
		        {field:'url',title:'资源路径',width:150},
		        {field:'resoType',title:'资源类型',width:100,
		        	formatter:function(value,row,index){
						if(value==0){
							return "菜单"
						}else{
							if(value==1){
								return "功能"
							}
						}
		        		
					}
		        },
		        {field:'resoTest',title:'资源描述',width:200},
		        {field:'resoGoal',title:'目标',width:80},
		        {field:'操作',title:'操作',width:80,
		        	formatter : function(value, row) {
						var str = '';
							str +='<img class="iconImg ext-icon-note"  onclick="findOneResoId('+row.id+');"/>', 
							str +='<img class="iconImg ext-icon-note_edit"  onclick="updateResources(\'{0}\');"/>', 
							str += '<img class="iconImg ext-icon-note_delete"  onclick="delResources(\'{0}\');"/>'
						return str;
					}		        	
		        }
		    ]]    
		});  
		
	})
	
	
/* 修改 */
	function updateResources(){
		var rowsArray= $('#resources_treegrid').treegrid("getSelections");
		if(rowsArray.length>1){
			$.messager.alert('我的消息','只能选择一个！','error');
		}else{
		var id=rowsArray[0].id;
		dialog("<%=request.getContextPath()%>/tree/toAddResources.do?id="+id);  //  调用  dialog  
		}
	}
/* 添加资源 */
	function  dialog(url){
		$("#resources_dialog").dialog({
			title: '新增资源',
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
						url:"<%=request.getContextPath()%>/tree/addResources.do",
						data:$("#resources_add").serialize(),
						success:function (msg){
							$.messager.alert('我的消息','提交成功！','info');
							$("#resources_dialog").dialog("close");	
							$('#resources_treegrid').treegrid("load");
						} 
					});
					}
				},{
					text:'关闭',
					iconCls:"icon-no",
					handler:function(){
						$("#resources_dialog").dialog("close");	
					}
				}],
		});
	}
	
	/* 删除 */
	function delResources(){
		$.messager.confirm('确认对话框', '您想要删除吗？', function(r){   //  true    false
			if (r){
				var rowsArray= $('#resources_treegrid').datagrid("getSelections");
				var ds="";
				$.each(rowsArray, function(i, row){
					ds+=row.id+",";
					});
				$.ajax({
					url:"<%=request.getContextPath()%>/tree/deleteResources.do",
					type:"post",
					data:{
						"ids":ds
					},success:function (msg){
						$('#resources_treegrid').treegrid("load");
					}					
				});
			}
		});
	}
	
	/* 查看资源 */
	function  findOneResoId(id){
		alert(id)
		$("#resources_dialog").dialog({
			title: '查看资源',
			 width: 900,    
			 height: 500, 
			 href:'<%=request.getContextPath()%>/tree/toAddResources.do?id='+id,
			 closed: false, 
			 modal: true,
			 iconCls:"icon-save",
			buttons:[{
				text:'关闭',
				iconCls:"icon-no",
				handler:function(){
					$("#resources_dialog").dialog("close");	
				}
			}]
		});
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