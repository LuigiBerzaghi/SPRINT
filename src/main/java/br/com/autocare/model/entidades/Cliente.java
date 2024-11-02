package br.com.autocare.model.entidades;
import java.io.IOException;



import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import br.com.autocare.services.ViacepService;


public class Cliente {
	
	
	ViacepService viaCep = new ViacepService();
	
	// atributos
	private int id;
    private String nome; //
    private String cpf; //
    private String telefone; //
    private String email; //
    private String senha; //
    private Endereco endereco; //será o CEP
    private List<Veiculo> veiculos;

    //construtor vazio
    public Cliente() {
		super();
	}

	// método construtor
    public Cliente(int id,String nome, String CPF, String telefone, String email, String senha, String cep) throws ClientProtocolException, IOException {
    	this.id = id;
        this.nome = nome;
        this.cpf = CPF;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.endereco = viaCep.getEnderecoo(cep);
        this.veiculos = new ArrayList<>();
        System.out.printf("\nO usuário %s foi cadastrado com sucesso!\n", nome);
    }

    // getters e setters
    
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

    public String getCpf() { 
        return cpf;
    }

    public void setCpf(String cpf) { 
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
    
    @Override
    public String toString() {
        return "\nCliente :" +
               "ID:" + id + 
               ", CPF:'" + cpf + '\'' +
               ", Telefone:'" + telefone + '\'' +
               ", Email:'" + email + '\'' +
               ", Senha:'" + senha + '\'' +
               ", Nome:'" + nome + '\'' +
               ", Endereço:'" + endereco.toString() + '\''
               ;
    }
    
}