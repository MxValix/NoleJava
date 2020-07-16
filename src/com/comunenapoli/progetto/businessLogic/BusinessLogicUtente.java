package com.comunenapoli.progetto.businessLogic;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.Ruolo;
import com.comunenapoli.progetto.model.Utente;
import com.comunenapoli.progetto.utils.Costanti;
import com.comunenapoli.progetto.utils.DataUtils;


public class BusinessLogicUtente {

	private UtenteDao utenteDao = null;
	private EntityManager em = null;

	public BusinessLogicUtente (EntityManager em ,UtenteDao utenteDao) {
		setEm(em);
		setUtenteDao(utenteDao);
	}

	public UtenteDao getUtenteDao() {
		return utenteDao; 
	}

	public void setUtenteDao(UtenteDao utenteDao) {
		this.utenteDao = utenteDao;
	}

	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
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

	public void update(Utente utente) {
		em.getTransaction().begin();
		try {
			utenteDao.update(utente);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}


	public void delete(Integer idUtente) {
		em.getTransaction().begin();
		try {
			Utente utente = utenteDao.findUtenteByIdUtente(idUtente);
			if (utente!=null) {
				utenteDao.delete(utente);
				em.getTransaction().commit();
			}
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

	public boolean isNuovoUtente(Utente utente) {
		boolean isNuovoUtente = false;
		if (utente!=null) {
			String username = utente.getUsername();
			boolean isRegistrato = utenteDao.checkUsername(username);
			if (!isRegistrato) {
				create(utente);
				isNuovoUtente = true;
			}
		}
		return isNuovoUtente;
	}

	public boolean isVerificato(Integer idUtente) {
		boolean checkVerifica = false;
		if (idUtente!=null) {
			checkVerifica = utenteDao.checkVerificaById(idUtente);
		}
		return checkVerifica;
	}

	public boolean verificaUtente(Utente utente, boolean isAccettato) {
		if (utente!=null) {
			Integer idUtente = utente.getIdUtente();
			if (!isVerificato(idUtente) && isAccettato) {
				utente.setIsVerificato(true);
				update(utente);
			} else {
				isAccettato = false;
			}	
		}
		return isAccettato;
	}

	public Integer updateDatiPersonali(Utente utente, String username, String password, String nome, String cognome) {
		boolean checkUsername = username!=null && !username.equals("") && !username.equals(utente.getUsername());
		boolean checkPassword = password!=null && !password.equals("") && !password.equals(utente.getPassword());
		boolean checkNome = nome!=null && !nome.equals("") && !nome.equals(utente.getNome());
		boolean checkCognome = cognome!=null && !cognome.equals("") && !cognome.equals(utente.getCognome());
		Integer count = 0;
		if (checkUsername){
			utente.setUsername(username);
			count++;
		}
		if (checkPassword){
			utente.setPassword(password);
			count++;
		}
		if (checkNome){
			utente.setNome(cognome);
			count++;
		}
		if (checkCognome) {
			utente.setCognome(cognome);
			count++;
		}
		if (count>0) { 					
			update(utente);
		}
		return count;
	}

	//TODO aggiustare quando utente già è staff
	public boolean updateRuolo(Utente utente, Integer idRuolo) {
		Integer ruoloStaff = Costanti.ID_RUOLO_STAFF;
		boolean checkPromozione = idRuolo == ruoloStaff;
		if (checkPromozione) {
			Ruolo ruolo = new Ruolo();
			ruolo.setId(idRuolo);
			utente.setRuolo(ruolo);
			update(utente);
			return true;
		}
		return false;
	}
	
	
	public Integer registrazione (Utente utente) throws Exception {
		String username = utente.getUsername();
		Date dataNascita = utente.getDataNascita();
		boolean checkUsername = utenteDao.checkUsername(username);
		if (!checkUsername && DataUtils.dataDiNascita(dataNascita)) {
			create(utente);
			return Costanti.REGISTRAZIONE_VALIDA;
		} else {
			if (checkUsername && !DataUtils.dataDiNascita(dataNascita)) {
				return Costanti.REGISTRAZIONE_FALLITA_UTENTE_ESISTENTE;
			}
			else {
				return Costanti.REGISTRAZIONE_FALLITA_ETA;
			}
		}
	}
	
	
	public boolean isEmailValid (String email) {
		boolean isValid = false;
		String chiocciola = "@";
		String dot = ".";
		if (email.contains(chiocciola) && email.contains(dot)) {
			isValid = true;
		}
		return isValid;
	}
	
	public List<Utente> listaUtenteNonVerificato(){
		List<Utente> utenti = utenteDao.findByIsVerificato();
		return utenti;
	}
	
	public Utente getUtenteById(Integer idUtente) {
		Utente utente = utenteDao.findUtenteByIdUtente(idUtente);
		return utente;
	}

	


}