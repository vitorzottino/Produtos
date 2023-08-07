package br.com.fiap.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private final String ORACLE = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

	public Connection conectarOracle() {
		try {
			System.out.println("Conectado");
			return DriverManager.getConnection(ORACLE, "rm93360", "100903");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar");
			throw new RuntimeException(e);

		}
	}
}
