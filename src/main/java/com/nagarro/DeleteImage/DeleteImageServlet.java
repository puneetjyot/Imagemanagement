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
 * Description- Delete image from the table
 */
package com.nagarro.DeleteImage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.filedownload.DownloadImage;
import com.nagarro.services.DeleteImage;

/**
 * Servlet implementation class DeleteImage
 */
public class DeleteImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteImageServlet() {
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

	
		int id=Integer.parseInt(request.getParameter("id"));
		
		HashMap<String,Integer> conditions=new HashMap<String, Integer>();
		conditions.put("id", id);
		DeleteImage deleteImage=new DeleteImage();
		deleteImage.deleteImage(conditions);
		
		/**
		 * used to refresh everytime redirecting to profile jsp 
		 */
		
		HttpSession httpsession=request.getSession(false);
			
			String username=(String) httpsession.getAttribute("user");
		  
		  Map usernamemap=new HashMap();
			
			usernamemap.put("username", username);
			
			DownloadImage downloadimage=new DownloadImage();
			
			downloadimage.downloadDbImage(usernamemap);
		
		response.sendRedirect("profile.jsp");

	}

}
