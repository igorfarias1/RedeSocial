package ui;

import java.util.Scanner;
import javax.naming.AuthenticationException;
import beans.*;
import controllers.*;

public class Teste {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		System.out.println("Titulo: ");
		String titulo = leitor.next();
		String texto = "";
		String linha = "";

		System.out.println("Digite seu texto: (dê enter e digite -- para finalizar) ");
		while (linha != "--") {
			linha = leitor.nextLine();
			char c = 13;
			texto = texto + c + linha;
			switch (linha) {
			case ("--"):
				linha = "--";
				break;
			default:
				break;
			}
		}

	}
}
