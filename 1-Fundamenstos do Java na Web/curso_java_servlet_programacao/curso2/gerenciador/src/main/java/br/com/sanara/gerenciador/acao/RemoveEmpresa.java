package br.com.sanara.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sanara.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		System.out.println(id);

		Banco banco = new Banco();
		banco.removeEmpresaIterator(id);

		// chama o navegador passando para ele redirecionar pra outra página, ai o
		// navegador faz a requisição novamente
		// response.sendRedirect("entrada?acao=ListaEmpresas");

		return "redirect:entrada?acao=ListaEmpresas";

	}
}