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
 * Description-Download Databse image to the folder

 */

package com.nagarro.filedownload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.hibernateutil.HibernateUtil;

import com.nagarro.model.ImageWrapper;
import com.nagarro.model.User;

public class DownloadImage {

	/**
	 * download db image
	 * @param conditions
	 */
	
	public void downloadDbImage(Map conditions){
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		/**
		 * Checks the condition and download the image for the logged in user
		 */

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
	
}
