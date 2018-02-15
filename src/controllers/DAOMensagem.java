package controllers;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import beans.Mensagem;

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

}
