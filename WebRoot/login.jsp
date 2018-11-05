<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	
	<title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/style.css">

		<script type="text/javascript">
		function _change(){
			document.getElementById("img").src="/javaweb2/VerifyCodeServlet?a="+new Date().getTime();
		}
	</script>
</head>

<body>
<%
  	String massage = "";
  	String msg = (String) request.getAttribute("msg");//获取requset域中的msg信息
  	if(msg !=null){
  		massage = msg;
  	}
   %>
  	
  	

	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height:150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				
				<form action="/javaweb2/LoginServlet" method="post">
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>后台管理中心</h1>
							<font color="red"><b><%= massage %></b></font>
						</div>
						<div class="panel-body"
							style="padding:30px; padding-bottom:10px; padding-top:10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="username"
										id="username" placeholder="登录账号" /> <span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="password"
										id="password" placeholder="登录密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field">
									<input type="text" class="input input-big" name="verifyCode"placeholder="填写下侧的验证码" /> 
										<img src="/javaweb2/VerifyCodeServlet"alt="" width="100" height="32" class="passcode"style="height:43px;cursor:pointer;"onClick="_change()">
										<br>
										<br>
										<img id="img" width="100" height="32" class="passcode"style="height:43px; cursor:pointer; src="/javaweb2/VerifyCodeServlet">
    		 							<a href="javascript:_change()">换一张</a>
								</div>
							</div>
						</div>
						<div style="padding:30px;">
							<input type="submit" id="button"
								class="button button-block bg-main text-big input-big"
								value="登录">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
