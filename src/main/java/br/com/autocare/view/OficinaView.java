package br.com.autocare.view;

import br.com.autocare.controller.OficinaController;
import br.com.autocare.model.entidades.Oficina;

public class OficinaView {
	//método que mostra os dados da oficina --
	public static void consultardados(Oficina oficina) {
		System.out.println("\nOs dados da oficina são:\n" + "\nOficina:\nIDoficina: " + oficina.getIdoficina() + "\nNome: " + oficina.getNome() + "\nEndereço: " + oficina.getEnderecoOficina() + "\nTelefone: " + oficina.getTelefone()
				+ "\nDisponibilidade: " + OficinaController.checarDisponibilidade(oficina));
	}
}
