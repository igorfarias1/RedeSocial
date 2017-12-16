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

	public Usuario(String login, String senha, String email, String primeiroNome, String sobrenome, String profissao) {
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;

	}

	@Override
	public String toString() {
		return login + " - " + primeiroNome + " " + sobrenome;
	}

}
