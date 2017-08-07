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
    <td>季节</td>
    <td>种类</td>
    <td>款式</td>
    <td>年份</td>
    <td>颜色</td>
    <td>图案</td>
    <td>面料</td>
    <td>领型</td>
    <td>袖型</td>
    <td>季度</td>
  </tr>
  <tr>
    <td><select name="season">
    <option></option>
     <option>春秋装</option>
     <option>夏装</option>
     <option>冬装</option>
     </select></td>
    <td><select name="kind" id="k" onchange="getstyle()">
    <option></option>
     <option >上衣</option>
     <option >下装</option>
     <option >连衣裙</option>
     </select></td>
    <td><select name="style" id="s">
    <option></option>
     </select></td>
    <td><select name="year" id="y" >
    	<option></option>
       
       </select></td>
    <td><select name="color">
    <option></option>
   <option>白色</option>
   <option>灰色</option>
   <option>黑色</option>
   </select></td>
    <td><select name="picture">
    <option></option>
   <option>条纹</option>
   <option>圆点</option>
   </select></td>
    <td><select name="material">
    <option></option>
   <option>棉</option>
   <option>毛呢</option>
   </select></td>
    <td><select name="collar">
    <option></option>
   <option>圆领</option>
   <option>一字领</option>
   </select></td>
    <td><select name="arm">
    <option></option>
   <option>短袖</option>
   <option>长袖</option>
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
     <input name="submit" type="submit" value="搜索" class="btn btn-default"/><br>
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
	
	if(value=="上衣"){
		var opt = document.createElement("option");
		opt.innerHTML="";
		select.appendChild(opt);
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
		opt.innerHTML="";
		select.appendChild(opt);
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
		opt.innerHTML="";
		select.appendChild(opt);
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