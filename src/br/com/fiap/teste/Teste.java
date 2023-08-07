package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.controller.ProdutosController;
import br.com.fiap.model.Produtos;

public class Teste {

	public static void main(String[] args) {
		
		
		ProdutosController controlador = new ProdutosController();
		Produtos produto1 = new Produtos("iPhone 15", "Celular de ultima geracao top", 1);
		
		
	
		
		
		List<Produtos> listaProdutos = controlador.listarTodos();
		
		
		for (Produtos produto : listaProdutos) {
			
			System.out.println(produto.toString());
			
		}

	}
	
	

}
