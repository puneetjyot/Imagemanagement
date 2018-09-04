/*
 * Assignment Advance java 2
 *
 * JDK Version 1.8
 *
 * Puneetjyot Singh(Trainee Technology)
 *
 * Creation date-24/07/2018
 *
 * Last updated By- 02/07/2018
 *
 * Description-Upload Service class uses to upload selected file after checking the size of file and setting the image

 */

package com.nagarro.imagemanagement.services;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nagarro.imagemanagement.Dao.ImageToDBDao;
import com.nagarro.imagemanagement.constants.Constant;

public class UploadService {

	public void upload(HttpServletRequest request, String user) {
		// TODO Auto-generated method stub
		

		  		 File file=null ;
		  	    int maxFileSize = 1024 * 1024;
		  	    int maxMemSize = 1024 * 1024 * 10;
		  	    //ServletContext context = request.getServletContext();
		  String filePath = Constant.getPath();

		  	 
		  	    // Verify the content type
		  	    String contentType = request.getContentType();
		  	 
		  	    if ((contentType.indexOf("multipart/form-data") >= 0)) {
		  	       DiskFileItemFactory factory = new DiskFileItemFactory();
		  	       // maximum size that will be stored in memory
		  	       factory.setSizeThreshold(maxMemSize);
		  	 
		  	       // Location to save data that is larger than maxMemSize.
		  	       factory.setRepository(new File("c:\\temp"));
		  	 
		  	       // Create a new file upload handler
		  	       ServletFileUpload upload = new ServletFileUpload(factory);
		  	 
		  	       // maximum file size to be uploaded.
		  	       upload.setSizeMax( maxFileSize );
		  	 
		  	       try { 
		  	          // Parse the request to get file items.
		  	          List fileItems = upload.parseRequest(request);
		  	 
		  	          // Process the uploaded file items
		  	          Iterator i = fileItems.iterator();
		  	 
		  	        
		  	          System.out.println("JSP File upload");  
		  	        
		  	 
		  	          while ( i.hasNext () ) {
		  	             FileItem fi = (FileItem)i.next();
		  	             if ( !fi.isFormField () ) {
		  	                // Get the uploaded file parameters
		  	                String fieldName = fi.getFieldName();
		  	                String fileName = fi.getName();
		  	                boolean isInMemory = fi.isInMemory();
		  	                long sizeInBytes = fi.getSize();
		  	 
		  	                // Write the file
		  	                if( fileName.lastIndexOf("\\") >= 0 ) {
		  	                   file = new File( filePath + 
		  	                   fileName.substring( fileName.lastIndexOf("\\"))) ;
		  	                } else {
		  	                   file = new File( filePath + 
		  	                   fileName.substring(fileName.lastIndexOf("\\")+1)) ;
		  	                }
		  	                fi.write( file ) ;
		  	                System.out.println("Uploaded Filename: " + filePath + 
		  	                fileName );
		  	             }
		  	          }
		  	         
		  	          ImageToDBDao image=new ImageToDBDao();
		  	          image.setimage(user);
		  	       } catch(Exception ex) {
		  	          System.out.println(ex);
		  	       }
		  	       finally{
		  	    	   file.delete();
		  	       }
		  	    } else {
		  	   	 System.out.println("No file uploaded");
		  	    }
		
	}

	
	
}
