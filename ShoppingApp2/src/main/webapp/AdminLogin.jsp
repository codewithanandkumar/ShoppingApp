<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="test.AdminBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<%
		AdminBean ab=(AdminBean)session.getAttribute("abean");
		out.println("Page belongs to : "+ab.getFname()+"<br>");
		
	%>
	<a href="product.html">Add Product</a>
	<a href="view">View All Product</a>
	<a href="logout"> Logout</a>
</body>
</html>