package br.com.fiap.model;

import java.util.ArrayList;
import java.util.List;

public class Categorias {

	private int idCategoria;
	private String nome;
	private List<Produtos> listaProdutos = new ArrayList<Produtos>();

	public Categorias() {
		super();
	}

	public Categorias(String nome) {

		this.nome = nome;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void preencherLista(Produtos produto) {
		listaProdutos.add(produto);
		
	}

}
