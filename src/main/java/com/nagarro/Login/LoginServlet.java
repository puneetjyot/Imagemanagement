package com.nagarro.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.nagarro.Session.LoginDao;
import com.nagarro.filedownload.DownloadImage;
import com.nagarro.hibernateutil.HibernateUtil;
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession httpsession=request.getSession();
		httpsession.setAttribute("user",username);
		
		LoginDao logindao=new LoginDao();
		boolean validate= logindao.login(username,password);
		
		if(validate){
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/profile.jsp");
 		requestDispatcher.forward(request,response);
 		
 		
 		//session.getTransaction().commit();
      //  HibernateUtil.shutdown();
		}
		else{
			PrintWriter out=response.getWriter();
			out.print("<font size='3' color='red' style= 'text-align:center' >Invalid Users</font>");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("./");
		
	 		requestDispatcher.include(request,response);
			
		}
		
	}
}
