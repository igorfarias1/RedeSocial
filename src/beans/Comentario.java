package beans;

import java.sql.Timestamp;

public class Comentario {
	
	private int id;
	private Timestamp dataHora;
	private String corpo;
	private Usuario autor;
	private Poema poema;
	
	public Comentario() {
		this.autor = new Usuario();
		this.poema = new Poema();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCorpo() {
		return corpo;
	}
	
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	
	public Usuario getAutor() {
		return autor;
	}
	
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
	public Timestamp getDataHora() {
		return this.dataHora;
	}
	
	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}
	
	public Poema getPoema() {
		return poema;
	}

	public void setPoema(Poema poema) {
		this.poema = poema;
	}

	@Override
	public String toString() {
		return "\n-----------" + this.getAutor().getLogin() + " comentou:\n" + this.getCorpo() + "\n" + this.getDataHora() + "\n-----------\n";
	}

}
