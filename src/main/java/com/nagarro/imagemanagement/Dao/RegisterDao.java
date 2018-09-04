/*
 * Assignment Advance java 2
 *
 * JDK Version 1.8
 *
 * Puneetjyot Singh(Trainee Technology)
 *
 * Creation date-24/09/2018
 *
 * Last updated By- 02/09/2018
 *
 * Description-Login servlet uses to login into application and calls login services to validate

 */

package com.nagarro.imagemanagement.Dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.imagemanagement.model.User;
import com.nagarro.imagemanagement.util.HibernateUtil;

public class RegisterDao {
/**
 * 
 * @param username
 * @param password
 */
	
	public void register(String username,String password){
	
	Session session= HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	User user =new User();
	user.setUsername(username);
	user.setPassword(password);
	session.save(user);
	session.getTransaction().commit(); 
    HibernateUtil.shutdown();
	}
	
	
}
