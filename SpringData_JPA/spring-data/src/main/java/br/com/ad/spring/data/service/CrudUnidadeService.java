package br.com.ad.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.ad.spring.data.orm.Unidade;
import br.com.ad.spring.data.repository.UnidadeRepository;

@Service
public class CrudUnidadeService {

	private Boolean system = true;
	private final UnidadeRepository unidadeRepository;

	public CrudUnidadeService( UnidadeRepository unidadeRepository) {
		this.unidadeRepository = unidadeRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual a ação de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvar(scanner);
				break;
				
			case 2:
				atualizar(scanner);
				break;
				
			case 3:
				visualizar();
				break;
				
			case 4:
				deletar(scanner);
				break;

			default:
				system = false;
				break;
			}
		}

	}

	private void salvar(Scanner scanner) {
		System.out.println("Digite o nome da unidade");
		String nome = scanner.next();
		
		System.out.println("Digite o endereco");
		String endereco = scanner.next();
		
		Unidade unidade = new Unidade();
		unidade.setDescricao(nome);
		unidade.setEndereco(endereco);
		
		unidadeRepository.save(unidade);
		System.out.println("Salvo");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Id");
		long id = scanner.nextInt();
		
		System.out.println("Digite o nome da unidade");
		String nome = scanner.next();
		
		System.out.println("Digite o endereco");
		String endereco = scanner.next();
				
		Unidade unidade = new Unidade();
		unidade.setId(id);
		unidade.setDescricao(nome);
		unidade.setEndereco(endereco);
		
		unidadeRepository.save(unidade);
		System.out.println("Atualizado");

	}

	private void visualizar() {
		Iterable<Unidade> unidades = unidadeRepository.findAll();
		unidades.forEach(unidade -> System.out.println(unidade.toString()));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id");
		long id = scanner.nextInt();
		unidadeRepository.deleteById(id);
		
		System.out.println("Deletado");
	}

}
