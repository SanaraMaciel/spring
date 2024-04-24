package br.com.sanara.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		/*
		 * método invalidate(), que remove o objeto HttpSession e todos os objetos
		 * associados a ele, ao mesmo tempo em que destrói o cookie. Com o método
		 * removeAttribute(), nós estávamos removendo o atributo, mas o objeto
		 * HttpSession continuava na memória. 
		 * sessao.removeAttribute("usuarioLogado");
		 */

		sessao.invalidate();
		return "redirect:entrada?acao=LoginForm";
	}

}