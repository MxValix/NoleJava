package com.comunenapoli.progetto.utils;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.businessLogic.BusinessLogicRuolo;
import com.comunenapoli.progetto.businessLogic.RuoloDao;
import com.comunenapoli.progetto.model.Ruolo;

public class BusinessLogicRuoloUtils {
	
	public static void generaRuoli(EntityManager entityManager) { 
		RuoloDao ruoloDao = new RuoloDao(entityManager);
	    BusinessLogicRuolo businessLogicRuolo = new BusinessLogicRuolo(entityManager,ruoloDao);
	    Ruolo ruoloAdmin = new Ruolo(1,"admin");
	    Ruolo ruoloStaff = new Ruolo(2,"staff");
	    Ruolo ruoloCliente = new Ruolo(3,"cliente");
	    businessLogicRuolo.createRuolo(ruoloAdmin);
	    businessLogicRuolo.createRuolo(ruoloStaff);
	    businessLogicRuolo.createRuolo(ruoloCliente);
	}
}
