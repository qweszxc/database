<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/bootstrap.min.js"></script>
<link href="./css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="./js/bootstrap.js"></script>
</head>
<body>
  <center>
    <form action="RegisterServlet" method="post">
     用户名：<input type="text" name="username"><br><br>
    密&nbsp;&nbsp;&nbsp;码：<input type="password" name="passwd"><br><br>
    确认密码：<input type="password" name="check_passwd"><br><br>
   <input type="submit" class="btn btn-default" value="注册">
    </form> <br>
    <%
    	String err=(String)request.getAttribute("err");
    	if(err==null);
    	else if(err=="1"){
    		out.println("已存在用户名");
    	}else if(err=="2"){
    		out.println("两个密码不一致");
    	}
     %>
    </center>
  </body>
</html>
