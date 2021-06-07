package br.com.ad.loja;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.ad.loja.dao.CategoriaDAO;
import br.com.ad.loja.modelo.Categoria;
import br.com.ad.loja.modelo.Produto;

public class TestaListagemDeCatedorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategoirias = categoriaDAO.listarComPeodutos();
			listaDeCategoirias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());

				}

			});
		}

	}

}
