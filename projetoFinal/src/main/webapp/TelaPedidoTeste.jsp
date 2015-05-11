<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="projetoFinal.Classes.Pedido"%>
<%@page import="projetoFinal.Classes.Cliente"%>
<%@page import="projetoFinal.Classes.Evento"%>
<%@page import="projetoFinal.Util.GerenciadorPedido"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function confirmaExclusao(id) {
		confirmou = window.confirm("Tem Certeza que deseja Excluir?")
		if (confirmou == true) {
			location.href = "PedidoController?acao=exc&id=" + id;
		}
	}
</script>
<link rel="stylesheet" type="text/css" href="estiloform.css">
<style type="text/css">
@import url("estiloform.css");
</style>
<title>Cadastrar Pedido</title>
<%@include file="header.html" %>
</head>
<body>
	<%
		Cliente cliente = (Cliente) request.getAttribute("cli");
		List<Cliente> clientes = (List<Cliente>) request
				.getAttribute("listacli");
		Pedido pedido = (Pedido) request.getAttribute("pdo");
		Evento evento = (Evento) request.getAttribute("eto");
		List<Evento> eventos = (List<Evento>) request
				.getAttribute("listaeto");
	%>

	<form action="PedidoController" method="POST">
		<fieldset>
			<input type="hidden" name="id">

			<fieldset class="grupo">
				<div class="campo">
					<label for="cliente">Cliente</label> <select>
						<%
							for (Cliente c : clientes) {
						%>
						<option name="cliente" id="cliente" style="width: 10em" value=<%=c.getId()%>>
							<%=c.getNome()%>
						</option>
						<%
							}
						%>

					</select>
				</div>
				<div class="campo">
					<label for="evento">Tipo Evento</label> <select>
						<%
						for (int i = 0; i < eventos.size(); i++) {
							Evento  e = eventos.get(i);
					%>
						<option name="evento" id="evento" style="width: 10em"
							value="<%=e.getId()%>">
							<%=e.getDescricao()
							%>
						</option>
						<%
							}
						%>
					</select>
				</div>
				<div class="campo">
					<label for="orgpdo">Origem Pedido</label> <input type="text"
						id="origempedido" name="origempedido" style="width: 10em" />
				</div>
			</fieldset>
			<fieldset class="grupo">
				<div class="campo">
					<label for="dtapdo">Data do Pedido</label> <input type="date"
						id="datapedido" name="datapedido" style="width: 10em" />
				</div>
				<div class="campo">
					<label for="crimnl">Cerimonial</label> <input type="text"
						id="cerimonial" name="cerimonial" style="width: 10em" />
				</div>
			</fieldset>
			<fieldset class="grupo">
				<div class="campo">
					<label for="dtaeto">Data evento</label> <input type="date"
						id="dataevento" name="dataevento" style="width: 10em" />
				</div>
				<div class="campo">
					<label for="hroeto">Horário do Evento</label> <input type="text"
						id="horaevento" name="horaevento" style="width: 10em" />
				</div>
			</fieldset>
			<fieldset class="grupo">
				<div class="campo">
					<label for="indcco">Indicação</label> <input type="text"
						id="indicacao" name="indicacao" style="width: 10em" />
				</div>
				<div class="campo">
					<label for="lcleto">Local do Evento</label> <input type="text"
						id="localevento" name="localevento" style="width: 10em" />
				</div>
			</fieldset>
			<fieldset class="grupo">
				<div class="campo">
					<label for="endeto">Endereço do Evento</label> <input type="text"
						id="enderecoevento" name="enderecoevento" style="width: 10em" />
				</div>
				<div class="campo">
					<label for="observ">Observação</label> <input type="text" id="obs"
						name="obs" style="width: 10em" />
				</div>
			</fieldset>
			
			<button class="botao submit" type="submit" name="submit">Salvar</button>
			<button class="botao submit" type="reset" onclick="location.href='http://localhost:8080/projetoFinal/menuprincipal.jsp'">Retornar</button>
		</fieldset>
	</form>


</body>
</html>