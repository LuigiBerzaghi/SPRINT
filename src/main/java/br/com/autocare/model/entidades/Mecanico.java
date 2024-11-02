package br.com.autocare.model.entidades;

import java.util.List;
import java.util.ArrayList;

public class Mecanico {

	//atributos
	
	private int idmecanico;
	private String nomeMecanico;
	private String telefoneMecanico;
	private List<Oficina> oficinas;
	private List<Servico> servicos;
	
	//métodos getters e setters
	
	
	public int getIdmecanico() {
		return idmecanico;
	}
	public void setIdmecanico(int idmecanico) {
		this.idmecanico = idmecanico;
	}
	public String getNomeMecanico() {
		return nomeMecanico;
	}
	public void setNomeMecanico(String nomeMecanico) {
		this.nomeMecanico = nomeMecanico;
	}
	public String getTelefoneMecanico() {
		return telefoneMecanico;
	}
	public void setTelefoneMecanico(String telefoneMecanico) {
		this.telefoneMecanico = telefoneMecanico;
	}
	public List<Oficina> getOficinas() {
		return oficinas;
	}
	public void setOficinas(List<Oficina> oficinas) {
		this.oficinas = oficinas;
	}
	public List<Servico> getServicos() {
		return servicos;
	}
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	//método construtor
	public Mecanico(int idmecanico, String nomeMecanico, String telefoneMecanico, String enderecoMecanico) {
		super();
		this.idmecanico = idmecanico;
		this.nomeMecanico = nomeMecanico;
		this.telefoneMecanico = telefoneMecanico;
		this.oficinas = new ArrayList<>();
		this.servicos = new ArrayList<>();
		System.out.printf("\nUm novo mecânico foi criado!\n");
	}
	
	//método toString()
	public String toString() {
		return "Mecanico idmecanico=" + idmecanico + "\nnome: " + nomeMecanico + "\ntelefone: "
				+ telefoneMecanico;
	}
	
	
	
	// removi o endereço de atributo do mecanico pois seu endereço será o da oficina
	
	
	
}
