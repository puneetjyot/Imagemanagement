package com.nagarro.Session;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;

import com.nagarro.constants.Constant;
import com.nagarro.hibernateutil.HibernateUtil;
import com.nagarro.model.ImageWrapper;

public class ImageToDBDao {

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
		HibernateUtil.shutdown();
	}
}
}
