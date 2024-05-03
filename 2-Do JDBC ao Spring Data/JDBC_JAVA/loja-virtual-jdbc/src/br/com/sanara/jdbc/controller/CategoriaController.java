package br.com.sanara.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.sanara.jdbc.dao.CategoriaDAO;
import br.com.sanara.jdbc.factory.ConnectionFactory;
import br.com.sanara.jdbc.modelo.Categoria;

public class CategoriaController {

	private CategoriaDAO categoriaDAO;

	public CategoriaController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.categoriaDAO = new CategoriaDAO(connection);
	}

	public List<Categoria> listar() {
		return this.categoriaDAO.listar();
	}
}
