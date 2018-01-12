

package beans;

public class Poema {
	
	private String titulo;
	private String escopo;
	private double mediaAvaliacao;
	private Usuario autor = new Usuario();

	public Poema(String titulo, String escopo, Usuario autor) {
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

	public void setMediaAvaliacao(double mediaAvaliacao) {
		this.mediaAvaliacao = mediaAvaliacao;
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

	public double getMediaAvaliacao() {
		return mediaAvaliacao;
	}
	
	public Usuario getAutor() {
		return autor;
	}
	
	@Override
	public String toString() {
		return this.getTitulo() + "\n" + this.getEscopo() + "\n" + this.getAutor().getLogin() + " - " + this.getAutor().getPrimeiroNome()
				+ " " + this.getAutor().getSobrenome();
	}

}