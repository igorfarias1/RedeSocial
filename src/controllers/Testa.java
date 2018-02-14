package controllers;

import beans.Poema;
import beans.Usuario;
import java.sql.Timestamp;
import java.time.LocalDateTime;
public class Testa {

	
	
	
	
	
	
	
	public static void main(String[] args) {
		DAOPoema lala = new DAOPoema();
		Timestamp t = Timestamp.valueOf(LocalDateTime.now());
		Usuario u = new Usuario("igorzin", "sha", "ahsdk", "haha", "hehe", "kiu");
		
		
		Poema p = new Poema(t, "amor", "humor\n--oioi", u);
		System.out.println(p);
		lala.criarPoema(p);
		

	}

}
