<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>administrator page</title>
</head>
<body>
	<h1>DOBRODOŠLI ADMIN </h1>
	
	<p>Ovo je administratorova strana. Ovde cu ubaciti stvari koje se ticu administratorskih poslova</p>
	
	<%
	int a = 5;
	int b = 3;
	
	int rez = a + b;
	String tekst = "Ovo je moj tekst u javi!";
	
	%>
	
	Adminov omiljeni broj je: <%=rez %> <br>
	A tekst je: <%=tekst %><br>
	
	<% for(int i = 1; i<=5;i++){ %>
	
	BROJ: <%=i %><br>
	
	<%} %>
	
</body>
</html>