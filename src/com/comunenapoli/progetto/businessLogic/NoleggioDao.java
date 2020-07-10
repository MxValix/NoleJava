package com.comunenapoli.progetto.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.Noleggio;


public class NoleggioDao implements DaoInterface<Noleggio> {
	private EntityManager manager = null;

	public NoleggioDao()
	{
		this(null);
	}
	
	public NoleggioDao(EntityManager entityManager)
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
	public void create(Noleggio noleggio) {
		manager.persist(noleggio);
	}

	@Override
	public List<Noleggio> retrieve() {
		List<Noleggio> noleggi = manager.createQuery("from Noleggio",Noleggio.class).getResultList();
		return noleggi;
	}

	@Override
	public void update(Noleggio noleggio) {
		manager.persist(noleggio);
	}

	@Override
	public void delete(Noleggio noleggio) {
		manager.remove(noleggio);
	}
}