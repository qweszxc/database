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
		request.setCharacterEncoding("gb2312");  //���ñ���  
        
        //��ô����ļ���Ŀ����  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //��ȡ�ļ���Ҫ�ϴ�����·��  
        String path = new String("F:/myeclipse/.metadata/.me_tcat7/webapps/test/imgs") ; 
          
        //���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬  
        //������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ  
        /** 
         * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ�  
         * ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem ��ʽ��  
         * Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ���� 
         */  
        factory.setRepository(new File(path));  
        //���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��  
        factory.setSizeThreshold(1024*1024) ;  
          
        //��ˮƽ��API�ļ��ϴ�����  
        ServletFileUpload upload = new ServletFileUpload(factory);   
        String newname=new String("");
        String n=new String("");
        ClothesBean cb=new ClothesBean();
        try {  
            //�����ϴ�����ļ�  
            List<FileItem> list = (List<FileItem>)upload.parseRequest(request);  
            int nn=0;
            for(FileItem item : list)  
            {  
            	nn++;
            	
                //��ȡ������������  
                String name = item.getFieldName();  
                //�����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ  
                if(item.isFormField())  
                {                     
                    //��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�  
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
                		 if(value.equals("����")){
                			 k=1;
                		 }else if(value.equals("��װ")){
                			 k=2;
                		 }else if(value.equals("����ȹ")){
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
                //�Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ  
                else  
                {  
                    /** 
                     * ������������Ҫ��ȡ �ϴ��ļ������� 
                     */  
                    //��ȡ·����  
                    String value = item.getName() ;  
                    //���������һ����б��  
                    int start = value.lastIndexOf("\\");  
                    //��ȡ �ϴ��ļ��� �ַ������֣���1�� ȥ����б�ܣ�  
                    String filename = value.substring(start+1);  
                    filename=new String(newname+".jpg");
                    //����д��������  
                    //���׳����쳣 ��exception ��׽  
                    System.out.println(filename);
                    //item.write( new File(path,filename) );//�������ṩ��  
                      
                    //�ֶ�д��  
                    OutputStream out = new FileOutputStream(new File(path,filename));  
                      
                    InputStream in = item.getInputStream() ;  
                    int length = 0 ;  
                    byte [] buf = new byte[1024] ;  
                      
                    System.out.println("��ȡ�ϴ��ļ����ܹ���������"+item.getSize());  
  
                    // in.read(buf) ÿ�ζ��������ݴ����   buf ������  
                    while( (length = in.read(buf) ) != -1)  
                    {  
                        //��   buf ������ ȡ������ д�� ���������������  
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
