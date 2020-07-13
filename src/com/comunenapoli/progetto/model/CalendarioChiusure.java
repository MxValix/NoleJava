package com.comunenapoli.progetto.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.comunenapoli.progetto.utils.Costanti;

@Entity
public class CalendarioChiusure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCalendario = null;
	
	private Date dataInizio = null;
	private Date dataFine = null;
	
	@ManyToOne
	@JoinColumn(name="ruoloCalendario")
	private Ruolo ruoloCalendario = null;

	public CalendarioChiusure() {
		this(null,null);
	}
	
	public CalendarioChiusure(Date dataInizio, Date dataFine) {
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.ruoloCalendario = new Ruolo(Costanti.ID_RUOLO_ADMIN,Costanti.RUOLO_ADMIN);
	}

	public Integer getIdCalendario() {
		return idCalendario;
	}

	public void setIdCalendario(Integer idCalendario) {
		this.idCalendario = idCalendario;
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

	public Ruolo getRuoloUtente() {
		return ruoloCalendario;
	}

	public void setRuoloUtente(Ruolo ruoloUtente) {
		this.ruoloCalendario = ruoloUtente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFine == null) ? 0 : dataFine.hashCode());
		result = prime * result + ((dataInizio == null) ? 0 : dataInizio.hashCode());
		result = prime * result + ((idCalendario == null) ? 0 : idCalendario.hashCode());
		result = prime * result + ((ruoloCalendario == null) ? 0 : ruoloCalendario.hashCode());
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
		CalendarioChiusure other = (CalendarioChiusure) obj;
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
		if (idCalendario == null) {
			if (other.idCalendario != null)
				return false;
		} else if (!idCalendario.equals(other.idCalendario))
			return false;
		if (ruoloCalendario == null) {
			if (other.ruoloCalendario != null)
				return false;
		} else if (!ruoloCalendario.equals(other.ruoloCalendario))
			return false;
		return true;
	}
	
}
