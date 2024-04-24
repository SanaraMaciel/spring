<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- declarando a variavel de escopo do formulário como o path que o servidor deve usar -->
<c:url value="/entrada" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:import url="logout-parcial.jsp" />

	<form action="${linkServletNovaEmpresa}" method="post">
		Nome: <input type="text" name="nome" /> 
		Data Abertura: <input type="text" name="data" />
		<input type="hidden" name="acao" value="NovaEmpresa" /> 
		<input type="submit" />
	</form>
</body>
</html>