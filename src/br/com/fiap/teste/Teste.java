package br.com.fiap.teste;

import br.com.fiap.controller.ProdutosController;
import br.com.fiap.model.Produtos;

public class Teste {

	public static void main(String[] args) {
		ProdutosController controlador = new ProdutosController();
		Produtos produto = new Produtos("iPhone 15", "Celular de ultima geracao top", 1);
		
		controlador.salvarProduto(produto);

	}

}
