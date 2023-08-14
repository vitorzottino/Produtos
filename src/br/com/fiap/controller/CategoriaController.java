package br.com.fiap.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.dao.CategoriasDAO;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Categorias;

public class CategoriaController {
	
	private CategoriasDAO categoriaDAO;
	
	public CategoriaController() {
		Connection connection = new ConnectionFactory().conectarOracle();
		this.categoriaDAO = new CategoriasDAO(connection);
	}
	
	public List<Categorias>listarCategorias() {
		return this.categoriaDAO.listarTodas();
	}
	
	public List<Categorias>listarCategoriasComProdutos(){
		return this.categoriaDAO.listarComProduto();
	}
	

}
