<html>
<%
	//scriptlet são os códigos java dentro da jsp
	//pegando o atributo nome da empresa que veio por requisição
	String nomeEmpresa = (String) request.getAttribute("empresa");
	System.out.println(nomeEmpresa);

%>

<body>
	Empresa
	<!--<% out.println(nomeEmpresa); %>-->
	<!-- usado para resumir ao invés de vc dar o out.println -->
	<!-- <%= nomeEmpresa %> -->
</body>
</html>
