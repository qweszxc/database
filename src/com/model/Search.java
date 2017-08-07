package com.model;

import java.sql.*;
import java.util.*;

public class Search {
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	
	private String id;
	private String name;
	private String kind;
	private String season;
	private String year;
	private String color;
	private String material;
	private String picture;
	private String collar;
	private String arm;
	public void close(){
		try{
			if(rs!=null){rs.close();rs=null;}
			if(sm!=null){sm.close();sm=null;}
			if(ct!=null){ct.close();ct=null;}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ClothesBean getclothes(String id){//根据ID找到对应衣服
		ClothesBean cb=new ClothesBean();
		
		try {
			ct=new ConnDB().getConn("clothes");
			sm=ct.createStatement();
			
			rs=sm.executeQuery("select * from clothes_style where id='"+id+"'");
			
			if(rs.next()){
				cb.setId(rs.getString(1));
	    		cb.setName(rs.getString(2));
	    		cb.setImg(rs.getString(3));
	    		cb.setKind(rs.getInt(4));
	    		cb.setSeason(rs.getString(5));
	    		cb.setYear(rs.getInt(6));
	    		cb.setColor(rs.getString(7));
	    		cb.setMaterial(rs.getString(8));
	    		cb.setPicture(rs.getString(9));
	    		cb.setCollar(rs.getString(10));
	    		cb.setArm(rs.getString(11));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cb;
	}
	
	public ArrayList fenye(int pageNow,int pageSize,ArrayList all){//分页
		ArrayList al=new ArrayList();
		int count=0;
		for(int i=pageSize*(pageNow-1);i<all.size();i++){
			if(count>pageSize-1)
				break;
			al.add(all.get(i));
			count++;
			
		}
		return al;
	}
	
	public ArrayList adminsearch(){//系统管理员搜索
		ArrayList al=new ArrayList();
		String n;
		String k;
		String s;
		String y;
		String co;
		String m;
		String p;
		String c;
		String a;
		if(name.equals(""))//如果下拉表为空，该属性没有约束，把n置为'name'
			n="name";	   //sql语句中 where name=name永远为真，相当于搜索所有衣服
		else
			n="\'"+name+"\'";
		if(kind.equals(""))
			k="kind";
		else if(kind.equals("上衣"))
			k="1";
		else if(kind.equals("下装"))
			k="2";
		else 
			k="3";
		if(season.equals(""))
			s="season";
		else s="\'"+season+"\'";
		if(year.equals(""))
			y="year";
		else y=year;
		if(color.equals(""))
			co="color";
		else co="\'"+color+"\'";
		if(material.equals(""))
			m="material";
		else m="\'"+material+"\'";
		if(picture.equals(""))
			p="picture";
		else p="\'"+picture+"\'";
		if(collar.equals(""))
			c="collar";
		else c="\'"+collar+"\'";
		if(arm.equals(""))
			a="arm";
		else a="\'"+arm+"\'";
		System.out.println(p);
		try{
			ct=new ConnDB().getConn("clothes");
			
			sm=ct.createStatement();
			
			System.out.println("select * from clothes_style where "
					+ "name="+n+" and kind="+k+" and season="+s+" and "
					+ "year="+y+" and color="+co+" and material="+m+" and "
					+ "picture="+p+" and collar="+c+" and arm="+a);
			
			rs=sm.executeQuery("select * from clothes_style where "
					+ "name="+n+" and kind="+k+" and season="+s+" and "
					+ "year="+y+" and color="+co+" and material="+m+" and "
					+ "picture="+p+" and collar="+c+" and arm="+a);
			
			
			
			while(rs.next()){
	    		ClothesBean cb=new ClothesBean();
	    		cb.setId(rs.getString(1));
	    		cb.setName(rs.getString(2));
	    		cb.setImg(rs.getString(3));
	    		cb.setKind(rs.getInt(4));
	    		cb.setSeason(rs.getString(5));
	    		cb.setYear(rs.getInt(6));
	    		cb.setColor(rs.getString(7));
	    		cb.setMaterial(rs.getString(8));
	    		cb.setPicture(rs.getString(9));
	    		cb.setCollar(rs.getString(10));
	    		cb.setArm(rs.getString(11));
	    		al.add(cb);
	    	}
			
			System.out.println(al.size());
			
		}catch (Exception e){
			e.printStackTrace();
		}
		return al;
	}
	
	public ArrayList designersearch(){
		ArrayList al=new ArrayList();
		int k;
		if(kind.equals("上衣")){
			k=1;
		}else if(kind.equals("下装")){
			k=2;
		}else{
			k=3;
		}
		
		try{
			ct=new ConnDB().getConn("clothes");
			
			sm=ct.createStatement();
	    	
	    	rs=sm.executeQuery(
	    			"select * from clothes_style where season='"+season+"' and kind="+k+" and name='"+name+"'");
	    					
	    	System.out.println("select * from clothes_style where season='"+season+"' and kind="+k+" and name='"+name+"'");
	    	while(rs.next()){
	    		ClothesBean cb=new ClothesBean();
	    		cb.setId(rs.getString(1));
	    		cb.setName(rs.getString(2));
	    		cb.setImg(rs.getString(3));
	    		cb.setKind(rs.getInt(4));
	    		cb.setSeason(rs.getString(5));
	    		cb.setYear(rs.getInt(6));
	    		cb.setColor(rs.getString(7));
	    		cb.setMaterial(rs.getString(8));
	    		cb.setPicture(rs.getString(9));
	    		cb.setCollar(rs.getString(10));
	    		cb.setArm(rs.getString(11));
	    		al.add(cb);
	    	}
	    	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return al;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind=kind;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCollar() {
		return collar;
	}

	public void setCollar(String collar) {
		this.collar = collar;
	}

	public String getArm() {
		return arm;
	}

	public void setArm(String arm) {
		this.arm = arm;
	}
}
