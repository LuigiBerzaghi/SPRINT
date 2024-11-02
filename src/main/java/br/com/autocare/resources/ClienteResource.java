package br.com.autocare.resources;

import java.sql.SQLException;



import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;


import br.com.autocare.bo.ClienteBO;
import br.com.autocare.model.entidades.Cliente;


@Path("/cliente") //nome da página
public class ClienteResource{
	
	private ClienteBO clienteBO = new ClienteBO();

	@GET
	@Path("/teste")
	@Produces(MediaType.TEXT_PLAIN)
	public String testarRota() {
	    return "API funcionando!";
	}

	
	//inserir (POST)
	@POST

	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Cliente cliente, @Context UriInfo uriInfo) {
	    try {
	        clienteBO.inserirBO(cliente);
	        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
	        builder.path(Integer.toString(cliente.getId()));
	        return Response.created(builder.build()).build();
	    } catch (SQLException e) {
	        // Log e tratamento de erro específico para SQL
	        e.printStackTrace();
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao inserir cliente: " + e.getMessage()).build();
	    } catch (Exception e) {
	        // Log e tratamento de erro genérico
	        e.printStackTrace();
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno do servidor: " + e.getMessage()).build();
	    }
	}

	
	//atualizar (PUT)
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(Cliente cliente, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
		clienteBO.atualizarBO(cliente);
		return Response.ok().build();
	}
	
	
	//deletar (DELETE)
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		clienteBO.deletarBO(id);
		return Response.ok().build();
	}
	
	
	//consultar (GET)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Cliente> selecionarRs() throws ClassNotFoundException, SQLException{
		return (ArrayList<Cliente>) clienteBO.selecionarBO();
	}
}