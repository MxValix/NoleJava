package com.comunenapoli.progetto.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ruolo {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idRuolo=null;
	
	private String nomeRuolo = null;

	@OneToMany(mappedBy="ruolo")
	private Set<Utente> utenti = null;

	public Ruolo() {
		this(null);
	}
	
	
	public Ruolo(String nomeRuolo) {
		utenti = new HashSet<Utente>();
		setNomeRuolo(nomeRuolo);
	}

	public Integer getId() {
		return idRuolo;
	}

	public void setId(Integer id) {
		this.idRuolo = id;
	}

	public String getNomeRuolo() {
		return nomeRuolo;
	}

	public void setNomeRuolo(String nomeRuolo) {
		this.nomeRuolo = nomeRuolo;
	}

	public Set<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(Set<Utente> utenti) {
		this.utenti = utenti;
	}
	
	
	

}
