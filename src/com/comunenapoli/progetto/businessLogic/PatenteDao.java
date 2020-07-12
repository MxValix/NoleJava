package com.comunenapoli.progetto.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.Patente;

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
	
	public Patente findPatenteByIdUtente(Integer idUtente) {
		Patente patente = manager.createQuery("select p from Patente p where p.utente_idUtente = :x",Patente.class).
				setParameter("x",idUtente).getSingleResult();
		return patente;
	}
	
	public Patente findPatenteByNumeroPatente(String numeroPatente) {
		Patente patente = manager.createQuery("select p from Patente p where p.numeroPatente = :x",Patente.class).
				setParameter("x",numeroPatente).getSingleResult();
		return patente;
	}
	
	
	
}