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
	private DAOMensagem conexaoMensagem = new DAOMensagem();
	private DAOComentario conexaoComentario = new DAOComentario();
	private Usuario usuarioLogado = new Usuario();

	
	private Usuario acharDestinatario(String busca) throws UserNotFoundException {
		return conexaoUsuario.buscarDestinatario(busca);

	}
	
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

	public void enviarMensagem(String texto, String loginDestinatario) {
		Timestamp t = Timestamp.valueOf(LocalDateTime.now());
		try {
			Usuario destinatario = acharDestinatario(loginDestinatario);
			Mensagem novaMensagem = new Mensagem(t, usuarioLogado, destinatario, texto);

			conexaoMensagem.enviarMensagem(novaMensagem);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public ArrayList<Mensagem> verMensagens() {
		return conexaoMensagem.listarMensagens(usuarioLogado.getLogin());
	}
	
	public ArrayList<Poema> verPoemasDeAmigos(){
		return conexaoPoema.exibirPoemasDeAmigos(usuarioLogado.getLogin());
	}

	public ArrayList<Poema> verPoemasDeUsuario(){
		return conexaoPoema.exibirPoemasDoUsuario(usuarioLogado.getLogin());
	}
	
	public void excluirPoema(int serial) {
		conexaoPoema.apagarPoema(serial);
	}
	
	public void criarComentario(String corpo, int serial) {
		Comentario novoComentario = new Comentario();
		Timestamp t = Timestamp.valueOf(LocalDateTime.now());
		Poema p = new Poema();
		p.setSerial(serial);
		
		novoComentario.setAutor(usuarioLogado);
		novoComentario.setCorpo(corpo);
		novoComentario.setDataHora(t);
		novoComentario.setPoema(p);
		
		conexaoComentario.criarComentario(novoComentario);
	}
	
	public ArrayList<Comentario> verComentariosDePoema(int serial){
		return conexaoComentario.listarComentarios(serial);
	}
}
