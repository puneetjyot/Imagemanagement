package com.nagarro.Session;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.model.User;

public class RegisterDao {

	public void register(String username,String password){
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session= sf.openSession();
	session.beginTransaction();
	User user =new User();
	user.setUsername(username);
	user.setPassword(password);
	session.save(user);
	session.getTransaction().commit(); 
	}
	
	
}
