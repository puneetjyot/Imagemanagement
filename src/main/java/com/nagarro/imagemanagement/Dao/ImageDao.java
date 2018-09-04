package com.nagarro.imagemanagement.Dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.imagemanagement.model.ImageWrapper;
import com.nagarro.imagemanagement.services.ImageService;
import com.nagarro.imagemanagement.util.HibernateUtil;

public class ImageDao 

{
	ImageService imageService=new ImageService();	
	
	public void updateImageName(String name, int imageid){

		
		
	Session session= HibernateUtil.getSessionFactory().openSession();
	
	session.beginTransaction();		
	
	 /**
	 * load the object of image wrapper class for the specified image id and 
	 */

	
		imageService.updateImageName(name, imageid,session);
	

	session.getTransaction().commit();
	 
	 
	}
	
	public void updateImage(int imageid, HttpServletRequest request){
		Session session= HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();		
		
		imageService.updateImage(imageid,request,session);
		
		session.getTransaction().commit();
		
	}
	public void downloadImage(Map conditions){
	

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		/**
		 * Checks the condition and download the image for the logged in user
		 */

		imageService.downloadImage(conditions,session);
	}
	
	public void deleteImage(HashMap<String,Integer> conditions){
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();		
		imageService.deleteImage(conditions, session);
		 
		 session.getTransaction().commit();
	}
	
}
