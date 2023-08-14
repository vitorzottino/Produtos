package br.com.fiap.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.dao.ProdutosDAO;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Produtos;

public class ProdutosController {

	private ProdutosDAO produtoDAO;

	public ProdutosController() {
		Connection connection = new ConnectionFactory().conectarOracle();
		this.produtoDAO = new ProdutosDAO(connection);
	}

	public void salvarProduto(Produtos produto) {
		this.produtoDAO.salvarComCategoria(produto);
	}

	public List<Produtos> listarTodos() {
		return this.produtoDAO.listarTodos();
	}

	public List<Produtos> listarComCategoria(int idCategoria) {
		return this.produtoDAO.listarComCategoria(idCategoria);
	}

	public void excluir(int id) {
		this.produtoDAO.excluir(id);
	}

	public void alterar(String nome, String descricao, int idCategoria, int idProduto) {
		this.produtoDAO.alterar(nome, descricao, idCategoria, idProduto);

	}

}
