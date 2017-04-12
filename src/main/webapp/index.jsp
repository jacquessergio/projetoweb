<%@page import="java.util.List"%>
<%@page import="br.com.fabricaweb.projetoweb.persistencia.entidade.Usuario"%>
<%@page import="br.com.fabricaweb.projetoweb.persistencia.jdbc.UsuarioDAO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP - Beginner</title>
</head>
<body>

	<%
		//EXEMPLO 1
		List<Usuario> in =  new UsuarioDAO().buscaTodos();
		
		//EXEMPLO 2
	    //List<Usuario> us = getUser.buscaTodos();
	%>
		<h3><a href="usuario.jsp?action=add">Cadastrar novo (+)</a></h3>
		<table border="1" bordercolor="red">
			<% for(Usuario u : in){ %>
				<tr>
					<td><%=u.getNome() %></td>		
					<td><%=u.getLogin() %></td>	
					<td><%=u.getSenha() %></td>
					<td><a href="usuario.jsp?id=<%=u.getId()%>&action=alter">Editar</a></td>
					<td><a href="usuario.jsp?id=<%=u.getId()%>&action=del">Ecluir</a></td>
				</tr>
			<% } %>
		
		</table>
	
	

   
</body>
</html>