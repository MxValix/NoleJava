package com.comunenapoli.progetto.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.comunenapoli.progetto.model.Patente;
import com.comunenapoli.progetto.model.Utente;

public class PatenteDao implements DaoInterface<Patente> {
	
	private EntityManager manager = null;

	public PatenteDao()
	{
		this(null);
	}
	
	public PatenteDao(EntityManager entityManager)
	{
		setManager(entityManager);
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void create(Patente patente) {
		manager.persist(patente);
	}

	@Override
	public List<Patente> retrieve() {
		List<Patente> patenti = manager.createQuery("from Patente",Patente.class).getResultList();
		return patenti;
	}

	@Override
	public void update(Patente patente) {
		manager.persist(patente);
	}

	@Override
	public void delete(Patente patente) {
		manager.remove(patente);
	}
	
	public Patente findPatenteByUtente(Utente utente) {
		TypedQuery<Patente> query = manager.createQuery("select p from Patente p where p.utente = :x",Patente.class);
		Patente patente = query.setParameter("x",utente).getResultList().stream().findFirst().orElse(null);
		return patente;
	}
	
	public Patente findPatenteByNumeroPatente(String numeroPatente) {
		TypedQuery<Patente> query = manager.createQuery("select p from Patente p where p.numeroPatente = :x",Patente.class);
		Patente patente = query.setParameter("x",numeroPatente).getResultList().stream().findFirst().orElse(null);
		return patente;
	}
	
	
	
}