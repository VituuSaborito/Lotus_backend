package modelo;

public class Arquivos {
	private int id;
	private String nome;
	private String caminho;
	private String formato;
	private String usuario;
	
	public Arquivos(String nome, String caminho, String formato, String usuario) {
		//this.id = id;
		this.nome = nome;
		this.caminho = caminho;
		this.formato = formato;
		this.usuario = usuario;
		
	}
	
	public Arquivos() {
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCaminho() {
		return caminho;
	}
	
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	public String getFormato() {
		return formato;
	}
	
	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	@Override
	public String toString() {
		return this.getNome() + " " + this.getCaminho() + " " + this.getFormato();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
