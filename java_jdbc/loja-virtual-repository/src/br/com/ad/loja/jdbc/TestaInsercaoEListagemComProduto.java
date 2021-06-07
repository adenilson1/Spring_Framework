package br.com.ad.loja.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ad.loja.ConnectionFactory;
import br.com.ad.loja.dao.ProdutoDAO;
import br.com.ad.loja.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}

	}
}
