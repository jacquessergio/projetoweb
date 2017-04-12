<%@page
	import="br.com.fabricaweb.projetoweb.persistencia.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@page
	import="br.com.fabricaweb.projetoweb.persistencia.jdbc.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		int id = 0;
		String labelButton = "", queryString = "", nome = "", login = "", senha = "";

		if (request.getParameter("id") != null) {

			id = Integer.parseInt(request.getParameter("id"));

			Usuario in = new UsuarioDAO().buscaPorId(id);

			id = in.getId();
			nome = in.getNome();
			login = in.getLogin();
			senha = in.getSenha();
		}

		String action = request.getParameter("action");

		if (action.equals("add")) {

			labelButton = "Cadastrar";

		} else if (action.equals("alter")) {

			labelButton = "Alterar";
			queryString = "?action=alter&id=" + id;

		} else if (action.equals("del")) {

			labelButton = "Excluir/Confirmar";
			queryString = "?action=del&id=" + id;

		}
	%>

	<form action="usucontroller<%=queryString%>" method="post">

		<label>ID:</label> 
			<input type="text" name="id" value="<%=id%>" /> 
		<br />
		<label>Nome:</label> 
			<input type="text" name="nome" value="<%=nome%>" />
		<br /> 
		<label>Login:</label> 
			<input type="text" name="login"value="<%=login%>" /> 
		<br />
		<label>Senha:</label>
			<input type="password" name="senha" value="<%=senha%>"> 
		<br />
			<button><%=labelButton%></button>

	</form>

</body>
</html>