package com.nagarro.constants;

public class Constant 
{
	
	public static int filemaxsize=1024 * 1024;
	
	public static int MemMaxSize=10*1024*1024;
	
private static String path="C:\\apache-tomcat5.5.29\\webapps\\data";

public static String getPath() {
	return path;
}

public static void setPath(String path) {
	Constant.path = path;
}
	
}
