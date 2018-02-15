package beans;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import controllers.DAOMensagem;
public class Testa {

	public static void main(String[] args) {
		
		Mensagem m = new Mensagem();
		DAOMensagem d = new DAOMensagem();
		
		Usuario u1 = new Usuario();
		u1.setLogin("igorzin");
		
		Usuario u2 = new Usuario();
		u2.setLogin("hemilis");
		
		m.setDataHora(Timestamp.valueOf(LocalDateTime.now()));
		m.setTexto("oi sumida rs");
		m.setRemetente(u1);
		m.setDestinatario(u2);
		
		d.enviarMensagem(m);
		
		
	}

}
