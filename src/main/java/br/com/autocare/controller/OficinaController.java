package br.com.autocare.controller;

import br.com.autocare.model.entidades.Oficina;
import br.com.autocare.view.OficinaView;

public class OficinaController {

	//método que checa se a oficina está disponível ou não --
	public static String checarDisponibilidade(Oficina oficina) {
		if (oficina.getDisponibilidade()==true) {
			return"Essa oficina está disponível no momento\n";
		}else {
			return"Essa oficina não está indisponível no momento\n";
		}
	}
	
	//método que mostra os dados da oficina --
	public void consultardados(Oficina oficina) {
		OficinaView.consultardados(oficina);
	}	
	
	
}
