package com.comunenapoli.progetto.businessLogic;

import java.sql.Date;
import java.text.ParseException;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.CartaDiCredito;
import com.comunenapoli.progetto.model.Utente;
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
		Utente utente = carta.getUtente();
		CartaDiCredito cartaUtente = getCartaByUtente(utente);
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
	
	
	public CartaDiCredito getCartaByUtente(Utente utente) {
		CartaDiCredito carta = cartaDao.findCartaByIdUtente(utente);
		return carta;
	}
	
	public boolean isCartaValid(Date dataScadenza) throws Exception {
		boolean isDataValida = DataUtils.dataScadenza(dataScadenza);
		return isDataValida;
	}
	
	public Integer responsoCarta(Utente utente) throws Exception {
		CartaDiCredito carta = getCartaByUtente(utente);
		boolean isCartaValid = false;
		if (carta==null) {
			return -1;
		}
		else {
			Date dataScadenza = carta.getDataDiScadenza();
			isCartaValid = isCartaValid(dataScadenza);
			if (isCartaValid) {
				return 1;
			}
		}
		return 0;	
	}
	
	public void operazioneCarta(Integer idUtente, String dataScadenzaString, String numeroCarta) throws ParseException {
		CartaDiCredito carta = cartaDao.findCartaByNumeroCarta(numeroCarta);
		boolean isNuovaCarta = carta == null;
		Date dataScadenza = DataUtils.convertiDataFromString(dataScadenzaString);
		carta.setDataDiScadenza(dataScadenza);
		if (isNuovaCarta) {
			carta.setNumeroCarta(numeroCarta);
			create(carta);
		}
		else {
			update(carta);
		}
	}

}