<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- para importar dados de classes e pacotes -->
<%@ page import="java.util.List, br.com.sanara.gerenciador.servlet.Empresa" %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Lista de empresas:
	<br />
	<ul>
		<%
		List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas");
		for (Empresa empresa : lista) {
		%>
		<li><%=empresa.getNome()%></li>
		<%
		}
		%>
	</ul>



</body>
</html>