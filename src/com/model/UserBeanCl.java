package com.model;
import java.sql.*;
import java.util.*;
public class UserBeanCl {
	
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;

	private int pageSize=4;//һҳ������
	private int rowCount=0;//��������
	private int pageCount=0;//ҳ��
	
	
	public int getpageCount(){//����ҳ��
		try{
			ct=new ConnDB().getConn("users");
			sm=ct.createStatement();
	    	
	    	rs=sm.executeQuery("select count(*) from users");
	    	
	    	if(rs.next())
	    		rowCount=rs.getInt(1);
	    	
	    	if(rowCount%pageSize==0){
	    		pageCount=rowCount/pageSize;
	    	}else{
	    		pageCount=rowCount/pageSize+1;
	    	}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return pageCount;
	}
	public ArrayList getUserByPage(int pageNow){//ͨ����ǰҳ�����û��б�
		ArrayList al=new ArrayList();
		try{
			ct=new ConnDB().getConn("users");
			sm=ct.createStatement();
	    	
	    	rs=sm.executeQuery("select top "+pageSize
	    	+" * from users where userid not in(select top " +pageSize*(pageNow-1)
	    	+" userid from users)");
	    	
	    	while(rs.next()){
	    		UserBean ub=new UserBean();
	    		ub.setUserid(rs.getInt(1));
	    		ub.setUsername(rs.getString(2));
	    		ub.setPasswd(rs.getString(3));
	    		ub.setGrade(rs.getInt(4));
	    		al.add(ub);
	    	}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return al;
	}
	
	public void close(){
		try{
			if(rs!=null){rs.close();rs=null;}
			if(sm!=null){sm.close();sm=null;}
			if(ct!=null){ct.close();ct=null;}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean checkUser(String u,String p){//��֤��¼
		boolean b= false;
		try{
			ct=new ConnDB().getConn("users");
			
			sm=ct.createStatement();
	    	
	    	rs=sm.executeQuery(
	    			"select passwd from users where username='"+u+"'");
	    						
	    	if(rs.next()){
	    		if(rs.getString(1).equals(p)){
	    			b=true;
	    		}
	    	}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return b;
	}
	public void zhuce(UserBean ub){//ע��
		try{
			ct=new ConnDB().getConn("users");
			
			sm=ct.createStatement();
	    	
	    	sm.executeUpdate("insert into users values('"+ub.getUserid()+"','"+ub.getPasswd()+"','3')");
	    						
	    	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
	}
}
