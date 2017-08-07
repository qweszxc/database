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
      <%
      	String id=(String)request.getAttribute("name");
       %>
   ID：<%=id %> <br/>  <br/>  
    <!-- 把上传的图片显示出来 -->  
    <img src="./imgs/<%=id%>" />  
    <br> <a href=luru.jsp>继续录入</a><br>
    <a href="LogoutServlet" >注销</a><br>
      <a href="wel.jsp">返回</a>
      </center>
</body>
</html>