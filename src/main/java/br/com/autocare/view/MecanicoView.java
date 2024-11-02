package br.com.autocare.view;

import br.com.autocare.model.entidades.Mecanico;

public class MecanicoView {

	//método para consultar as oficinas em que o mecânico trabalha --
	public static void consultaOficinas(Mecanico mecanico) {
		System.out.printf("\nOficinas em que o mecânico de id %d trabalha:\n", mecanico.getIdmecanico());
		for (int i=0; i<mecanico.getOficinas().size(); i++) {
			System.out.printf(mecanico.getOficinas().get(i).getNome() );
		}
	}
	
	//método para consultar os serviços que o mecânico realizou --
	public static void consultaservicos(Mecanico mecanico) {
		System.out.printf("\nServiços que o mecânico de id: %d realizou:\n", mecanico.getIdmecanico());
		for (int i=0; i<mecanico.getServicos().size(); i++) {
			System.out.printf("\nServiços realizados:\n" + mecanico.getServicos().get(i) );
		}
	}
	
	//método para pegar os dados de contato do mecanico --
	public static void contatar(Mecanico mecanico) {
		System.out.println("\nDados do mecânico:");
		System.out.printf( "\nNome: " + mecanico.getNomeMecanico() + "\nTelefone: " + mecanico.getTelefoneMecanico() +"\n" );
		consultaOficinas(mecanico);
		System.out.printf("\n");
	}
	
}
