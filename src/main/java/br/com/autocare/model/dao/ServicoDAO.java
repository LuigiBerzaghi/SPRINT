package br.com.autocare.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.autocare.model.dao.util.Conexao;
import br.com.autocare.model.entidades.Servico;

public class ServicoDAO {
private Connection conn;
	
	public ServicoDAO() throws SQLException {
		conn = Conexao.getConexao();
		System.out.println("Conectado!");
		}
	
	//Método inserir
	public boolean inserir(Servico servico) {
		String sql = "INSERT INTO servico VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, servico.getIdservico());
			ps.setString(2,servico.getData());
			ps.setString(3, servico.getMecanico().getNomeMecanico());
			ps.setString(4, servico.getVeiculo().getPlaca());
			ps.setInt(5,servico.getDiagnostico().getIdDiagnostico());
			ps.execute();
			System.out.printf("\nO serviço de Id: %d foi cadastrado no banco de dados!\n", servico.getIdservico());
		}catch(SQLException e) {
			if (conn == null) {
				System.err.println("\nConexão nula!\n");
			}
			e.printStackTrace();
			return false;
		}finally {
			try {
				System.out.println("\nFechando a conexão com o banco de dados!\n");
				conn.close();
			}catch(SQLException e) {
				System.err.println("\nErro ao fechar a conexão\n");
				e.printStackTrace();
			}
		}
		return true;
	}
	
	//Método excluir
	public boolean excluir(int id) {
		String sql = "DELETE FROM servico WHERE id_serv = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.err.println("\nErro ao remover o serviço!\n");
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("\nErro ao fechar a conexão!\n");
				e.printStackTrace();
			}
		}
		return true;
	}
	
	//Método atualizar
	public void atualizar(Servico servico) {
	    String sql = "UPDATE servico SET id_serv = ?, data_serv = ?, carro_serv = ?, diagnostico_id_diag = ? WHERE id_serv = ?";
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	    	ps.setInt(1, servico.getIdservico());
			ps.setString(2,servico.getData());
			ps.setString(3, servico.getMecanico().getNomeMecanico());
			ps.setString(4, servico.getVeiculo().getPlaca());
			ps.setInt(5,servico.getDiagnostico().getIdDiagnostico());
			ps.execute();       
	        ps.executeUpdate();                   
	    } catch (SQLException e) {
	    	System.err.println("\nErro ao atualizar os dados do serviço!\n");
	        e.printStackTrace(); 
	    }
	}
}
