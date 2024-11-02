package br.com.autocare.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.autocare.controller.OficinaController;
import br.com.autocare.model.dao.util.Conexao;
import br.com.autocare.model.entidades.Oficina;

public class OficinaDAO {
private Connection conn;
	
	public OficinaDAO() throws SQLException {
		conn = Conexao.getConexao();
		System.out.println("Conectado!");
		}
	
	//Método inserir
	public boolean inserir(Oficina oficina) {
		String sql = "INSERT INTO oficina VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, oficina.getIdoficina());
			ps.setString(2,oficina.getEnderecoOficina());
			ps.setString(3, oficina.getTelefone());
			ps.setString(4, OficinaController.checarDisponibilidade(oficina));
			ps.execute();
			System.out.printf("\nA oficina de nome: %s foi cadastrado no banco de dados!\n", oficina.getNome());
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
		String sql = "DELETE FROM oficina WHERE id_ofc = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.err.println("\nErro ao remover a oficina!\n");
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
	public void atualizar(Oficina oficina) {
	    String sql = "UPDATE oficina SET id_ofc = ?, endereco_ofc = ?, telefone_ofc = ?, horario_ofc = ? WHERE id_ofc = ?";
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	    	ps.setInt(1, oficina.getIdoficina());
			ps.setString(2,oficina.getEnderecoOficina());
			ps.setString(3, oficina.getTelefone());
			ps.setString(4, OficinaController.checarDisponibilidade(oficina));
			ps.execute();       
	        ps.executeUpdate();                   
	    } catch (SQLException e) {
	    	System.err.println("\nErro ao atualizar os dados da oficina!\n");
	        e.printStackTrace(); 
	    }
	}
}
