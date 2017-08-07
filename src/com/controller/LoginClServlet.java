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
 * Servlet implementation class LoginClServlet
 */
@WebServlet("/LoginClServlet")
public class LoginClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u=request.getParameter("username");
		String p=request.getParameter("passwd");
		HttpSession hs=request.getSession(true);
		
		UserBeanCl ubc=new UserBeanCl();
		if(u.equals("admin"))//�ж��û��������в�ͬ����ת
		{
			if(ubc.checkUser(u, p)){
				System.out.println("success");
				
				//hs.setMaxInactiveInterval(20);sessionʱ��
				hs.setAttribute("uname", u);
				
				request.getRequestDispatcher("wel.jsp").forward(request, response);
				
			}else{
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else{
			if(ubc.checkUser(u, p)){//��֤��¼
				hs.setAttribute("uname", u);
				request.setAttribute("username", u);
				request.getRequestDispatcher("designsearch.jsp").forward(request, response);
				}
			else
				request.getRequestDispatcher("login.jsp").forward(request, response);
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
