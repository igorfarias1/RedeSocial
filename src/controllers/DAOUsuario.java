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
	// LEMBRAR: Os proximos metodos (buscarUsuario, editar, remover...) estão
	// salvos no email para serem ajeitados nos proximos marcos.
}