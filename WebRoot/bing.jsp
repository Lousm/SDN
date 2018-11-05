<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'bing.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/echarts.js"></script>

  </head>
  
  <body>
  
   <%
  	String username = (String)session.getAttribute("username");
  	if(username==null){
  		request.setAttribute("msg", "您还没有登录！");
  		request.getRequestDispatcher("login.jsp").forward(request, response);
  		return;
  	}
   %>
<div id="echartsPie" style="width: 600px;height:400px;"></div>  
<script type="text/javascript">  
    var echartsPie;  
    var cid1;
    var cid2;
    var cid3;
    var cid4;
    cid1=<%request.getAttribute("cid1");%>
    cid2=<%request.getAttribute("cid2");%>
    cid3=<%request.getAttribute("cid3");%>
    cid4=<%request.getAttribute("cid4");%>
    console.log(cid1);
   
/*      var json = [  
                {value:cid1,name:'控制器1'},  
                {value:cid2,name:'控制器2'},  
                {value:cid3,name:'控制器3'},
                {value:cid4,name:'控制器4'} 
                ]; */   
         var json = [  
                {value:30,name:'控制器1'},  
                {value:15,name:'控制器2'},  
                {value:20,name:'控制器3'},
                {value:35,name:'控制器4'} 
                ]; 
    var option = {  
            title : {  
                text: '控制器负载分布',  
                subtext: '',  
                x:'center'  
            },  
            tooltip : {  
                trigger: 'item',  
                formatter: "{a} <br/>{b} : {c} 个"  
            },  
            legend: {  
                orient : 'vertical',  
                x : 'left',  
                data:['控制器1','控制器2','控制器3','控制器4']  
            },  
            toolbox: {  
                show : true,  
                feature : {  
                    mark : {show: true},  
                    dataView : {show: true, readOnly: false},  
                    magicType : {  
                        show: true,   
                        type: ['pie', 'funnel'],  
                        option: {  
                            funnel: {  
                                x: '25%',  
                                width: '50%',  
                                funnelAlign: 'left',  
                                max: 1548  
                            }  
                        }  
                    },  
                    restore : {show: true},  
                    saveAsImage : {show: true}  
                }              },  
            calculable : true,  
            series : [  
                {  
                    name:'负载',  
                    type:'pie',  
                    radius : '70%',//饼图的半径大小  
                    center: ['50%', '60%'],//饼图的位置  
                    data:json  
                }  
            ]  
        };   
      
    echartsPie = echarts.init(document.getElementById('echartsPie'));  
    $(function(){  
        echartsPie.setOption(option);  
          
    });                       
</script>  
</body>  
</html>
