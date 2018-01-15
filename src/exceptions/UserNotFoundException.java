package exceptions;

import java.io.IOException;

//Checked Exception lançada ao tentar fazer-se operações com amigos e estes não forem encontrados
public class UserNotFoundException extends IOException {
	
	//Constrói a exceção com uma mensagem padrão
	public UserNotFoundException() {
		super("Usuário não encontrado.");
	}
	
	//Constrói a exceção com a adição de uma mensagem informando o motivo do lançamento da exceção
	public UserNotFoundException(String message) {
		super("Usuário não encontrado:  " + message);
	}

}
