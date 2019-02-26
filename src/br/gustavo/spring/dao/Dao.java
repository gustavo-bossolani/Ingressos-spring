package br.gustavo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import br.gustavo.spring.config.HibernateConfig;

@Repository
public class Dao {
	
    public <T> void salva(T t) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(t);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public <T> List <T> busca(Class<T> t) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
        	return session.createCriteria(t).list();
        }
    }
	public <T> T buscaPorID(Class<T> t, int id) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			return session.get(t, new Integer(id));
        }
	}
	
	public <T> void atualiza(T t) {
		Transaction transaction = null;
		
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
            session.update(t);
            
            transaction.commit();
        }
	}
	
	public <T> void deleta(T t) {
		Transaction transaction = null;
		
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.delete(t);
			
			transaction.commit();
		}
	}
	
	public EventoDao eventoDao() {
		return new EventoDao();
	}
	
	public ClienteDao clienteDao() {
		return new ClienteDao();
	}
	
	public VendaDao vendaDao() {
		return new VendaDao();
	}
}
