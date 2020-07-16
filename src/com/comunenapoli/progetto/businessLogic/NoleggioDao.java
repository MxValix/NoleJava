package com.comunenapoli.progetto.businessLogic;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.comunenapoli.progetto.model.Auto;
import com.comunenapoli.progetto.model.Noleggio;
import com.comunenapoli.progetto.model.Utente;


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

	public List<Noleggio> findNoleggiByUtente(Utente utente) {
		List<Noleggio> noleggi = manager.createQuery("select n from Noleggio n where n.utente = :x",Noleggio.class).
				setParameter("x",utente).getResultList();
		return noleggi;
	}
	
	public Noleggio findNoleggioByAuto(Auto auto) {
		TypedQuery<Noleggio> query = manager.createQuery("select n from Noleggio n where n.auto = :x",Noleggio.class);
		Noleggio noleggio = query.setParameter("x",auto).getResultList().stream().findFirst().orElse(null);
		return noleggio;
	}
	
	public Noleggio findNoleggioByIdNoleggio(Integer idNoleggio) {
		TypedQuery<Noleggio> query = manager.createQuery("select n from Noleggio n where n.idNoleggio = :x",Noleggio.class);
		Noleggio noleggio = query.setParameter("x",idNoleggio).getResultList().stream().findFirst().orElse(null);
		return noleggio;
	}
	
	public boolean findNoleggioDisponibileByAuto(Auto auto, Date dataInizio){
		TypedQuery<Noleggio> query = manager.createQuery("select n from Noleggio n where n.auto = :x and n.dataFine >= :y",Noleggio.class);
		Noleggio noleggio = query.setParameter("x",auto).setParameter("y",dataInizio).getResultList().stream().findFirst().orElse(null);
		if (noleggio!=null) {
			return false;
		}
		return true;
	}
	
	public List<Noleggio> findNoleggiByAuto(Auto auto) {
		TypedQuery<Noleggio> query = manager.createQuery("select n from Noleggio n where n.auto = :x",Noleggio.class);
		List<Noleggio> noleggi = query.setParameter("x",auto).getResultList();
		return noleggi;
	}

	public List<Noleggio> findNoleggiByDataInizio(Date dataChiusura) {
		TypedQuery<Noleggio> query = manager.createQuery("select n from Noleggio n where n.dataInizio = :x",Noleggio.class);
		List<Noleggio> noleggi = query.setParameter("x",dataChiusura).getResultList();
		return noleggi;
	}

	public List<Noleggio> findNoleggiByDataInizioDataFine(Date dataInizioChiusura, Date dataFineChiusura) {
		TypedQuery<Noleggio> query = manager.createQuery("select n from Noleggio n where n.dataInizio BETWEEN :x AND :y",Noleggio.class);
		List<Noleggio> noleggi = query.setParameter("x",dataInizioChiusura).setParameter("y",dataFineChiusura).getResultList();
		return noleggi;
	}
	
	
}