package br.com.autocare.view;

import br.com.autocare.model.entidades.Veiculo;

public class VeiculoView {

	//método para consultar os diagnosticos vinculados a este veiculo --
	public static void consultaDiagnosticos(Veiculo veiculo) {
		System.out.println("\nDiagnósticos vinculados a este veículo:");
		for (int i=0; i<veiculo.getDiagnosticos().size(); i++) {
			System.out.println(veiculo.getDiagnosticos().get(i));
		}
	}
	
	//método para consultar os problemas vinculados a este veículo --
	public static void consultaProblemas(Veiculo veiculo) {
		System.out.println("\nProblemas vinculados a este veículo:\n");
		for (int i=0; i<veiculo.getProblemas().size(); i++) {
			System.out.printf("\nProblema %d:\n%s", i+1, veiculo.getProblemas().get(i));
		}
			}
	
	// método para consultar o status do veiculo -- 
	public static void verStatus(Veiculo veiculo) {
		if (veiculo.getStatus()==true) {
			System.out.println("\nSeu veículo não possui nenhum tipo de problemas!\n");
		}else {
			System.out.println("\nSeu veículo não está em bom estado\n");
		}	
	}
	
    // método para consultar os dados de um veículo --
    public static void consultarDadosVeiculo(Veiculo veiculo) {
        System.out.printf("\nOs dados do veículo são:" + veiculo.toString() + "\n");
    }

}
