package br.com.sanara.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sanara.gerenciador.acao.Acao;

//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		
//		HttpSession sessao = request.getSession();
//		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
//		boolean ehAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//				
//		if(ehAcaoProtegida && usuarioNaoEstaLogado) {
//		    response.sendRedirect("redirect:entrada?acao=LoginForm");
//		    return;
//		}
		
		

		String nomeDaClasse = "br.com.sanara.gerenciador.acao." + paramAcao;

		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);// carrega a classe com o nome
			// cria uma nova instancia da classe que foi informada
			Object obj = classe.newInstance();
			// faz o cast de Object para acao
			Acao acao = (Acao) obj;
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] tipoEndereco = nome.split(":");

		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}

		/*
		 * String nome = null;
		 * 
		 * if (paramAcao.equals("ListaEmpresas")) { ListaEmpresas acao = new
		 * ListaEmpresas(); nome = acao.executa(request, response);
		 * 
		 * } else if (paramAcao.equals("RemoveEmpresa")) { RemoveEmpresa acao = new
		 * RemoveEmpresa(); nome = acao.executa(request, response);
		 * 
		 * } else if (paramAcao.equals("MostraEmpresa")) { MostraEmpresa acao = new
		 * MostraEmpresa(); nome = acao.executa(request, response);
		 * 
		 * } else if (paramAcao.equals("AlteraEmpresa")) { AlteraEmpresa acao = new
		 * AlteraEmpresa(); nome = acao.executa(request, response);
		 * 
		 * } else if (paramAcao.equals("NovaEmpresa")) { NovaEmpresa acao = new
		 * NovaEmpresa(); nome = acao.executa(request, response); }else if
		 * (paramAcao.equals("NovaEmpresaForm")) {
		 * 
		 * NovaEmpresaForm acao = new NovaEmpresaForm(); nome = acao.executa(request,
		 * response); }
		 * 
		 * String[] tipoEndereco = nome.split(":");
		 * 
		 * if(tipoEndereco[0].equals("forward")) { RequestDispatcher rd =
		 * request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
		 * rd.forward(request, response); }else {
		 * response.sendRedirect(tipoEndereco[1]); }
		 */

	}

}
