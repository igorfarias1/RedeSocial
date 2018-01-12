package controllers;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DAOAmizade {
	
	private ConexaoBD conexao;
	
	public DAOAmizade() {
		// cria o objeto para conexão com banco, porém não o inicializa
		// a conexão deve ser aberta e, consequentemente, fechada durante o envio de
		// comandos ao banco
		
		this.conexao = new ConexaoBD();
	}

	public void adicionarAmigo(String u1, String u2) {
		conexao.conectar();
		
		try {
			
			PreparedStatement stm = conexao.getConexao().prepareStatement("INSERT INTO beans.amizade(usuario1, usuario2) VALUES (?,?);");
			
			stm.setString(1, u1);
			stm.setString(2, u2);
			
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			conexao.desconectar();
		}
		
		
	}
	
}
