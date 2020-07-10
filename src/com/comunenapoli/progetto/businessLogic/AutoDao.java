package com.comunenapoli.progetto.businessLogic;

import java.util.List;

import javax.persistence.EntityManager;

import com.comunenapoli.progetto.model.Auto;

public class AutoDao implements DaoInterface<Auto> {
	
	private EntityManager manager = null;

	public AutoDao()
	{
		this(null);
	}
	
	public AutoDao(EntityManager entityManager)
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
	public void create(Auto auto) {
		manager.persist(auto);
	}

	@Override
	public List<Auto> retrieve() {
		List<Auto> listaAuto = manager.createQuery("from Auto",Auto.class).getResultList();
		return listaAuto;
	}

	@Override
	public void update(Auto auto) {
		manager.persist(auto);
	}

	@Override
	public void delete(Auto auto) {
		manager.remove(auto);
	}
	
	public List<Auto> findByTipologiaAuto(String tipologia){
		return manager.createQuery("select u from Auto u where u.tipologiaAuto = :x ",Auto.class).
				setParameter("x",tipologia).getResultList();
	}
	
	public List<Auto> findByMarca(String marca){
		return manager.createQuery("select u from Auto u where u.marca = :x ",Auto.class).
				setParameter("x",marca).getResultList();
	}
	
	public List<Auto> findByCambio(String cambio){
		return manager.createQuery("select u from Auto u where u.cambio = :x ",Auto.class).
				setParameter("x",cambio).getResultList();
	}
	
	public List<Auto> findByNumeroPosti(Integer numeroPosti){
		return manager.createQuery("select u from Auto u where u.numeroPosti = :x ",Auto.class).
				setParameter("x",numeroPosti).getResultList();
	}


	
}