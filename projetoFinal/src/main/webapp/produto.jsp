<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="projetoFinal.Classes.Produto"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estiloform.css">
<style type="text/css">
@import url("estiloform.css");
</style>
<title>Alterar Produto</title>
<%@include file="header.html" %>
</head>
<body>
	<%
		Produto produto = (Produto) request.getAttribute("pro");
	%>
	<form action="ProdutoController" method="POST">

		<fieldset>
			<fieldset class="grupo">
				<div class="campo">
					<input type="hidden" name="id" value="<%=produto.getId()%>">


					<label> Descricao: </label> <input type="text" name="descricao"
						value="<%=produto.getDescricao()%>"> <label>
						Valor: </label> <input type="text" name="valor"
						value="<%=produto.getValor()%>">
			</fieldset>
			</div>
		</fieldset>
	<button class="botao submit" type="submit" >Salvar</button>
					<button class="botao submit" type="reset" onclick="location.href='http://localhost:8080/projetoFinal/menuprincipal.jsp'">Retornar</button>
	</form>

</body>
</html>