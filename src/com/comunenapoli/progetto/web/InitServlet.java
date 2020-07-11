package com.comunenapoli.progetto.web;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.comunenapoli.progetto.businessLogic.BusinessLogicUtente;
import com.comunenapoli.progetto.businessLogic.UtenteDao;
import com.comunenapoli.progetto.utils.BusinessLogicRuoloUtils;
import com.comunenapoli.progetto.utils.BusinessLogicUtenteUtils;
import com.comunenapoli.progetto.utils.Costanti;
import com.comunenapoli.progetto.utils.EntityManagerUtils;



@WebServlet(value="/iS", loadOnStartup = 1)
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		
		EntityManager entityManager = EntityManagerUtils.apriConnessione();
		
		UtenteDao utenteDao = new UtenteDao(entityManager);
	    BusinessLogicUtente businessLogicUtente = new BusinessLogicUtente(entityManager,utenteDao);
	    
		getServletContext().setAttribute(Costanti.CHIAVE_SERVLET, entityManager);		
		getServletContext().setAttribute(Costanti.CHIAVE_UTENTE_DAO, utenteDao);
		getServletContext().setAttribute(Costanti.BUSINESS_LOGIC_UTENTE, businessLogicUtente);
		getServletContext().setAttribute(Costanti.BUSINESS_LOGIC_RUOLO, businessLogicUtente);
		
		//getServletContext().setAttribute(Costanti.BUSINESS_LOGIC_AUTO, businessLogicAuto);
		//getServletContext().setAttribute(Costanti.BUSINESS_LOGIC_NOLEGGIO, businessLogicNoleggio);
		//getServletContext().setAttribute(Costanti.BUSINESS_LOGIC_PATENTE_CARTA, businessLogicPatenteCarta);

		BusinessLogicRuoloUtils.generaRuoli(entityManager);
	    BusinessLogicUtenteUtils.creaAdmin(entityManager);
	}
	
	
	public void destroy(){	
		EntityManager entityManager = (EntityManager) getServletContext().getAttribute(Costanti.CHIAVE_SERVLET);	
		EntityManagerUtils.chiudiConnessione(entityManager);
	}
	
 
}
