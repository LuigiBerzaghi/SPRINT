package br.com.autocare.view;

import br.com.autocare.model.entidades.Cliente;

public class ClienteView {
	
	    public static String exibirCliente(Cliente cliente) {
	        return "\nCliente: \nId: " + cliente.getId() + "\nNome: " + cliente.getNome() + "\nCPF: " + cliente.getCpf() + "\nTelefone: " + cliente.getTelefone() + "\nEmail: " + cliente.getEmail() + "\nSenha: "
	                + cliente.getSenha() + "\nEndereco: " + cliente.getEndereco() + "\nVeiculos: " + "\n" +cliente.getVeiculos();
	    }
	    

		public static void consultaVeiculos(Cliente cliente) {
			System.out.println("\nOs veículos do cliente de Id: " + cliente.getId() + " são:\n");
			for (int i=0; i<cliente.getVeiculos().size(); i++) {
				System.out.println(cliente.getVeiculos().get(i));
			}
		}


}


