package br.com.autocare.model.entidades;

import java.util.ArrayList;
import java.util.List;

public class Diagnostico {
	
	//atributos
	private int idDiagnostico;
	private String datadiagnostico;
	private float orcamento;
	private List<Problema> problemas;
	private Veiculo veiculo;
	
	
	//métodos getters e setters
	public int getIdDiagnostico() {
		return idDiagnostico;
	}
	public void setIdDiagnostico(int idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}
	public List<Problema> getProblemas() {
		return problemas;
	}
	public void setProblemas(List<Problema> problemas) {
		this.problemas = problemas;
	}
	public String getDatadiagnostico() {
		return datadiagnostico;
	}
	public void setDatadiagnostico(String datadiagnostico) {
		this.datadiagnostico = datadiagnostico;
	}
	public float getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	//método construtor 
	public Diagnostico(int idDiagnostico, String datadiagnostico, float orcamento, Veiculo veiculo) {
		System.out.printf("\nUm novo diagnóstico foi criado!\n");
		this.idDiagnostico = idDiagnostico;
		this.datadiagnostico = datadiagnostico;
		this.orcamento = orcamento;
		this.problemas = new ArrayList<>();
		this.veiculo = veiculo;
	}
	
	@Override
	public String toString() {
	    return "\nDiagnóstico ID: " + idDiagnostico + "\nData do diagnóstico: " + datadiagnostico +
	    		"\nOrçamento: " + orcamento + "\nPlaca do veículo: " + veiculo.getPlaca();
	}

}
	
