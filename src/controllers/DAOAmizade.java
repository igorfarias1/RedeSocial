package controllers;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import exceptions.UserNotFoundException;
import beans.Usuario;

public class DAOAmizade {

	private ConexaoBD conexao;

	public DAOAmizade() {
		// cria o objeto para conexão com banco, porém não o inicializa
		// a conexão deve ser aberta e, consequentemente, fechada durante o envio de
		// comandos ao banco

		this.conexao = new ConexaoBD();
	}

	public void adicionarAmigo(String u1, String u2) throws UserNotFoundException {
		conexao.conectar();
		DAOUsuario temp = new DAOUsuario();
		if (temp.buscarUsuario(u2).size() == 0) {
			throw new UserNotFoundException("Não foi possível adicionar " + u2 + " aos seus amigos.");
		}

		try {

			PreparedStatement stm = conexao.getConexao()
					.prepareStatement("INSERT INTO beans.amizade(usuario1, usuario2) VALUES (?,?);");

			stm.setString(1, u1);
			stm.setString(2, u2);

			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			conexao.desconectar();
		}

	}

	public void removerAmigo(String u1, String u2) throws UserNotFoundException {
		conexao.conectar();

		try {
			ResultSet amizadeExistente = conexao.executarSQL(
					"SELECT * FROM beans.amizade WHERE usuario1 = '" + u1 + "' AND usuario2 = '" + u2 + "';");

			if (!amizadeExistente.next()) {
				throw new UserNotFoundException("Não foi possível remover o amigo.");
			}

			PreparedStatement stm = conexao.getConexao()
					.prepareStatement("DELETE FROM beans.amizade WHERE usuario1 = ? AND usuario2 = ?");

			stm.setString(1, u1);
			stm.setString(2, u2);

			stm.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}

	public ArrayList<Usuario> listarAmigos(String loginUsuario) {
		conexao.conectar();
		ArrayList<Usuario> arrayAmigos = new ArrayList<>();
		ResultSet conjuntoAmigos = conexao.executarSQL(
				"SELECT * FROM beans.usuario, beans.amizade WHERE amizade.usuario2 = usuario.login AND amizade.usuario1 = '"
						+ loginUsuario + "';");

		try {
			while (conjuntoAmigos.next()) {
				String login = conjuntoAmigos.getString("login");
				String senha = conjuntoAmigos.getString("senha");
				String email = conjuntoAmigos.getString("email");
				String primeiroNome = conjuntoAmigos.getString("primeiro_nome");
				String sobrenome = conjuntoAmigos.getString("sobrenome");
				String profissao = conjuntoAmigos.getString("profissao");
				
				arrayAmigos.add(new Usuario(login, senha, email, primeiroNome, sobrenome, profissao));	

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			conexao.desconectar();
		}

		return arrayAmigos;
	}

}
