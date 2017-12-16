<<<<<<< HEAD
package ui;

import beans.*;
import controllers.*;
import java.util.ArrayList;

public class Facade {
	
	private DAOUsuario conexaoUsuario = new DAOUsuario();
	
	public void cadastrar(String login, String senha, String email, String nome, String sobrenome, String profissao) {
		Usuario novoUsuario = new Usuario(login, senha, email, nome, sobrenome, profissao);
		conexaoUsuario.criarUsuario(novoUsuario);
	}
	
	public void excluir(String login, String senha) {
		conexaoUsuario.excluirUsuario(login, senha);
	}
	
	public ArrayList<Usuario> buscarUsuario(String busca) {
		return conexaoUsuario.buscarUsuario(busca);
		
	}
=======

//Ignore essa classe por enquanto, a interface do marco 2 é a InterfaceProvisória

package ui;

import java.util.Scanner;
import beans.*;
import controllers.*;

public class Facade {

	public void cadastrarUsuario() {

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

>>>>>>> 901e39503ae57f036aed15f0d1646435414bec68
}
