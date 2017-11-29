package beans;
import java.util.ArrayList;

/*
 * Algumas dúvidas:
 * - Nos métodos setters o código recebe a senha como argumento, 
 * 		seria melhor o próprio metodo pedir essa senha para verificá-la?
 */

public class Usuario {

	private String login;
	private String senha;
	private String email;
	private String primeiroNome;
	private String sobrenome;
	private String profissao;

	public Usuario() {
		
	}
	
	public Usuario(String login, String senha, String email, String primeiroNome, 
			String sobrenome, String profissao) {
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.primeiroNome = primeiroNome;
		this.sobrenome = sobrenome;
		this.profissao = profissao;
		
	}

	public String getEmail() {
			return email;
	}
	
	public void setEmail(String email, String senha) {
		if (senha == this.senha) {
			this.email = email;
		} else {
			System.out.println("Senha incorreta. Permissão negada.");
		}
	}
	
	public String getPrimeiroNome() {
			return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome, String senha) {
		if (senha == this.senha) {
			this.primeiroNome = primeiroNome;
		} else {
			System.out.println("Senha incorreta. Permissão negada.");
		}
	}

	public String getSobrenome() {
			return sobrenome;
	}

	public void setSobrenome(String sobrenome, String senha) {
		if (senha == this.senha) {
			this.sobrenome = sobrenome;
		} else {
			System.out.println("Senha incorreta. Permissão negada.");
		}
	}

	public String getProfissao() {
			return profissao;
	}

	public void setProfissao(String profissao, String senha) {
		if (senha == this.senha) {
			this.profissao = profissao;
		} else {
			System.out.println("Senha incorreta. Permissão negada.");
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login, String senha) {
		if (senha == this.senha) {
			this.login = login;
		} else {
			System.out.println("Senha incorreta. Permissão negada.");
		}
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String novaSenha, String senhaAtual) {
		if (senhaAtual == this.senha) {
			this.senha = novaSenha;
			System.out.println("Senha alterada!");
		} else {
			System.out.println("Senha atual incorreta. Permissão negada.");
		}

	}
	
	@Override
	public String toString() {
		return login + " - " + primeiroNome + " " + sobrenome;
	}

}
