package br.com.autocare.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.autocare.model.dao.ClienteDAO;
import br.com.autocare.model.entidades.Cliente;

public class ClienteBO {

    // Instancia o ClienteDAO uma única vez
    private ClienteDAO clienteDAO;

    // Construtor que inicializa o ClienteDAO
    public ClienteBO() {
        this.clienteDAO = new ClienteDAO();
		System.out.println("ClienteDAO foi inicializado com sucesso.");
    }

    // Método para inserir um novo cliente
    public void inserirBO(Cliente cliente) throws ClassNotFoundException, SQLException {
        if (clienteDAO == null) {
            throw new IllegalStateException("ClienteDAO não foi inicializado.");
        }
        clienteDAO.inserir(cliente);
    }

    // Método para atualizar os dados de um cliente existente
    public void atualizarBO(Cliente cliente) throws ClassNotFoundException, SQLException {
        if (clienteDAO == null) {
            throw new IllegalStateException("ClienteDAO não foi inicializado.");
        }
        clienteDAO.atualizar(cliente);
    }

    // Método para deletar um cliente pelo ID
    public void deletarBO(int id) throws ClassNotFoundException, SQLException {
        if (clienteDAO == null) {
            throw new IllegalStateException("ClienteDAO não foi inicializado.");
        }
        clienteDAO.excluir(id);
    }

    // Método para selecionar todos os clientes
    public ArrayList<Cliente> selecionarBO() throws ClassNotFoundException, SQLException {
        if (clienteDAO == null) {
            throw new IllegalStateException("ClienteDAO não foi inicializado.");
        }
        return (ArrayList<Cliente>) clienteDAO.selecionar();
    }
}
