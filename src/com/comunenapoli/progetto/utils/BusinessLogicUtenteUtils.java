package com.comunenapoli.progetto.utils;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.businessLogic.BusinessLogicUtente;
import com.comunenapoli.progetto.businessLogic.UtenteDao;
import com.comunenapoli.progetto.model.Ruolo;
import com.comunenapoli.progetto.model.Utente;

public class BusinessLogicUtenteUtils {

	public static void creaAdmin(EntityManager entityManager) {
		UtenteDao utenteDao = new UtenteDao(entityManager);
	    BusinessLogicUtente businessLogic = new BusinessLogicUtente(entityManager,utenteDao);
		String username = "admin@nolejava.com";
	    String password = "admin123";
	    String nome = "Gennaro";
	    String cognome = "Esposito";
	    Ruolo ruolo = new Ruolo();
	    ruolo.setId(Costanti.ID_RUOLO_ADMIN);
	    ruolo.setNomeRuolo("admin");
	    LocalDate dataNascitaLD = LocalDate.of(1993, 05, 19);
	    Date dataNascita = DataUtils.convertiDataFromLocalDate(dataNascitaLD);

	    Utente utente = new Utente(username,password,nome,cognome,dataNascita,ruolo);
	    utente.setIsVerificato(true);
	    businessLogic.create(utente);
	}
	
}
