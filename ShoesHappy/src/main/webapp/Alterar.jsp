<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="model.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>
    
<%
	Usuario usuario = new Usuario();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="UsuarioServlet" method="get">
			<table>
				<tr>
					<td>Matricula:</td>
					<td> <input type="text" name="matricula" value="<%=request.getParameter("matricula")%>"> </td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td> <input type="text" name="nome" value="<%=request.getParameter("nome")%>"> </td>
				</tr>
				<tr>
					<td>Endereço:</td>
					<td> <input type="text" name="ender" value="<%=request.getParameter("endereco")%>"> </td>
				</tr>
				<tr>
					<td>Modalidade:</td>
					<td> <input type="text" name="mod" value="<%=request.getParameter("modalidade")%>"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Atualizar">
						<input type="reset" value="Resetar">
					</td>
				</tr>
			</table>
			<a href="Consultar.jsp">voltar</a>
		</form>
	</div>
</body>
</html>