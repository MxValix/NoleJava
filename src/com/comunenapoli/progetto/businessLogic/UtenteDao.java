package com.comunenapoli.progetto.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.Utente;

public class UtenteDao implements DaoInterface<Utente> {

	private EntityManager manager = null;
	
	public UtenteDao()
	{
		this(null);
	}
	
	public UtenteDao(EntityManager entityManager)
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
	public void create(Utente utente) {
		manager.persist(utente); 
	}

	@Override
	public List<Utente> retrieve() {
		List<Utente> utenti = manager.createQuery("from Utente",Utente.class).getResultList();
		return utenti;
	}

	@Override
	public void update(Utente utente) {
		manager.persist(utente);
	}

	@Override
	public void delete(Utente utente) {
		manager.remove(utente);
	}
	
	public List<Utente> findByUsernameAndPassword(String username,String password){
		return manager.createQuery("select u from Utente u where u.username = :x and u.password = :y",Utente.class).
				setParameter("x",username).setParameter("y",password).getResultList();
	}
	
	public List<Utente> findByRuolo(Integer idRuolo){
		return manager.createQuery("select u from Utente u where u.ruoloUtente = :x ",Utente.class).
				setParameter("x",idRuolo).getResultList();
	}
	
	public Integer findRuoloByIdUtente(Integer idUtente) {
		Utente utente = manager.createQuery("select u from Utente u where u.idUtente = :x ",Utente.class).
				setParameter("x",idUtente).getSingleResult();
		return utente.getRuolo().getId();
	}
	
		
}