package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import beans.Comentario;
import beans.Poema;

public class DAOComentario {

	private ConexaoBD conexao;

	public DAOComentario() {
		// cria o objeto para conexão com banco, porém não o inicializa
		// a conexão deve ser aberta e, consequentemente, fechada durante o envio de
		// comandos ao banco
		this.conexao = new ConexaoBD();
	}

	public void criarComentario(Comentario c) {
		conexao.conectar();

		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement(
					"INSERT INTO beans.comentario(data_hora, corpo, autor, id_poema) VALUES (?,?,?,?);");

			stm.setTimestamp(1, c.getDataHora());
			stm.setString(2, c.getCorpo());
			stm.setString(3, c.getAutor().getLogin());
			stm.setInt(4, c.getPoema().getSerial());

			stm.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			conexao.desconectar();
		}

	}

	public ArrayList<Comentario> listarComentarios(int serialPoema) {
		conexao.conectar();
		ArrayList<Comentario> listaComentarios = new ArrayList();

		ResultSet set = conexao.executarSQL(
				"SELECT * FROM beans.comentario WHERE id_poema = '" + serialPoema + "';");
		try {

			while (set.next()) {

				int id = set.getInt("id");
				Timestamp dataHora = set.getTimestamp("data_hora");
				String loginAutor = set.getString("autor");
				String corpo = set.getString("corpo");
				
				Comentario c = new Comentario();

				c.setDataHora(dataHora);
				c.setId(id);
				c.setCorpo(corpo);
				c.getAutor().setLogin(loginAutor);

				listaComentarios.add(c);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			conexao.desconectar();
		}

		return listaComentarios;
		
	}

}
