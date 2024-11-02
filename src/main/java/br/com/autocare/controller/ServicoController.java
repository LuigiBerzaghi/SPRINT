package br.com.autocare.controller;

import br.com.autocare.model.entidades.Servico;
import br.com.autocare.view.ServicoView;

public class ServicoController {

	//método para consultar os dados do serviço --
	public void consultarservico(Servico servico) {
		System.out.println(ServicoView.consultarservico(servico));
	}

	//método para definir o status --
	public static String definestatus(Servico servico) {
		if (servico.isStatus() == true) {
			return "O serviço foi realizado\n";
		}else {
			return "O serviço está pendente\n";
		}
	}
	
	
}
