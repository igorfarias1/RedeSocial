package ui;

import java.util.ArrayList;

import beans.Usuario;
import controllers.DAOUsuario;
import exceptions.AuthenticationException;

public class FacadeNoLogin {
	
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

}
