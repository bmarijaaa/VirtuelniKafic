
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User"%>
<%@ page import="model.Artikal"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>racun</title>
</head>
<body>
<% 	User user =  (User)session.getAttribute("ovdeJeUserObjekat"); 
	double totalPrice = (Double)request.getAttribute("totalPrice");
	List<Artikal> listaArtikala = (List<Artikal>)request.getAttribute("listaArtikala");
	List<String> listaKolicina = (List<String>)request.getAttribute("listaKolicina");
%>
User: <%=user.getUserName() %> <br><br>
Racun:  <table border="1">
			<tr>
				<th>ime artilka</th>
				<th>cena</th>
				<th>popust</th>
				<th>kolicina</th>
			</tr>
			<% for(int i = 0; i<listaArtikala.size() ; i++){ %>
				<tr>
					<td><%=listaArtikala.get(i).getImeArtikla() %></td>
					<td><%=listaArtikala.get(i).getCena() %></td>
					<td><%=listaArtikala.get(i).getPopust() %></td>
					<td><%=listaKolicina.get(i)%></td>
				</tr>
			<%} %>
		</table>
		
		<br><br>

Total price:<%=totalPrice %> <br><br>

<a href="view/user.jsp">back to user</a>

</body>
</html>