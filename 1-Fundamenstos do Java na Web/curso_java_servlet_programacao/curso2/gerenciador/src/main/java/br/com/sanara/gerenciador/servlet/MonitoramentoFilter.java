package br.com.sanara.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter(urlPatterns="/entrada")
@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println(" MonitoramentoFilter ");
		
		// medindo o tempo de execução
		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		
		
		//executa a acao
		chain.doFilter(request, response);
		

		// medindo o tempo de execução
		long depois = System.currentTimeMillis();

		System.out.println("tempo de execução da ação: " + acao + (depois - antes));

	}

}
