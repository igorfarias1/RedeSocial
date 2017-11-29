package controllers;

import beans.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class DAOUsuario {
	
	private ConexaoBD conexao;
	
	public DAOUsuario() {
		// cria o objeto para conexão com banco, porém não o inicializa
		// a conexão deve ser aberta e, consequentemente, fechada durante o envio de comandos
		// ao banco
		this.conexao = new ConexaoBD();
	}
	
	public void criarUsuario(Usuario p) {
		// abrindo a conexão com o BD
		conexao.conectar();

		try {
			// usando um PreparedStatement com valores externos como parâmetros (representados pelo '?')
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into beans.usuario(login, senha, email, primeiro_nome, sobrenome, profissao) values(?,?,?,?,?,?)");
			// os métodos set devem ser escolhidos de acordo com os tipos dos atributos da entidade que está
			// sendo acessada. A sequência é determinada por índices, iniciando do valor 1.
			
			pst.setString(1, p.getLogin());
			pst.setString(2, p.getSenha());
			pst.setString(3, p.getEmail());
			pst.setString(4, p.getPrimeiroNome());
			pst.setString(5, p.getSobrenome());
			pst.setString(6, p.getProfissao());
			
			// solicitação da execução da query, após seu preparo
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
		
	}
	
	// busca de pessoas por seu código de identificação no banco (id)
/*	public Usuario buscarUsuario(String login) {
		// abrindo a conexão com o BD
		conexao.conectar();
		// busca utilizando o método de consulta do objeto ConexaoBD
		ResultSet resultado = conexao.executarSQL("select * from usuario where login = \'" + login + "\'");
		Usuario p = new Usuario();
		
		try {
			resultado.next();
			// os métodos get devem ser escolhidos de acordo com os tipos dos atributos da entidade que está
			// sendo acessada
			String loginUser = resultado.getString("login");
			String nomeUser = resultado.getString("primeiro_nome");
			String sobrenomeUser = resultado.getString("sobrenome");
			String emailUser = resultado.getString("email");
			String profUser = resultado.getString("profissao");
			String senha = resultado.getString("senha");
			
			p.setLogin(loginUser, senha);
			p.setPrimeiroNome(nomeUser, senha);
			p.setSobrenome(sobrenomeUser, senha);
			p.setEmail(emailUser, senha);
			p.setProfissao(profUser, senha);
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
		return p;
	}
	
	public void excluirUsuario(String login) {
		// abrindo a conexão com o BD
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from usuario where login = \'" + login + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
	}

	public void editarPessoa(int id, String nome, int idade) {
		// abrindo a conexão com o BD
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("update pessoas set nome = ?, idade = ? "
					+ "where cod_pessoa = \'" + id + "\'");
			stm.setString(1, nome);
			stm.setInt(2, idade);
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
	}
	
	public ArrayList<Pessoa> verTodos() {
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		
		// abrindo a conexão com o BD
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from pessoas");
		
		try {
			// para iterar sobre os resultados de uma consulta, deve-se utilizar o método next()
			while (resultado.next()) {
				int idPessoa = resultado.getInt("cod_pessoa");
				String nomePessoa = resultado.getString("nome");
				int idadePessoa = resultado.getInt("idade");
				pessoas.add(new Pessoa(idPessoa, nomePessoa, idadePessoa));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
		return pessoas;
	}
*/
}