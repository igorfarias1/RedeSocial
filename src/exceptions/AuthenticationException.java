package exceptions;

import java.io.IOException;

public class AuthenticationException extends IOException{
	
	// Constrói a exceção com a mensagem padrão
	public AuthenticationException() {
		super("Erro de autenticação");
	}
	
	// Constrói a exceção adicionando informações à mensagem padrão
	public AuthenticationException(String message) {
		super("Erro de autenticação: " + message);
	}
}
