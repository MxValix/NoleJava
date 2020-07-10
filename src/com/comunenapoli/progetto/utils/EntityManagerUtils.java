package com.comunenapoli.progetto.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils {

	public static EntityManager apriConnessione() {
		String nomeLogico= "Nolejava";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(nomeLogico);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public static void chiudiConnessione(EntityManager entityManager) {
		EntityManagerFactory emf = entityManager.getEntityManagerFactory();
		if ( entityManager.isOpen() ) {
		    entityManager.close();
		}
		if ( emf.isOpen() ) {
		    emf.close();
		}
	}
}
