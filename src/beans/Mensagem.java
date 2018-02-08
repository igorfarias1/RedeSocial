package beans;

public class Mensagem {

	private Usuario remetente;
	private Usuario destinatario;
	private String texto;

	public Usuario getRemetente() {
		return remetente;
	}
	
	public Usuario getDestinatario() {
		return destinatario;
	}

	public String getTexto() {
		return texto;
	}
	
	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}
	
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		return "------------\nDe: " + remetente.getLogin() + "\nPara: " + destinatario.getLogin() + "\n" + texto + "\n------------";
	}
}
