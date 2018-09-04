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
 * Description-Image upload servlet uses to upload image into database and calls upload services

 */
package com.nagarro.fileupload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.filedownload.DownloadImage;
import com.nagarro.services.UploadService;

/**
 * Servlet implementation class FileUploadDBServlet
 */

public class FileUploadDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setIntHeader("Refresh", 1);
//		RequestDispatcher requestDispatcher=request.getRequestDispatcher("profile.jsp");
//		
// 		requestDispatcher.include(request,response);
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Here");
		HttpSession httpsession=request.getSession(false);
		String user=(String)httpsession.getAttribute("user");

		UploadService uploadservice=new UploadService();
		uploadservice.upload(request,user);
		
//		if(isSet){
	//	response.setIntHeader("Refresh", 1);
		
		 // HttpSession httpsession=request.getSession(false);
			
		//	String username=(String) httpsession.getAttribute("user");
		  
		  Map conditions=new HashMap();
			
			conditions.put("username", user);
			
			DownloadImage downloadimage=new DownloadImage();
			
			downloadimage.downloadDbImage(conditions);
			
			response.sendRedirect("profile.jsp");
			
		//}
		
			
			
	
	}

}
