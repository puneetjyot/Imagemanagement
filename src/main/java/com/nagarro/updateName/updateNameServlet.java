package com.nagarro.updateName;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.services.UpdateImageName;

/**
 * Servlet implementation class updateNameServlet
 */
public class updateNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateNameServlet() {
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
	
    	String name=request.getParameter("imgNewName");
    	
	
	  UpdateImageName updateImageName=new UpdateImageName();  
	  updateImageName.updateName(name, imageid);
    
	response.sendRedirect("profile.jsp");
	
	}

}
