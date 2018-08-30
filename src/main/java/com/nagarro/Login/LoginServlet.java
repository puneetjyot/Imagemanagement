package com.nagarro.Login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.nagarro.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session= sf.openSession();
		session.beginTransaction();		
		Criteria cr = session.createCriteria(User.class);
        // Add restriction.
		 Map conditions=new HashMap();
		
		 conditions.put("username", request.getParameter("username"));
		 conditions.put("password", request.getParameter("password"));
         //cr.add(Restrictions.eqOrIsNull("username", "anmol"));
         cr.add(Restrictions.allEq(conditions));
         List employees = cr.list();
         if(employees.isEmpty()){
        	 System.out.println("no record");
         }
         else{
         User result=(User) employees.get(0);
         System.out.println("hello-> "+result.getUsername()); 
         RequestDispatcher requestDispatcher=request.getRequestDispatcher("/profile.jsp");
 		requestDispatcher.forward(request,response);
	}

}
}
