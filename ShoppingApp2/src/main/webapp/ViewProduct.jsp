<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>

	<%
	AdminBean ab=(AdminBean)session.getAttribute("abean");
	out.println("Page belongs to "+ab.getFname()+"<br>");
		ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("al");
		ListIterator<ProductBean> itr=al.listIterator();
		if(al.size()==0)
		{
			out.println("product not available");
		}
	   	while(itr.hasNext())
		{
	   	ProductBean pcol=(ProductBean)itr.next();
		out.println(pcol.getCode()+"&nbsp"+pcol.getName()+"&nbsp"+pcol.getPrice()+"&nbps"+pcol.getQty()+"&nbsp"+"<a href='edit?'</a>");
		}
	%>
	<br><br>
<a href="product.html">Add Product</a>&nbsp;&nbsp;&nbsp;
<a href="logout">logout</a>
</body>
</html>