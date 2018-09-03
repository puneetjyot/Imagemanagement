package com.nagarro.services;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.hibernateutil.HibernateUtil;
import com.nagarro.model.ImageWrapper;


public class DeleteImage {

	public void deleteImage(HashMap<String,Integer> conditions){
		
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();		
		Criteria cr = session.createCriteria(ImageWrapper.class);
		
		 cr.add(Restrictions.allEq(conditions));
		 
		 List images=cr.list();
		 
		 session.delete(images.get(0));
		 
		 session.getTransaction().commit();
		
		
	}
	
}
