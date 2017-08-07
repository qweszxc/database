package com.model;

//连接数据库类
import java.sql.*;
public class ConnDB {
	private Connection ct=null;
	
	public Connection getConn(String name){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
		    
	    	ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1444;DatabaseName="+name+"",
															"sa","1234");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ct;
	}
}
