<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="UsuarioServlet" method="post">
			<table>
				<tr>
					<td>Nome:</td>
					<td> <input type="text" name="nome"> </td>
				</tr>
				<tr>
					<td>Endereço:</td>
					<td> <input type="text" name="ender"> </td>
				</tr>
				<tr>
					<td>Modalidade:</td>
					<td> <input type="text" name="mod"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Cadastrar">
					</td>
				</tr>
			</table>
			<a href="index.html">voltar</a>
		</form>
	</div>

</body>
</html>