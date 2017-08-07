<%@ page language="java" import="java.util.*,java.sql.*,com.model.*" contentType="text/html; charset=UTF-8"
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
<style type="text/css">
#preview{width:260px;height:190px;border:1px solid #000;overflow:hidden;}
#imghead {filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);}
</style>
<script type="text/javascript">
 		
 		//上传图片浏览功能
        function previewImage(file)
        {
          var MAXWIDTH  = 260; 
          var MAXHEIGHT = 180;
          var div = document.getElementById('preview');
          if (file.files && file.files[0])
          {
              div.innerHTML ='<img id=imghead>';
              var img = document.getElementById('imghead');
              img.onload = function(){
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width  =  rect.width;
                img.height =  rect.height;
//                 img.style.marginLeft = rect.left+'px';
                img.style.marginTop = rect.top+'px';
              }
              var reader = new FileReader();
              reader.onload = function(evt){img.src = evt.target.result;}
              reader.readAsDataURL(file.files[0]);
          }
          else //兼容IE
          {
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
            div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
          }
        }
        function clacImgZoomParam( maxWidth, maxHeight, width, height ){
            var param = {top:0, left:0, width:width, height:height};
            if( width>maxWidth || height>maxHeight )
            {
                rateWidth = width / maxWidth;
                rateHeight = height / maxHeight;
                 
                if( rateWidth > rateHeight )
                {
                    param.width =  maxWidth;
                    param.height = Math.round(height / rateWidth);
                }else
                {
                    param.width = Math.round(width / rateHeight);
                    param.height = maxHeight;
                }
            }
             
            param.left = Math.round((maxWidth - param.width) / 2);
            param.top = Math.round((maxHeight - param.height) / 2);
            return param;
        }
</script>    
</head>
<body>
  <center>
    <form action="FileUpLoad" enctype="multipart/form-data" method="post" >  
          
               ID：<input type="text" name="id" id="i" readonly> <br/>  <br/> 
              <input type="submit" class="btn btn-default" value="提交"/>  
              <div id="preview">
    <img id="imghead" width=100 height=100 border=0 src='<%=request.getContextPath()%>/images/defaul.jpg'>
</div>
<input type="file" onchange="previewImage(this)" name="file1" />   <br>
       年份：<select name="year" id="y" onchange="getid()">
       
       </select>
   季度:<select name="jidu" id="j" onchange="getid()">
   	<option>1</option>
   	<option>2</option>
   	<option>3</option>
   	<option>4</option>
   </select>
   种类:<select name="kind" id="k" onchange="getid()">
   <option>上衣</option>
   <option>下装</option>
   <option>连衣裙</option>
   </select>
   季节:<select name="season">
   	<option>春秋装</option>
   	<option>夏装</option>
   	<option>冬装</option>
   </select><br><br>
   款式:<select name="style" id="s" >
   <option>卫衣</option>
   <option>外套</option>
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
  //循环打印年份
var select = document.getElementById("y");
for(var i=2015;i<=2060;i++){
var opt = document.createElement("option");
opt.value=i;
opt.innerHTML=i;
select.appendChild(opt);
}
</SCRIPT>
<%
	//获取三个种类衣服各自的数量，用以确定ID
	Statement sm=null;
	ResultSet rs=null;
	Connection ct=null;
	ct=new ConnDB().getConn("clothes");
	sm=ct.createStatement();
	int count1=0;
	int count2=0;
	int count3=0;
	rs=sm.executeQuery(
	    "select count(*) from clothes_style where kind= 1 ");
	    if(rs.next()){
	    	count1=rs.getInt(1);//获取上衣的总数
	    }
	rs=sm.executeQuery(
	    "select count(*) from clothes_style where kind= 2 ");
	    if(rs.next()){
	    	count2=rs.getInt(1);//获取下装的总数
	    }
	rs=sm.executeQuery(
	    "select count(*) from clothes_style where kind=3 ");
	    if(rs.next()){
	    	count3=rs.getInt(1);//获取连衣裙的总数
	    }
 %>
 <script type="text/javascript">
 function getid(){//获得ID
 	getstyle();
 	var a;
 	a=document.getElementById("y").value;
 	a=a%100;
 	var b;
 	b=document.getElementById("j").value;
 	
 	var c;
 	var d;
 	var kind=document.getElementById("k").value;
 	if(kind=="上衣"){
 		c=1;
 		d=<%=count1+1%>;
 	}else if(kind=="下装"){
 		c=2;
 		d=<%=count2+1%>;
 	}else{
 		c=3;
 		d=<%=count3+1%>;
 	}
 	
 	if(d<10){
 		document.getElementById("i").value=a+b+c+0+0+d;
 	}else if(d<100){
 		document.getElementById("i").value=a+b+c+0+d;
 	}else{
 		document.getElementById("i").value=a+b+c+d;
 	}
 	
 }
 </script>
<SCRIPT LANGUAGE="JavaScript">
function getstyle(){//获得款式，款式通过种类控制

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
}
</SCRIPT>
</html>
