<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="projetoFinal.Classes.Produto"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%
Produto produto = (Produto)request.getAttribute("pro");
%>
<form action="ProdutoController" method="POST">
		
		
		<input type="hidden" name="id" value="<%=produto.getId()%>">
		
		
		<label>
		Descricao:
		</label>
		<input type="text" name="descricao" value="<%=produto.getDescricao()%>">
		
		<label>
		Valor:
		</label>
		<input type="text" name="valor" value="<%=produto.getValor() %>">
		
		<input type="submit" value="Salvar">
</form>

</body>
</html>