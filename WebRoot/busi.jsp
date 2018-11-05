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
	right: 3px;
	top: 21px;
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
   
    <div class="list-item none">
          <form action="/javaweb2/BusinessDistributionServlet" method="post">
          <a >请选择控制器：</a>
			<select class="select_none" name="con_num">
				  <option value="1" >1</option>
				  <option value="2" >2</option>
				  <option value="3" >3</option>
				  <option value="4" >4</option>
			  </select>
			  
			  <a >请选择要分发的业务：</a>
			  <select class="select_none" name="bus_num">
				  <option value="APP1" >APP1</option>
				  <option value="APP2" >APP2</option>
				  <option value="APP3" >APP3</option>
				  <option value="APP4" >APP4</option>
				  <option value="APP5" >APP5</option>

			  </select><br>
			  <input type="submit" value="发送" class="submit_1"/>
			  </form>
          </div>
          <br>

<h1>节点业务</h1>
	

	<table width="96%" cellpadding="0" cellspacing="0" border="1" id="tableDate">
		<tr>
			<th>节点id</th>
			<th>控制器id</th>

			<th>业务</th>
			
			
		</tr>
		 <c:forEach items="${result}" var="p">
			<tr>&nbsp;&nbsp;
				<td>&nbsp;&nbsp;<c:out value="${p.nid}" /></td>
				<td>&nbsp;&nbsp;<c:out value="${p.cid}" /></td>

				<td>&nbsp;&nbsp;<c:out value="${p.buis}" /></td>

			</tr>
		</c:forEach>
	</table>

</body>
<script type="text/javascript" >
	$(function(){
		$('#submit').click(function(){
		var _url = "/javaweb2/BusinessDistributionServlet";
		//var params = { "id": "1" };
		console.log(2);
 		$.ajax({
			   type:"post",//请求方式
			  url:_url,//发送请求地址
			    data:{ },
			   //请求成功后的回调函数有两个参数
			   success:function(data,textStatus){
			    	 $("#tableDate").append(data); 
			   } 
		}); 
		});
	});
</script>
</html>
