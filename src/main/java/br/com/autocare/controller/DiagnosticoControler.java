package br.com.autocare.controller;

import br.com.autocare.model.entidades.Diagnostico;
import br.com.autocare.model.entidades.Problema;
import br.com.autocare.view.DiagnosticoView;

public class DiagnosticoControler {

	
	//método para vincular problemas ao disgnostico --
	public void addproblemas(Diagnostico diagnostico, Problema problema) {
		System.out.printf("\nProblema de id: %d vinculado ao diagnóstico de id: %d\n", diagnostico.getIdDiagnostico(), problema.getIdproblema());
		diagnostico.getProblemas().add(problema);
	}
	
	//método para desvincular um problema do diagnóstico --	
	public void desvincularDiagnostico(Diagnostico diagnostico, Problema problema) {
		System.out.printf("\nProblema de id: %d desvinculado ao diagnóstico de id: %d\n", diagnostico.getIdDiagnostico(), problema.getIdproblema());
		diagnostico.getProblemas().remove(problema);
	}
	
	//método para consultar todos os dados do diagnóstico --
	public void consultarDiagnostico(Diagnostico diagnostico) {
		DiagnosticoView.consultarDiagnostico(diagnostico);
		}
	
}
	
