package br.com.autocare.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.autocare.model.dao.util.*;
import br.com.autocare.model.entidades.Mecanico;

public class MecanicoDAO {
private Connection conn;
	
	public MecanicoDAO() throws SQLException {
		conn = Conexao.getConexao();
		System.out.println("Conectado!");
		}
	
	//Método inserir
	public boolean inserir(Mecanico mecanico) {
		String sql = "INSERT INTO mecanico VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mecanico.getIdmecanico());
			ps.setString(2,mecanico.getNomeMecanico());
			ps.setString(3, mecanico.getTelefoneMecanico());
			ps.setString(4, mecanico.getOficinas().toString());
			ps.execute();
			System.out.printf("\nO mecânico de nome: %s foi cadastrado no banco de dados!\n", mecanico.getNomeMecanico());
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
		String sql = "DELETE FROM mecanico WHERE id_mec = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.err.println("\nErro ao remover o mecanico!\n");
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
	public void atualizar(Mecanico mecanico) {
	    String sql = "UPDATE clientes SET id_mec = ?, nome_mec = ?, telefone_mec = ? WHERE id = ?";
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	    	ps.setInt(1, mecanico.getIdmecanico());
			ps.setString(2,mecanico.getNomeMecanico());
			ps.setString(3, mecanico.getTelefoneMecanico());
			ps.setString(4, mecanico.getOficinas().toString());
			ps.execute();       
	        ps.executeUpdate();                   
	    } catch (SQLException e) {
	    	System.err.println("\nErro ao atualizar os dados do mecânico!\n");
	        e.printStackTrace(); 
	    }
	}
}
