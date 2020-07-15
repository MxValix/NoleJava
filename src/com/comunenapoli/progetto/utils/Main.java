package com.comunenapoli.progetto.utils;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.businessLogic.BusinessLogicNoleggio;
import com.comunenapoli.progetto.businessLogic.BusinessLogicUtente;
import com.comunenapoli.progetto.businessLogic.CalendarioChiusureDao;
import com.comunenapoli.progetto.businessLogic.NoleggioDao;
import com.comunenapoli.progetto.businessLogic.UtenteDao;
import com.comunenapoli.progetto.model.Utente;

public class Main {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = EntityManagerUtils.apriConnessione();
		CalendarioChiusureDao calendarioChiusureDao = new CalendarioChiusureDao(entityManager);
		NoleggioDao noleggioDao = new NoleggioDao(entityManager);
		BusinessLogicRuoloUtils.generaRuoli(entityManager);
		BusinessLogicNoleggio businessLogicNoleggio = new BusinessLogicNoleggio(entityManager,noleggioDao,calendarioChiusureDao);
		UtenteDao utenteDao = new UtenteDao(entityManager);
	    LocalDate dataNascitaLD = LocalDate.of(1993, 05, 19);
	    Date dataNascita = DataUtils.convertiDataFromLocalDate(dataNascitaLD);
	    BusinessLogicUtente businessLogicUtente = new BusinessLogicUtente(entityManager,utenteDao);
	    BusinessLogicUtenteUtils.creaAdmin(entityManager);
		businessLogicNoleggio.deleteNoleggiByDataInizio(dataNascita);
		Utente utente = businessLogicUtente.getUtenteById(1);
		System.out.println(utente.getUsername() + "username");
	    /*
	    String username = "prova@gmail.com";
	    String password = "1dssjd";
	    String nome = "Francesco";
	    String cognome = "Boh";
	    Ruolo ruolo = null;
	    LocalDate dataNascitaLD = LocalDate.of(1993, 05, 19);
	    Date dataNascita = DataUtils.convertiData(dataNascitaLD);

	    Utente utente = new Utente(username,password,nome,cognome,dataNascita,ruolo);
	    businessLogic.create(utente);
	    
	    Utente utenteLogin = businessLogic.login(username, password);
	    if (utenteLogin!=null) {
	    	System.out.println("Sono utente registrato");
	    }
	    Utente utente2 = new Utente(username,password,nome,cognome,dataNascita,ruolo);
	    boolean isNuovoUtente = businessLogic.isNuovoUtente(utente2);
	    System.out.println("isRegistrato: " + isNuovoUtente);
	    
	    boolean isVerificato = businessLogic.isVerificato(1);
	    System.out.println("isVerificato: " + isVerificato);	
	    
	    boolean verificaUtente = businessLogic.verificaUtente(utente, true);
	    
	    isVerificato = businessLogic.isVerificato(1);
	    System.out.println("isVerificato: " + isVerificato);	
	    
	    boolean isUpdated = businessLogic.updateRuolo(utente, 2);
	    System.out.println(isUpdated + " aggiornato");
	   
	    isUpdated = businessLogic.updateRuolo(utente, 3);
	    System.out.println(isUpdated + " aggiornato 3");

	    
	    isUpdated = businessLogic.updateRuolo(utente, 1);
	    System.out.println(isUpdated + " aggiornato 2");
	    
	    businessLogic.delete(1);
	    */
	    EntityManagerUtils.chiudiConnessione(entityManager);

	}
}

