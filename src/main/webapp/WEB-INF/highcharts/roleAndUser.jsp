<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/inc.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>highcharts-用户角色分布</title>
</head>

 <body>
	 <div  id="container" style="min-width: 400px;height: 400px;"></div>
	
</body>

  <script>
        $(function () {
        	$.ajax({
        		type:"post",
        		data:"data",
        		url:"${pageContext.request.contextPath}/highchartsController/getData.do",
        		dataType:"json",
        		success:function(data){
        			if(data.success){
        	        	var chart = new Highcharts.Chart('container', {
        	    				        chart: {
        	    				            plotBackgroundColor: null,
        	    				            plotBorderWidth: null,
        	    				            plotShadow: false
        	    				        },
        	    				        
        	    				        title: {
        	    				            text: data.msg
        	    				        },
        	    				        
        	    				        
        	    				        tooltip: {
        	    				            headerFormat: '{series.name}<br>',
        	    				            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        	    				        },
        	    				        
        	    				        
        	    				        plotOptions: {
        	    				            pie: {
        	    				                allowPointSelect: true,
        	    				                cursor: 'pointer',
        	    				                dataLabels: {
        	    				                    enabled: true,
        	    				                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
        	    				                    style: {
        	    				                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
        	    				                    }
        	    				                }
        	    				            }
        	    				        },
        	    				        series: [{
        	    				            type: 'pie',
        	    				            name: data.msg,
        	    				            data: data.object,
        	    				        }]
        	    				    });
        	
        
        			}
        		}
        	})
        })
        
        	

</script> 

</html>