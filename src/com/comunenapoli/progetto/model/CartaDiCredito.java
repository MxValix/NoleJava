package com.comunenapoli.progetto.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CartaDiCredito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCartaDiCredito = null;
	
	@Column(unique = true)
	private String numeroCarta = null;
	
	private Integer cvv = null;
	private Date dataDiScadenza = null;
	
	@OneToOne
	private Utente utente = null;
	
	public CartaDiCredito() {
		this(null,null,null);
	}
	
	public CartaDiCredito(String numeroCarta, Integer cvv, Date dataDiScadenza) {
		this.numeroCarta = numeroCarta;
		this.cvv = cvv;
		this.dataDiScadenza = dataDiScadenza;
	}

	public Integer getIdCartaDiCredito() {
		return idCartaDiCredito;
	}

	public void setIdCartaDiCredito(Integer idCartaDiCredito) {
		this.idCartaDiCredito = idCartaDiCredito;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Date getDataDiScadenza() {
		return dataDiScadenza;
	}

	public void setDataDiScadenza(Date dataDiScadenza) {
		this.dataDiScadenza = dataDiScadenza;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	
	
	

}
