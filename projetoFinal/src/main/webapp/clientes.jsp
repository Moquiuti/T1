<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="projetoFinal.Classes.Cliente"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="estiloform.css">
<style type="text/css">
@import url("estiloform.css");
</style>
<title>Listar Cliente</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function confirmaExclusao(id) {
		confirmou = window.confirm("Tem Certeza que deseja Excluir?")
		if (confirmou == true) {
			location.href = "ClienteController?acao=exc&id=" + id;
		}
	}
</script>
<%@include file="header.html" %>
</head>
<body>
	<fieldset>
		<fieldset class="grupo">
			<div class="campo" >
				<h1>Lista de Clientes</h1>
				<table>
					<tr class="alt">
						<td>ID</td>
						<td>Nome</td>
						<td>Telefone</td>
						<td>Email</td>
					</tr>
					<%
						//Scriptlet
						List<Cliente> clientes = (List<Cliente>) request
								.getAttribute("cli");

						for (int i = 0; i < clientes.size(); i++) {
							Cliente c = clientes.get(i);
					%>

					<tr>
						<td><%=c.getId()%></td>
						<td><%=c.getNome()%></td>
						<td><%=c.getTelefone()%></td>
						<td><%=c.getEmail()%></td>
						<td><button class="botao submit" type="submit" onclick="location.href='javascript:confirmaExclusao(<%=c.getId()%>)'">EXCLUIR</button></td>
						<td><button class="botao submit" type="submit" onclick="location.href='ClienteController?acao=edit&id=<%=c.getId()%>'">EDITAR</button></td>
					</tr>
					<%
						}
					%>
				</table>
					<button class="botao submit" type="reset" onclick="location.href='http://localhost:8080/projetoFinal/menuprincipal.jsp'">RETORNAR</button>
			</div>
		</fieldset>
	</fieldset>
</body>
</html>