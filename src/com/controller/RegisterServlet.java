package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.*;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String c_p=request.getParameter("check_passwd");
		
		Statement sm=null;
		ResultSet rs=null;
		Connection ct=null;
		try{
			ct=new ConnDB().getConn("users");
			sm=ct.createStatement();
			
			rs=sm.executeQuery("select * from users where username = '"+u+"' " );
			if(!rs.next()){
				if(p.equals(c_p)){
					
					sm.executeUpdate("insert into users values('"+u+"','"+p+"',3)");
					
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else{
					request.setAttribute("err", "2");
					
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
				
			}else{
				request.setAttribute("err", "1");
				
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){rs.close();rs=null;}
				if(sm!=null){sm.close();sm=null;}
				if(ct!=null){ct.close();ct=null;}
			}catch(Exception e){
				e.printStackTrace();
			}
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
