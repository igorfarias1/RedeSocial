package ui;

import beans.*;
import controllers.*;
import exceptions.*;
import java.util.ArrayList;

public class Facade {

	private DAOUsuario conexaoUsuario = new DAOUsuario();

	public void cadastrar(String login, String senha, String email, String nome, String sobrenome, String profissao) {
		Usuario novoUsuario = new Usuario(login, senha, email, nome, sobrenome, profissao);
		conexaoUsuario.criarUsuario(novoUsuario);
	}

	public void excluir(String login, String senha) {
		try {
			conexaoUsuario.excluirUsuario(login, senha);
		} catch (AuthenticationException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Usuario> buscarUsuario(String busca) {
		return conexaoUsuario.buscarUsuario(busca);

	}

}
