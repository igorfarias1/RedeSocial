package ui;

import java.util.Scanner;
import javax.naming.AuthenticationException;
import beans.*;
import controllers.*;

public class Teste {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		String texto = "";
		String linha = "";

		System.out.println("Digite seu texto: (dê enter e digite -- para finalizar) ");
		while (linha != "--") {
			linha = leitor.nextLine();
			texto = texto + "\n" + linha;
			switch (linha) {
			case ("--"):
				linha = "--";
				break;
			default:
				break;
			}
			System.out.println(texto);
		}

	}

}
