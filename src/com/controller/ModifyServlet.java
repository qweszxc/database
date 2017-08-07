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
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("gb2312");
		
		//获取表单传递的信息
		
		String name=(String)request.getParameter("style");
		String season=(String)request.getParameter("season");
		String color=(String)request.getParameter("color");
		String picture=(String)request.getParameter("picture");
		String material=(String)request.getParameter("material");
		String collar=(String)request.getParameter("collar");
		String arm=(String)request.getParameter("arm");
		
		String id=(String)request.getParameter("id");
		System.out.println(id);
		
		//调用Update类修改信息
		
		Update ud=new Update();
		ud.setArm(arm);
		ud.setCollar(collar);
		ud.setColor(color);
		ud.setId(id);
		ud.setMaterial(material);
		ud.setPicture(picture);
		ud.setSeason(season);
		ud.update();
		
		HttpSession hs=request.getSession(true);
		//因为信息已修改，之前的搜索结果清除
		hs.removeAttribute("atotal");
		
		request.getRequestDispatcher("adminsearch.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
