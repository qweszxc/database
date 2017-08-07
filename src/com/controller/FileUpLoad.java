package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;  
import java.io.*;  
import java.util.List;  
import com.model.*;
import org.apache.commons.fileupload.*;
//import org.apache.commons.fileupload.FileUploadException;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload; 

/**
 * Servlet implementation class FileUpLoad
 */
@WebServlet("/FileUpLoad")
public class FileUpLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("gb2312");  //设置编码  
        
        //获得磁盘文件条目工厂  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //获取文件需要上传到的路径  
        String path = new String("F:/myeclipse/.metadata/.me_tcat7/webapps/test/imgs") ; 
          
        //如果没以下两行设置的话，上传大的 文件 会占用 很多内存，  
        //设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同  
        /** 
         * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上，  
         * 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的  
         * 然后再将其真正写到 对应目录的硬盘上 
         */  
        factory.setRepository(new File(path));  
        //设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室  
        factory.setSizeThreshold(1024*1024) ;  
          
        //高水平的API文件上传处理  
        ServletFileUpload upload = new ServletFileUpload(factory);   
        String newname=new String("");
        String n=new String("");
        ClothesBean cb=new ClothesBean();
        try {  
            //可以上传多个文件  
            List<FileItem> list = (List<FileItem>)upload.parseRequest(request);  
            int nn=0;
            for(FileItem item : list)  
            {  
            	nn++;
            	
                //获取表单的属性名字  
                String name = item.getFieldName();  
                //如果获取的 表单信息是普通的 文本 信息  
                if(item.isFormField())  
                {                     
                    //获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的  
                	if(name.equals("id")){
	                    String value = item.getString() ;  
	                    newname= new String(value);
	                    request.setAttribute(name, value);  
	                    cb.setId(newname);
	                    cb.setImg(newname);
                	}else if(name.equals("style")){
	                    String value = new String(item.getString("gb2312")) ;
	                    cb.setName(value);
                	}else if(name.equals("season")){
                		String value = new String(item.getString("gb2312")) ;
	                    cb.setSeason(value);
                	}else if(name.equals("kind")){
                		 String value = new String(item.getString("gb2312")) ;
                		 int k=1;
                		 if(value.equals("上衣")){
                			 k=1;
                		 }else if(value.equals("下装")){
                			 k=2;
                		 }else if(value.equals("连衣裙")){
                			 k=3;
                		 }
 	                    cb.setKind(k);
                	}else if(name.equals("year")){
                		String value = new String(item.getString("gb2312")) ;
	                    cb.setYear(Integer.parseInt(value));
                	}else if(name.equals("color")){
                		String value = new String(item.getString("gb2312")) ;
	                    cb.setColor(value);
                	}else if(name.equals("material")){
                		String value = new String(item.getString("gb2312")) ;
	                    cb.setMaterial(value);
                	}else if(name.equals("picture")){
                		String value = new String(item.getString("gb2312")) ;
	                    cb.setPicture(value);
                	}else if(name.equals("collar")){
                		String value = new String(item.getString("gb2312")) ;
	                    cb.setCollar(value);
                	}else if(name.equals("arm")){
                		String value = new String(item.getString("gb2312")) ;
	                    cb.setArm(value);
                	}
                	
                }  
                //对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些  
                else  
                {  
                    /** 
                     * 以下三步，主要获取 上传文件的名字 
                     */  
                    //获取路径名  
                    String value = item.getName() ;  
                    //索引到最后一个反斜杠  
                    int start = value.lastIndexOf("\\");  
                    //截取 上传文件的 字符串名字，加1是 去掉反斜杠，  
                    String filename = value.substring(start+1);  
                    filename=new String(newname+".jpg");
                    //真正写到磁盘上  
                    //它抛出的异常 用exception 捕捉  
                    System.out.println(filename);
                    //item.write( new File(path,filename) );//第三方提供的  
                      
                    //手动写的  
                    OutputStream out = new FileOutputStream(new File(path,filename));  
                      
                    InputStream in = item.getInputStream() ;  
                    int length = 0 ;  
                    byte [] buf = new byte[1024] ;  
                      
                    System.out.println("获取上传文件的总共的容量："+item.getSize());  
  
                    // in.read(buf) 每次读到的数据存放在   buf 数组中  
                    while( (length = in.read(buf) ) != -1)  
                    {  
                        //在   buf 数组中 取出数据 写到 （输出流）磁盘上  
                        out.write(buf, 0, length);  
                          
                    }
                    
                    
                    out.flush();
                    
                    in.close();  
                    out.close();  
                    n=new String(path+"\\"+filename);
                    request.setAttribute("name", filename);   
                }  
            }  
              
              
              
        } catch (FileUploadException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } 
        
 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ClothesBeanLr cbl=new ClothesBeanLr();
        cbl.luru(cb);
        request.getRequestDispatcher("filedemo.jsp").forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
