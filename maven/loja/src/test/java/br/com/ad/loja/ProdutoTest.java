package br.com.ad.loja;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class ProdutoTest {

	@Test
	public void test() {

		Produto p = new Produto("teste", BigDecimal.TEN);
		assertEquals("teste", p.getNome());
		assertEquals(BigDecimal.TEN, p.getPreco());

	}

}
