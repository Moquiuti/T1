<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="projetoFinal.Classes.Evento"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estiloform.css">
<style type="text/css">
@import url("estiloform.css");
</style>
<title>Alterar Evento</title>
<%@include file="header.html" %>
</head>
<body>
	<%
		Evento eve = (Evento) request.getAttribute("eto");
	%>
	<form action="EventoController" method="POST">
		<fieldset>
			<fieldset class="grupo">
				<div class="campo">

					<input type="hidden" name="id" value="<%=eve.getId()%>"> <label>
						Descricao: </label> <input type="text" name="descricao"
						value="<%=eve.getDescricao()%>">
			</fieldset>
			</div>
		</fieldset>
		<button class="botao submit" type="submit" >Salvar</button>
					<button class="botao submit" type="reset" onclick="location.href='http://localhost:8080/projetoFinal/menuprincipal.jsp'">Retornar</button>
	</form>

</body>
</html>