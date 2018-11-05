<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP ' business.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
body {
	background-color: #E8F0F5;
}

tr:nth-child(even) {
	background-color: #F0B99D;
}

tr:hover {
	background-color: #fff;
}

th {
	padding: 10px;
	background-color: #333;
	 
}

td {
	padding: 10px;
	background-color: #fff;
}

tr {
	text-align: center;
}

from {
	width: 800px;
	margin-left: 5px;
	margin-bottom: 0px;
}

input {
	width: 961px;
	height: 30px;
	border: 1px solid #369;
	margin-top: 5px;
}

.bu {
	margin-left: 1225px;
	margin-top: 5px;
	display: inline;
	position: absolute;
	right: 700px;
	top: 65px;
}
.w {
	width: 1065px;
	position: relative;
}
.del{
width:200px;
}
button{
    width: 65px;
	height: 30px;
	border: 1px solid #369;
	background-color: #A5BFD6;
	font-size: 16px;
}
</style>

</head>

<body>

 <%
  	String username1 = (String)session.getAttribute("username");
  	if(username1==null){
  		request.setAttribute("msg", "您还没有登录！");
  		request.getRequestDispatcher("login.jsp").forward(request, response);
  		return;
  	}
   %>
   
  <div class="w">
	<form action="/javaweb2/SetNodeServlet" method="post">

			<font color="red">${msg}</font>
			<div>
				&nbsp;&nbsp;<h2>请输入节点数量：</h2>
				<br>
				<div class="col-sm-10">
					<input type="text" class="select_none" name="nodenumber" placeholder="请输入1000以内的数字">

		
			  <button type="submit" class="bu">确定</button>
				</div>
				
			</div>
			
			<br>
			<br>
		</form>
	</div>

</body>

</html>
