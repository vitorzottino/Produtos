package br.com.fiap.model;

public class Produtos {

	private int idProduto, idCategoria;
	private String nome;
	private String descricao;


	public Produtos() {

	}

	public Produtos(String nome, String descricao, int idCategoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.idCategoria = idCategoria;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

}
