package br.com.autocare.controller;

import java.io.IOException;



import org.apache.http.client.ClientProtocolException;

import br.com.autocare.model.entidades.Cliente;
import br.com.autocare.model.entidades.Veiculo;
import br.com.autocare.services.ViacepService;
import br.com.autocare.view.*;

public class ClienteController {
	
	ViacepService viaCep = new ViacepService();
	
	//método que edita os dados do cliente --
	public void editarDadosCliente(Cliente cliente, String nome, String CPF, String telefone, String email, String senha, String cep) throws ClientProtocolException, IOException {
		cliente.setNome(nome);
        cliente.setCpf(CPF);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setSenha(senha);
		cliente.setEndereco(viaCep.getEnderecoo(cep));
        System.out.printf("\nOs dados do usuário %s foram atualizados com sucesso! \nSeus novos dados são: \n", cliente.getNome());
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + CPF);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
        System.out.println("Endereço: " + cliente.getEndereco().toString());
        System.out.println("Id: " + cliente.getId());
    }

    // Método para consultar os dados de um cliente --   
	public void consultarDadosCliente(Cliente cliente) {
		 System.out.println(ClienteView.exibirCliente(cliente));

  }

    // método para adicionar um veículo à lista de veículos do cliente --
    public void adicionarVeiculo(Cliente cliente, Veiculo veiculo) {
        cliente.getVeiculos().add(veiculo);
        System.out.printf("\nO veículo de placa: %s foi vinculado ao usuário(a) de Id: %d\n", veiculo.getPlaca(), cliente.getId());
    }
    
    // método para remover um veículo da lista de veículos do cliente --
    public void removerVeiculo(Cliente cliente, Veiculo veiculo) {
        cliente.getVeiculos().remove(veiculo);
        System.out.printf("\nO veículo de placa: %s foi desvinculado do usuário(a) de Id: %d\n", veiculo.getPlaca(), cliente.getId());
    }
    
    //método para consultar veículos vinculados ao cliente --
	public void consultaVeiculos(Cliente cliente) {
		ClienteView.consultaVeiculos(cliente);
	}
	
	

	
	
	
	
}
