package br.gustavo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.gustavo.spring.config.HibernateConfig;
import br.gustavo.spring.model.Cliente;

public class ClienteDao {

	Session session = HibernateConfig.getSessionFactory().openSession();
	
	
	//Aqui estamos verificando se o Cliente realmentre já foi cadastrado no banco
	public boolean verificaSeExiste(Cliente cliente) {
		
		// Basicamente este comando pede que o banco busque algum cliente com os demais requisitos:
		// o Email e Senha deve ser igual a do cliente passado por parâmetro
		// Partindo disso o banco retornara uma lista com os objeto(s) encontrados
		
		List<Cliente> resultado = session.createCriteria(Cliente.class)
		.add((Restrictions.eq("email", cliente.getEmail())))
		.add(Restrictions.eq("senha", cliente.getSenha())).list();
		
		if(!resultado.isEmpty()) {
			return true;
		}
		return false;
	}
	
	//Aqui estamos buscando todos os dados do cliente usando o email e senha como parâmetro, retornando um unico objeto
	public Cliente buscaDados(Cliente cliente) {
		return (Cliente) session.createCriteria(Cliente.class)
				.add((Restrictions.eq("email", cliente.getEmail())))
				.add(Restrictions.eq("senha", cliente.getSenha())).uniqueResult();
	}
}
