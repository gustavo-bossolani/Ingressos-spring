package br.gustavo.spring.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.gustavo.spring.config.HibernateConfig;
import br.gustavo.spring.model.Evento;

@Repository
public class EventoDao {

	Session session = HibernateConfig.getSessionFactory().openSession();

	public boolean verificaDisponibilidade(Evento evento) {
		// return this.session.createQuery("select e from Eventos where e.data
		// like:data")
		// .setParameter("data", evento.getData()).list();

		List list = this.session.createCriteria(Evento.class)
				.add(Restrictions.eq("data", evento.getData()))
				.add(Restrictions.eq("casaShow", evento.getCasaShow())).list();
		
		if(list.isEmpty()) {
			return true;	//Caso a lista for vazia, o evento não existe
		}
		return false;	// Caso a lista não estiver vazia, o evento 
	}

	//Estamos buscando eventos com datas ainda disponiveis, ou seja, eventos não ocorridos
	public List<Evento> buscaEventosDisponiveis() {
		return session.createCriteria(Evento.class).add(Restrictions.gt("data", Calendar.getInstance())).list();
	}

	public List<Evento> buscaTodosEventos() {
		return session.createQuery("select e from Evento e").list();
	}

	public List<Evento> organizaPorData() {
		return this.session.createCriteria(Evento.class).addOrder(Order.asc("data"))
				.add(Restrictions.gt("data", Calendar.getInstance())).list();
	}

	public List<Evento> organizaPorPrecoIngresso() {
		return this.session.createCriteria(Evento.class).addOrder(Order.asc("ingressoUnitario"))
				.add(Restrictions.gt("data", Calendar.getInstance()))
				.add(Restrictions.gt("data", Calendar.getInstance())).list();
	}

	public List<Evento> organizaPorNome() {
		return this.session.createCriteria(Evento.class).addOrder(Order.asc("nome"))
				.add(Restrictions.gt("data", Calendar.getInstance())).list();
	}

	public List<Evento> organizaPorCapacidade() {
		// return this.session.createQuery("select e from Evento e where e.capacidade > 0").list();
		return this.session.createCriteria(Evento.class).addOrder(Order.asc("capacidade"))
				.add(Restrictions.gt("data", Calendar.getInstance()))
				.add(Restrictions.gt("capacidade",0))
				.list();

	}

}
