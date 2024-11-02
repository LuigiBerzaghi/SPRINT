package br.com.autocare.model.entidades;

public class Problema {
	
	//atributos
	
	private int idproblema;
	private String descricao;
	private String causa;
	private String solucao;
	private String status;
	
	
	//método getters e setters
	
	
	public int getIdproblema() {
		return idproblema;
	}
	public void setIdproblema(int idproblema) {
		this.idproblema = idproblema;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public String getSolucao() {
		return solucao;
	}
	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	//método construtor
	
	public Problema(int idproblema, String descricao, String causa, String solucao, String status) {
		this.idproblema = idproblema;
		this.descricao = descricao;
		this.causa = causa;
		this.solucao = solucao;
		this.status = status;
		System.out.printf("\nUm novo problema foi criado!\n");
	}	
	
	//método toString
	public String toString() {
		return  "\nID: " + idproblema + "\nDescrição: " + descricao + "\nCausa: " + causa + "\nSolução: " + solucao + "\nStatus: " + status + "\n";
	}
}