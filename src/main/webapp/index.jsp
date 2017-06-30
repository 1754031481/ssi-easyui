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
<title>人人网数据展示</title>
<!-- base需要放到head中 --> 
<base href="<%=basePath%>"> 
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:false" style="height:110px;">
		<center>six不six</center>
	</div>   
    <div  class="easyui-accordion" data-options="region:'west',title:'导航',split:false" style="width:300px;">
    
	<div title="栏目一" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
		<!-- Tree -->
		<span id="tree"></span>
	</div>
    
    </div>   
    <div class="easyui-tabs" id="mainTabs" data-options="region:'center'" style="background:#eee;">
    	<div title="欢迎页" style="padding:10px">   
        	<font color="red">注意1：</font>		<br>
        	<font color="red">注意2：</font>		<br>
        	<font color="red">注意3：</font>		<br>
    	</div>
    </div> 
</body>

<script type="text/javascript">
	$(function(){
		$('#tree').tree({    
		    url:'<%=request.getContextPath()%>/tree/newTreeList.do',
		    onLoadSuccess:function(node, data){
				var t = $(this);
				if(data) {
					$(data).each(function(index, d){
						if(this.state == 'closed') {
							t.tree('expandAll');
						}
					});
				}
			},
			onClick: function(node){
		    	var url = '${pageContext.request.contextPath}' + node.url;
		    	var opts = {
		    		title : node.text,
		    		content:'<iframe src="' + url + '" frameBorder="0" style="border:0;width:100%;height:99%;"></iframe>',    
		    	    closable:true,    
		    	    tools:[{    
		    	        iconCls:'icon-mini-refresh',    
		    	        handler:function(){    
		    	            alert('refresh');    
		    	        }    
		    	    }] 
		    	}
		    	addTab(opts);
			}
		}); 
		//创建一个tab页面，或者选中tabs页
		function addTab(opts){
			var t = $('#mainTabs');
			if(t.tabs('exists',opts.title)){
				t.tabs('select',opts.title);
			}else{
				t.tabs('add', opts);
			}
		};
	}),

		

	
	$(function(){
		mainTabs = $('#mainTabs').tabs({
			fit : true,
			border : false,
			tools : [ {
				iconCls : 'ext-icon-arrow_up',
				handler : function() {
					mainTabs.tabs({
						tabPosition : 'top'
					});
				}
			}, {
				iconCls : 'ext-icon-arrow_left',
				handler : function() {
					mainTabs.tabs({
						tabPosition : 'left'
					});
				}
			}, {
				iconCls : 'ext-icon-arrow_down',
				handler : function() {
					mainTabs.tabs({
						tabPosition : 'bottom'
					});
				}
			}, {
				iconCls : 'ext-icon-arrow_right',
				handler : function() {
					mainTabs.tabs({
						tabPosition : 'right'
					});
				}
			}, {
				text : '刷新',
				iconCls : 'ext-icon-arrow_refresh',
				handler : function() {
					var panel = mainTabs.tabs('getSelected').panel('panel');
					var frame = panel.find('iframe');
					try {
						if (frame.length > 0) {
							for (var i = 0; i < frame.length; i++) {
								frame[i].contentWindow.document.write('');
								frame[i].contentWindow.close();
								frame[i].src = frame[i].src;
							}
							if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
								try {
									CollectGarbage();
								} catch (e) {
								}
							}
						}
					} catch (e) {
					}
				}
			},{
				text : '关闭',
				iconCls : 'ext-icon-cross',
				handler : function() {
					var index = mainTabs.tabs('getTabIndex', mainTabs.tabs('getSelected'));
					var tab = mainTabs.tabs('getTab', index);
					if (tab.panel('options').closable) {
						mainTabs.tabs('close', index);
					} else {
						$.messager.alert('提示', '[' + tab.panel('options').title + ']不可以被关闭！', 'error');
					}
				}
			} ]
		});
	});
</script>

<script type="text/javascript">

<%-- $(document).ready(function(){
 	 $("#tree").tree({
		url:"<%=request.getContextPath()%>/tree/newTreeList.do",
		method:"get",
		animate:true,//动画效果
		lines:true,//是否显示线
		iconCls:true,
		//一次性展开所有节点
		onLoadSuccess:function(node, data){
 			var t = $(this);
 			if(data) {
 				$(data).each(function(index, d){
 					if(this.state == 'closed') {
 						t.tree('expandAll');
 					}
 				});
 			}
 		},
		onBeforeExpand: function (node){ // 展开前回掉函数
			
			$("#tree").tree("options").url="<%=request.getContextPath()%>/tree/newTreeList.do="+node.id;
		},
		onClick:function(node){
			var  flag=$("#tab").tabs("exists",node.text); //  当前选项卡是否存在	
			if(!flag){
			if(node.url){
			//单击tree的时候  添加一个新的选项卡  
				$('#tab').tabs('add',{    
    				title:node.text,    
   				   	content:'<iframe id="work" src="<%=request.getContextPath()%>/'+node.url+'"  width="100%" height="600"></iframe>',    
    				closable:true,    
    				tools:[{    
        			iconCls:'icon-mini-refresh',    //选项卡  上的刷新
       				handler:function(){    
					// 调用 'refresh' 方法更新选项卡面板的内容
					var tab = $('#tab').tabs('getSelected');  // 获取选择的面板tab.panel('refresh', 'get_content.php');
						$("#tab").tabs('update',{
						tab:tab,
						 options : {
        						  content : '<iframe  src="<%=request.getContextPath()%>/'+node.url+'" scrolling="auto" width="100%" height="600"></iframe>',
						 }
			});
	        }
	    }]    
	}); 
	}
	}else{
	$("#tab").tabs('select',node.text);
	}
	 }
	});
}) --%>
</script>
</html>