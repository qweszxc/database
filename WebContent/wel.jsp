<%@ page language="java" import="java.util.*,java.sql.*,com.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<center>
  <% 
  	String username=null;
  	HttpSession hs=request.getSession(true);
  	try{
  		//防止非法登录
  		username=(String)hs.getAttribute("uname");
  		if(username==null){//检查是否有用户名，若没有即没登录，跳转到登录页面
  			response.sendRedirect("login.jsp");
  			return;
  		}
  	}catch(Exception e){
  		e.printStackTrace();
  	}
  	
  	%>
      welcome <%=username %><br>
    <a href="LogoutServlet" >注销</a>
    <a href="luru.jsp">录入信息</a>
    <br><a href="adminsearch.jsp">数据管理</a>
    <hr>
    <%
    	//调用model类获得页数和当前页码
    	UserBeanCl ubc=new UserBeanCl();
    	
		int pageCount=ubc.getpageCount();
    	String s_pageNow=(String)request.getParameter("userpageNow");
    	int pageNow=1;
    	if(s_pageNow!=null){
    		pageNow=Integer.parseInt(s_pageNow);
    	}
    	
    	ArrayList al=ubc.getUserByPage(pageNow);//得到当前页码相应用户列表
    	
    	
    	
    %>
    	<h1>用户信息列表</h1>
    	<table border="1">
    	<tr><td>用户id</td><td>用户名</td><td>用户密码</td><td>用户等级</td></tr>
    <%
    	for(int i=0;i<al.size();i++){
    		UserBean ub=(UserBean)al.get(i);
    %>
    		<tr><td><%=ub.getUserid() %></td><td><%=ub.getUsername() %></td>
    		<td><%=ub.getPasswd() %></td><td><%=ub.getGrade() %></td></tr>
    <%
    	}
     %>
    	</table>
    
	<%
		//分页
		if(pageNow!=1){
			out.println("<a href=wel.jsp?userpageNow="+(pageNow-1)+">上一页</a>");
		}
		
		for(int i=1;i<=pageCount;i++){
			out.println("<a href=wel.jsp?userpageNow="+i+">["+i+"]</a>");
		}
		if(pageNow!=pageCount){
			out.println("<a href=wel.jsp?userpageNow="+(pageNow+1)+">下一页</a>");
		}
	%>
	
	</center>
</body>
</html>