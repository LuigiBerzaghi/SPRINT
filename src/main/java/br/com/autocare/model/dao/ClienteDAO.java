package br.com.autocare.model.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.autocare.model.dao.util.Conexao;
import br.com.autocare.model.entidades.Cliente;
import br.com.autocare.model.entidades.Endereco;


public class ClienteDAO {

	
	public static Connection conn;
	
	public ClienteDAO() throws SQLException {
		conn = Conexao.getConexao();
		System.out.println("Conectado!");
		}
	
	//Método inserir
	public boolean inserir(Cliente cliente) {
		String sql = "INSERT INTO cliente VALUES(?,?,?,?,?,?,?)";
		try (Connection conn = Conexao.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, cliente.getId());
			ps.setString(2,cliente.getCpf());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getEmail());
			ps.setString(5,cliente.getSenha());
			ps.setString(6, cliente.getNome());
			Endereco endereco = cliente.getEndereco();
	        String enderecoConcatenado = String.format("%s, %s, %s, %s, %s",
	                endereco.getCep(), endereco.getLogradouro(), 
	                endereco.getComplemento(), endereco.getBairro(), endereco.getUf());
	        
	        ps.setString(7, enderecoConcatenado);
			ps.execute();
			System.out.printf("\nO usuário %s foi cadastrado no banco de dados!\n", cliente.getNome());
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
		String sql = "DELETE FROM cliente WHERE id_clie = ?";
		
		try (Connection conn = Conexao.getConexao();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.err.println("\nErro ao remover o cliente!\n");
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
	public void atualizar(Cliente cliente) {
	    String sql = "UPDATE cliente SET id_clie = ?, cpf_clie = ?, telefone_clie = ?, email_clie = ?, senha_clie = ?"
	    		+ ", nome_clie = ?, endereco_clie = ? WHERE id_clie = ?";
	    try (Connection conn = Conexao.getConexao();
    		PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, cliente.getId());
			ps.setString(2,cliente.getCpf());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getEmail());
			ps.setString(5,cliente.getSenha());
			ps.setString(6, cliente.getNome());
			Endereco endereco = cliente.getEndereco();
	        String enderecoConcatenado = String.format("%s, %s, %s, %s, %s",
	                endereco.getCep(), endereco.getLogradouro(), 
	                endereco.getComplemento(), endereco.getBairro(), endereco.getUf());
	        
	        ps.setString(7, enderecoConcatenado);
			ps.setInt(8, cliente.getId());
			ps.execute();       
	        ps.executeUpdate();                   
	    } catch (SQLException e) {
	    	System.err.println("\nErro ao atualizar os dados do cliente!\n");
	        e.printStackTrace(); 
	    }
	}

	//Método listar
	
	// Select 
	public List<Cliente> selecionar() {
	    List<Cliente> listaCliente = new ArrayList<>();
	    String sql = "SELECT * FROM cliente";
	    try (Connection conn = Conexao.getConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {
	         
	        while (rs.next()) {
	            Cliente cliente = new Cliente();
	            cliente.setId(rs.getInt(1));
	            cliente.setCpf(rs.getString(2));
	            cliente.setTelefone(rs.getString(3));
	            cliente.setEmail(rs.getString(4));
	            cliente.setSenha(rs.getString(5));
	            cliente.setNome(rs.getString(6));

	            // Extrai e divide o endereço concatenado
	            String enderecoConcatenado = rs.getString(7); // A coluna de endereço concatenado
	            String[] enderecoPartes = enderecoConcatenado.split(", ");
	            Endereco endereco = new Endereco(
	                enderecoPartes[0],  // CEP
	                enderecoPartes[1],  // Logradouro
	                enderecoPartes[2],  // Complemento
	                enderecoPartes[3],  // Bairro
	                enderecoPartes[4]   // UF
	            );
	            cliente.setEndereco(endereco);

	            listaCliente.add(cliente);
	        }
	    } catch (SQLException e) {
	        System.err.println("\nErro ao listar clientes!\n");
	        e.printStackTrace();
	    }
	    return listaCliente;
	}

	
}
