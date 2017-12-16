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
		// a conexão deve ser aberta e, consequentemente, fechada durante o envio de
		// comandos
		// ao banco
		this.conexao = new ConexaoBD();
	}

	public void criarUsuario(Usuario p) {
		// abrindo a conexão com o BD
		conexao.conectar();

		try {
			// usando um PreparedStatement com valores externos como parâmetros
			// (representados pelo '?')
			PreparedStatement pst = conexao.getConexao().prepareStatement(
					"INSERT INTO beans.usuario(login, senha, email, primeiro_nome, sobrenome, profissao) VALUES(?,?,?,?,?,?);");
			// os métodos set devem ser escolhidos de acordo com os tipos dos atributos da
			// entidade que está
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

	// Método que recebe, por questão de segurança, o login e a senha do usuário
	public void excluirUsuario(String login, String senha) {
		// abrindo a conexão com o BD
		conexao.conectar();

		try {
			// Os comandos SQL verificam se login E a senha correspondem
			// ao informado no menuExcluir() da UserInterface
			PreparedStatement stm = conexao.getConexao()
					.prepareStatement("DELETE FROM beans.usuario WHERE login = ? AND senha = ?;");
			stm.setString(1, login);
			stm.setString(2, senha);
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
	}

	public ArrayList<Usuario> buscarUsuario(String palavraDeBusca) {
		// Busca um usuário por parte do seu nome, sobrenome ou login
		conexao.conectar();
		ArrayList<Usuario> usuarios = new ArrayList<>();

		// Procura no banco de dados os usuarios que possuem palavraDeBusca no seu
		// login, nome ou sobrenome
		ResultSet resultado = conexao.executarSQL(
				"SELECT * FROM beans.usuario " + "WHERE login LIKE '%" + palavraDeBusca + "%' OR primeiro_nome LIKE '%"
						+ palavraDeBusca + "%'" + " OR sobrenome LIKE '%" + palavraDeBusca + "%';");

		try {
			while (resultado.next()) {
				String login = resultado.getString("login");
				String senha = resultado.getString("senha");
				String email = resultado.getString("email");
				String primeiroNome = resultado.getString("primeiro_nome");
				String sobrenome = resultado.getString("sobrenome");
				String profissao = resultado.getString("profissao");
				
				usuarios.add(new Usuario(login, senha, email, primeiroNome, sobrenome, profissao));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return usuarios;
	}

	// LEMBRAR: Os proximos metodos (buscarUsuario, editar, remover...) estão
	// salvos no email para serem ajeitados nos proximos marcos.
}