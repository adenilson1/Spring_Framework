package br.com.ad.loja;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	/**
	 * Criando um pool de conexões.
	 */

	public DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPoolDataSource = new ComboPooledDataSource();
		comboPoolDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPoolDataSource.setUser("root");
		comboPoolDataSource.setPassword("root");
		
		comboPoolDataSource.setMaxPoolSize(15); //determina o numero de conexoes

		this.dataSource = comboPoolDataSource;
	}

	public Connection recuperarConexao() throws SQLException {

		return this.dataSource.getConnection(); // retorna a interface que chama a conexao com o pool
	}

}
