package com.nagarro.Session;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.hibernateutil.HibernateUtil;
import com.nagarro.model.User;

public class RegisterDao {

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
