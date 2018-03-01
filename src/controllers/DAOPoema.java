package controllers;

import beans.Poema;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			PreparedStatement stm = conexao.getConexao()
					.prepareStatement("INSERT INTO beans.poema(data_hora, titulo, escopo, autor) VALUES(?,?,?,?)");

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

	public ArrayList<Poema> exibirPoemasDeAmigos(String loginUsuario) {
		conexao.conectar();
		
		ArrayList<Poema> listaPoemas = new ArrayList();

		ResultSet set = conexao.executarSQL(
				"SELECT id, data_hora, autor, escopo, titulo FROM beans.poema, beans.amizade WHERE usuario1 = '"
						+ loginUsuario + "' AND usuario2 = autor ORDER BY data_hora DESC;");

		try {
			while (set.next()) {
				
				int serial = set.getInt("id");
				Timestamp dataHora = set.getTimestamp("data_hora");
				String loginAutor = set.getString("autor");
				String escopo = set.getString("escopo");
				String titulo = set.getString("titulo");
				
				Poema p = new Poema();
				
				p.setDataHora(dataHora);
				p.setSerial(serial);
				p.setEscopo(escopo);
				p.setTitulo(titulo);
				p.getAutor().setLogin(loginAutor);
				
				listaPoemas.add(p);
								
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			conexao.desconectar();
		}
		
		return listaPoemas;

	}
	
	public ArrayList<Poema> exibirPoemasDoUsuario(String loginUsuario) {
		conexao.conectar();
		
		ArrayList<Poema> listaPoemas = new ArrayList();

		ResultSet set = conexao.executarSQL(
				"SELECT id, data_hora, autor, escopo, titulo FROM beans.poema WHERE autor = '"
						+ loginUsuario + "' ORDER BY data_hora DESC;");

		try {
			while (set.next()) {
				
				int serial = set.getInt("id");
				Timestamp dataHora = set.getTimestamp("data_hora");
				String loginAutor = set.getString("autor");
				String escopo = set.getString("escopo");
				String titulo = set.getString("titulo");
				
				Poema p = new Poema();
				
				p.setDataHora(dataHora);
				p.setSerial(serial);
				p.setEscopo(escopo);
				p.setTitulo(titulo);
				p.getAutor().setLogin(loginAutor);
				
				listaPoemas.add(p);
								
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			conexao.desconectar();
		}
		
		return listaPoemas;
	}
	
	public void apagarPoema(int serial) {
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("DELETE FROM beans.poema WHERE id = ?");
			
			stm.setInt(1, serial);
			
			stm.execute();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
