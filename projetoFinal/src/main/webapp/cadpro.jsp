<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Produto</title>
</head>
<body>
	<form action="ProdutoController" method="POST">
		<input type="hidden" name="id"> <label>Descrição: </label> <input
		type="text" name="descricao"> <label>Valor: </label> <input
		type="text" name="valor"> <input type="submit" 
		value="Salvar">
	</form>
</body>
</html>