package ui;

import java.util.Scanner;
import beans.*;
import controllers.*;
public class InterfaceProvisoria {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Criação de usuário!");
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
		
		Usuario u = new Usuario(login, senha, email, nome, sobrenome, profissao);
		
		DAOUsuario integrador = new DAOUsuario();
		
		integrador.criarUsuario(u);
		
		
		
	}
	
}
