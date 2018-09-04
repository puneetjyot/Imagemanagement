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
 * Description-Constant class used to store the constants 

 */

package com.nagarro.imagemanagement.constants;

public class Constant 
{
	
	public static int filemaxsize=1024 * 1024;
	
	public static int MemMaxSize=10*1024*1024;
	
	public static int megabyte=1024 * 1024;
	
private static String path="C:\\apache-tomcat5.5.29\\webapps\\data";

public static String getPath() {
	return path;
}

public static void setPath(String path) {
	Constant.path = path;
}
	
}
