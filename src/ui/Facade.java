package ui;

import beans.*;
import controllers.*;
import exceptions.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Facade {

	private DAOUsuario conexaoUsuario = new DAOUsuario();
	private DAOAmizade conexaoAmizade = new DAOAmizade();
	private DAOPoema conexaoPoema = new DAOPoema();
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
	
	public void publicarPoema(String titulo, String escopo) {
		Timestamp t = Timestamp.valueOf(LocalDateTime.now());
		Poema p = new Poema(t, titulo, escopo, usuarioLogado);
		
		conexaoPoema.criarPoema(p);
		
	}
	


}
