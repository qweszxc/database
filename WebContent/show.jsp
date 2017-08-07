<%@ page language="java" import="java.util.*,com.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  	HttpSession hs=request.getSession(true);
  	ArrayList all=(ArrayList)hs.getAttribute("dtotal");
  	
  	if(all!=null){
  		
  		Search search=new Search();
  		int pageNow=1;
  		String s_pageNow=(String)request.getParameter("pageNow");
  		if(s_pageNow!=null){
  			pageNow=Integer.parseInt(s_pageNow);
  		}
  		int pageCount=all.size()/3+1-(all.size()-all.size()/3*3)/3;
  		
  		ArrayList al=search.fenye(pageNow, 3, all);
   %>
   
  <table width="100%" height="100%" border="1">
  <tr>
  <% 
  	for(int i=0;i<3;i++){
  		if(i<al.size()){
  			System.out.println(((ClothesBean)al.get(i)).getId());
    		out.print("<td width='33%' height='70%'><img src='./imgs/"
    		+((ClothesBean)al.get(i)).getId()+".jpg' height='100%' width='100%'/></td>");
    	}else{
    		out.print("<td width='33%' height='70%'></td>");
    	}
    }
    %>
  </tr>
  <tr>
  <%
  	for(int i=0;i<3;i++){
  		if(i<al.size()){
  			String s=((ClothesBean)al.get(i)).getName();
  			String c=((ClothesBean)al.get(i)).getColor();
  			String arm=((ClothesBean)al.get(i)).getArm();
  			String collar=((ClothesBean)al.get(i)).getCollar();
  			String sea=((ClothesBean)al.get(i)).getSeason();
  			out.print("<td height='20%'>款式："+s+"&nbsp;季节："+sea+"&nbsp;颜色："+
  			c+"&nbsp;领型："+collar+"&nbsp;袖型："+arm+"</td>");
  		}else
  		{
  			out.print("<td height='20%'>&nbsp;</td>");
  		}
  	}
   %>
  </tr>
  <tr>
    <td height="10%" colspan="3"><div align="center">
    	<%
    		for(int i=1;i<=pageCount;i++){
    			out.println("<a href='designsearch.jsp?pageNow="+i+"'>"+i+"</a>");
    		}
    	 %>
    </div></td>
  </tr>
</table>
<%} %>
  </body>
</html>
