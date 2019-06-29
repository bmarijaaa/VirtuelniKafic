

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    
<%@ page import="model.User" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.AdminDAO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>administrator page</title>
</head>
<body>

	<%
		User user = (User)session.getAttribute("ovdeJeUserObjekat");
	%>
	
	<h1>DOBRODOŠLI <%=user.getUserName() %> </h1>
	
	<p>Ovo je administratorova strana. Ovde cu ubaciti stvari koje se ticu administratorskih poslova</p>
	
	<a href = "addBalance.jsp"><button>ADD BALANCE</button></a>
	<a href = "addArtikal.jsp"><button>ADD ARTIKAL</button></a><br><br>
	
	<hr>
	<br>
	
	<%
		List<User> listaUsera = new ArrayList<User>();
		listaUsera = AdminDAO.vratiSveUsere();
		
	%>
	
	
	<table border="1">
		<tr>
			<th> ID        </th>
			<th> USER NAME </th>
			<th> PASSWORD  </th>
			<th> NOVCANIK  </th>
		</tr>
		<%
			for(User u: listaUsera){
		%>
			<tr>
				<td> <%= u.getIdUser()   %> </td>
				<td> <%= u.getUserName() %> </td>
				<td> <%= u.getPassword() %> </td>
				<td> <%= u.getNovcanik() %> </td>
			</tr>
		<%
			}
		%>
	</table>
	
</body>
</html>