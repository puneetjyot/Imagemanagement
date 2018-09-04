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
 * Description-Service class used by updateImagename servlet to update the name
 */

package com.nagarro.services;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.hibernateutil.HibernateUtil;
import com.nagarro.model.ImageWrapper;

public class UpdateImageName {

	/**
	 * used to update the given name on the specified imageid
	 * @param name
	 * @param imageid
	 */
	public void updateName(String name, int imageid) 
	
	{
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();		
		
		 
		/**
		 * load the object of image wrapper class for the specified image id and 
		 */
		
		Object obj=session.load(ImageWrapper.class,new Integer(imageid));

		ImageWrapper imageWrapper=(ImageWrapper)obj;
		
		//update the image name here
		
		imageWrapper.setImagename(name);

		session.getTransaction().commit();
		 
		 
		
		
	}

}
