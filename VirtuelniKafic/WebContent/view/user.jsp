<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user page</title>
</head>
<body>
	<%
		User user = (User)session.getAttribute("ovdeJeUserObjekat");
	%>
	<h1>DOBRODOSLI USER</h1>
	
	<p>Ovde cu ubaciti stvari koje se ticu usera</p>

	
	ZDRAVO <%=user.getUserName() %>
</body>
</html>