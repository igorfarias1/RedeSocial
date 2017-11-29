package beans;
import java.util.ArrayList;
public class Testes {
	public static void main(String[] args) {
		
		Usuario u1 = new Usuario("igor", "0000", "igorfarias201@gmail.com", "Igor", "Farias");
		Usuario u2 = new Usuario("hemis", "1000", "igorfarias201@gmail.com", "Hemilly", "Sales");
		Usuario u3 = new Usuario("gustav", "2000", "igorfarias201@gmail.com", "Gustavo", "Porto");
		Usuario u4 = new Usuario("dhi", "4000", "igorfarias201@gmail.com", "Dhiego", "Vinicius");
		Usuario u5 = new Usuario("marinhoclaudiojose", "arcoirisjamudoudecor", "igorfarias201@gmail.com", "Claudio José Bezerra Marinho", "Bezerra Marinho");
		Usuario u6 = new Usuario("helo", "5000", "igorfarias201@gmail.com", "Heloisa", "Luana");
		
		
		
		u1.adicionarAmigo(u2);
		u1.adicionarAmigo(u3);
		
		u2.adicionarAmigo(u1);
		u2.adicionarAmigo(u3);
		u2.adicionarAmigo(u6);
		
		u3.adicionarAmigo(u5);
		u3.adicionarAmigo(u2);
		
		ArrayList<Usuario> a = new ArrayList<>();
		a = u2.getAmigos();
		
		u1.procurarAmigo("emi");
		
		
	}
}
