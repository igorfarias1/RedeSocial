package exceptions;

import java.io.IOException;

public class AuthenticationException extends IOException{
	
	public AuthenticationException() {
		super("Erro de autenticação");
	}
	
	public AuthenticationException(String message) {
		super("Erro de autenticação: " + message);
	}
}
