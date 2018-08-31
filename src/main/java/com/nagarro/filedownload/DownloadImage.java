package com.nagarro.filedownload;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

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
	         for(int index=0;index<images.size();index++){
	         
		 
		ImageWrapper imgNew = (ImageWrapper)images.get(index);;
		
		byte[] bAvatar = imgNew.getData();
		 
		try{
		
		       String imageFilePath=""+new File(".").getAbsolutePath()+"\\images";

		       new File(imageFilePath).mkdir();

			
			FileOutputStream fos = new FileOutputStream(imageFilePath+"\\test"+index+".jpeg");
		    
			fos.write(bAvatar);
		    
			fos.close();
		
		}
		
		catch(Exception e){
		
			e.printStackTrace();
		
		}
	         }
		
		 
	
	}
	
}
