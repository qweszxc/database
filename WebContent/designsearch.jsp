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
     ���ڣ�<select name="season">
     <option>����װ</option>
     <option>��װ</option>
     <option>��װ</option>
     </select>
     ���ࣺ<select name="kind" id="k" onchange="getstyle()">
     <option >����</option>
     <option >��װ</option>
     <option >����ȹ</option>
     </select>
     ��ʽ��<select name="style" id="s">
     <option>����</option>
     <option>����</option>
     </select>
     <input type="submit" class="btn btn-default" value="����">
     <a href="LogoutServlet" >ע��</a>
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
	
	if(value=="����"){
		var opt = document.createElement("option");
		opt.value="����";
		opt.innerHTML="����";
		select.appendChild(opt);
		var opt = document.createElement("option");
		opt.value="����";
		opt.innerHTML="����";
		select.appendChild(opt);
	}else if(value=="��װ"){
		var opt = document.createElement("option");
		opt.value="ţ�п�";
		opt.innerHTML="ţ�п�";
		select.appendChild(opt);
		var opt = document.createElement("option");
		opt.value="���п�";
		opt.innerHTML="���п�";
		select.appendChild(opt);
	}else if(value=="����ȹ"){
		var opt = document.createElement("option");
		opt.value="����ȹ";
		opt.innerHTML="����ȹ";
		select.appendChild(opt);
		var opt = document.createElement("option");
		opt.value="����ȹ";
		opt.innerHTML="����ȹ";
		select.appendChild(opt);
	}
}
</SCRIPT>
</html>