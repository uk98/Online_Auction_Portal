<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<a href="Homepage.jsp">Home</a>
	<a href="FAQ.jsp">FAQs</a>
	<a href="Login.jsp">Login</a>
	<a href="Signup.jsp">Signup</a>
	<div class="login-box">
        <h1>Login here</h1>
        <form method="get" action="LoginServlet">
        	<p>Login ID</p>
        		<input type="text" name="custid" placeholder=" enter your login id" required>
            <p>Password</p>
	            <input type="password" name="custpass" placeholder="enter your password" required><br>
	            <input type="submit" value="Login"><br>
	        <a href="registration.html">Register yourself </a> 
        </form>
    </div>
</body>
</html>