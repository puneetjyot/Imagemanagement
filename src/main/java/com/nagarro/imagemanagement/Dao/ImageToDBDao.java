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
 * Description-Set image in the database by inserting all the attributes of image in model class

 */

package com.nagarro.imagemanagement.Dao;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;

import com.nagarro.imagemanagement.constants.Constant;
import com.nagarro.imagemanagement.model.ImageWrapper;
import com.nagarro.imagemanagement.util.HibernateUtil;

public class ImageToDBDao {
	
	/**
	 * function to Set image in the database by inserting all the attributes of image in model class
	 * @param user
	 */

	public void setimage(String user){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		File file=null;
		File folder = new File(Constant.getPath());
		File[] listOfFiles = folder.listFiles();
		for (File files : listOfFiles) {
		    if (files.isFile()) {
		     file=new File(Constant.getPath()+"\\"+files.getName());
		    }
		
		byte[] imageData = new byte[(int) file.length()];
		 
		try {
		    FileInputStream fileInputStream = new FileInputStream(file);
		    fileInputStream.read(imageData);
		    fileInputStream.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		ImageWrapper image = new ImageWrapper();
		image.setData(imageData);
		image.setUsername(user);
		image.setImagename(files.getName());
		session.save(image);    //Save the data
		 
		session.getTransaction().commit();
		//HibernateUtil.shutdown();
	}
}
}
