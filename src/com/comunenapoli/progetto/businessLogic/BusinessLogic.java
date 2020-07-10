package com.comunenapoli.progetto.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.Utente;


public class BusinessLogic {

	private UtenteDao utenteDao = null;
	private RuoloDao ruoloDao = null;
	private AutoDao autoDao = null;
	private PatenteDao patenteDao = null;
	private CartaDiCreditoDao cartaDiCreditoDao = null;
	private EntityManager em = null;

	public BusinessLogic(UtenteDao utenteDao, RuoloDao ruoloDao, AutoDao autoDao, PatenteDao patenteDao, CartaDiCreditoDao cartaDiCreditoDao, EntityManager em) {
		this.utenteDao = utenteDao;
		this.ruoloDao = ruoloDao;
		this.autoDao = autoDao;
		this.patenteDao = patenteDao;
		this.cartaDiCreditoDao = cartaDiCreditoDao;
		this.em = em;
	}


	public Integer getRuolo(String user,String passw) {
		Utente utente = login(user,passw);
		Integer idRuolo = 0;
		if (utente!=null) {
			Integer idUtente = utente.getIdUtente();
			idRuolo = checkRuolo(idUtente);
		}
		return idRuolo;
	}

	public void create(Utente utente) {
		em.getTransaction().begin();
		try {
			utenteDao.create(utente);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public Utente login(String username, String password) {
		em.getTransaction().begin();
		Utente utente = null;
		try {
			List<Utente> listaUtente = utenteDao.findByUsernameAndPassword(username, password);
			boolean checkLista = listaUtente==null || listaUtente.isEmpty() || listaUtente.size()>1;
			if (!checkLista) {
				utente = listaUtente.get(0);
				String usernameDb = utente.getUsername();
				String passwordDb = utente.getPassword();
				boolean checkUserPass = usernameDb.equalsIgnoreCase(username) && passwordDb.equals(password);
				if (!checkUserPass) {
					utente = null;
				}
			}
			em.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return utente;
	}

	public Integer checkRuolo(Integer idUtente) {
		Integer idRuolo = 0;
		if (idUtente!=null) {
			idRuolo = utenteDao.findRuoloByIdUtente(idUtente);
		}
		return idRuolo;
	}



}
