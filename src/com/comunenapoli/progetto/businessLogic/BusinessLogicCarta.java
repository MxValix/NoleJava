package com.comunenapoli.progetto.businessLogic;

import java.sql.Date;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.CartaDiCredito;
import com.comunenapoli.progetto.utils.DataUtils;


public class BusinessLogicCarta {

	private CartaDiCreditoDao cartaDao = null;
	private EntityManager em = null;

	public BusinessLogicCarta(EntityManager em, CartaDiCreditoDao cartaDao) {
		this.cartaDao = cartaDao;
		this.em = em;
	}

	
	public CartaDiCreditoDao getCartaDao() {
		return cartaDao;
	}



	public void setCartaDao(CartaDiCreditoDao cartaDao) {
		this.cartaDao = cartaDao;
	}



	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void create(CartaDiCredito carta) {
		em.getTransaction().begin();
		try {
			cartaDao.create(carta);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void update(CartaDiCredito carta) {
		em.getTransaction().begin();
		try {
			cartaDao.update(carta);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}


	public void delete(Integer idPatente) {
		//TODO 
	}


	//crea la carta solo se l'utente non ne ha già una associata, e se nessun altro utente ha lo stesso numeroCarta associato
	public boolean creaCarta(CartaDiCredito carta) {
		Integer idUtente = carta.getUtente().getIdUtente();
		CartaDiCredito cartaUtente = getCartaByIdUtente(idUtente);
		if (cartaUtente==null) {
			String numeroPatente = carta.getNumeroCarta();
			cartaUtente = cartaDao.findCartaByNumeroCarta(numeroPatente);
			if (cartaUtente==null) {
				create(carta);
				return true;
			}
		}
		return false;
	}
	
	
	public CartaDiCredito getCartaByIdUtente(Integer idUtente) {
		CartaDiCredito carta = cartaDao.findCartaByIdUtente(idUtente);
		return carta;
	}
	
	public boolean isCartaValid(Date dataScadenza) throws Exception {
		boolean isDataValida = DataUtils.dataScadenza(dataScadenza);
		return isDataValida;
	}
	
	public Integer responsoCarta(Integer idUtente) throws Exception {
		CartaDiCredito carta = getCartaByIdUtente(idUtente);
		boolean isPatenteValida = false;
		if (carta==null) {
			return -1;
		}
		else {
			Date dataScadenza = carta.getDataDiScadenza();
			isPatenteValida = isCartaValid(dataScadenza);
			if (isPatenteValida) {
				return 1;
			}
		}
		return 0;	
	}
	

}