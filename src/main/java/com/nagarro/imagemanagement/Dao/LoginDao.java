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
 * Description-Login DAO and services which validates the user

 */

package com.nagarro.imagemanagement.Dao;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.imagemanagement.model.User;
import com.nagarro.imagemanagement.util.HibernateUtil;

public class LoginDao {
	
	 

	public boolean login(String username, String password) {
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(User.class);
		
		// Add restriction.
		
		Map conditions = new HashMap();

		conditions.put("username", username);
		
		conditions.put("password", password);
		
		cr.add(Restrictions.allEq(conditions));
		
		List employees = cr.list();
		
		if (employees.isEmpty()) {

			
			return false;
		}
		
		else {
		
			User result = (User) employees.get(0);
			
		//	System.out.println("hello-> " + result.getUsername());
			
			conditions.remove("password");

			
		//	DownloadImage downloadimage = new DownloadImage();
			ImageDao imagedao=new ImageDao();
			imagedao.downloadImage(conditions);

		}

		session.getTransaction().commit();
		// HibernateUtil.shutdown();
		return true;
	}

}
