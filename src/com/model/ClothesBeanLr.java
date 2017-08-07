package com.model;
import java.sql.*;
import java.util.*;

//ÒÂ·þÂ¼ÈëÀà

public class ClothesBeanLr {
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	
	public void luru(ClothesBean cb){
		try{
			ct=new ConnDB().getConn("clothes");
			sm=ct.createStatement();
			sm.executeUpdate("insert into clothes_style values('"+cb.getId()+"','"+cb.getName()+"',"
					+ "'"+cb.getImg()+"','"+cb.getKind()+"','"+cb.getSeason()+"',"
							+ "'"+cb.getYear()+"','"+cb.getColor()+"',"
							+ "'"+cb.getMaterial()+"','"+cb.getPicture()+"',"
									+ "'"+cb.getCollar()+"','"+cb.getArm()+"')");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
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
}
