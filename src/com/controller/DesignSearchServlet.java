package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.*;
import java.util.*;

@WebServlet("/DesignSearchServlet")
public class DesignSearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取表单传递的信息
		
		request.setCharacterEncoding("gb2312");
		String season=request.getParameter("season");
		String kind=request.getParameter("kind");
		String style=request.getParameter("style");
		request.setAttribute("season", season);
		request.setAttribute("kind", kind);
		request.setAttribute("style", style);
		
		//调用Search类搜索
		String s_pageNow=(String)request.getParameter("pageNow");
		int pageNow=Integer.parseInt(s_pageNow);
		try{
			Search s=new Search();
			s.setSeason(season);
			s.setKind(kind);
			s.setName(style);
			
			ArrayList all=s.designersearch();
			
			HttpSession hs=request.getSession(true);
			hs.setAttribute("dtotal", all);//把搜索结果放入session
			
			int pageCount=all.size()/3+all.size()%3;
			
			ArrayList al=s.fenye(1, 3, all);
			
			request.setAttribute("pageCount", Integer.toString(pageCount));
			request.setAttribute("result", al);
			request.setAttribute("total", all);
			request.setAttribute("pageNow", s_pageNow);
			request.getRequestDispatcher("designsearch.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}

}
