<html>
<%
	//scriptlet s�o os c�digos java dentro da jsp
	//pegando o atributo nome da empresa que veio por requisi��o
	String nomeEmpresa = (String) request.getAttribute("empresa");
	System.out.println(nomeEmpresa);

%>

<body>
	Empresa
	<!--<% out.println(nomeEmpresa); %>-->
	<!-- usado para resumir ao inv�s de vc dar o out.println -->
	<!-- <%= nomeEmpresa %> -->
</body>
</html>
