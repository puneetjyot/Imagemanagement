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
 * Description- Hibernamte Util class to create session factory and to open session
 */
package com.nagarro.hibernateutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fasterxml.classmate.AnnotationConfiguration;

public class HibernateUtil {
	   private static final SessionFactory sessionFactory = buildSessionFactory();
	      
	    @SuppressWarnings("deprecation")
	    private static SessionFactory buildSessionFactory() {
	        try {
	            // Create the SessionFactory from hibernate.cfg.xml
	            return new Configuration().configure().buildSessionFactory();
	  
	        }
	        catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	  
	    /**
	     * Retrun session factory
	     * @return
	     */
	    
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	  
	    /**
	     * cloase the session
	     */
	    
	    public static void shutdown() {
	        getSessionFactory().close();
	    }
}
