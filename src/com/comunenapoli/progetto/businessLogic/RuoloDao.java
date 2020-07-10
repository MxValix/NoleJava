package com.comunenapoli.progetto.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.Ruolo;

public class RuoloDao implements DaoInterface<Ruolo> {
	
	private EntityManager manager = null;

	
	public RuoloDao()
	{
		this(null);
	}
	
	public RuoloDao(EntityManager entityManager)
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
	public void create(Ruolo ruolo) {
		manager.persist(ruolo);
	}

	@Override
	public List<Ruolo> retrieve() {
		List<Ruolo> ruoli = manager.createQuery("from Ruolo",Ruolo.class).getResultList();
		return ruoli;
	}

	@Override
	public void update(Ruolo ruolo) {
		manager.persist(ruolo);
	}

	@Override
	public void delete(Ruolo ruolo) {
		manager.remove(ruolo);
	}
}