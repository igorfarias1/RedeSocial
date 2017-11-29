package beans;
import java.util.ArrayList;

/*
 * Algumas dúvidas:
 * - Nos métodos setters o código recebe a senha como argumento, 
 * 		seria melhor o próprio metodo pedir essa senha para verificá-la?
 * - Dúvida com o retorno de getAmigos() e de procurarAmigo():
 * 		deixo void e printo na tela ou deixo String?
 * 
 * 
 * - Nos metodos getters eu verifico se o perfil é privado, e apenas caso não seja,
 * o metodo retornará o devido atributo. 
 * O problema é caso  perfil seja privado nem mesmo as classes DAO serão capazes de acessar os atributos.
 * 
 */

public class Usuario {

	private String login;
	private String senha;
	private String email;
	private String primeiroNome;
	private String sobrenome;
	private String profissao;
//	private ArrayList<Usuario> amigos = new ArrayList<Usuario>();
	private boolean perfilPrivado;

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
	
/*	public void adicionarAmigo(Usuario amigo) {
		this.amigos.add(amigo);
		System.out.println("Amigo adicionado!");
	}

	public void desfazerAmigo(Usuario amigo) {
		this.amigos.remove(amigo);
		System.out.println(amigo.primeiroNome + " foi removido.");
	}
	
	// Procura um amigo dentre os amigos do usuario
	
	// Tô achando esse método bastante ilegível, eu poderia melhorá-lo?
	public void procurarAmigo(String nome) {
		ArrayList<String> encontrados = new ArrayList<>();
		for (Usuario x : amigos) {
			if(x.primeiroNome.contains(nome) || x.sobrenome.contains(nome)) {
				encontrados.add(x.toString());
			}
			if(x.login.contains(nome)) {
				 
				if (!encontrados.contains(x.toString())) {
					encontrados.add(x.toString());
				}
			}
		}
		System.out.println(encontrados);
	}
*/
	
	public void setPerfilPrivado(boolean perfilPrivado, String senha) {
		if (senha == this.senha) {
			this.perfilPrivado = perfilPrivado;
		} else {
			System.out.println("Senha incorreta. Permissão negada.");
		}
	}

	public boolean isPerfilPrivado() {
		return perfilPrivado;
	}

	public String getEmail() {
		if(!isPerfilPrivado()) {
			return email;
		} else {
			System.out.println("Permissão negada.");
			return null;
		}
	}
	
	public void setEmail(String email, String senha) {
		if (senha == this.senha) {
			this.email = email;
		} else {
			System.out.println("Senha incorreta. Permissão negada.");
		}
	}
	
	public String getPrimeiroNome() {
		if(!isPerfilPrivado()) {
			return primeiroNome;
		} else {
			System.out.println("Permissão negada.");
			return null;
		}
	}

	public void setPrimeiroNome(String primeiroNome, String senha) {
		if (senha == this.senha) {
			this.primeiroNome = primeiroNome;
		} else {
			System.out.println("Senha incorreta. Permissão negada.");
		}
	}

	public String getSobrenome() {
		if(!isPerfilPrivado()) {
			return sobrenome;
		} else {
			System.out.println("Permissão negada.");
			return null;
		}
	}

	public void setSobrenome(String sobrenome, String senha) {
		if (senha == this.senha) {
			this.sobrenome = sobrenome;
		} else {
			System.out.println("Senha incorreta. Permissão negada.");
		}
	}

	public String getProfissao() {
		if(!isPerfilPrivado()) {
			return profissao;
		} else {
			System.out.println("Permissão negada.");
			return null;
		}
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
	
/*	public ArrayList<Usuario> getAmigos() {
		if(!isPerfilPrivado()) {
			System.out.println("Amigos de " + primeiroNome);
			System.out.println(amigos);
			return amigos;
		} else {
			System.out.println("Permissão negada.");
			return null;
		}
	}*/
	
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
