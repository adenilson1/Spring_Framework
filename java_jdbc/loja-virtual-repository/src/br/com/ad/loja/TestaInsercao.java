package br.com.ad.loja;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.recuperarConexao();

		Statement stm = con.createStatement();
		stm.execute("INSERT INTO PRODUTO(nome, descricao) VALUES('Mouse', 'Mouse sem fio')",
				Statement.RETURN_GENERATED_KEYS);
		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O di criado foi: " + id);
		}

	}

}
