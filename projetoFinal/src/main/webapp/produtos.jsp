<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="projetoFinal.Classes.Produto"%>
<%@page import="projetoFinal.Util.GerenciadorProduto"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="estiloform.css">
<style type="text/css">
@import url("estiloform.css");
</style>
<title>Listar Produtos</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produtos</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function confirmaExclusao(id) {
		confirmou = window.confirm("Tem Certeza que deseja Excluir?")
		if (confirmou == true) {
			location.href = "ProdutoController?acao=exc&id=" + id;
		}
	}
</script>
<%@include file="header.html" %>
</head>
<body>
	<fieldset>
		<fieldset class="grupo">
			<div class="campo">
				<h1>Lista de Produtos</h1>
				<table>
					<tr class="alt">
						<td>ID</td>
						<td>Descri��o</td>
						<td>Valor</td>
					</tr>
					<%
						//Scriptlet
						List<Produto> produtos;
						produtos = (List<Produto>) request.getAttribute("pro");

						for (int i = 0; i < produtos.size(); i++) {
							Produto p = produtos.get(i);
					%>

					<tr>
						<td><%=p.getId()%></td>
						<td><%=p.getDescricao()%></td>
						<td><%=p.getValor()%></td>
						<td><button class="botao submit" type="submit" onclick="location.href='javascript:confirmaExclusao(<%=p.getId()%>)'">EXCLUIR</button></td>
						<td><button class="botao submit" type="submit" onclick="location.href='ProdutoController?acao=edit&id=<%=p.getId()%>'">EDITAR</button></td>
					</tr>
					<%
						}
					%>
				</table>
					<button class="botao submit" type="reset" onclick="location.href='http://localhost:8080/projetoFinal/menuprincipal.jsp'">Retornar</button>
			</div>
		</fieldset>
	</fieldset>
</body>
</html>