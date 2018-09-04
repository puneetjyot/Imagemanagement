package com.nagarro.imagemanagement.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.imagemanagement.constants.Constant;
import com.nagarro.imagemanagement.model.ImageWrapper;

public class ImageService
{

	public void updateImageName(String name, int imageid, Session session){
	
		Object obj=session.load(ImageWrapper.class,new Integer(imageid));

		ImageWrapper imageWrapper=(ImageWrapper)obj;
		
		//update the image name here
		
		imageWrapper.setImagename(name);
		
	}

	public void updateImage(int imageid, HttpServletRequest request, Session session) {

		Object obj = session.load(ImageWrapper.class, new Integer(imageid));

		ImageWrapper imageWrapper = (ImageWrapper) obj;

		File file = null;
		int maxFileSize = Constant.filemaxsize;
		int maxMemSize = Constant.MemMaxSize;
		// ServletContext context = request.getServletContext();
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
			upload.setSizeMax(maxFileSize);

			try {
				// Parse the request to get file items.
				List fileItems = upload.parseRequest(request);

				// Process the uploaded file items
				Iterator i = fileItems.iterator();

				System.out.println("JSP file uploaded");

				while (i.hasNext()) {
					FileItem fi = (FileItem) i.next();
					if (!fi.isFormField()) {
						// Get the uploaded file parameters
						
						String fileName = fi.getName();

						System.out.println(fileName);

						file = new File(fileName);
						
						System.out.println("Uploaded Filename: " + filePath + fileName);
					
						byte[] imageData = new byte[(int) file.length()];

						/**
						 * read the image data and set that data in image wrapper model class to update the image
						 */
						
						try {
							FileInputStream fileInputStream = new FileInputStream(file);
							fileInputStream.read(imageData);
							fileInputStream.close();
							imageWrapper.setData(imageData);

						//	session.getTransaction().commit();
						} 
						catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

			} 
			catch (Exception ex) {
				System.out.println(ex);
			}

		} 
		else {
			System.out.println("No image uploaded");
		}	
		
	}

	public void downloadImage(Map conditions,Session session) {

		Criteria cr = session.createCriteria(ImageWrapper.class);
		
		  cr.add(Restrictions.allEq(conditions));
		  
	         List images = cr.list();
	        
	         System.out.println();
	         
	         //setting image path as absolute file path 
	         String imageFilePath=""+new File(".").getAbsolutePath()+"\\images";

		       File cleanfile=new File(imageFilePath);
		       try {
				
		    	   FileUtils.cleanDirectory(cleanfile);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		       
		       new File(imageFilePath).mkdir();

	         for(int index=0;index<images.size();index++){
	         
		 
		ImageWrapper imgNew = (ImageWrapper)images.get(index);;
		
		String imagename=imgNew.getImagename();
		
		byte[] bAvatar = imgNew.getData();
		 
		try{
		
			/**
			 * Write the image to the file path specified
			 */
		     
			
			FileOutputStream fos = new FileOutputStream(imageFilePath+"\\"+imagename+"#"+imgNew.getId()+".jpeg");
		    
			fos.write(bAvatar);
		    
			fos.close();
		
		}
		
		catch(Exception e){
		
			e.printStackTrace();
		
		}
	         }
		
	}
	
	
	public void deleteImage(HashMap<String,Integer> conditions,Session session){
		Criteria cr = session.createCriteria(ImageWrapper.class);
		
		 cr.add(Restrictions.allEq(conditions));
		 
		 List images=cr.list();
		 
		 session.delete(images.get(0));
	}
	
	
	
	
}
