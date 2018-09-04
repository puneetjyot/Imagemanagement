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
 * Description-Update Image servlet

 */

package com.nagarro.updateimage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.filedownload.DownloadImage;
import com.nagarro.services.UpdateImage;

/**
 * Servlet implementation class UpdateImageServlet
 */
public class UpdateImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateImageServlet() {
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
		
		int imageid=0;
		
		  Cookie[] cookies=request.getCookies();
		    if(cookies!=null){
		    	for(Cookie cookie:cookies){
		    		if(cookie.getName().equals("imageid")){
		    			imageid=Integer.parseInt(cookie.getValue());
		    		}
		    	}
		    }
			
	//	    	String name=request.getParameter("imgNewName");	}

	//System.out.println(request.getParameter("image"));
	
		UpdateImage updateImage=new UpdateImage();
		
		updateImage.updateImage(imageid, request);
		
		
		/**
		 * used to refresh everytime redirecting to profile jsp 
		 */
		
		HttpSession httpsession=request.getSession(false);
	
		String username=(String) httpsession.getAttribute("user");
		
		Map conditions=new HashMap();
		
		conditions.put("username", username);
		
		DownloadImage downloadimage=new DownloadImage();
  		
		downloadimage.downloadDbImage(conditions);
  		
		response.sendRedirect("profile.jsp");
		
	}

}

