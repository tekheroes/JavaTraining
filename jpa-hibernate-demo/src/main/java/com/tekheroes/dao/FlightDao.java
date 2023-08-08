package com.tekheroes.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tekheroes.entity.Flight;

public class FlightDao {
	private EntityManagerFactory factory;
	
	public FlightDao() {
		factory = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public void save(Flight f) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.persist(f);
		txn.commit();
		em.close();
	}
	
	public Flight fetch(int code) {
		EntityManager em = factory.createEntityManager();
		Flight f = em.find(Flight.class, code);
		return f;
	}
	
	public List<Flight> list() {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("from Flight");
		return query.getResultList();
	}
	
	public List<Flight> listByCarrier(String carrier) {
		EntityManager em = factory.createEntityManager();
		
//		Query query = em.createQuery("from Flight where carrier=:car");
		Query query = em.createNamedQuery("byCarrier");
		query.setParameter("car", carrier);
		
		return query.getResultList();
	}
	
	public List<Flight> listByRoute(String source, String destiny) {
		EntityManager em = factory.createEntityManager();
		
//		Query query = em.createQuery("from Flight where source=:src and destiny=:dest");
		Query query = em.createNamedQuery("byRoute");
		query.setParameter("src", source);
		query.setParameter("dest", destiny);
		
		return query.getResultList();
	}
	
	public int count() {
		EntityManager em = factory.createEntityManager();
		
//		Query query = em.createQuery("SELECT count(*) FROM Flight");
		Query query = em.createNativeQuery("select count(*) from flight");
		
		return ((BigInteger)query.getSingleResult()).intValue();
	}
}
