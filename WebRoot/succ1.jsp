<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>SDN水下传感器网络业务分发系统</title>
	<link type="text/css" rel="stylesheet" href="css/style1.css" />
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
  
  <div class="top"></div>
  
<div id="header">
	
	<div class="logo"><img src="images/logo.png">SDN水下传感器网络业务分发系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li><a >root</a></li>
			<li><a href="login.jsp">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
	<ul id="nav_dot">
      <li>
          <h4 class="M1"><span></span>控制管理</h4>
          <div class="list-item none">
          <!-- <a  value="1">控制器数量</a>
          <form action="/javaweb2/ControllerServlet" method="post">
			  <input type="text" name="con_num"  placeholder="请输入控制器数量 1~4 "/>
			  <input type="submit" value="确定" class="submit_1"/>
			  
			  
		  </form> -->
            <a href='/javaweb2/ControllerCharServlet'>控制器状态</a> 
          </div>
        </li>
        <li>
          <h4 class="M2"><span></span>节点信息</h4>
          <div class="list-item none">
          <a href='succNodenum.jsp'>节点数量</a>
            <a href='/javaweb2/GetNodeServlet'>节点数据表</a>
            <a href='/javaweb2/ChartServlet'>节点状态</a> 
            
           </div>
        </li>
       <li>
          <h4 class="M3"><span></span>业务管理</h4>
          <div class="list-item none">
        	 <a href="succBusi.jsp">业务分发</a>
         </div>
        </li>
        <li>
          <h4  class="M9"><span></span>系统帮助</h4>
          <div class="list-item none">
            <a href="succHelp.jsp">帮助</a>

          </div>
        </li>

 	 </ul>
 	 
		</div>
		<div class="m-right">
			<div class="right-nav">
					<ul>
          <br>

					</ul>
			</div>
			<div class="main">
				
			<!-- <img class="img" src="images/back.png"> -->
      
			</div>
		</div>
</div>
<!-- <div class="bottom"></div>
<div id="footer"><p>---------</p></div> -->
<div id="footer"><p>Copyright©  2018 版权所有 河南科技学院</p></div>
<script>navList(12);</script>
  </body>
</html>
