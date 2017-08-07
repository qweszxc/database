package com.model;

import java.sql.*;

public class Update {
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	
	private String id;
	private String season;
	private String color;
	private String material;
	private String picture;
	private String collar;
	private String arm;
	
	public void setId(String id) {
		this.id = id;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setCollar(String collar) {
		this.collar = collar;
	}

	public void setArm(String arm) {
		this.arm = arm;
	}

	public void update(){//ÐÞ¸Ä
		try {
			ct=new ConnDB().getConn("clothes");
			
			sm=ct.createStatement();
			
			sm.executeUpdate("update clothes_style"
					+ " set season='"+season+"',color='"+color+"',"
					+ "material='"+material+"',picture='"+picture+"',arm='"+arm+"' "
							+ " where id='"+id+"'");
			
			System.out.println("update clothes_style"
					+ " set season='"+season+"',color='"+color+"',"
					+ "material='"+material+"',picture='"+picture+"',arm='"+arm+"' "
							+ " where id='"+id+"'");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(String i){//É¾³ý
		try {
			ct=new ConnDB().getConn("clothes");
			
			sm=ct.createStatement();
			
			sm.executeUpdate("delete from clothes_style where id='"+i+"'");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
