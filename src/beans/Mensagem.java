package beans;

import java.sql.Timestamp;

public class Mensagem {

	private int id;
	private Timestamp dataHora;
	private Usuario remetente;
	private Usuario destinatario;
	private String texto;

	
	public Mensagem(int id, Timestamp dataHora, Usuario remetente, Usuario destinatario, String texto) {
		this.id = id;
		this.dataHora = dataHora;
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.texto = texto;
	}
	
	public Mensagem(Timestamp dataHora, Usuario remetente, Usuario destinatario, String texto) {
		this.dataHora = dataHora;
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.texto = texto;		
	}
	
	public Mensagem() {
		
	}
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public String toString() {
		return "------------\nDe: " 
				+ remetente.getLogin() 
				+ "\nPara: " 
				+ destinatario.getLogin() 
				+ "\n" 
				+ texto
				+ "\n------------";
	}
}
