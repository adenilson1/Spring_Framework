package br.com.ad.loja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// validacao com jdbc, para evitar o SQL INJECTION
public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		
		try (Connection con = factory.recuperarConexao()) {
			con.setAutoCommit(false);
			try (PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO(nome, descricao) VALUES(?, ?)",
					Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel("SmartTV", "45 polegadas", stm);
				adicionarVariavel("Radio", "Radio de bateria", stm);

				con.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXCUTADO");
				con.rollback();
			}

		}

	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		if (nome.equals("Radio")) {
			throw new RuntimeException("Não possivel adicionar o produto");
		}
		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);

			}

		}
	}

}
