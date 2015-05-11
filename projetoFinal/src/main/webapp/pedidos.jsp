<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="projetoFinal.Classes.Pedido"%>
<%@page import="projetoFinal.Util.GerenciadorPedido"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="estiloform.css">
<style type="text/css">
@import url("estiloform.css");
</style>
<title>Listar Pedidos</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function confirmaExclusao(id) {
		confirmou = window.confirm("Tem Certeza que deseja Excluir?")
		if (confirmou == true) {
			location.href = "PedidoController?acao=exc&id=" + id;
		}
	}
</script>
<title>Pedido</title>
<%@include file="header.html" %>
</head>
<body style="width: 600px;margin-left:5%;">
	<fieldset>
		<fieldset class="grupo">
			<div class="campo">
				<h1>Lista de Pedidos</h1>
				<table>
					<tr class="alt">
						<td>Código do Pedido</td>
						<td>Código do Cliente</td>
						<td>Origem do Pedido</td>
						<td>Cerimonial</td>
						<td>Horario do Evento</td>
						<td>Indicação</td>
						<td>Local do Evento</td>
						<td>Endereco do Evento</td>
						<td>Observação</td>
						<td>Tipo do Evento</td>
						<td>Data do evento</td>
						<td>Data do Pedido</td>
					</tr>
					<%
						//Scriptlet
						List<Pedido> pedidos;
						pedidos = (List<Pedido>) request.getAttribute("pdo");

						for (int i = 0; i < pedidos.size(); i++) {
							Pedido ped = pedidos.get(i);
					%>

					<tr>
						<td><%=ped.getId()%></td>
						<td><%=ped.getCliente().getNome()%></td>
						<td><%=ped.getOrigemPedido()%></td>
						<td><%=ped.getCeriominal()%></td>
						<td><%=ped.getHoraEvento()%></td>
						<td><%=ped.getIndicacao()%></td>
						<td><%=ped.getLocalEvento()%></td>
						<td><%=ped.getEnderecoEvento()%></td>
						<td><%=ped.getObs()%></td>
						<td><%=ped.getTipoEvento().getDescricao()%></td>	
						<td><%=ped.getDataEvento()%></td>
						<td><%=ped.getDataPedido()%></td>
						<td><button class="botao submit" type="submit" onclick="location.href='javascript:confirmaExclusao(<%=ped.getId()%>)'">EXCLUIR</button></td>
						<td><button class="botao submit" type="submit" onclick="location.href='PedidoController?acao=edit&id=<%=ped.getId()%>'">EDITAR</button></td>					
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