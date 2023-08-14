package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Produtos;

public class ProdutosDAO {

	private Connection connection;

	public ProdutosDAO(Connection connection) {
		this.connection = connection;

	}

	public void salvarComCategoria(Produtos produto) {
		try {
			String sql = " INSERT INTO PRODUTO (NOME, DESCRICAO, idCategoria) VALUES (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setInt(3, produto.getIdCategoria());
			ps.execute();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produtos> listarTodos() {
		List<Produtos> listaProdutos = new ArrayList<Produtos>();

		try {
			String sql = "SELECT idProduto, nome, descricao, idCategoria FROM PRODUTO";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Produtos produto = new Produtos();
				produto.setIdProduto(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setDescricao(rs.getString(3));
				produto.setIdCategoria(rs.getInt(4));
				listaProdutos.add(produto);

			}
			ps.close();
			rs.close();
			return listaProdutos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produtos> listarComCategoria(int idCategoria) {
		List<Produtos> listaProdutos = new ArrayList<Produtos>();

		try {
			String sql = "SELECT  * FROM PRODUTO WHERE idCategoria = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idCategoria);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Produtos produto = new Produtos();
				produto.setIdProduto(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setDescricao(rs.getString(3));
				produto.setIdCategoria(rs.getInt(4));
				listaProdutos.add(produto);

			}
			ps.close();
			rs.close();
			return listaProdutos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	
	public void alterar(String nome, String descricao, int idCategoria, int idProduto) {
		try {
			String sql = "update produto P set P.nome = ?, P.descricao = ?, P.idCategoria = ?, WHERE idProduto = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, descricao);
			ps.setInt(3, idCategoria);
			ps.setInt(4, idProduto);
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public void excluir(int id) {

		try {
			String sql = "DELETE FROM PRODUTO WHERE idProduto = ? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
