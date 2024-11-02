package br.com.autocare.model.entidades;

public class Oficina {
	
	//atributos
	private String nome;
	private int idoficina;
	private String enderecoOficina;
	private String telefone;
	private boolean disponibilidade;
	
	//métodos getters e setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdoficina() {
		return idoficina;
	}
	public void setIdoficina(int idoficina) {
		this.idoficina = idoficina;
	}
	public String getEnderecoOficina() {
		return enderecoOficina;
	}
	public void setEnderecoOficina(String enderecoOficina) {
		this.enderecoOficina = enderecoOficina;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public boolean getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	//método construtor
	public Oficina(String nome, int idoficina, String enderecoOficina, String telefone, boolean disponibilidade) {
		super();
		this.idoficina = idoficina;
		this.enderecoOficina = enderecoOficina;
		this.telefone = telefone;
		this.disponibilidade = disponibilidade;
		this.nome = nome;
		System.out.printf("\nUma nova oficina foi criada!\n");
	}
	@Override
	public String toString() {
		return "\nNome: " + nome + "\nID: " + idoficina + "\nEndereço: " + enderecoOficina
				+ "\nTelefone: " + telefone + "\nDisponibilidade: " + disponibilidade + "\n";
	}
	
	
}