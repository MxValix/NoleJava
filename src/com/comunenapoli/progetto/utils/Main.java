package com.comunenapoli.progetto.utils;

import javax.persistence.EntityManager;

public class Main {
	public static void main(String[] args) {
		EntityManager entityManager = EntityManagerUtils.apriConnessione();
	}
}

