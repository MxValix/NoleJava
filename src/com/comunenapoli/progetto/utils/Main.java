package com.comunenapoli.progetto.utils;

import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.businessLogic.BusinessLogic;
import com.comunenapoli.progetto.businessLogic.UtenteDao;
import com.comunenapoli.progetto.model.Noleggio;
import com.comunenapoli.progetto.model.Ruolo;
import com.comunenapoli.progetto.model.Utente;


public class Main {
	public static void main(String[] args) {
		EntityManager entityManager = EntityManagerUtils.apriConnessione();
		UtenteDao utenteDao = new UtenteDao(entityManager);
	    BusinessLogic businessLogic = new BusinessLogic(entityManager,utenteDao);
	    
	    String username = "prova@gmail.com";
	    String password = "1dssjd";
	    String nome = "Francesco";
	    String cognome = "Boh";
	    Date dataNascita = new Date(1993-05-19);
	    Ruolo ruolo = null;
		Set<Noleggio> noleggi = null;
		
	    Utente utente = new Utente(username,password,nome,cognome,dataNascita,ruolo,noleggi);
	    businessLogic.create(utente);
	    
	    Utente utenteLogin = businessLogic.login(username+"a", password);
	    if (utenteLogin!=null) {
	    	System.out.println("Sono utente registrato");
	    }
	}
}

