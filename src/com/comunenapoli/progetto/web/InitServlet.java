package com.comunenapoli.progetto.web;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.comunenapoli.progetto.businessLogic.AutoDao;
import com.comunenapoli.progetto.businessLogic.BusinessLogicAuto;
import com.comunenapoli.progetto.businessLogic.BusinessLogicCarta;
import com.comunenapoli.progetto.businessLogic.BusinessLogicNoleggio;
import com.comunenapoli.progetto.businessLogic.BusinessLogicPatente;
import com.comunenapoli.progetto.businessLogic.BusinessLogicUtente;
import com.comunenapoli.progetto.businessLogic.CalendarioChiusureDao;
import com.comunenapoli.progetto.businessLogic.CartaDiCreditoDao;
import com.comunenapoli.progetto.businessLogic.NoleggioDao;
import com.comunenapoli.progetto.businessLogic.PatenteDao;
import com.comunenapoli.progetto.businessLogic.UtenteDao;
import com.comunenapoli.progetto.model.Auto;
import com.comunenapoli.progetto.model.Noleggio;
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
		//RuoloDao ruoloDao = new RuoloDao(entityManager);
		PatenteDao patenteDao = new PatenteDao(entityManager);
		CartaDiCreditoDao cartaDao = new CartaDiCreditoDao(entityManager);
		AutoDao autoDao = new AutoDao(entityManager);
		NoleggioDao noleggioDao = new NoleggioDao(entityManager);
		CalendarioChiusureDao calendarioChiusureDao = new CalendarioChiusureDao(entityManager);


	    BusinessLogicUtente businessLogicUtente = new BusinessLogicUtente(entityManager,utenteDao);
	    BusinessLogicPatente businessLogicPatente = new BusinessLogicPatente(entityManager,patenteDao);
	    BusinessLogicCarta businessLogicCarta = new BusinessLogicCarta(entityManager,cartaDao);
	    BusinessLogicAuto businessLogicAuto = new BusinessLogicAuto(entityManager,autoDao);
	    BusinessLogicNoleggio businessLogicNoleggio = new BusinessLogicNoleggio(entityManager,noleggioDao,calendarioChiusureDao);


	    
	    
		getServletContext().setAttribute(Costanti.CHIAVE_SERVLET, entityManager);		
		getServletContext().setAttribute(Costanti.CHIAVE_UTENTE_DAO, utenteDao);
		getServletContext().setAttribute(Costanti.BUSINESS_LOGIC_UTENTE, businessLogicUtente);
		//getServletContext().setAttribute(Costanti.BUSINESS_LOGIC_RUOLO, businessLogicRuolo);
		
		getServletContext().setAttribute(Costanti.BUSINESS_LOGIC_AUTO, businessLogicAuto);
		getServletContext().setAttribute(Costanti.BUSINESS_LOGIC_NOLEGGIO, businessLogicNoleggio);
		getServletContext().setAttribute(Costanti.BUSINESS_LOGIC_PATENTE, businessLogicPatente);
		getServletContext().setAttribute(Costanti.BUSINESS_LOGIC_UTENTE, businessLogicUtente);
		getServletContext().setAttribute(Costanti.BUSINESS_LOGIC_CARTA, businessLogicCarta);

		BusinessLogicRuoloUtils.generaRuoli(entityManager);
	    BusinessLogicUtenteUtils.creaAdmin(entityManager);
	    Auto auto = new Auto("berlina","bmw","M3","A",12.00, "nero", 3, "DV854RT", "metano", 3.100, "ewff.img");
	    Auto auto2 = new Auto("asadw","dwff","efewe","A",32.00, "nero", 2, "BP854RT", "benzina", 2.100, "dewdf.png");
	    businessLogicAuto.create(auto);
	    businessLogicAuto.create(auto2);
	}
	
	
	public void destroy(){	
		EntityManager entityManager = (EntityManager) getServletContext().getAttribute(Costanti.CHIAVE_SERVLET);	
		EntityManagerUtils.chiudiConnessione(entityManager);
	}
	
 
}
