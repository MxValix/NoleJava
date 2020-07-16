package com.comunenapoli.progetto.businessLogic;

import java.sql.Date;
import java.text.ParseException;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.Patente;
import com.comunenapoli.progetto.model.Utente;
import com.comunenapoli.progetto.utils.DataUtils;


public class BusinessLogicPatente {

	private PatenteDao patenteDao = null;
	private EntityManager em = null;

	public BusinessLogicPatente (EntityManager em ,PatenteDao patenteDao) {
		setEm(em);
		setPatenteDao(patenteDao);
	}


	public PatenteDao getPatenteDao() {
		return patenteDao;
	}



	public void setPatenteDao(PatenteDao patenteDao) {
		this.patenteDao = patenteDao;
	}



	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void create(Patente patente) {
		em.getTransaction().begin();
		try {
			patenteDao.create(patente);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void update(Patente patente) {
		em.getTransaction().begin();
		try {
			patenteDao.update(patente);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}


	public void delete(Integer idPatente) {
		//TODO 
	}


	//crea la patente solo se l'utente non ne ha già una associata, e se nessun altro utente ha lo stesso numeroPatente associato
	public boolean creaPatente(Patente patente) {
		Utente utente = patente.getUtente();
		Integer idUtente = utente.getIdUtente();
		Patente patenteUtente = getPatenteByUtente(utente);
		if (patenteUtente==null) {
			String numeroPatente = patente.getNumeroPatente();
			patenteUtente = patenteDao.findPatenteByNumeroPatente(numeroPatente);
			if (patenteUtente==null) {
				create(patente);
				return true;
			}
		}
		return false;
	}
	
	
	public Patente getPatenteByUtente(Utente utente) {
		Patente patente = patenteDao.findPatenteByUtente(utente);
		return patente;
	}
	
	public boolean isPatenteValid(Date dataScadenza) throws Exception {
		boolean isDataValida = DataUtils.dataScadenza(dataScadenza);
		return isDataValida;
	}
	
	public Integer responsoPatente(Utente utente) throws Exception {
		Patente patente = patenteDao.findPatenteByUtente(utente);
		boolean isPatenteValida = false;
		if (patente==null) {
			return -1;
		}
		else {
			Date dataScadenza = patente.getDataScadenza();
			isPatenteValida = isPatenteValid(dataScadenza);
			if (isPatenteValida) {
				return 1;
			}
		}
		return 0;	
	}
	
	public void operazionePatente(Integer idUtente, String dataScadenzaString, String numeroPatente) throws ParseException {
		Patente patente = patenteDao.findPatenteByNumeroPatente(numeroPatente);
		boolean isNuovaPatente = patente == null;
		Date dataScadenza = DataUtils.convertiDataFromString(dataScadenzaString);
		patente.setDataScadenza(dataScadenza);
		if (isNuovaPatente) {
			patente.setNumeroPatente(numeroPatente);
			create(patente);
		}
		else {
			update(patente);
		}
	}
	

}