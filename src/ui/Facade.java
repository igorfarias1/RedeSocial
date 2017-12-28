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

	public void excluir(String login, String senha) throws AuthenticationException {
		conexaoUsuario.excluirUsuario(login, senha);
	}

	public ArrayList<Usuario> buscarUsuario(String busca) {
		return conexaoUsuario.buscarUsuario(busca);

	}

	public void login(String login, String senha) throws AuthenticationException {
		conexaoUsuario.validarLogin(login, senha);
	}

}
