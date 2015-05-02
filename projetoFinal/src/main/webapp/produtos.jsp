<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="java.util.List"%>
   <%@page import="projetoFinal.Classes.Produto"%>
   <%@page import="projetoFinal.Util.GerenciadorProduto"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
<link rel="stylesheet" type="text/css" href="estilo.css">
<style type="text/css">
@import url("estilo.css");
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function confirmaExclusao(id) {
		confirmou = window.confirm("Tem Certeza que deseja Excluir?")
		if (confirmou == true) {
			location.href = "ProdutoController?acao=exc&id=" + id;
		}
	}
</script>
</head>
<body>

	<h1>Lista de Produtos</h1>
	<table>
		<tr>
			<td>ID</td>
			<td>Descrição</td>
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
			<td><a href='javascript:confirmaExclusao(<%=p.getId()%>)'>
					excluir </a></td>
			<td>
		<a href='ProdutoController?acao=edit&id=<%=p.getId()%>'> editar </a>
			</td>
			</tr>
		<%
			}
		%>
	</table>
</html>