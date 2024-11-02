package br.com.autocare.controller;

import br.com.autocare.model.entidades.Diagnostico;
import br.com.autocare.model.entidades.Problema;
import br.com.autocare.model.entidades.Veiculo;
import br.com.autocare.view.VeiculoView;

public class VeiculoController {
	
	//método para vincular um problema	--
	public void vincularProblema(Veiculo veiculo, Problema problema) {
		veiculo.getProblemas().add(problema);
		System.out.printf("\nProblema de id: %d vinculado ao veículo de id: %d\n", veiculo.getIdcarro(), problema.getIdproblema());
	}
	
	//método para desvincular um problema --
	public void desvincularProblema(Veiculo veiculo, Problema problema) {
		veiculo.getProblemas().remove(problema);
		System.out.printf("\nProblema de id: %d desvinculado do veículo de id: %d\n", veiculo.getIdcarro(), problema.getIdproblema());
	}
	
	//método para vincular um diagnóstico ao veiculo --	
	public void vincularDiagnostico(Veiculo veiculo,Diagnostico diagnostico) {
		veiculo.getDiagnosticos().add(diagnostico);
		System.out.printf("\nDiagnóstico de id: %d vinculado ao veículo de id: %d\n", veiculo.getIdcarro(), diagnostico.getIdDiagnostico());
	}
	
	//método para desvincular um diagnóstico ao veiculo --	
	public void desvincularDiagnostico(Veiculo veiculo,Diagnostico diagnostico) {
		veiculo.getDiagnosticos().remove(diagnostico);
		System.out.printf("\nDiagnóstico de id: %d desvinculado do veículo de id: %d\n", veiculo.getIdcarro(), diagnostico.getIdDiagnostico());
	}
	
	//método para consultar os diagnosticos vinculados a este veiculo --
	public void consultaDiagnosticos(Veiculo veiculo) {
		VeiculoView.consultaDiagnosticos(veiculo);
		}
		
	//método para consultar os problemas vinculados a este veículo --
	public void consultaProblemas(Veiculo veiculo) {
		VeiculoView.consultaProblemas(veiculo);
			}
	// método para consultar o status do veiculo -- 
	public void verStatus(Veiculo veiculo) {
		VeiculoView.verStatus(veiculo);	
	}	
    // método para consultar os dados de um veículo --
    public void consultarDadosVeiculo(Veiculo veiculo) {
        VeiculoView.consultarDadosVeiculo(veiculo);
    }
}
