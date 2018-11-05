<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>SDN水下传感器网络节点数据分析系统</title>

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
  	String username = (String)session.getAttribute("username");
  	if(username==null){
  		request.setAttribute("msg", "您还没有登录！");
  		request.getRequestDispatcher("login.jsp").forward(request, response);
  		return;
  	}
   %>

	<div class="w">

		
		
		<form action="/javaweb2/GetNodeServlet" method="post">

			<font color="red">${msg}</font>
			<div>
				&nbsp;&nbsp;<h2>选择轮次：</h2>
				<br>
				<div class="col-sm-10">
					
				<select class="select_none" name="number">
				  <option value="1" >1</option>
				  <option value="2" >2</option>
				  <option value="3" >3</option>
				  <option value="4" >4</option>
				  <option value="5" >5</option>
				  <option value="6" >6</option>
				  <option value="7" >7</option>
				  <option value="8" >8</option>
				  <option value="9" >9</option>
				  <option value="10" >10</option>
				  <option value="11" >11</option>
				  <option value="12" >12</option>
				  <option value="13" >13</option>
				  <option value="14" >14</option>
				  <option value="15" >15</option>
				  <option value="16" >16</option>
				  <option value="17" >17</option>
				  <option value="18" >18</option>
				  <option value="19" >19</option>
				  <option value="20" >20</option>
				  <option value="21" >21</option>
				  <option value="22" >22</option>
				  <option value="23" >23</option>
				  <option value="24" >24</option>
				  <option value="25" >25</option>
				  <option value="26" >26</option>
				  <option value="27" >27</option>
				  <option value="28" >28</option>
				  <option value="29" >29</option>
				  <option value="30" >30</option>
				  <option value="31" >31</option>
				  <option value="32" >32</option>
				  <option value="33" >33</option>
				  <option value="34" >34</option>
				  <option value="35" >35</option>
				  <option value="36" >36</option>
				  <option value="37" >37</option>
				  <option value="38" >38</option>
				  <option value="39" >39</option>
				  <option value="40" >40</option>
				  <option value="41" >41</option>
				  <option value="42" >42</option>
				  <option value="43" >43</option>
				  <option value="44" >44</option>
				  <option value="45" >45</option>
				  <option value="46" >46</option>
				  <option value="47" >47</option>
				  <option value="48" >48</option>
				  <option value="49" >49</option>
				  <option value="50" >50</option>
				  <option value="51" >51</option>
				  <option value="52" >52</option>
				  <option value="53" >53</option>
				  <option value="54" >54</option>
				  <option value="55" >55</option>
				  <option value="56" >56</option>
				  <option value="57" >57</option>
				  <option value="58" >58</option>
				  <option value="59" >59</option>
				  <option value="60" >60</option>
				  
			  </select>
		
			  <button type="submit" class="bu">确定</button>
				</div>
				
			</div>
			
			<br>
			<br>
		</form>
		<h1>第${tru}轮次数据</h1>
	</div>


	<table width="96%" cellpadding="0" cellspacing="0" border="1" id="tableDate">
		<tr>
			<th>节点id</th>
			<th>坐标[x]</th>
			<th>坐标[y]</th>
			<th>业务</th>
			<th>轮次</th>
			<th>电量</th>
			<th>状态</th>
			<th>状态随机数</th>
			
		</tr>
		 <c:forEach items="${result}" var="p">
			<tr>&nbsp;&nbsp;
				<td>&nbsp;&nbsp;<c:out value="${p.nid}" /></td>
				<td>&nbsp;&nbsp;<c:out value="${p.xcoord}" /></td>
				<td>&nbsp;&nbsp;<c:out value="${p.ycoord}" /></td>
				<td>&nbsp;&nbsp;<c:out value="${p.buis}" /></td>
				<td>&nbsp;&nbsp;<c:out value="${p.tru}" /></td>
				<td>&nbsp;&nbsp;<c:out value="${p.energy}" /></td>
				<td>&nbsp;&nbsp;<c:out value="${p.state}" /></td>
				<td>&nbsp;&nbsp;<c:out value="${p.srand}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
<script type="text/javascript" >
	$(function(){
		$('#submit').click(function(){
		var _url = "/javaweb2/GetNodeServlet";
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
