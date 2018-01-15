package ui;

import beans.*;
import controllers.*;
import exceptions.*;
import java.util.ArrayList;

public class Facade {

	private DAOUsuario conexaoUsuario = new DAOUsuario();
	private DAOAmizade conexaoAmizade = new DAOAmizade();
	private Usuario usuarioLogado = new Usuario();

	public void login(String login, String senha) throws AuthenticationException {
		conexaoUsuario.validarLogin(login, senha);
		usuarioLogado.setLogin(login);
		usuarioLogado.setSenha(senha);
		
	}
	
	public void addAmigo(String loginAmigo) throws UserNotFoundException {
		conexaoAmizade.adicionarAmigo(usuarioLogado.getLogin(), loginAmigo);
	}
	
	public void removerAmigo(String loginAmigo) throws UserNotFoundException {
		conexaoAmizade.removerAmigo(usuarioLogado.getLogin(), loginAmigo);
	}
	
	public ArrayList<Usuario> verAmigos() {
		return conexaoAmizade.listarAmigos(usuarioLogado.getLogin());
	}
	


}
