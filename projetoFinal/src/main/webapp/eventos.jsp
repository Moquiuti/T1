<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="projetoFinal.Classes.Evento"%>
<%@page import="projetoFinal.Util.GerenciadorEvento"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="estiloform.css">
<style type="text/css">
@import url("estiloform.css");
</style>
<title>Listar Eventos</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function confirmaExclusao(id) {
		confirmou = window.confirm("Tem Certeza que deseja Excluir?")
		if (confirmou == true) {
			location.href = "EventoController?acao=exc&id=" + id;
		}
	}
</script>
<%@include file="header.html" %>
</head>
<body>
	<fieldset>
		<fieldset class="grupo">
			<div class="campo">
				<h1>Lista de Eventos</h1>
				<table>
					<tr class="alt">
						<td>ID</td>
						<td>Descrição</td>
					</tr>
					<%
						//Scriptlet
						List<Evento> eventos;
						eventos = (List<Evento>) request.getAttribute("eto");

						for (int i = 0; i < eventos.size(); i++) {
							Evento e = eventos.get(i);
					%>

					<tr>
						<td><%=e.getId()%></td>
						<td><%=e.getDescricao()%></td>
						<td><button class="botao submit" type="submit" onclick="location.href='javascript:confirmaExclusao(<%=e.getId()%>)'">EXCLUIR</button></td>
						<td><button class="botao submit" type="submit" onclick="location.href='EventoController?acao=edit&id=<%=e.getId()%>'">EDITAR</button></td>
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