package br.com.autocare.view;

import br.com.autocare.controller.ServicoController;
import br.com.autocare.model.entidades.Servico;

public class ServicoView {
	
	//método para consultar os dados do serviço
	
	public static String consultarservico(Servico servico) {
		return "\nOs dados do serviço são:" + "\nServiço:IDservico:" + servico.getIdservico() + "\nData:"
	+ servico.getData() + "\nVeiculo:" + servico.getVeiculo() + "\nStatus:" + ServicoController.definestatus(servico);
	}
}
