package ui;

import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
	private Scanner leitor = new Scanner(System.in);
	private Facade fachada = new Facade();

	public void menuInicial() {
			System.out.println("1 - Cadastrar-se");
			System.out.println("2 - Excluir sua conta");
			System.out.println("3 - Buscar por usuário");
			System.out.println("Escolha uma opção: ");
			String opcao = leitor.nextLine();

			switch (opcao) {
			case ("1"):
				menuCadastro();
				break;
			case ("2"):
				menuExcluir();
				break;
			case ("3"):
				menuBuscar();
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
	}

	// Menu ativado quando o usuário digita 1 no menu inicial.
	public void menuCadastro() {
		//Recebe os dados do usuario e envia para facade 
		//que terá a responsabilidade de integrar as outras classes do sistema

		System.out.println("Criação de usuário!");
		System.out.println("Nome: ");
		String nome = leitor.nextLine();

		System.out.println("Sobrenome: ");
		String sobrenome = leitor.nextLine();

		System.out.println("Login: ");
		String login = leitor.nextLine();

		System.out.println("Senha: ");
		String senha = leitor.nextLine();

		System.out.println("Email: ");
		String email = leitor.nextLine();

		System.out.println("Profissão: ");
		String profissao = leitor.nextLine();

		fachada.cadastrar(login, senha, email, nome, sobrenome, profissao);

	}

	// Menu ativado quando o usuário digita 2 no menu inicial
	public void menuExcluir() {
		//Método que para excluir um usuário requer seu login e senha
		
		System.out.println("Excluir sua conta!");
		System.out.println("Digite seu login: ");
		String login = leitor.nextLine();

		System.out.println("Digite sua senha: ");
		String senha = leitor.nextLine();

		// Chama a fachada que vai se encarregar de excluir o usuario
		// integrando as classes Usuario e DAOUsuario
		fachada.excluir(login, senha);

	}

	// Menu ativado quando o usuario digita 3 no menu inicial
	public void menuBuscar() {
		// Busca um usuário por parte do seu nome, sobrenome ou login
		
		System.out.println("Buscar por: ");
		String palavra = leitor.next();

		// Salva o resultado da busca em um ArrayList<Usuario> e imprime o resultado
		ArrayList resultado = fachada.buscarUsuario(palavra);
		System.out.println(resultado);
	}

}
