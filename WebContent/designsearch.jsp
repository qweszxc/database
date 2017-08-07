<%@ page language="java" import="java.util.*" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/bootstrap.min.js"></script>
<link href="./css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="./js/bootstrap.js"></script>
</head>
<body>
<center>
  <% 
  	String username=null;
  	HttpSession hs=request.getSession(true);
  	try{
  		
  		username=(String)hs.getAttribute("uname");
  		if(username==null){
  			response.sendRedirect("login.jsp");
  			return;
  		}
  	}catch(Exception e){
  		e.printStackTrace();
  	}
  	%>
     <br><br>
     <form action="DesignSearchServlet?pageNow=1" method="post">
     季节：<select name="season">
     <option>春秋装</option>
     <option>夏装</option>
     <option>冬装</option>
     </select>
     种类：<select name="kind" id="k" onchange="getstyle()">
     <option >上衣</option>
     <option >下装</option>
     <option >连衣裙</option>
     </select>
     款式：<select name="style" id="s">
     <option>卫衣</option>
     <option>外套</option>
     </select>
     <input type="submit" class="btn btn-default" value="搜索">
     <a href="LogoutServlet" >注销</a>
     </form>
     <table width="100%" border="1" height="100%">
  <tr>
    <td height="100%"><jsp:include page="show.jsp" /></td>
  </tr>
</table>
     </center>
</body>
<SCRIPT LANGUAGE="JavaScript">
function getstyle(){

	var select = document.getElementById("s");
	 document.getElementById("s").options.length=0; 
	 
	 var obj = document.getElementById("k"); 

	var index = obj.selectedIndex; 
	
	var text = obj.options[index].text; 
	
	var value = obj.options[index].value; 
	
	if(value=="上衣"){
		var opt = document.createElement("option");
		opt.value="卫衣";
		opt.innerHTML="卫衣";
		select.appendChild(opt);
		var opt = document.createElement("option");
		opt.value="外套";
		opt.innerHTML="外套";
		select.appendChild(opt);
	}else if(value=="下装"){
		var opt = document.createElement("option");
		opt.value="牛仔裤";
		opt.innerHTML="牛仔裤";
		select.appendChild(opt);
		var opt = document.createElement("option");
		opt.value="休闲裤";
		opt.innerHTML="休闲裤";
		select.appendChild(opt);
	}else if(value=="连衣裙"){
		var opt = document.createElement("option");
		opt.value="连衣裙";
		opt.innerHTML="连衣裙";
		select.appendChild(opt);
		var opt = document.createElement("option");
		opt.value="背心裙";
		opt.innerHTML="背心裙";
		select.appendChild(opt);
	}
}
</SCRIPT>
</html>