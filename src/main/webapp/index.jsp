<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Login Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
	.login-content {
		background: aliceblue;
    	text-align: center;
    	padding: 20px;
    	border-radius: 10px;
	}
</style>
</head>
<body>
<form method="post" class="container" action="LoginServlet">

<div id="login-box" class="login-content">
<h2>Login Page</h2>
Please provide your credential to use this website
<br>
<br>
<div id="login-box-name" style="margin-top:20px;">User Id:</div>
<div id="login-box-field" style="margin-top:20px;margin-bottom:20px">
<input name="username" class="form-login" title="username" value="" size="30" maxlength="50" required/>
</div>
<div id="login-box-name">Password:</div>
<div id="login-box-field" style="margin-top:20px; margin-bottom:20px">
<input name="password" type="password" class="form-login" title="Password" value="" size="30" maxlength="48" required/>
</div>
<br />
<span class="login-box-options">
New User?  <a href="Register.jsp" style="margin-left:30px;">Register Here</a>
</span>
<br />
<br />
<input type="submit" value="Login" />
</div>
</form>
</body>
</html>