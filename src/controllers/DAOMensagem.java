package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import beans.Mensagem;
import beans.Usuario;

public class DAOMensagem {

	private ConexaoBD conexao;

	public DAOMensagem() {
		// cria o objeto para conexão com banco, porém não o inicializa
		// a conexão deve ser aberta e, consequentemente, fechada durante o envio de
		// comandos ao banco
		this.conexao = new ConexaoBD();

	}

	public void enviarMensagem(Mensagem m) {
		conexao.conectar();

		try {

			PreparedStatement statement = conexao.getConexao()
					.prepareStatement("INSERT INTO beans.mensagem(data_hora, remetente, destinatario, texto) VALUES (?,?,?,?);");

			statement.setTimestamp(1, m.getDataHora());
			statement.setString(2, m.getRemetente().getLogin());
			statement.setString(3, m.getDestinatario().getLogin());
			statement.setString(4, m.getTexto());
			
			statement.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}
	
	public ArrayList<Mensagem> listarMensagens(String loginUsuario) {
		conexao.conectar();
		ArrayList<Mensagem> mensagens = new ArrayList<>();
		
		try {
			
			ResultSet resultado = conexao.executarSQL("SELECT * FROM beans.mensagem WHERE remetente = '%" 
			+ loginUsuario + "%';");
			
			while (resultado.next()) {
				
				int id = resultado.getInt("id");
				Timestamp dataHora = resultado.getTimestamp("data_hora");
				String loginRemetente = resultado.getString("remetente");
				String loginDestinatario = resultado.getString("destinatario");
				String texto = resultado.getString("texto");
				
				Mensagem m = new Mensagem(id, dataHora, new Usuario(), new Usuario(), texto);
				m.getRemetente().setLogin(loginRemetente);
				m.getDestinatario().setLogin(loginDestinatario);
				
				mensagens.add(m);
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			conexao.desconectar();
		}
		
		return mensagens;
	}

}
