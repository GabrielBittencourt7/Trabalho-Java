<%@page import="model.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Usuario usuario = new Usuario();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	
	listaUsuarios = usuarioDAO.read();
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>consultar</title>
</head>
<body>
	<div>
		<table border="1">
			<tr>
				<td style="Width:50px" align="center">Matrícula</td>
				<td style="Width:100px" align="center">Nome</td>
				<td style="Width:50px" align="center">Endereço</td>
				<td style="Width:100px" align="center">Modalidade</td>
				<td style="Width:100px" align="center" colspan=2 >Ações</td>
			</tr>
			<%for(int cont=0; cont< listaUsuarios.size(); cont++) {%>
			<tr>
				<td> <%=listaUsuarios.get(cont).getMatricula() %> </td>
				<td> <%=listaUsuarios.get(cont).getNome() %> </td>
				<td> <%=listaUsuarios.get(cont).getEndereco() %> </td>
				<td> <%=listaUsuarios.get(cont).getModalidade() %> </td>
				<td><a href="Alterar.jsp?matricula=<%=listaUsuarios.get(cont).getMatricula()%>
												   &nome=<%=listaUsuarios.get(cont).getNome()%>
												   &endereco=<%=listaUsuarios.get(cont).getEndereco()%>
												   &modalidade=<%=listaUsuarios.get(cont).getModalidade()%>">Alterar</a> </td>
				<td><a href="Excluir.jsp?matricula=<%=listaUsuarios.get(cont).getMatricula()%>">Excluir</a> </td>
			</tr>
			<%}%>
			
		</table>
		<a href="index.html">Voltar</a>
	</div>
</body>
</html>