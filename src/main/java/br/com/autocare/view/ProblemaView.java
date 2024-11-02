package br.com.autocare.view;

import br.com.autocare.model.entidades.Problema;

public class ProblemaView {
	public static void consultaProblema(Problema problema) {
		System.out.println("\nOs dados do problema são:"+ "\nIDproblema:" + problema.getIdproblema() + "\nDescricao:" + problema.getDescricao() + "\nCausa:" + problema.getCausa() + "\nSolucao:"
				+ problema.getSolucao() + "\nStatus:" + problema.getStatus() + "\n");
	}
}
