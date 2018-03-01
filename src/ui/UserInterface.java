package ui;

import java.util.Scanner;

import beans.Comentario;
import beans.Poema;
import exceptions.*;
import java.util.ArrayList;

public class UserInterface {
	private Scanner leitor = new Scanner(System.in);
	private Facade fachada = new Facade();
	private FacadeNoLogin fachadaNoLogin = new FacadeNoLogin();

	public void menuInicial() {
		int opcao = -1;
		while (opcao != 0) {

			System.out.println("\n1 - Cadastrar-se");
			System.out.println("2 - Fazer login");
			System.out.println("3 - Excluir sua conta");
			System.out.println("4 - Buscar por usuário");
			System.out.println("0 - Encerrar programa");

			System.out.print("\nEscolha uma opção: ");
			opcao = leitor.nextInt();

			switch (opcao) {
			case (1):
				interfaceCadastro();
				break;
			case (2):
				menuLogin();
				break;
			case (3):
				interfaceExcluir();
				break;
			case (4):
				interfaceBuscar();
				break;
			case (0):
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
	}

	// Método ativado a partir do menuInicial (opção 1)
	public void interfaceCadastro() {
		// Recebe os dados do usuario e envia para fachada
		// que terá a responsabilidade de integrar as outras classes do sistema

		System.out.println("Criação de usuário!");
		System.out.print("Nome: ");
		String nome = leitor.next();

		System.out.print("Sobrenome: ");
		String sobrenome = leitor.next();

		System.out.print("Login: ");
		String login = leitor.next();

		System.out.print("Senha: ");
		String senha = leitor.next();

		System.out.print("Email: ");
		String email = leitor.next();

		System.out.print("Profissão: ");
		String profissao = leitor.next();

		fachadaNoLogin.cadastrar(login, senha, email, nome, sobrenome, profissao);

	}

	// Método ativado a partir do menuInicial (opção 3)
	public void interfaceExcluir() {
		// Método que pede seu login e senha para excluir a sua conta

		System.out.println("Excluir sua conta!");
		System.out.print("Digite seu login: ");
		String login = leitor.next();

		System.out.print("Digite sua senha: ");
		String senha = leitor.next();

		try {
			fachadaNoLogin.excluir(login, senha);
		} catch (AuthenticationException e) {
			System.out.println(e.getMessage());
		}

	}

	// Método ativado a partir do menuInicial (opção 4) ou menuLogin (opção 1)
	public void interfaceBuscar() {
		// Busca um usuário por parte do seu nome, sobrenome ou login
		System.out.println("Pesquisar!");
		System.out.print("Digite parte do nome, sobrenome ou login: ");
		String palavra = leitor.next();

		// Salva o resultado da busca em um ArrayList<Usuario> e imprime o resultado
		try {
			ArrayList resultado = fachadaNoLogin.buscarUsuario(palavra);
			System.out.println(resultado);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	// Menu ativado a partir do menuInicial (opção 2)
	public void menuLogin() {
		// Loga o usuário e apresenta um sub menu com diversas opções

		System.out.print("Login: ");
		String login = leitor.next();

		System.out.print("Senha: ");
		String senha = leitor.next();

		try {
			fachada.login(login, senha);
			int opcao = -1;

			while (opcao != 0) {
				System.out.println("");
				System.out.println("1 - Buscar por usuário");
				System.out.println("2 - Amizades");
				System.out.println("3 - Publicar poema");
				System.out.println("4 - Meus poemas");
				System.out.println("5 - Feed de poemas");
				System.out.println("6 - Enviar Direct Message");
				System.out.println("7 - Ver suas mensagens");
				System.out.println("0 - Encerrar a sessão");
				System.out.print("Escolha uma opção: ");
				opcao = leitor.nextInt();

				switch (opcao) {
				case (1):
					interfaceBuscar();
					break;
				case (2):
					menuAmizades();
					break;
				case (3):
					interfacePost();
					break;
				case (4):
					meusPoemas();
					break;
				case (5):
					feedPoemas();
					break;
				case (6):
					interfaceMensagem();
					break;
				case (7):
					verMensagens();
					break;
				case (0):
					break;
				default:
					System.out.println("Opção inválida.");
				}
			}

		} catch (AuthenticationException e) {
			System.out.println(e.getMessage());
		}

	}

	// Menu que apresenta opções referentes aos amigos (adicionar, remover e listar)
	// Ativado a partir do menuLogin (opção 2)
	public void menuAmizades() {
		int opcao = -1;

		while (opcao != 0) {
			System.out.println("");
			System.out.println("1 - Adicionar amigo");
			System.out.println("2 - Remover amigo");
			System.out.println("3 - Listar amigos");
			System.out.println("0 - Voltar ao menu inicial");
			System.out.print("Escolha uma opção: ");
			opcao = leitor.nextInt();

			switch (opcao) {
			case (1):
				interfaceAdd();
				break;
			case (2):
				interfaceRemover();
				break;
			case (3):
				interfaceVerAmigos();
				break;
			case (0):
				break;
			default:
				System.out.println("Opção inválida.");
			}
		}
	}

	// Método ativado a partir do menuAmizades (opção 1)
	public void interfaceAdd() {
		// Adiciona um usuário a lista de amigos do usuário logado

		System.out.println("");
		System.out.print("Digite o login do seu novo amigo: ");
		String login = leitor.next();

		try {
			fachada.addAmigo(login);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	// Método ativado a partir do menuAmizades (opção 2)
	public void interfaceRemover() {
		// Remove um usuário da sua lista de amigos

		System.out.println("");
		System.out.print("Digite o login do amigo que você quer remover: ");
		String login = leitor.next();

		try {
			fachada.removerAmigo(login);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	// Método ativado a partir do menuAmizades (opção 3)
	public void interfaceVerAmigos() {
		// Imprime todos os amigos de um usuário
		System.out.println(fachada.verAmigos());
	}

	// Interface ativada a partir do menuLogin
	public void interfacePost() {
		// Publica um novo poema
		// Por hora, não será possível fazer um post de poema com quebras de linhas
		// Mas fica a dica pra Igor e Hemilly do futuro
		
		leitor.nextLine();
		
		System.out.println("Título: ");
		String titulo = leitor.nextLine();
		
		System.out.println("Escopo: ");
		String escopo = leitor.nextLine();
		
		fachada.publicarPoema(titulo, escopo);
		
	}

	public void interfaceMensagem() {
		leitor.nextLine();
		System.out.print("Destinatário da mensagem: ");
		String loginDestinatario = leitor.next();

		leitor.nextLine();

		System.out.println("Digite sua mensagem (limite 140 caracteres):");
		String texto = leitor.nextLine();

		fachada.enviarMensagem(texto, loginDestinatario);
	}

	public void verMensagens() {
		// Mostra ao usuário as suas últimas mensagens recebidas
		// ordenadas em ordem decrescente de data/hora de envio

		System.out.println("Mensagens ordenadas pelas mais recentes");
		ArrayList mensagens = fachada.verMensagens();

		int cont = 0;
		while (cont < mensagens.size()) {
			System.out.println(mensagens.get(cont));

			if (cont == 0) {
				System.out.println("1 - Próxima mensagem");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = leitor.nextInt();

				switch (opcao) {
				case (1):
					cont++;
					break;
				case (0):
					cont = mensagens.size();
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
			} else if (cont == mensagens.size() - 1) {
				System.out.println("1 - Mensagem anterior");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = leitor.nextInt();

				switch (opcao) {
				case (1):
					cont--;
					break;
				case (0):
					cont = mensagens.size();
					break;
				default:
					System.out.println("Opção inválida");
				}
			} else {
				System.out.println("1 - Próxima mensagem");
				System.out.println("2 - Mensagem anterior");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = leitor.nextInt();

				switch (opcao) {
				case (1):
					cont++;
					break;
				case (2):
					cont--;
					break;
				case (0):
					cont = mensagens.size();
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
			}
		}

	}
	
	public void feedPoemas() {
		System.out.println("\nFeed de poemas");
		ArrayList<Poema> poemas = fachada.verPoemasDeAmigos();

		int cont = 0;
		if(poemas.size() == 0) {
			System.out.println("\nNão há poemas a serem mostrados.");
		}
		
		while (cont < poemas.size()) {
			System.out.println(poemas.get(cont));

			if (cont == 0) {
				System.out.println("1 - Próximo poema");
				System.out.println("2 - Comentar");
				System.out.println("3 - Ver comentários deste poema");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = leitor.nextInt();

				switch (opcao) {
				case (1):
					cont++;
					break;
				case (2):
					comentar(poemas.get(cont).getSerial());
					break;
				case (3):
					verComentarios(poemas.get(cont).getSerial());
					break;
				case (0):
					cont = poemas.size();
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
			} else if (cont == poemas.size() - 1) {
				System.out.println("1 - Poema anterior");
				System.out.println("2 - Comentar");
				System.out.println("3 - Ver comentários deste poema");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = leitor.nextInt();

				switch (opcao) {
				case (1):
					cont--;
					break;
				case (2):
					comentar(poemas.get(cont).getSerial());
					break;
				case (3):
					verComentarios(poemas.get(cont).getSerial());
					break;
				case (0):
					cont = poemas.size();
					break;
				default:
					System.out.println("Opção inválida");
				}
			} else {
				System.out.println("1 - Próximo poema");
				System.out.println("2 - Comentar");
				System.out.println("3 - Ver comentários deste poema");
				System.out.println("4 - Poema anterior");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = leitor.nextInt();

				switch (opcao) {
				case (1):
					cont++;
					break;
				case (2):
					comentar(poemas.get(cont).getSerial());
					break;
				case (3):
					verComentarios(poemas.get(cont).getSerial());
					break;
				case (4):
					cont--;
					break;
				case (0):
					cont = poemas.size();
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
			}
		}
	}
	
	public void meusPoemas() {
		System.out.println("\nMeus poemas");
		ArrayList<Poema> poemas = fachada.verPoemasDeUsuario();

		int cont = 0;
		if(poemas.size() == 0) {
			System.out.println("\nVocê não possui poemas publicados.");
		}
		
		while (cont < poemas.size()) {
			System.out.println(poemas.get(cont));

			if (cont == 0) {
				System.out.println("1 - Próximo poema");
				System.out.println("2 - Apagar poema");
				System.out.println("3 - Comentar");
				System.out.println("4 - Ver comentários deste poema");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = leitor.nextInt();

				switch (opcao) {
				case (1):
					cont++;
					break;
				case (2):
					fachada.excluirPoema(poemas.get(cont).getSerial());
					cont++;
					break;
				case (3):
					comentar(poemas.get(cont).getSerial());
					break;
				case (4):
					verComentarios(poemas.get(cont).getSerial());
					break;
				case (0):
					cont = poemas.size();
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
			} else if (cont == poemas.size() - 1) {
				System.out.println("1 - Poema anterior");
				System.out.println("2 - Apagar poema");
				System.out.println("3 - Comentar");
				System.out.println("4 - Ver comentários deste poema");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = leitor.nextInt();

				switch (opcao) {
				case (1):
					cont--;
					break;
				case (2):
					fachada.excluirPoema(poemas.get(cont).getSerial());
					cont++;
					break;
				case (3):
					comentar(poemas.get(cont).getSerial());
					break;
				case (4):
					verComentarios(poemas.get(cont).getSerial());
					break;
				case (0):
					cont = poemas.size();
					break;
				default:
					System.out.println("Opção inválida");
				}
			} else {
				System.out.println("1 - Próximo poema");
				System.out.println("2 - Apagar poema");
				System.out.println("3 - Comentar");
				System.out.println("4 - Ver comentários deste poema");
				System.out.println("5 - Poema anterior");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = leitor.nextInt();

				switch (opcao) {
				case (1):
					cont++;
					break;
				case (2):
					fachada.excluirPoema(poemas.get(cont).getSerial());
					cont++;
					break;
				case (3):
					comentar(poemas.get(cont).getSerial());
					break;
				case (4):
					verComentarios(poemas.get(cont).getSerial());
					break;
				case (5):
					cont--;
					break;
				case (0):
					cont = poemas.size();
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
			}
		}
	}
	
	public void comentar(int serialPoema) {
		leitor.nextLine();
		System.out.println("Digite seu comentário: ");
		String corpo = leitor.nextLine();
		
		fachada.criarComentario(corpo, serialPoema);
		
	}	

	public void verComentarios(int serialPoema) {
		System.out.println("\nComentários deste poema");
		ArrayList<Comentario> comentarios = fachada.verComentariosDePoema(serialPoema);

		int cont = 0;
		if(comentarios.size() == 0) {
			System.out.println("\nEsse poema não possui comentários.");
		}
		
		while (cont < comentarios.size()) {
			System.out.println(comentarios.get(cont));

			if (cont == 0) {
				System.out.println("1 - Próximo comentario");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = leitor.nextInt();

				switch (opcao) {
				case (1):
					cont++;
					break;
				case (0):
					cont = comentarios.size();
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
			} else if (cont == comentarios.size() - 1) {
				System.out.println("1 - Comentário anterior");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = leitor.nextInt();

				switch (opcao) {
				case (1):
					cont--;
					break;
				case (0):
					cont = comentarios.size();
					break;
				default:
					System.out.println("Opção inválida");
				}
			} else {
				System.out.println("1 - Próximo comentário");
				System.out.println("2 - Comentário anterior");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = leitor.nextInt();

				switch (opcao) {
				case (1):
					cont++;
					break;
				case (2):
					cont--;
					break;
				case (0):
					cont = comentarios.size();
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
			}
		}
	}
	
}
