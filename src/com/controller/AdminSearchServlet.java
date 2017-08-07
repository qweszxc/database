package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import com.model.*;

/**
 * Servlet implementation class AdminSearchServlet
 */
@WebServlet("/AdminSearchServlet")
public class AdminSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("gb2312");
		String season=request.getParameter("season");
		String kind=request.getParameter("kind");
		String style=request.getParameter("style");
		String year=request.getParameter("year");
		String color=request.getParameter("color");
		String picture=request.getParameter("picture");
		String material=request.getParameter("material");
		String collar=request.getParameter("collar");
		String arm=request.getParameter("arm");
		try{
			Search search=new Search();
			search.setSeason(season);
			search.setKind(kind);
			search.setName(style);
			search.setYear(year);
			search.setColor(color);
			search.setPicture(picture);
			search.setMaterial(material);
			search.setCollar(collar);
			search.setArm(arm);
			
			HttpSession hs=request.getSession(true);
			
			ArrayList all=search.adminsearch();
			
			hs.setAttribute("atotal", all);

			request.getRequestDispatcher("adminsearch.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
