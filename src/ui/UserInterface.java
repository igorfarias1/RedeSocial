package ui;

import java.util.Scanner;

import exceptions.AuthenticationException;

import java.util.ArrayList;

public class UserInterface {
	private Scanner leitor = new Scanner(System.in);
	private Facade fachada = new Facade();
	private FacadeNoLogin fachadaNoLogin = new FacadeNoLogin();

	public void menuInicial() {
		String opcao = "";
		while (opcao != "sair") {

			System.out.println("\n1 - Cadastrar-se");
			System.out.println("2 - Fazer login");
			System.out.println("3 - Excluir sua conta");
			System.out.println("4 - Buscar por usuário");
			System.out.println("sair - Encerrar programa");

			System.out.print("\nEscolha uma opção: ");
			opcao = leitor.nextLine();

			switch (opcao) {
			case ("1"):
				menuCadastro();
				break;
			case ("2"):
				menuLogin();
				break;
			case ("3"):
				menuExcluir();
				break;
			case ("4"):
				menuBuscar();
				break;
			case ("sair"):
				opcao = "sair";
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
	}

	// Menu ativado quando o usuário digita 1 no menu inicial.
	public void menuCadastro() {
		// Recebe os dados do usuario e envia para facade
		// que terá a responsabilidade de integrar as outras classes do sistema

		System.out.print("Criação de usuário!");
		System.out.print("Nome: ");
		String nome = leitor.nextLine();

		System.out.print("Sobrenome: ");
		String sobrenome = leitor.nextLine();

		System.out.print("Login: ");
		String login = leitor.nextLine();

		System.out.print("Senha: ");
		String senha = leitor.nextLine();

		System.out.print("Email: ");
		String email = leitor.nextLine();

		System.out.print("Profissão: ");
		String profissao = leitor.nextLine();

		fachadaNoLogin.cadastrar(login, senha, email, nome, sobrenome, profissao);

	}

	// Menu ativado quando o usuário digita 2 no menu inicial
	public void menuExcluir() {
		// Método que para excluir um usuário requer seu login e senha

		System.out.println("Excluir sua conta!");
		System.out.print("Digite seu login: ");
		String login = leitor.nextLine();

		System.out.print("Digite sua senha: ");
		String senha = leitor.nextLine();

		// Chama a fachada que vai se encarregar de excluir o usuario
		// integrando as classes Usuario e DAOUsuario

		try {
			fachadaNoLogin.excluir(login, senha);
		} catch (AuthenticationException e) {
			System.out.println(e.getMessage());
		}

	}

	// Menu ativado quando o usuario digita 3 no menu inicial ou digita 1 no menuLogin
	public void menuBuscar() {
		// Busca um usuário por parte do seu nome, sobrenome ou login

		System.out.print("Digite parte do nome, sobrenome ou login: ");
		String palavra = leitor.nextLine();

		// Salva o resultado da busca em um ArrayList<Usuario> e imprime o resultado
		ArrayList resultado = fachadaNoLogin.buscarUsuario(palavra);
		System.out.println(resultado);
	}

	// Menu ativado quando o usuario digita 3 no menu inicial
	public void menuLogin() {
		// Loga o usuário e apresenta um sub menu com diversas opções

		System.out.print("Login: ");
		String login = leitor.nextLine();

		System.out.print("Senha: ");
		String senha = leitor.nextLine();

		try {
			fachada.login(login, senha);
			String opcao = "";

			while (opcao != "sair") {
				System.out.println("");
				System.out.println("1 - Buscar por usuário");
				System.out.println("2 - Adicionar amigo");
				System.out.println("sair - Encerrar a sessão");
				System.out.print("Escolha uma opção: ");
				opcao = leitor.nextLine();

				switch (opcao) {
				case ("1"):
					menuBuscar();
					break;
				case ("2"):
					menuAdd();
					break;
				case ("sair"):
					opcao = "sair";
					break;
				default:
					System.out.println("Opção inválida.");
				}
			}

		} catch (AuthenticationException e) {
			System.out.println(e.getMessage());
		}

	}
	
	//Menu ativado a partir do menuLogin (opção 2)
	public void menuAdd() {
		//Adiciona um usuário a lista de amigos do usuário logado
		
		System.out.println("");
		System.out.print("Digite o login do seu novo amigo: ");
		String login = leitor.nextLine();
		
		fachada.addAmigo(login);
		
	}

}
