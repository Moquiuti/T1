<!DOCTYPE html>
<%@page import="projetoFinal.Classes.Cliente"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="estiloform.css">
<style type="text/css">
@import url("estiloform.css");
</style>
<title>Cliente</title>
<%@include file="header.html" %>
</head>
<body>
	<%
		Cliente cliente = (Cliente) request.getAttribute("cli");
	%>
	<form action="ClienteServlet" method="POST">

		<fieldset>
			<fieldset class="grupo">
				<div class="campo">
					<input type="hidden" name="id" value="<%=cliente.getId()%>">


					<label> Nome: </label> <input type="text" name="nome"
						value="<%=cliente.getNome()%>"> <label> Email: </label> <input
						type="text" name="email" value="<%=cliente.getEmail()%>">

					<label> Telefone: </label> <input type="text" name="telefone"
						value="<%=cliente.getTelefone()%>">
			</fieldset>
			</div>
		</fieldset>
<button class="botao submit" type="submit" >Salvar</button>
					<button class="botao submit" type="reset" onclick="location.href='http://localhost:8080/projetoFinal/menuprincipal.jsp'">Retornar</button>
	</form>
</body>
</html>