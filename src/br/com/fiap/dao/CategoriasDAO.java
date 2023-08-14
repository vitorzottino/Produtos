package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Categorias;
import br.com.fiap.model.Produtos;

public class CategoriasDAO {

	private Connection connection;

	public CategoriasDAO(Connection connection) {
		this.connection = connection;

	}

	public List<Categorias> listarTodas() {
		try {
			List<Categorias> listaCategorias = new ArrayList<Categorias>();
			String sql = "select * from categoria";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Categorias categoria = new Categorias();
				categoria.setIdCategoria(rs.getInt(1));
				categoria.setNome(rs.getString(2));
				listaCategorias.add(categoria);

			}
			rs.close();
			ps.close();
			return listaCategorias;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Categorias> listarComProduto() {
		try {
			Categorias categoriaAtual = null;
			List<Categorias> listaCategorias = new ArrayList<Categorias>();
			String sql = "SELECT C.idCategoria, C.nome, P.idProduto, P.nome, P.descricao, P.idCategoria FROM CATEGORIA C INNER JOIN PRODUTO P ON C.idCategoria = P.idCategoria order by C.idCategoria";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				if (categoriaAtual == null || !categoriaAtual.getNome().equals(rs.getString(2))) {
					Categorias categoria = new Categorias();
					categoria.setIdCategoria(rs.getInt(1));
					categoria.setNome(rs.getString(2));
					listaCategorias.add(categoria);
					categoriaAtual = categoria;
				}

				Produtos produto = new Produtos();
				produto.setIdProduto(rs.getInt(3));
				produto.setNome(rs.getString(4));
				produto.setDescricao(rs.getString(5));
				produto.setIdCategoria(rs.getInt(6));
				categoriaAtual.adicionaProduto(produto);
			}

			rs.close();
			ps.close();
			return listaCategorias;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
