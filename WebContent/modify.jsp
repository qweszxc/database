<%@ page language="java" import="java.util.*,com.model.*" contentType="text/html; charset=UTF-8"
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
  		String id=request.getParameter("id");//获取所修改衣服的ID
  		Search search=new Search();
  		ClothesBean cb=search.getclothes(id);//找到衣服
  		
   %>
    <form action="ModifyServlet"  method="post" >  
          
      ID：<input type="text" name="id" id="i" value="<%=id%>" readonly > <br/><br/> 
       <input type="submit" class="btn btn-default" value="提交"/>  
       <div>
    <img id="imghead" width=100 height=100 border=0 src='./imgs/<%=id%>.jpg'>
</div> <br>
     
 <select name="kind" id="k" style="display:none">
   </select>
   季节:<select name="season">
   	<option>春秋装</option>
   	<option>夏装</option>
   	<option>冬装</option>
   </select><br><br>
   款式:<select name="style" id="s" >
   </select>
   &nbsp;
   颜色:<select name="color">
   <option>白色</option>
   <option>灰色</option>
   <option>黑色</option>
   </select>
   图案:<select name="picture">
   <option>条纹</option>
   <option>圆点</option>
   </select>
   面料:<select name="material">
   <option>棉</option>
   <option>毛呢</option>
   </select><br><br>
   领型:<select name="collar">
   <option>圆领</option>
   <option>一字领</option>
   </select>
   袖型:<select name="arm">
   <option>短袖</option>
   <option>长袖</option>
   </select>
     </form>  
     </center>
  </body>
  <SCRIPT LANGUAGE="JavaScript">

	//获取种类，控制款式
	value =<%=cb.getKind()%>;
	
	
	var select = document.getElementById("s");

	if(value=="1"){
		var opt = document.createElement("option");
		opt.value="卫衣";
		opt.innerHTML="卫衣";
		select.appendChild(opt);
		var opt = document.createElement("option");
		opt.value="外套";
		opt.innerHTML="外套";
		select.appendChild(opt);
	}else if(value=="2"){
		var opt = document.createElement("option");
		opt.value="牛仔裤";
		opt.innerHTML="牛仔裤";
		select.appendChild(opt);
		var opt = document.createElement("option");
		opt.value="休闲裤";
		opt.innerHTML="休闲裤";
		select.appendChild(opt);
	}else{
		var opt = document.createElement("option");
		opt.value="连衣裙";
		opt.innerHTML="连衣裙";
		select.appendChild(opt);
		var opt = document.createElement("option");
		opt.value="背心裙";
		opt.innerHTML="背心裙";
		select.appendChild(opt);
	}

</SCRIPT>
</html>
