<%@page import="java.util.ArrayList"%>
<%@page import="com.comunenapoli.progetto.model.Auto"%>
<%@page import="java.util.List"%>
<%@page import="com.comunenapoli.progetto.utils.Costanti"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>
</head>
<body>
 <%List<Auto> automobili =  
            (ArrayList<Auto>)request.getSession().getAttribute(Costanti.LISTA_COMPLETA_AUTO); 
        for(Auto a:automobili){%> 
            <tr> 
                <td><%=a.getMarca()%></td> 
               <form action="/Nolejava/autoServlet" method="POST">
               		<input type="hidden" name="idautobtn" value="<%=a.getIdAuto()%>">
               		<input type="submit" value="Vai all'auto">
               </form>
            </tr> 
            <%}%> 
</body>
</html>