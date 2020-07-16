package com.comunenapoli.progetto.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
				setParameter("x",idUtente).getResultList().stream().findFirst().orElse(null);
		return utente.getRuolo().getId();
	}
	
	/* Controlla se l'utente è presente nel sistema, se è presente ritorna true altrimenti false */
	public boolean checkUsername(String username){
		TypedQuery<Utente> query = manager.createQuery("select u from Utente u where u.username = :x",Utente.class);
		Utente utente = query.setParameter("x",username).getResultList().stream().findFirst().orElse(null);
		boolean checkUtente = utente!=null;
		return checkUtente;
	}
	
	public boolean checkVerificaById(Integer idUtente){
		boolean isPresente = false;
		Utente utente = manager.createQuery("select u from Utente u where u.idUtente = :x",Utente.class).
				setParameter("x",idUtente).getResultList().stream().findFirst().orElse(null);
		if (utente!=null) {
			isPresente = utente.getIsVerificato();
		}
		return isPresente;
	}

	public Utente findUtenteByIdUtente(Integer idUtente) {
		Utente utente = manager.createQuery("select u from Utente u where u.idUtente = :x",Utente.class).
				setParameter("x",idUtente).getResultList().stream().findFirst().orElse(null);
		return utente;
	}
	
	public List<Utente> findByIsVerificato(){
		List<Utente> utenti = manager.createQuery("select u from Utente u where u.isVerificato = 0 ",Utente.class).getResultList();
		return utenti;
	}
	
	/*
	public void updateVerifica(Utente utente){
		boolean isPresente = false;
		boolean isVerificato = utente.getIsVerificato();
		Integer idUtente = utente.getIdUtente();
		manager.createQuery("update Utente u set u.isVerificato = :x where u.idUtente = :y").
				setParameter("x",true).setParameter("y",idUtente);	
	}
	*/
		
}