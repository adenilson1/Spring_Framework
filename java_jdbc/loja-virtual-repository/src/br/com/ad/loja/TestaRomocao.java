package br.com.ad.loja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRomocao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory fatory = new ConnectionFactory();
		Connection connection = fatory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();
		Integer linhasMoficadas = stm.getUpdateCount();
		System.out.println("Quantidade de linhas que foram modificadas "+ linhasMoficadas);
	}

}
