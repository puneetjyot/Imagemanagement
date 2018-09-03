package com.nagarro.services;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.hibernateutil.HibernateUtil;
import com.nagarro.model.ImageWrapper;

public class UpdateImageName {

	public void updateName(String name, int imageid) 
	
	{
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();		
		
		 
		Object obj=session.load(ImageWrapper.class,new Integer(imageid));

		ImageWrapper imageWrapper=(ImageWrapper)obj;
		
		imageWrapper.setImagename(name);

		session.getTransaction().commit();
		 
		 
		
		
	}

}
