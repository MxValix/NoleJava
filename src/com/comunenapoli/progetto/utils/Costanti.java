package com.comunenapoli.progetto.utils;

public interface Costanti {
	
	
	public final static Integer ID_RUOLO_ADMIN = 1;
	public final static Integer ID_RUOLO_STAFF = 2;
	public final static Integer ID_RUOLO_CLIENTE = 3;
	
	public final static String RUOLO_ADMIN = "admin";
	public final static String RUOLO_STAFF = "staff";
	public final static String RUOLO_CLIENTE = "cliente";


	public final static String USER_IN_SESSION = "sessionUser";
	public final static String CHIAVE_RUOLO_SESSIONE = "chiaveSessione";
	
	
	public final static String CHIAVE_SESSIONE = "chiaveSessione";

	
	public final static String CHIAVE_SERVLET = "chiaveServlet";
	
	public static final String CHIAVE_UTENTE_DAO = "chiaveUtenteDao";
	
	public static final String BUSINESS_LOGIC_UTENTE = "businessLogicUtente"; 
	public static final String BUSINESS_LOGIC_RUOLO = "businessLogicRuolo"; 
	public static final String BUSINESS_LOGIC_AUTO = "businessLogicAuto"; 
	public static final String BUSINESS_LOGIC_NOLEGGIO = "businessLogicNoleggio"; 
	public static final String BUSINESS_LOGIC_PATENTE_CARTA = "businessLogicPatenteCarta"; 
	
	
	public final static Integer REGISTRAZIONE_VALIDA = 1;
	public final static Integer REGISTRAZIONE_FALLITA_UTENTE_ESISTENTE = 0;
	public final static Integer REGISTRAZIONE_FALLITA_ETA = -1;
	
	public final static Integer ERRORE_GENERICO = -2;
	public final static Integer MODIFICA_FALLITA = 0;

	


}
