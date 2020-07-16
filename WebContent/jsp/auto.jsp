<%@page import="com.comunenapoli.progetto.model.Auto"%>
<%@page import="com.comunenapoli.progetto.utils.Costanti"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Auto auto = (Auto)request.getSession().getAttribute(Costanti.AUTO_IN_SESSION); %>
<%= auto.toString()%>
	<form action="/Nolejava/noleggioServlet" method="POST">
		<input type="submit" value="Continua prenotazione">
	</form>

</body>
</html>