<!DOCTYPE html>
<%@page import="projetoFinal.Classes.Cliente"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Cliente cliente = (Cliente)request.getAttribute("cli");
%>
<form action="ClienteServlet" method="POST">
		
		
		<input type="hidden" name="id" value="<%=cliente.getId()%>">
		
		
		<label>
		Nome:
		</label>
		<input type="text" name="nome" value="<%=cliente.getNome()%>">
		
		<label>
		Email:
		</label>
		<input type="text" name="email" value="<%=cliente.getEmail()%>">
		
		<label>
		Telefone:
		</label>
		<input type="text" name="telefone" value="<%=cliente.getTelefone()%>">
		
		<input type="submit" value="Salvar">
</form>
</body>
</html>