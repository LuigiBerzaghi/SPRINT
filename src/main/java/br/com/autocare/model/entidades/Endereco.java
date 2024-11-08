package br.com.autocare.model.entidades;

public class Endereco {
	
	private int id;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String uf;
	
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endereco(int id, String cep, String logradouro, String complemento, String bairro, String uf) {
		super();
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "\n"+"CEP: " + cep + ", Logradouro: " + logradouro + ", Complemento: " + complemento + ", Bairro: "
				+ bairro + ", UF: " + uf;
	}	
	
	
}
