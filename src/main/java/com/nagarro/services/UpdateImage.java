package com.nagarro.services;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;

import com.nagarro.Session.ImageToDBDao;
import com.nagarro.constants.Constant;
import com.nagarro.hibernateutil.HibernateUtil;
import com.nagarro.model.ImageWrapper;

public class UpdateImage {
	
	public void updateImage(int imageid, HttpServletRequest request){
	Session session= HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();		

	Object obj=session.load(ImageWrapper.class,new Integer(imageid));

	ImageWrapper imageWrapper=(ImageWrapper)obj;

		 File file=null ;
	    int maxFileSize = Constant.filemaxsize;
	    int maxMemSize = Constant.MemMaxSize;
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
	 
	        System.out.println("JSP file uploaded");
	 
	          while ( i.hasNext () ) {
	             FileItem fi = (FileItem)i.next();
	             if ( !fi.isFormField () ) {
	                // Get the uploaded file parameters
	                String fieldName = fi.getFieldName();
	                String fileName = fi.getName();
	                boolean isInMemory = fi.isInMemory();
	                long sizeInBytes = fi.getSize();
	 
	                System.out.println(fileName);
	                
	            //     Write the file
//	                if( fileName.lastIndexOf("\\") >= 0 ) {
//	                   file = new File( filePath + 
//	                   fileName.substring( fileName.lastIndexOf("\\"))) ;
//	                } else {
//	                   file = new File( filePath + 
//	                   fileName.substring(fileName.lastIndexOf("\\")+1)) ;
//	                }
//	                fi.write( file ) ;
	                
	                file=new File(fileName);
	                System.out.println("Uploaded Filename: " + filePath + 
	                fileName + "<br>");
	                byte[] imageData = new byte[(int) file.length()];
	       		 
	        		try {
	        		    FileInputStream fileInputStream = new FileInputStream(file);
	        		    fileInputStream.read(imageData);
	        		    fileInputStream.close();
	        		    imageWrapper.setData(imageData);

	        			session.getTransaction().commit();
	        		} catch (Exception e) {
	        		    e.printStackTrace();
	        		}
	             }
	          }
	        
//	          ImageToDBDao image=new ImageToDBDao();
//	          image.setimage(user);
          
	       } catch(Exception ex) {
	          System.out.println(ex);
	       }
	      
	    } else
	    {
	    	System.out.println("No image uploaded");
	    }
	  
		//ImageWrapper image = new ImageWrapper();
		//image.setData(imageData);
//		image.setUsername(user);
//		image.setImagename(files.getName());
//		session.save(image);    //Save the data
		 






	 
	
	
	
}
}