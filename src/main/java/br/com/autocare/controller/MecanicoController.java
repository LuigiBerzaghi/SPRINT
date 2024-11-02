package br.com.autocare.controller;

import br.com.autocare.model.entidades.Mecanico;
import br.com.autocare.model.entidades.Oficina;
import br.com.autocare.model.entidades.Servico;
import br.com.autocare.view.MecanicoView;

public class MecanicoController {
	
		//método para pegar os dados de contato do mecanico --
		public void contatar(Mecanico mecanico) {
			MecanicoView.contatar(mecanico);
		}
		
		//método para vincular um serviço à um mecânico --
		public void addservico(Mecanico mecanico,Servico servico) {
			mecanico.getServicos().add(servico);
			System.out.printf("\nServiço de id: %d foi vinculado ao mecânico de id %d\n", servico.getIdservico() ,mecanico.getIdmecanico() );
		}

		//método para vincular uma oficina a um mecânico --
		public void vincularOficina(Mecanico mecanico, Oficina oficina) {
			mecanico.getOficinas().add(oficina);
			System.out.printf("\nOficina de id %d foi vinculada ao mecânico de id: %d\n", oficina.getIdoficina(), mecanico.getIdmecanico());
			}
		
		//método para consultar as oficinas em que o mecânico trabalha --
		public void consultaOficinas(Mecanico mecanico) {
			MecanicoView.consultaOficinas(mecanico);
		}
		
		//método para consultar os serviços que o mecânico realizou --
		public void consultaservicos(Mecanico mecanico) {
			MecanicoView.consultaservicos(mecanico);
			
		}
	}
