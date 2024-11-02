package br.com.autocare.model.entidades;


public class Servico {
	
	//atributos da classe
	private int idservico;
	private String data;
	private Veiculo veiculo;
	private boolean status;
	private Mecanico mecanico;
	private Diagnostico diagnostico;
	
	//métodos getters e setters
	public int getIdservico() {
		return idservico;
	}
	public void setIdservico(int idservico) {
		this.idservico = idservico;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Mecanico getMecanico() {
		return mecanico;
	}
	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}
	
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}
	public void setMecanico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	//método construtor
	public Servico(int idservico, String data, Veiculo veiculo,  boolean status,Mecanico mecanico, Diagnostico diagnostico) {
		this.idservico = idservico;
		this.data = data;
		this.veiculo = veiculo;
		this.status = status;
		this.mecanico = mecanico;
		this.diagnostico = diagnostico;
	}
	
	//método toString
	@Override
	public String toString() {
		return "\nID: " + idservico + "\nData: " + data + "\nVeiculo: " + veiculo + "\nStatus:" + status
				+ "\nMecânico: "+getMecanico()+ "Diagnóstico: "+ getDiagnostico() +"\n";
	}

}
