package br.gustavo.spring.config;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import br.gustavo.spring.dao.Dao;
import br.gustavo.spring.model.Cliente;

@Path("/cliente")
public class ClienteService {

	@Autowired
	private Dao dao;
	
	/*
	 * @POST/PUT
	 * @REMOVE
	 * @POST
	 */
	
	@GET
	@Path("/todos") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> todos(){
		return dao.busca(Cliente.class);
	}
	
	@GET
	@Path("/buscaPorId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscaPorId(@PathParam("id") int id) {
		return dao.buscaPorID(Cliente.class, id);
	}
	
	@GET
	@Path("/gustavo")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente cliente(){
		Cliente cliente = new Cliente();
		cliente.setNome("Gustavo");
		cliente.setEmail("gustavo@email.com");
		cliente.setSenha("123");
		return cliente;
	}
	
}
