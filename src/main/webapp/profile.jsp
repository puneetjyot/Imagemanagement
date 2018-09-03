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
<table class="table text-md-center text-info">
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
	String name=listOfImages[index].getName();
	//out.print()
	int i=name.lastIndexOf('#');
	int j=name.lastIndexOf('.');
	int id=Integer.parseInt(name.substring(i+1,j));
	String imgname=name.substring(0,i);
	
	if(listOfImages[index].isFile())
	{
		out.print("<tr>");
		
		out.print("<td>");
		
		out.print(index+1);
		
		out.print("</td>");
		
		out.print("<td>");
		
		out.print(imgname);
		
		out.print("</td>");
		
		out.print("<td>");
		
		out.print(listOfImages[index].length());
		
		out.print("</td>");
		
		out.print("<td>");
		
		out.print("<img src='"+imageFilePath+"\\"+listOfImages[index].getName()+"'+ height='150' width='150'/>");
		
		out.print("</td>");
		
		out.print("<td>");
		
		
		
		out.print("<input type='button' class='form-control btn-link btn-outline-info text-info' data-toggle='modal' data-target='#exampleModal' value='Update' onclick='updateclicked("+id+")'/>");
		
		out.print("<form method='post' action='DeleteImageServlet'>");
		
		out.print("<input type='hidden' name='id' value='"+id+"'/>");
		
		out.print("<input type='submit' class='form-control btn-link btn-outline-info text-info' value='Delete'/>");

		out.print("</form>");
		
		out.print("</td>");
		
		out.print("</tr>");
    	
    	
    }
}


%>



</table>
<script type="text/javascript">

function updateclicked(id){
	document.cookie="imageid="+id;
	
}


</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
      
      <div class="modal" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Update</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <form class="form-group" method="post" action="updateNameServlet">
                  <input class="form-control" type="text" placeholder="Enter new name" name="imgNewName">
                  <input class="btn btn-info py-1 px-3" type="submit" id="upload-btn" value="Update Name"/>
              </form>
            </div>
            
            <div class="modal-body">
              <form class="form-group" method="post" enctype = "multipart/form-data" action="UpdateImageServlet">
                        <input class="btn btn-outline-info text-info p-0 mr-1" type="file" name="image" accept="image/*"/>
                        <input class="btn btn-info py-1 px-3" type="submit" id="upload-btn" value="Update Image"/>
                  </form>
            </div>
          </div>
        </div>
      </div>


</body>
</html>