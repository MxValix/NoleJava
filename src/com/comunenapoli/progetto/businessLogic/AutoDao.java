package com.comunenapoli.progetto.businessLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
		TypedQuery<Auto> query = manager.createQuery("select u from Auto u where u.tipologiaAuto = :x ",Auto.class);
		List<Auto> listaAutomobili = query.setParameter("x",tipologia).getResultList();
		return listaAutomobili;
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

	public Auto findByIdAuto(Integer idAuto){
		Auto auto = manager.createQuery("select a from Auto a where a.idAuto = :x ",Auto.class).
				setParameter("x",idAuto).getResultList().stream().findFirst().orElse(null);
		return auto;
	}


	public List<Auto> findAutoByFilters(String sql, HashMap<String, String> parametriAuto){
		String query = "select a from Auto a " + sql;
		System.out.println(query);
		TypedQuery<Auto> typedQuery = manager.createQuery(query,Auto.class);
		List<String> parametriKey = new ArrayList<String>();
		int filterSize = parametriAuto.size();
		for (String nomeParametro : parametriAuto.keySet()){
			parametriKey.add(nomeParametro);
		}
		for (int i=0;i<filterSize;i++) {
			String key1 = parametriKey.get(i);
			String value1 = parametriAuto.get(key1);

			if(filterSize==1) {
				typedQuery = typedQuery.setParameter(key1, value1);
			}
			else {
				i++;
				String key2 = parametriKey.get(i);
				String value2 = parametriAuto.get(key2);
				if (filterSize==2) {
					typedQuery = typedQuery.setParameter(key1, value1).setParameter(key2, value2);
				}
				else {
					i++;
					String key3 = parametriKey.get(i);
					String value3 = parametriAuto.get(key3);
					if (filterSize==3) {
						typedQuery = typedQuery.setParameter(key1, value1).setParameter(key2, value2).setParameter(key3, value3);
					}
				}
			}
		} 
		List<Auto> automobili = typedQuery.getResultList();
		return automobili;
	}

}