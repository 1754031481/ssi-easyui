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
<style type="text/css">
	body {
		font-size: 12px;
	}
</style>
<%@include file="/common/inc.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人人网登录</title>
<!-- base需要放到head中 --> 
<base href="<%=basePath%>"> 
</head>
<body>
<div id="addDialog"></div>
	<strong>SSHE示例系统默认账户：</strong>
		<br />
		<br />
	<div style="width: 400px; height: 300px;">
		<table class="table table-bordered">
			<tr>
				<th>登录名/密码</th>
				<th>账户描述</th>
			</tr>
			<tr>
				<td>admin/123</td>
				<td>超管，拥有系统所有权限</td>
			</tr>
			<tr>
				<td>666/666</td>
				<td>来宾用户，拥有查看权限</td>
			</tr>
			<tr>
				<td>杀我别用感情刀/789</td>
				<td>资源管理员</td>
			</tr>
			<tr>
				<td>真的很疼/789</td>
				<td>角色管理员</td>
			</tr>
			<tr>
				<td>admin3/123456</td>
				<td>机构管理员</td>
			</tr>
			<tr>
				<td>admin4/123456</td>
				<td>用户管理员</td>
			</tr>
			<tr>
				<td>admin5/123456</td>
				<td>系统监控管理员</td>
			</tr>
		</table>
	</div>
		<br />
	<strong>如果登录不了，或者数据错乱、丢失等情况，请点击下面链接</strong>
		<br />

<div id="login_dialog" style="padding: 3px;">
	<div id="login_tabs" class="easyui-tabs" data-options="fit:true">  
		 <div title="用户输入模式" >   
			  <form class="login_form">
			  	<table class="table table-bordered table-condensed">
			 	<tr>
			 		<th>登录名：</th>
			 		<td><input class="easyui-textbox" name="name" data-options="iconCls:'icon-man'" style="width:182px"> </td>
			 	</tr>
			 	<tr>
			 		<th>密码：</th>
			 		<td><input class="easyui-textbox" name="pwd" type="password" data-options="iconCls:'icon-lock'" style="width:182px"> </td>
			 	</tr>
			  	</table>
			  </form>
		</div>   
	
		<div title="自动补全模式" data-options="closable:false" style="overflow:auto;">   
		    <form class="login_form">
		    	<table class="table table-bordered table-condensed">
		    		<tr>
		    			<th>登录名：</th>
		    			<td><input id="tab2_name" name="name" style="width: 182px;"></td>
		    		</tr>
		    		<tr>
		    			<th>密码：</th>
		    			<td><input class="easyui-textbox" name="pwd" type="password" data-options="iconCls:'icon-lock'" style="width:182px"> </td>
		    		</tr>
		    	</table>
		    </form>
		 </div>  
    
		  <div title="数据表格模式" style="overflow: hidden; padding: 10px;">   
			  <form class="login_form">
			  	<table class="table table-bordered table-condensed" style="padding: 1px;">
			  		<tr>
			  			<th>登录名：</th>
			  			<td><input id="tab3_name" name="name" style="width: 182px;"/></td>
			  		</tr>
			  		<tr>
			  			<th>密码：</th>
			  			<td><input class="easyui-textbox" name="pwd" type="password" data-options="iconCls:'icon-lock'" style="width:182px"> </td>
			  		</tr>
			  	</table>
			  </form>
		 </div>   
	</div>	
</div>	
		
</body>
<script type="text/javascript">
$(function() {
	
	$('#login_dialog').dialog({    
	    title: '系统登录',    
	    width: 360,    
	    height: 220,    
	    closed: false,  
	    closable: false,
	    iconCls: "icon-lock-login",
	    buttons:[{
			text:'注册',
			handler:function(){
				dialog();
			}
		},{
			id: 'loginBtn',
			text:'登录',
			handler:function(){
				loginUser();
			}
		}],
		onOpen : function() {
			$('form :input:first').focus();
			$('form :input').keyup(function(event) {
				if (event.keyCode == 13) {
					loginUser();
				}
			});
		}
	});
	
	//自动补全模式
	$('#tab2_name').combobox({    
	    url:'${pageContext.request.contextPath}/user/userList.do',    
	    valueField:'name',    
	    textField:'name',
	    mode: 'remote'
	}); 
	
	//数据表格模式
	$('#tab3_name').combogrid({        
	    url:'${pageContext.request.contextPath}/user/showPageUser.do',
	    panelWidth : 600,
		panelHeight : 250,
		idField : 'name',
		textField : 'name',
		pagination : true,
		fitColumns : true,
		required : true,
		rownumbers : true,
		mode : 'remote',
		delay : 500,
		sortName : 'name',
		sortOrder : 'asc',
		pageSize : 5,
		pageList : [ 5, 10 ],
	    columns: [[    
	        {field:'id',title:'序号',width:100,sortable:true},    
	        {field:'name',title:'名称',width:100,sortable:true},
	        {field:'createdatetime',title:'创建时间',width:120,sortable:true},    
	        {field:'modifydatetime',title:'修改时间',width:120,sortable:true} 
	    ]]  
	});	
	
	
})

//手动输入模式
function loginUser(){
	var loginTabs = $('#login_tabs').tabs('getSelected');//当前选中的tab
	var $form = loginTabs.find('.login_form');//选中的tab里面的form
	$('#loginBtn').linkbutton('disable');
	$.post('${pageContext.request.contextPath}/user/login.do', $form.serialize(), function(result) {
		if (result.success) {
			location.replace('${pageContext.request.contextPath}/index.jsp');
		} else {
			$('#loginBtn').linkbutton('enable');
			$.messager.show({
				title:'提示',
				msg:result.msg,
				timeout:2000,
				showType:'slide',
				width: '250px',
				height: '150px'
			});
		}
	}, 'json');
}

/* 添加用户 */
function  dialog(){
	$("#addDialog").dialog({
		title: '用户注册',
		 width: 200,    
		 height: 200, 
		 href:'<%=request.getContextPath()%>/user/toAdd.do',
		 closed: false, 
		 modal: true,
		 iconCls:"icon-save",
		 buttons:[{
				text:'OK',
				iconCls:"icon-ok",
				handler:function(){
				$.ajax({
					type:"post",
					url:"<%=request.getContextPath()%>/user/insertUser.do",
					data:$("#userFrom").serialize(),
					success:function (msg){
						$.messager.alert('我的消息','注册成功，请登录！','info');
						$("#addDialog").dialog("close");	
						$('#userShow').datagrid("load");
					} 
				});
				}
			},{
				text:'关闭',
				iconCls:"icon-no",
				handler:function(){
					$("#addDialog").dialog("close");	
				}
			}],
	});
}
</script>
</html>