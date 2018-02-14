//CLASSE INUTILIZADA POR ENQUANTO

package controllers;

import beans.Poema;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.omg.Messaging.SyncScopeHelper;

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
			PreparedStatement stm = conexao.getConexao().prepareStatement("INSERT INTO beans.poema(data_hora, titulo, escopo, login_usuario) VALUES(?,?,?,?)");
			
			stm.setTimestamp(1, p.getDataHora());
			stm.setString(2, p.getTitulo());
			stm.setString(3, p.getEscopo());
			stm.setString(4, p.getAutor().getLogin());
			
			stm.execute();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			conexao.desconectar();
		}
		
		
		
	}
	
}
