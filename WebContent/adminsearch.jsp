<%@ page language="java" contentType="text/html; charset=gb2312"
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
<style>
.right{
float:right;
}
</style>
</head>
<body>
<center>
  <% 
  	String username=request.getParameter("user");
  	%>
     <br><br>
     <form action="AdminSearchServlet" method="post">
     <table width="100%" border="1">
     
  <tr>
    <td>����</td>
    <td>����</td>
    <td>��ʽ</td>
    <td>���</td>
    <td>��ɫ</td>
    <td>ͼ��</td>
    <td>����</td>
    <td>����</td>
    <td>����</td>
    <td>����</td>
  </tr>
  <tr>
    <td><select name="season">
    <option></option>
     <option>����װ</option>
     <option>��װ</option>
     <option>��װ</option>
     </select></td>
    <td><select name="kind" id="k" onchange="getstyle()">
    <option></option>
     <option >����</option>
     <option >��װ</option>
     <option >����ȹ</option>
     </select></td>
    <td><select name="style" id="s">
    <option></option>
     </select></td>
    <td><select name="year" id="y" >
    	<option></option>
       
       </select></td>
    <td><select name="color">
    <option></option>
   <option>��ɫ</option>
   <option>��ɫ</option>
   <option>��ɫ</option>
   </select></td>
    <td><select name="picture">
    <option></option>
   <option>����</option>
   <option>Բ��</option>
   </select></td>
    <td><select name="material">
    <option></option>
   <option>��</option>
   <option>ë��</option>
   </select></td>
    <td><select name="collar">
    <option></option>
   <option>Բ��</option>
   <option>һ����</option>
   </select></td>
    <td><select name="arm">
    <option></option>
   <option>����</option>
   <option>����</option>
   </select></td>
    <td><select name="jidu" id="j" >
    <option></option>
   	<option>1</option>
   	<option>2</option>
   	<option>3</option>
   	<option>4</option>
   </select></td>
  </tr>
</table>
     <input name="submit" type="submit" value="����" class="btn btn-default"/><br>
     </form>
     <table width="100%" border="1" height="100%">
  <tr>
    <td height="100%"><jsp:include page="ashow.jsp" /></td>
  </tr>
</table>
     </center>
</body>
<SCRIPT LANGUAGE="JavaScript">
var select = document.getElementById("y");
for(var i=2015;i<=2060;i++){
var opt = document.createElement("option");
opt.value=i;
opt.innerHTML=i;
select.appendChild(opt);
}
function getstyle(){

	var select = document.getElementById("s");
	 document.getElementById("s").options.length=0; 
	 
	 var obj = document.getElementById("k"); 

	var index = obj.selectedIndex; 
	
	var text = obj.options[index].text; 
	
	var value = obj.options[index].value; 
	
	if(value=="����"){
		var opt = document.createElement("option");
		opt.innerHTML="";
		select.appendChild(opt);
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
		opt.innerHTML="";
		select.appendChild(opt);
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
		opt.innerHTML="";
		select.appendChild(opt);
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