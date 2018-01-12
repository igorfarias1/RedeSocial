//CLASSE INUTILIZADA POR ENQUANTO

package controllers;

import beans.Poema;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOPoema {

	private ConexaoBD conexao;
	
	public DAOPoema() {
		// cria o objeto para conexão com banco, porém não o inicializa
		// a conexão deve ser aberta e, consequentemente, fechada durante o envio de
		// comandos ao banco
		this.conexao = new ConexaoBD();
	}
	
	public void criarPoema(Poema p) {
		
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("INSERT INTO beans.poema(titulo, escopo,  media_avaliacoes, login_autor) VALUES(?,?,?,?)");
			
			stm.setString(1, p.getTitulo());
			stm.setString(2, p.getEscopo());
			stm.setDouble(3, p.getMediaAvaliacao());
			stm.setString(4, p.getAutor().getLogin());
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			conexao.desconectar();
		}
		
		
		
	}
	
}
