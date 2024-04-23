<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- para importar dados de classes e pacotes -->
<%@ page
	import="java.util.List, br.com.sanara.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- usada para fazer formatação de datase etc  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Standard Taglib</title>
</head>
<body>

	Lista de empresas:
	<br />
	<ul>
		<!-- iterando a lista com a lib jstl -->
		<c:forEach items="${empresas}" var="empresa">
			<!-- imprime o campo nome com a data formatada-->
			<li>${empresa.nome }-<fmt:formatDate
					value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" />				
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id }">editar</a>
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id }">remove</a>
			</li>
		</c:forEach>


	</ul>



</body>
</html>