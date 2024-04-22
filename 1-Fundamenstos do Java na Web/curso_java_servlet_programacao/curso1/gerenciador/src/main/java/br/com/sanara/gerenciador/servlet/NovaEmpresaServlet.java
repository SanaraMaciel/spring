package br.com.sanara.gerenciador.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");

		// lendo os parametros que são mandados pela requisição
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		Date dataAbertura = null;
		
		//formatando a data no patern desejado
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		List<Empresa> lista = banco.getEmpresas();
		request.setAttribute("empresas", lista);		
		request.setAttribute("empresa", empresa.getNome());
		
		//faz o navegador fazer um redirecionamento para alguma página chamando o outro servlet
		response.sendRedirect("listaEmpresas");
		
		// chama o JSP
		// RequestDispatcher rd = request.getRequestDispatcher("exercicioLaco.jsp");		
		//RequestDispatcher rd = request.getRequestDispatcher("novaEmpresaCriada.jsp");
		
		//Um servlet tbm pode chamar outro servlet -- listaEmpresas
		//RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		
		// usar a requesição para colocar o atributo dentro da requisição antes de passar pra JSP
		//request.setAttribute("empresa", empresa.getNome());
		//rd.forward(request, response);

		/*
		 * não é + necessário printar aqui pois agora tem a jsp PrintWriter out =
		 * response.getWriter(); out.println("<html>"); out.println("<body>");
		 * out.println("Empresa " + nomeEmpresa + " cadastrada com sucesso");
		 * out.println("</body>"); out.println("</html>");
		 */

	}

}
