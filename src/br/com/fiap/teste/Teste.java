package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.controller.CategoriaController;
import br.com.fiap.model.Categorias;

public class Teste {

	public static void main(String[] args) {

		CategoriaController controleCategoria = new CategoriaController();

		List<Categorias> listaCategorias = controleCategoria.listarCategoriasComProdutos();

		for (Categorias categorias : listaCategorias) {

			System.out.println(categorias.toString());

		}

	}

}
