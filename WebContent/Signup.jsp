<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<a href="Homepage.jsp">Home</a>
	<a href="FAQ.jsp">FAQs</a>
	<a href="Login.jsp">Login</a>
	<a href="Signup.jsp">Signup</a>
	<h2 class="title">Registration Info</h2>
                    <form method="get" action="RegisterServlet">
                        <div class="input-group">
                            <input class="input--style-3" type="text" placeholder="Name" name="name" required/>
                        </div>
                        
                          <div class="input-group">
                            <input class="input--style-3" type="password" placeholder="Password" name="pwd" required/>
                        </div>
                        
                          <div class="input-group">
                            <input class="input--style-3" type="password" placeholder="Confirm Password" name="cpwd" required/>
                        </div>
                        
                         <div class="input-group">
                            <input class="input--style-3" type="number" placeholder="Phone" name="mno" required>
                        </div>
                        
                        <div class="input-group">
                            <input class="input--style-3" type="text" placeholder="Address" name="addr" required/>
                        </div>
           
                        <div class="input-group">
                            <input class="input--style-3" type="email" placeholder="Email" name="mail" required/>
                        </div>
                        
                       
                        <div class="p-t-10">
                            <button class="btn btn--pill btn--green" type="submit">Register</button>
                        </div>
                    </form>
  
</body>
</html>