<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {font-family: Arial, Helvetica, sans-serif;margin: 0;}

ul.topnav {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

ul.topnav li {float: left;}

ul.topnav li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

ul.topnav li a:hover:not(.active) {background-color: #111;}

ul.topnav li a.active {background-color: #04AA6D;}

ul.topnav li.right {float: right;}

@media screen and (max-width: 600px) {
  ul.topnav li.right, 
  ul.topnav li {float: none;}
}
</style>
</head>
<body>
<%   
	String name=(String)session.getAttribute("uname"); 
%> 
<ul class="topnav">
  <li><a class="active" href="welcome.jsp">Home</a></li>
  <% if (name==null) { %>
	  <li><a href="login.jsp">Login</a></li>
	  <li><a href="signup.jsp">Sign up</a></li>
  <% } else { %>
  	<li><a href="logout">Logout</a></li>
   <% } %>
  <li class="right"><a href="#about">Notes</a></li>
</ul>

<div style="padding:0 16px;">
  <h2>Wecome to keepClone</h2>
	 
	
	<% if (name!=null) { %>
         <% out.print("welcome  "+name); %>
    <% } else { %>
         <p> Login for more info</p>
    <% } %>
</div>

</body>
</html>


