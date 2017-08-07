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
<script type="text/javascript" src="./js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
</head>
<body>
<center>
    用户登录 <br>
    <hr>
    <form action="LoginClServlet" method="post">
    用户名：<input type="text" name="username"><br><br>
    密&nbsp;&nbsp;码：<input type="password" name="passwd"><br><br>
    <input type="submit" class="btn btn-default" value="登录">
    <a href="register.jsp" >注册</a><br>
    
    </form>
    
    </center>
</body>
</html>