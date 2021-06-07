package br.com.ad.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ad.spring.data.service.CrudCargoService;
import br.com.ad.spring.data.service.CrudFuncionarioService;
import br.com.ad.spring.data.service.CrudUnidadeService;
import br.com.ad.spring.data.service.RelatoriosFuncionarioDinamico;
import br.com.ad.spring.data.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private final CrudUnidadeService unidadeSerevice;
	private final CrudFuncionarioService funcionarioService;
	private final RelatoriosService relatoriosService;
	private final RelatoriosFuncionarioDinamico relatorioFuncionarioDinamico;

	private Boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService, CrudUnidadeService unidadeSerevice,
			CrudFuncionarioService funcionarioService, RelatoriosService relatoriosService,
			RelatoriosFuncionarioDinamico relatorioFuncionarioDinamico) {

		this.cargoService = cargoService;
		this.unidadeSerevice = unidadeSerevice;
		this.funcionarioService = funcionarioService;
		this.relatoriosService = relatoriosService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (system) {
			System.out.println("Qual a ação que você quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Funcionario");
			System.out.println("2 - Cargo");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorios");
			System.out.println("5 - Relatorios dinamico");

			Integer function = scanner.nextInt();

			switch (function) {
			case 1:
				funcionarioService.inicial(scanner);
				break;

			case 2:
				cargoService.inicial(scanner);
				break;

			case 3:
				unidadeSerevice.inicial(scanner);
				break;

			case 4:
				relatoriosService.inicial(scanner);
				break;
				
			case 5:
				relatorioFuncionarioDinamico.inicial(scanner);
				break;

			default:
				System.out.println("Finalizado");
				system = false;
				break;
			}

		}

	}

}
