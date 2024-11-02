package br.com.autocare.controller;

import br.com.autocare.model.entidades.Problema;
import br.com.autocare.view.ProblemaView;

public class ProblemaController {
	
	//método para consultar os detalhes do problema --
	
	public void consultaproblema(Problema problema) {
		ProblemaView.consultaProblema(problema);
	}

}

