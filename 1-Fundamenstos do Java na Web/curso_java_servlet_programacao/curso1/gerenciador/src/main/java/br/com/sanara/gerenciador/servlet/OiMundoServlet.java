package br.com.sanara.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/oi")
//Tomcat só instancia a servlet quando realmente ocorre uma requisição. 
//Isso é o comportamento padrão que podemos alterar facilmente! A anotação loadOnStartup
//@WebServlet(urlPatterns="/oi", loadOnStartup=1)
public class OiMundoServlet extends HttpServlet {

	public OiMundoServlet() {
		System.out.println("Criando Oi Mundo Servlet");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		// devolver a resposta pro navegador em caracteres
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Oi mundo! Meu Primeiro servlet!");
		out.println("</body>");
		out.println("</html>");

		System.out.println("o servlet OiMundoServlet foi chamado");
	}
}
