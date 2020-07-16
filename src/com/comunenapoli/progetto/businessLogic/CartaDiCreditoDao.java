package com.comunenapoli.progetto.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.CartaDiCredito;
import com.comunenapoli.progetto.model.Utente;

public class CartaDiCreditoDao implements DaoInterface<CartaDiCredito> {
	
	private EntityManager manager = null;

	public CartaDiCreditoDao()
	{
		this(null);
	}
	
	public CartaDiCreditoDao(EntityManager entityManager)
	{
		setManager(entityManager);
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void create(CartaDiCredito cartaDiCredito) {
		manager.persist(cartaDiCredito);
	}

	@Override
	public List<CartaDiCredito> retrieve() {
		List<CartaDiCredito> carteDiCredito = manager.createQuery("from CartaDiCredito",CartaDiCredito.class).getResultList();
		return carteDiCredito;
	}

	@Override
	public void update(CartaDiCredito cartaDiCredito) {
		manager.persist(cartaDiCredito);
	}

	@Override
	public void delete(CartaDiCredito cartaDiCredito) {
		manager.remove(cartaDiCredito);
	}
	
	public CartaDiCredito findCartaByIdUtente(Utente utente) {
		CartaDiCredito carta = manager.createQuery("select c from CartaDiCredito c where c.utente = :x",CartaDiCredito.class).
				setParameter("x",utente).getResultList().stream().findFirst().orElse(null);
		return carta;
	}
	
	public CartaDiCredito findCartaByNumeroCarta(String numeroCarta) {
		CartaDiCredito carta = manager.createQuery("select c from CartaDiCredito c where c.numeroCarta = :x",CartaDiCredito.class).
				setParameter("x",numeroCarta).getResultList().stream().findFirst().orElse(null);
		return carta;
	}
	
	
}