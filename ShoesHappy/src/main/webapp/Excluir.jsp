<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Usuario usuario = new Usuario();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	usuario.setMatricula(Integer.parseInt(request.getParameter("matricula")));
	usuarioDAO.delete(usuario);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir</title>
</head>
<body>
	<h1>Produto excluido com sucesso!</h1>
	<a href="consultar.jsp">voltar</a>
</body>
</html>