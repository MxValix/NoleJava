package com.comunenapoli.progetto.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Noleggio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNoleggio = null;
	
	private Date dataPrenotazione = null;	
	private Date dataInizio = null;
	private Date dataFine = null;
	private Boolean isDisponibile = true;
	
	@ManyToOne
	private Utente utente = null;
	
	@OneToOne
	private Auto auto = null;
	
	public Noleggio() {
		this(null,null,null,null,null);
	}
	

	public Noleggio(Date dataPrenotazione, Date dataInizio, Date dataFine, Utente utente,
			Auto auto) {
		super();
		this.dataPrenotazione = dataPrenotazione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.utente = utente;
		this.auto = auto;
	}

	public Integer getIdNoleggio() {
		return idNoleggio;
	}

	public void setIdNoleggio(Integer idNoleggio) {
		this.idNoleggio = idNoleggio;
	}

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	public Boolean getIsDisponibile() {
		return isDisponibile;
	}

	public void setIsDisponibile(Boolean isDisponibile) {
		this.isDisponibile = isDisponibile;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auto == null) ? 0 : auto.hashCode());
		result = prime * result + ((dataFine == null) ? 0 : dataFine.hashCode());
		result = prime * result + ((dataInizio == null) ? 0 : dataInizio.hashCode());
		result = prime * result + ((dataPrenotazione == null) ? 0 : dataPrenotazione.hashCode());
		result = prime * result + ((idNoleggio == null) ? 0 : idNoleggio.hashCode());
		result = prime * result + ((isDisponibile == null) ? 0 : isDisponibile.hashCode());
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
		Noleggio other = (Noleggio) obj;
		if (auto == null) {
			if (other.auto != null)
				return false;
		} else if (!auto.equals(other.auto))
			return false;
		if (dataFine == null) {
			if (other.dataFine != null)
				return false;
		} else if (!dataFine.equals(other.dataFine))
			return false;
		if (dataInizio == null) {
			if (other.dataInizio != null)
				return false;
		} else if (!dataInizio.equals(other.dataInizio))
			return false;
		if (dataPrenotazione == null) {
			if (other.dataPrenotazione != null)
				return false;
		} else if (!dataPrenotazione.equals(other.dataPrenotazione))
			return false;
		if (idNoleggio == null) {
			if (other.idNoleggio != null)
				return false;
		} else if (!idNoleggio.equals(other.idNoleggio))
			return false;
		if (isDisponibile == null) {
			if (other.isDisponibile != null)
				return false;
		} else if (!isDisponibile.equals(other.isDisponibile))
			return false;
		if (utente == null) {
			if (other.utente != null)
				return false;
		} else if (!utente.equals(other.utente))
			return false;
		return true;
	}

	

}
