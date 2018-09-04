package com.nagarro.imagemanagement.services;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.nagarro.imagemanagement.Dao.ImageDao;

public class Refresh {

	public void refresh(String username){

		
		  
		  Map usernamemap=new HashMap();
			
			usernamemap.put("username", username);
			
			ImageDao imagedao=new ImageDao();
			
			imagedao.downloadImage(usernamemap);
		
		
	}
}
