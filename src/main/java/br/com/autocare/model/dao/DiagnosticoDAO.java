package br.com.autocare.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.autocare.model.dao.util.Conexao;
import br.com.autocare.model.entidades.Diagnostico;

public class DiagnosticoDAO {
	
	private Connection conn;
	
	public DiagnosticoDAO() throws SQLException {
		conn = Conexao.getConexao();
		System.out.println("Conectado!");
		}
	
	//Método inserir
	public boolean inserir(Diagnostico diagnostico) {
		String sql = "INSERT INTO diagnostico VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, diagnostico.getIdDiagnostico());
			ps.setFloat(2,diagnostico.getOrcamento());
			ps.setString(3, diagnostico.getDatadiagnostico());
			ps.setString(4, diagnostico.getProblemas().toString());
			ps.setInt(5,diagnostico.getVeiculo().getIdcarro());
			ps.execute();
			System.out.printf("\nO diagnóstico de ID: %d foi cadastrado no banco de dados!\n", diagnostico.getIdDiagnostico());
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
		String sql = "DELETE FROM diagnostico WHERE id_diag = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.err.println("\nErro ao remover o diagnóstico!\n");
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
	public void atualizar(Diagnostico diagnostico) {
	    String sql = "UPDATE diagnostico SET id_diag = ?, orcamento_diag = ?, data_diag = ?,"
	    		+ " problema_diag = ?, veiculo_id_veic = ?"
	    		+ "WHERE id = ?";
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, diagnostico.getIdDiagnostico());
			ps.setFloat(2,diagnostico.getOrcamento());
			ps.setString(3, diagnostico.getDatadiagnostico());
			ps.setString(4, diagnostico.getProblemas().toString());
			ps.setInt(5,diagnostico.getVeiculo().getIdcarro());
			ps.setInt(6, diagnostico.getIdDiagnostico());
			ps.execute();       
	        ps.executeUpdate();                   
	    } catch (SQLException e) {
	    	System.err.println("\nErro ao atualizar os dados do diagnóstico!\n");
	        e.printStackTrace(); 
	    }
	}
}
