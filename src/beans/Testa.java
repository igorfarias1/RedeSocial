package beans;

public class Testa {

	public static void main(String[] args) {
		
		Mensagem m = new Mensagem();
		Usuario u1 = new Usuario();
		u1.setLogin("lukinho");
		Usuario u2 = new Usuario();
		u2.setLogin("kyloren");
		m.setTexto("oi sumido rs");
		m.setRemetente(u1);
		m.setDestinatario(u2);
		
		System.out.println(m);
		
	}

}
