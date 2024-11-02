package br.com.autocare.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.autocare.model.dao.util.Conexao;
import br.com.autocare.model.entidades.Veiculo;

public class VeiculoDAO {
private Connection conn;
	
	public VeiculoDAO() throws SQLException {
		conn = Conexao.getConexao();
		System.out.println("Conectado!");
		}
	
	//Método inserir
	public boolean inserir(Veiculo veiculo) {
		String sql = "INSERT INTO veiculo VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, veiculo.getIdcarro());
			ps.setString(2,veiculo.getDono().getNome());
			ps.setString(3, veiculo.getModelo());
			ps.setString(4, veiculo.getPlaca());
			ps.setString(5,veiculo.getCor());
			ps.setInt(6, veiculo.getAno());
			ps.setInt(7, veiculo.getDono().getId());
			ps.execute();
			System.out.printf("\nO veículo de placa: %s foi cadastrado no banco de dados!\n", veiculo.getPlaca());
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
		String sql = "DELETE FROM veiculo WHERE id_veic = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.err.println("\nErro ao remover o veiculo!\n");
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
	public void atualizar(Veiculo veiculo) {
	    String sql = "UPDATE veiculo SET id_veic = ?, dono_veic = ?, modelo_veic = ?, placa_veic = ?, cor_veic = ?"
	    		+ ", ano_veic = ?, cliente_id_clie = ? WHERE id_veic = ?";
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	    	ps.setInt(1, veiculo.getIdcarro());
			ps.setString(2,veiculo.getDono().getNome());
			ps.setString(3, veiculo.getModelo());
			ps.setString(4, veiculo.getPlaca());
			ps.setString(5,veiculo.getCor());
			ps.setInt(6, veiculo.getAno());
			ps.setInt(7, veiculo.getDono().getId());
			ps.execute();       
	        ps.executeUpdate();                   
	    } catch (SQLException e) {
	    	System.err.println("\nErro ao atualizar os dados do veículo!\n");
	        e.printStackTrace(); 
	    }
	}
}
