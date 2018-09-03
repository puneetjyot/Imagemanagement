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

	public void downloadDbImage(Map conditions){
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		

		Criteria cr = session.createCriteria(ImageWrapper.class);
		
		  cr.add(Restrictions.allEq(conditions));
		  
	         List images = cr.list();
	        
	         System.out.println();
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
