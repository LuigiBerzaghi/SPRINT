package br.com.autocare.view;

import br.com.autocare.model.entidades.Diagnostico;

public class DiagnosticoView {
	public static void consultarDiagnostico(Diagnostico diagnostico) {
		System.out.println("\nOs dados do diagnóstico são:\n" + diagnostico.toString());
		for (int i=0; i<diagnostico.getProblemas().size(); i++) {
			System.out.printf("\nProblema %d:\n%s\n", i+1, diagnostico.getProblemas().get(i));
			}
		}
}
