package com.nagarro.Session;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.filedownload.DownloadImage;
import com.nagarro.hibernateutil.HibernateUtil;
import com.nagarro.model.User;

public class LoginDao {
	
	public boolean login(String username, String password){
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();		
		Criteria cr = session.createCriteria(User.class);
        // Add restriction.
		 Map conditions=new HashMap();
		
		 conditions.put("username", username);
		 conditions.put("password", password);
         cr.add(Restrictions.allEq(conditions));
         List employees = cr.list();
         if(employees.isEmpty()){
        	 
        	 return false;
         }
         else{
         User result=(User) employees.get(0);
         System.out.println("hello-> "+result.getUsername());
         conditions.remove("password");
  		DownloadImage downloadimage=new DownloadImage();
  		downloadimage.downloadDbImage(conditions);
         
         
	}

         session.getTransaction().commit();
       //  HibernateUtil.shutdown();
         return true;
	}

}
