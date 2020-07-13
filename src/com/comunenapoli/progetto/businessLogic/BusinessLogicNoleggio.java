package com.comunenapoli.progetto.businessLogic;


import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.CalendarioChiusure;
import com.comunenapoli.progetto.model.Noleggio;
import com.comunenapoli.progetto.utils.Costanti;

public class BusinessLogicNoleggio {

	private NoleggioDao noleggioDao = null;
	private CalendarioChiusureDao  calendarioChiusureDao = null;
	private EntityManager em = null;

	public BusinessLogicNoleggio (EntityManager em ,NoleggioDao noleggioDao, CalendarioChiusureDao  calendarioChiusureDao) {
		setEm(em);
		setNoleggioDao(noleggioDao);
		setCalendarioChiusureDao(calendarioChiusureDao);
	}

	public NoleggioDao getNoleggioDao() {
		return noleggioDao; 
	}

	public void setNoleggioDao(NoleggioDao noleggioDao) {
		this.noleggioDao = noleggioDao;
	}
	

	public CalendarioChiusureDao getCalendarioChiusureDao() {
		return calendarioChiusureDao;
	}

	public void setCalendarioChiusureDao(CalendarioChiusureDao calendarioChiusureDao) {
		this.calendarioChiusureDao = calendarioChiusureDao;
	}

	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}



	public void create(Noleggio noleggio) {
		em.getTransaction().begin();
		try {
			noleggioDao.create(noleggio);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void update(Noleggio noleggio) {
		em.getTransaction().begin();
		try {
			noleggioDao.update(noleggio);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}


	public void delete(Noleggio noleggio) {
		em.getTransaction().begin();
		try {
			if (noleggio!=null) {
				noleggioDao.delete(noleggio);
				em.getTransaction().commit();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void createCalendario(CalendarioChiusure calendarioChiusure) {
		em.getTransaction().begin();
		try {
			calendarioChiusureDao.create(calendarioChiusure);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void updateCalendario(CalendarioChiusure calendarioChiusure) {
		em.getTransaction().begin();
		try {
			calendarioChiusureDao.update(calendarioChiusure);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void deleteCalendario(CalendarioChiusure calendarioChiusure) {
		em.getTransaction().begin();
		try {
			if (calendarioChiusure!=null) {
				calendarioChiusureDao.delete(calendarioChiusure);
				em.getTransaction().commit();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	
	public void setDisponibilitaFalse(Integer idAuto) {
		Noleggio noleggio = noleggioDao.findNoleggioByIdAuto(idAuto);
		noleggio.setIsDisponibile(false);
		update(noleggio);
	}
	
	public void setDisponibilitaTrue(Integer idAuto) {
		Noleggio noleggio = noleggioDao.findNoleggioByIdAuto(idAuto);
		noleggio.setIsDisponibile(true);
		update(noleggio);
	}
	
	public boolean setNoleggioByCliente(Noleggio noleggio) {
		Integer idAuto = noleggio.getAuto().getIdAuto();
		Date dataInizio = noleggio.getDataInizio();
		boolean noleggioDisponibile = noleggioDao.findNoleggioDisponibileByIdAuto(idAuto, dataInizio);
		if (noleggioDisponibile) {
			noleggio.setIsDisponibile(false);
			create(noleggio);
		}
		return noleggioDisponibile;
	}	
	
	public boolean deleteNoleggiByIdUtente(Integer idUtente) {
		List<Noleggio> noleggi = noleggioDao.findNoleggiByIdUtente(idUtente);
		boolean checkEliminato = false;
		if (noleggi!=null) {
			for (int i=0; i<noleggi.size(); i++) {
				Noleggio noleggio = noleggi.get(i);
				delete(noleggio);
			}
			checkEliminato = true;
		}
		return checkEliminato;
	}
	
	public boolean deleteNoleggioByIdNoleggio(Integer idNoleggio) {
		Noleggio noleggio = noleggioDao.findNoleggioByIdNoleggio(idNoleggio);
		boolean checkEliminato = false;
		if (noleggio!=null) {
			delete(noleggio);
			checkEliminato = true;
		}
		return checkEliminato;
	}
	
	public boolean deleteNoleggiByIdAuto(Integer idAuto) {
		List<Noleggio> noleggi = noleggioDao.findNoleggiByIdAuto(idAuto);
		boolean checkEliminato = false;
		if (noleggi!=null) {
			for (int i=0; i<noleggi.size(); i++) {
				Noleggio noleggio = noleggi.get(i);
				delete(noleggio);
			}
			checkEliminato = true;
		}
		return checkEliminato;
	}
	
	public boolean deleteNoleggiByDataInizio(Date dataChiusura) {
		List<Noleggio> noleggi = noleggioDao.findNoleggiByDataInizio(dataChiusura);
		boolean checkEliminato = false;
		if (noleggi!=null) {
			for (int i=0; i<noleggi.size(); i++) {
				Noleggio noleggio = noleggi.get(i);
				delete(noleggio);
			}
			checkEliminato = true;
		}
		CalendarioChiusure calendarioChiusure = new CalendarioChiusure (dataChiusura, dataChiusura);
	    createCalendario(calendarioChiusure);
		// TODO il caso in cui non c'è noleggio, deve inserirlo con isDisponibile false
		return checkEliminato;
	}
	
}