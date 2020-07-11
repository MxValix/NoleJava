package com.comunenapoli.progetto.businessLogic;


import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.Ruolo;


public class BusinessLogicRuolo {

	private RuoloDao ruoloDao = null;
	private EntityManager em = null;

	public BusinessLogicRuolo (EntityManager em ,RuoloDao ruoloDao) {
		setEm(em);
		setRuoloDao(ruoloDao);
	}
	

	
	public RuoloDao getRuoloDao() {
		return ruoloDao;
	}



	public void setRuoloDao(RuoloDao ruoloDao) {
		this.ruoloDao = ruoloDao;
	}



	public EntityManager getEm() {
		return em;
	}



	public void setEm(EntityManager em) {
		this.em = em;
	}



	public void createRuolo(Ruolo ruolo) {
		em.getTransaction().begin();
		try {
			ruoloDao.create(ruolo);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	

}