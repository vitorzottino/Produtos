package br.com.fiap.teste;

import java.util.Scanner;

import br.com.fiap.controller.ProdutosController;
import br.com.fiap.model.Produtos;

public class TesteInserir {

	public static void main(String[] args) {
		
		ProdutosController controlador = new ProdutosController();
		Scanner input = new Scanner(System.in);
		Produtos novoProduto = new Produtos();
		
		
		System.out.print("Insira o nome do produto: ");
		novoProduto.setNome(input.next());
		System.out.print("Insira a descricao do produto: ");
		novoProduto.setDescricao(input.next());
		System.out.println("Insira o id da categoria: ");
		novoProduto.setIdCategoria(input.nextInt());
		controlador.salvarProduto(novoProduto);
		System.out.println("Produto Inserido");
		input.close();
		
	}
}
