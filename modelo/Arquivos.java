package modelo;

public class Arquivos {
	private int id;
	private String nome;
	private String caminho;
	private String formato;
	
	public Arquivos(int id, String nome, String caminho, String formato) {
		this.id = id;
		this.nome = nome;
		this.caminho = caminho;
		this.formato = formato;
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
}
