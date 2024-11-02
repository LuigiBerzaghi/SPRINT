package br.com.autocare.model.entidades;
import java.util.ArrayList;
import java.util.List;

public class Veiculo {
	
	//atributos

	private int ano; //
	private Cliente dono;
	private String modelo; //
	private String placa; // 
	private String cor; //
	private String marca; //
	private int idcarro;
	private boolean status;
	private List<Problema> problemas;
	private List<Diagnostico> diagnosticos;

	//métodos getters e setters
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Cliente getDono() {
		return dono;
	}
	public void setDono(Cliente dono) {
		this.dono = dono;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getIdcarro() {
		return idcarro;
	}
	public void setIdcarro(int idcarro) {
		this.idcarro = idcarro;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
    public List<Problema> getProblemas() {
        return problemas;
    }
    public List<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }
    
    //criar um construtor apenas com os atributos que tenham no front-end, o resto entra como nulo
    
	//método construtor
	public Veiculo(int ano, Cliente dono, String modelo, String placa, String cor, String marca, int idcarro, boolean status) {
		this.ano = ano;
		this.dono = dono;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.marca = marca;
		this.idcarro = idcarro;
		this.status = status;
		this.problemas = new ArrayList<>();
		this.diagnosticos = new ArrayList<>();
	}
		
    // Construtor padrão
    public Veiculo() {
        // Inicialização padrão dos atributos, se necessário
        this.problemas = new ArrayList<>();
        this.diagnosticos = new ArrayList<>();
    }
	
	//método toString()
	public String toString() {
		return  "\nAno: " + ano + "\nDono: " + dono.getNome() + "\nModelo: " + modelo + "\nPlaca: " + placa + "\nCor: " + cor
				+ "\nMarca: " + marca + "\nidCarro: " + idcarro;
	}	

}
