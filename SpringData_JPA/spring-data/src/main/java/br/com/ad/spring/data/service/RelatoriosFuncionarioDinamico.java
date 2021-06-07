package br.com.ad.spring.data.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.ad.spring.data.orm.Funcionario;
import br.com.ad.spring.data.repository.FuncionarioRepository;
import br.com.ad.spring.data.specification.SpecificationFuncionario;

@Service
public class RelatoriosFuncionarioDinamico {
	
	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RelatoriosFuncionarioDinamico (FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		System.out.println("Digite um nome");
		String nome = scanner.next();
		
		if(nome.equalsIgnoreCase("NULL")) {
			nome = null;
		}
		
		System.out.println("Digite um cpf");
		String cpf = scanner.next();
		
		if(cpf.equalsIgnoreCase("NULL")) {
			cpf = null;
		}
		
		System.out.println("Digite um salario");
		BigDecimal salario = scanner.nextBigDecimal();
		
		if(salario.compareTo(BigDecimal.ZERO) == 0) {
			salario = null;
		}
		
		System.out.println("Digite a data de admissão");
		String data = scanner.next();
		
		LocalDate dataAdmissao;
		
		if(data.equalsIgnoreCase("NULL")) {
			dataAdmissao = null;
		}else {
			dataAdmissao= LocalDate.parse(data, formatter);
		}
		
		
		
		
		List<Funcionario> funcionarios = funcionarioRepository
				.findAll(Specification.where(
						SpecificationFuncionario.nome(nome))
						.or(SpecificationFuncionario.cpf(cpf))
						.or(SpecificationFuncionario.salario(salario))
						.or(SpecificationFuncionario.dataAdmissao(dataAdmissao))
						);
		funcionarios.forEach(System.out::println);
		
	}

}
