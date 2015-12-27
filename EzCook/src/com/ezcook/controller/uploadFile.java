package com.ezcook.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class uploadFile
 */
public class uploadFile  {
	protected static String upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int maxFilesize=500*1024;
		int maxMemSize=40*1024;
		File file;
		String filePath="D:\\try";
		String username=request.getParameter("name");
	      System.out.println("username: "+filePath);

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	      if( !isMultipart ){
	          return "";
	       }

	      //tao bo dem
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File("C:\\temp"));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // maximum file size to be uploaded.
	      upload.setSizeMax(maxFilesize);
	      try
	      {
	          // Parse the request to get file items.
	           List fileItems = upload.parseRequest(request);
	    	
	          // Process the uploaded file items
	          Iterator i = fileItems.iterator();
	          while ( i.hasNext () ) 
	          {
	             FileItem fi = (FileItem)i.next();
	             if ( !fi.isFormField() )	
	             {
	            	 Date now=new Date();
	            	 String fileName=now.getYear()+"_"+now.getMonth()+"_"+now.getDay()+"_"+now.getHours()+"_"+now.getMinutes()+"_"+now.getSeconds()+"_"+Math.random();
	            	 fileName+="."+fi.getName().substring(fi.getName().lastIndexOf("."));
	            	 filePath=filePath+"\\"+fileName;
	            	 File myfile=new File(filePath);
	            	 fi.write(myfile);
	             }
	          }

	      }
	      catch(Exception ex){
	    	  System.out.println(ex);
	      }
	      return filePath;
	}

}
