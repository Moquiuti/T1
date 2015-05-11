<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estiloform.css">
<style type="text/css">
@import url("estiloform.css");
</style>
<title>Cadastrar Evento</title>
<%@include file="header.html" %>
</head>
<body>
	<form action="EventoController" method="POST">
		<fieldset>
			<input type="hidden" name="id">
			<fieldset class="grupo">
				<input type="hidden" name="id"> <label>Descrição: </label> <input
					type="text" name="descricao"> 
					<button class="botao submit" type="submit" >Salvar</button>
					<button class="botao submit" type="reset" onclick="location.href='http://localhost:8080/projetoFinal/menuprincipal.jsp'">Retornar</button>
			</fieldset>
			</div>
		</fieldset>
	</form>
</body>
</html>