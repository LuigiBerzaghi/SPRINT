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

    // Método inserir
	public void inserir(Cliente cliente) throws SQLException {
	    Connection conn = null;
	    PreparedStatement stmtEndereco = null;
	    PreparedStatement stmtCliente = null;
	    PreparedStatement stmtVeiculo = null;

	    try {
	        conn = Conexao.getConexao();
	        conn.setAutoCommit(false);

	        // Inserir o endereço primeiro
	        Endereco endereco = cliente.getEndereco(); 
	        if (endereco != null) {
	            String sqlEndereco = "INSERT INTO endereco (id_endereco, cep, logradouro, complemento, bairro, uf) VALUES (?, ?, ?, ?, ?, ?)";
	            stmtEndereco = conn.prepareStatement(sqlEndereco);
	            stmtEndereco.setInt(1, endereco.getid());
	            stmtEndereco.setString(2, endereco.getCep());
	            stmtEndereco.setString(3, endereco.getLogradouro());
	            stmtEndereco.setString(4, endereco.getComplemento());
	            stmtEndereco.setString(5, endereco.getBairro());
	            stmtEndereco.setString(6, endereco.getUf());
	            stmtEndereco.executeUpdate();
	        }

	        // Agora o cliente
	        String sqlCliente = "INSERT INTO cliente (id_clie, cpf_clie, telefone_clie, email_clie, senha_clie, nome_clie, endereco_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        stmtCliente = conn.prepareStatement(sqlCliente);
	        stmtCliente.setInt(1, cliente.getId());
	        stmtCliente.setString(2, cliente.getCpf());
	        stmtCliente.setString(3, cliente.getTelefone());
	        stmtCliente.setString(4, cliente.getEmail());
	        stmtCliente.setString(5, cliente.getSenha());
	        stmtCliente.setString(6, cliente.getNome());
	        stmtCliente.setInt(7, endereco.getid());
	        stmtCliente.executeUpdate();

	        conn.commit(); 
	    } catch (SQLException e) {
	        if (conn != null) {
	            conn.rollback();
	        }
	        throw e; 
	    } finally {
	        // Fechando os recursos
	        if (stmtCliente != null) stmtCliente.close();
	        if (stmtEndereco != null) stmtEndereco.close();
	        if (stmtVeiculo != null) stmtVeiculo.close();
	        if (conn != null) conn.close();
	    }
	}



    // Método excluir
    public void excluir(int clienteId) {
        String sqlDeleteCliente = "DELETE FROM cliente WHERE id_clie = ?";
        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {
            conexao = Conexao.getConexao();
            pstmt = conexao.prepareStatement(sqlDeleteCliente);
            pstmt.setInt(1, clienteId);
            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Cliente excluído com sucesso!");
            } else {
                System.out.println("Nenhum cliente encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao tentar excluir o cliente: " + e.getMessage());
        } finally {
            fecharRecursos(pstmt, conexao);
        }
    }

 // Método atualizar
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET cpf_clie = ?, telefone_clie = ?, email_clie = ?, senha_clie = ?, nome_clie = ?, endereco_id = ? WHERE id_clie = ?";
        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {
            conexao = Conexao.getConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, cliente.getCpf());
            pstmt.setString(2, cliente.getTelefone());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getSenha());
            pstmt.setString(5, cliente.getNome());
            pstmt.setInt(6, cliente.getEndereco().getid());
            pstmt.setInt(7, cliente.getId());
            pstmt.executeUpdate(); 
        } catch (SQLException e) {
            System.err.println("\nErro ao atualizar os dados do cliente: " + e.getMessage());
        } finally {
            fecharRecursos(pstmt, conexao);
        }
    }


    // Método listar (select)
    public List<Cliente> selecionar() {
        List<Cliente> listaCliente = new ArrayList<>();
        String sql = "SELECT * FROM cliente c JOIN endereco e ON c.endereco_id = e.id_endereco";
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id_clie"));
                cliente.setCpf(rs.getString("cpf_clie"));
                cliente.setTelefone(rs.getString("telefone_clie"));
                cliente.setEmail(rs.getString("email_clie"));
                cliente.setSenha(rs.getString("senha_clie"));
                cliente.setNome(rs.getString("nome_clie"));

                Endereco endereco = new Endereco();
                endereco.setid(rs.getInt("id_endereco"));
                endereco.setCep(rs.getString("cep"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setUf(rs.getString("uf"));

                cliente.setEndereco(endereco);
                listaCliente.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("\nErro ao listar clientes: " + e.getMessage());
        } finally {
            fecharRecursos(stmt, conexao, rs);
        }
        return listaCliente;
    }

    // Método para fechar recursos
    private void fecharRecursos(PreparedStatement pstmt, Connection conexao) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar os recursos: " + e.getMessage());
        }
    }

    // Sobrecarga do método para incluir ResultSet
    private void fecharRecursos(PreparedStatement pstmt, Connection conexao, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            fecharRecursos(pstmt, conexao);
        } catch (SQLException e) {
            System.err.println("Erro ao fechar o ResultSet: " + e.getMessage());
        }
    }
}
