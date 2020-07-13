package com.comunenapoli.progetto.businessLogic;


import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.Auto;

public class BusinessLogicAuto {

	private AutoDao autoDao = null;
	private EntityManager em = null;

	public BusinessLogicAuto (EntityManager em ,AutoDao autoDao) {
		setEm(em);
		setAutoDao(autoDao);
	}


	public AutoDao getAutoDao() {
		return autoDao;
	}

	public void setAutoDao(AutoDao autoDao) {
		this.autoDao = autoDao;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void create(Auto auto) {
		em.getTransaction().begin();
		try {
			autoDao.create(auto);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void update(Auto auto) {
		em.getTransaction().begin();
		try {
			autoDao.update(auto);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void delete(Integer idAuto) {
		em.getTransaction().begin();
		try {
			Auto auto = autoDao.findByIdAuto(idAuto);
			if (auto!=null) {
				autoDao.delete(auto);
				em.getTransaction().commit();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public Auto getAutoByIdAuto(Integer idAuto) {
		Auto auto = autoDao.findByIdAuto(idAuto);
		return auto;
	}

	
}