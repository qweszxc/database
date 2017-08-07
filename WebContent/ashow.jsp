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
<%
  	HttpSession hs=request.getSession(true);
  	ArrayList all=(ArrayList)hs.getAttribute("atotal");//获取搜索结果列表
  	
  	if(all!=null){
  		
  		Search search=new Search();
  		int pageNow=1;
  		String s_pageNow=(String)request.getParameter("pageNow");
  		if(s_pageNow!=null){
  			pageNow=Integer.parseInt(s_pageNow);
  		}
  		int pageCount=all.size()/5+1-(all.size()-all.size()/5*5)/5;//列表分页页数
  		
  		ArrayList al=search.fenye(pageNow, 5, all);//获取当前页码的列表
   %>
    
    <table width="100%" height="100%" border="1">
    
    <%
    	for(int i=0;i<5;i++){
    		out.print("<tr>");
    			if(i<al.size()){
	    			ClothesBean cb=(ClothesBean)al.get(i);
    				out.print("<td width='15%' height='18%'><img src='./imgs/"+cb.getId()+".jpg' height='100%' width='100%'/></td>");
    				out.print("<td>"+cb.getSeason()+"</td>");
    				out.print("<td>"+cb.getName()+"</td>");
    				out.print("<td>"+cb.getYear()+"</td>");
    				out.print("<td>"+cb.getColor()+"</td>");
    				out.print("<td>"+cb.getPicture()+"</td>");
    				out.print("<td>"+cb.getCollar()+"</td>");
    				out.print("<td>"+cb.getMaterial()+"</td>");
    				out.print("<td>"+cb.getArm()+"</td>");
    				//out.print("<td>&nbsp;</td>");
    				out.print("<td><a href='modify.jsp?id="+cb.getId()+"'>修改</a>"
    				+"<br><br><a href='DeleteServlet?id="+cb.getId()+"'>删除</a></td>");
    			}
    		out.print("</tr>");
    	}
     %>
    
  
  <tr>
    <td height="10%" colspan="11"><div align="center">
    <%
    	for(int i=1;i<=pageCount;i++){//分页
    			out.println("<a href='adminsearch.jsp?pageNow="+i+"'>"+i+"</a>");
    		}
     %>
    </div></td>
  </tr>
</table>
    
    <%} %>
</body>
</html>