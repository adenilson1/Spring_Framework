package br.com.ad.spring.data.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.ad.spring.data.orm.Funcionario;
import br.com.ad.spring.data.orm.FuncionarioProjecaoDto;
import br.com.ad.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {
	private Boolean system = true;

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private final FuncionarioRepository funcionarioRepository;

	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;

	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual a ação de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario nome");
			System.out.println("2 - Busca funcionario nome, data de admissao e salario maior");
			System.out.println("3 - Busca funcionario data de admissao");
			System.out.println("4 - Pesquisa funcionario salario");

			int action = scanner.nextInt();

			switch (action) {
			case 1:

				buscaFuncionarioNome(scanner);
				break;
				
			case 2:

				buscaFuncionarioNomeSalarioMaiorData(scanner);
				break;
				
			case 3:

				buscaFuncionarioDataAdmissao(scanner);
				break;
				
			case 4:

				pesquisaFuncionarioSalario();
				break;

			default:
				system = false;
				break;
			}
		}

	}

	private void buscaFuncionarioNome(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = scanner.next();

		List<Funcionario> list = funcionarioRepository.findByNome(nome);

		list.forEach(System.out::println);
	}

	private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = scanner.next();

		System.out.println("Qual data deseja pesquisar");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);

		System.out.println("Qual salario deseja pesquisar");
		BigDecimal salario = scanner.nextBigDecimal();

		List<Funcionario> list = funcionarioRepository
				.findNomeSalarioMaiorDataAdmissao(nome, salario, localDate);

		list.forEach(System.out::println);

	}
	
	private void buscaFuncionarioDataAdmissao(Scanner scanner) {
		System.out.println("Qual data deseja pesquisar");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		List<Funcionario> list = funcionarioRepository.findDataAdmissaoMaior(localDate);
		
		list.forEach(System.out::println);
	}
	
	private void pesquisaFuncionarioSalario() {
		List<FuncionarioProjecaoDto> list = funcionarioRepository.findFuncionarioSalario();
		list.forEach(f -> System.out.println("Funcionario: id: "+f.getId()
		+ "  | nome: "+f.getNome() + " | salario: "+f.getSalario()));
		
	}

}