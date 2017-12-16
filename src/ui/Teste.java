package ui;

import java.util.Scanner;
import beans.*;
import controllers.*;
import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Buscar por: ");
		String busca = leitor.next();
		
		DAOUsuario daoUsuario = new DAOUsuario();
		
		ArrayList<Usuario> resultado = daoUsuario.buscarUsuario(busca);
		
		System.out.println(resultado);
		
		
	}
	
}
