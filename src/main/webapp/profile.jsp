<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Profile</title>

</head>
<body>
<%@ page import="java.io.File" %>
<h2 style="color:blue;text-align:center">Image Management Utility</h2>
<hr>
<h4>Please select an image file to upload(Max size 1 MB)</h4>

<div style="display: flex; justify-content: center">
<form class="form-inline mt-3" method="post" action="FileUploadDBServlet" enctype = "multipart/form-data" >
<input class="form-control" type=file name=browse style="display: inline accept="image/*"/>
	<input class="form-control" type="submit" value="Confirm" >
	<input class="form-control" type="button" value="Cancel &nbsp;">
	</form>
</div>
<br>
<br>
<p>
Uploaded images
</p>
<table border="1" width="1300" style="text-align:center">
<tr>
<th>S.NO</th>
<th>Name</th>
<th>Size</th>
<th>Preview</th>
<th>Action</th>
</tr>

<% 
String imageFilePath=new File(".").getAbsolutePath()+"\\images";
File folder = new File(imageFilePath);
File[] listOfImages = folder.listFiles();
for(int index=0;index<listOfImages.length;index++)
{
	if(listOfImages[index].isFile())
	{
		out.print("<tr>");
		
		out.print("<td>");
		
		out.print(index);
		
		out.print("</td>");
		
		out.print("<td>");
		
		out.print(listOfImages[index].getName());
		
		out.print("</td>");
		
		out.print("<td>");
		
		out.print(listOfImages[index].length());
		
		out.print("</td>");
		
		out.print("<td>");
		
		out.print("<img src='"+imageFilePath+"\\"+listOfImages[index].getName()+"'+ height='150' width='150'/>");
		
		out.print("</td>");
		
		
		out.print("</tr>");
    	
    	
    }
    
}


%>

</table>


</body>
</html>