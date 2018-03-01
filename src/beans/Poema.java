package beans;

import java.sql.Timestamp;

public class Poema {
	
	private int serial;
	private Timestamp dataHora;
	private String titulo;
	private String escopo;
	private Usuario autor = new Usuario();

	public Poema(Timestamp dataHora, String titulo, String escopo, Usuario autor) {
		this.dataHora = dataHora;
		this.titulo = titulo;
		this.escopo = escopo;
		this.autor = autor;
	}
	
	public Poema(int serial, Timestamp dataHora, String titulo, String escopo, double mediaAvaliacao, Usuario autor) {
		this.serial = serial;
		this.dataHora = dataHora;
		this.titulo = titulo;
		this.escopo = escopo;
		this.autor = autor;
		
	}
	
	public Poema() {
		
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setEscopo(String escopo) {
		this.escopo = escopo;
	}
	
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEscopo() {
		return escopo;
	}
	
	public Usuario getAutor() {
		return autor;
	}
	
	public int getSerial() {
		return serial;
	}
	
	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	@Override
	public String toString() {
		return "\n-----------\n" + this.getDataHora() + "\n" + this.getTitulo() + "\n\n" + this.getEscopo() + "\n\nPostado por: " + this.getAutor().getLogin() + "\n-----------\n";
	}

}