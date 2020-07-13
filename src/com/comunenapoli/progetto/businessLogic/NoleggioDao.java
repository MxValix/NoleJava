package com.comunenapoli.progetto.businessLogic;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	public List<Noleggio> findNoleggiByIdUtente(Integer idUtente) {
		List<Noleggio> noleggi = manager.createQuery("select n from Noleggio n where n.utente_idUtente = :x",Noleggio.class).
				setParameter("x",idUtente).getResultList();
		return noleggi;
	}
	
	public Noleggio findNoleggioByIdAuto(Integer idAuto) {
		TypedQuery<Noleggio> query = manager.createQuery("select n from Noleggio n where n.auto_idAuto = :x",Noleggio.class);
		Noleggio noleggio = query.
				setParameter("x",idAuto).getSingleResult();
		return noleggio;
	}
	
	public Noleggio findNoleggioByIdNoleggio(Integer idNoleggio) {
		TypedQuery<Noleggio> query = manager.createQuery("select n from Noleggio n where n.idNoleggio = :x",Noleggio.class);
		Noleggio noleggio = query.setParameter("x",idNoleggio).getSingleResult();
		return noleggio;
	}
	
	public boolean findNoleggioDisponibileByIdAuto(Integer idAuto, Date dataInizio){
		TypedQuery<Noleggio> query = manager.createQuery("select n from Noleggio n where n.auto_idAuto = :x and n.dataFine >= :y",Noleggio.class);
		Noleggio noleggio = query.setParameter("x",idAuto).setParameter("y",dataInizio).getSingleResult();
		if (noleggio!=null) {
			return false;
		}
		return true;
	}
	
	public List<Noleggio> findNoleggiByIdAuto(Integer idAuto) {
		TypedQuery<Noleggio> query = manager.createQuery("select n from Noleggio n where n.auto_idAuto = :x",Noleggio.class);
		List<Noleggio> noleggi = query.setParameter("x",idAuto).getResultList();
		return noleggi;
	}

	public List<Noleggio> findNoleggiByDataInizio(Date dataChiusura) {
		TypedQuery<Noleggio> query = manager.createQuery("select n from Noleggio n where n.dataInizio = :x",Noleggio.class);
		List<Noleggio> noleggi = query.setParameter("x",dataChiusura).getResultList();
		return noleggi;
	}
	
	
}