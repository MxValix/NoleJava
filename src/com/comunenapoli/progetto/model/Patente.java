package com.comunenapoli.progetto.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Patente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPatente = null;
	
	@Column(unique = true)
	private String numeroPatente = null;
	private Date dataRilascio = null;
	private Date dataScadenza = null;
	private String categoria = null;
	
	@OneToOne
	private Utente utente = null;

	public Patente() {
		this(null,null,null,null,null);
	}

	public Patente(String numeroPatente, Date dataRilascio, Date dataScadenza, String categoria, Utente utente) {
		this.numeroPatente = numeroPatente;
		this.dataRilascio = dataRilascio;
		this.dataScadenza = dataScadenza;
		this.categoria = categoria;
		this.utente = utente;
	}

	public Integer getIdPatente() {
		return idPatente;
	}

	public void setIdPatente(Integer idPatente) {
		this.idPatente = idPatente;
	}

	public String getNumeroPatente() {
		return numeroPatente;
	}

	public void setNumeroPatente(String numeroPatente) {
		this.numeroPatente = numeroPatente;
	}

	public Date getDataRilascio() {
		return dataRilascio;
	}

	public void setDataRilascio(Date dataRilascio) {
		this.dataRilascio = dataRilascio;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((dataRilascio == null) ? 0 : dataRilascio.hashCode());
		result = prime * result + ((dataScadenza == null) ? 0 : dataScadenza.hashCode());
		result = prime * result + ((idPatente == null) ? 0 : idPatente.hashCode());
		result = prime * result + ((numeroPatente == null) ? 0 : numeroPatente.hashCode());
		result = prime * result + ((utente == null) ? 0 : utente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patente other = (Patente) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (dataRilascio == null) {
			if (other.dataRilascio != null)
				return false;
		} else if (!dataRilascio.equals(other.dataRilascio))
			return false;
		if (dataScadenza == null) {
			if (other.dataScadenza != null)
				return false;
		} else if (!dataScadenza.equals(other.dataScadenza))
			return false;
		if (idPatente == null) {
			if (other.idPatente != null)
				return false;
		} else if (!idPatente.equals(other.idPatente))
			return false;
		if (numeroPatente == null) {
			if (other.numeroPatente != null)
				return false;
		} else if (!numeroPatente.equals(other.numeroPatente))
			return false;
		if (utente == null) {
			if (other.utente != null)
				return false;
		} else if (!utente.equals(other.utente))
			return false;
		return true;
	}
	
}
