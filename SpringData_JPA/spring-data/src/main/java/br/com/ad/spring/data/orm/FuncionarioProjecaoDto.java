package br.com.ad.spring.data.orm;

import java.math.BigDecimal;

/**
 * Interface based projection 
 *
 */
public interface FuncionarioProjecaoDto {
	
	Integer getId();
	String getNome();
	BigDecimal getSalario();

}
