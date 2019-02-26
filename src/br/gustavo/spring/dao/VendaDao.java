package br.gustavo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.gustavo.spring.config.HibernateConfig;
import br.gustavo.spring.model.Cliente;
import br.gustavo.spring.model.Venda;

public class VendaDao {

	Session session = HibernateConfig.getSessionFactory().openSession();
	
	public List<Venda> buscaVendas(Cliente cliente){
		return session.createCriteria(Venda.class).add(Restrictions.eq("cliente", cliente)).list();
	}
}
