package com.comunenapoli.progetto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class Auto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAuto = null;
	
	private String tipologiaAuto = null;
	private String marca = null;
	private String modello = null;
	private String cambio = null;
	private Double cilindrata = null;
	private String colore = null;
	private Integer numeroPosti = null;
	@Column(unique = true)
	private String targa = null;
	private String tipoCarburante = null;
	private Double prezzoPerGiorno = null;
	private String urlImg = null;
	
	@OneToOne(mappedBy="auto")
	private Noleggio noleggio =null;
	
	public Auto() {
		this(null,null,null,null,null,null,null,null,null,null,null);
	}
	

	public Auto(String tipologiaAuto, String marca, String modello, String cambio, Double cilindrata, String colore,
			Integer numeroPosti, String targa, String tipoCarburante, Double prezzoPerGiorno, String urlImg) {
		this.tipologiaAuto = tipologiaAuto;
		this.marca = marca;
		this.modello = modello;
		this.cambio = cambio;
		this.cilindrata = cilindrata;
		this.colore = colore;
		this.numeroPosti = numeroPosti;
		this.targa = targa;
		this.tipoCarburante = tipoCarburante;
		this.prezzoPerGiorno = prezzoPerGiorno;
		this.urlImg = urlImg;
	}


	public Integer getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(Integer idAuto) {
		this.idAuto = idAuto;
	}

	public String getTipologiaAuto() {
		return tipologiaAuto;
	}

	public void setTipologiaAuto(String tipologiaAuto) {
		this.tipologiaAuto = tipologiaAuto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public Double getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(Double cilindrata) {
		this.cilindrata = cilindrata;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public Integer getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(Integer numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getTipoCarburante() {
		return tipoCarburante;
	}

	public void setTipoCarburante(String tipoCarburante) {
		this.tipoCarburante = tipoCarburante;
	}

	public Double getPrezzoPerGiorno() {
		return prezzoPerGiorno;
	}

	public void setPrezzoPerGiorno(Double prezzoPerGiorno) {
		this.prezzoPerGiorno = prezzoPerGiorno;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public Noleggio getNoleggio() {
		return noleggio;
	}


	public void setNoleggio(Noleggio noleggio) {
		this.noleggio = noleggio;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cambio == null) ? 0 : cambio.hashCode());
		result = prime * result + ((cilindrata == null) ? 0 : cilindrata.hashCode());
		result = prime * result + ((colore == null) ? 0 : colore.hashCode());
		result = prime * result + ((idAuto == null) ? 0 : idAuto.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modello == null) ? 0 : modello.hashCode());
		result = prime * result + ((noleggio == null) ? 0 : noleggio.hashCode());
		result = prime * result + ((numeroPosti == null) ? 0 : numeroPosti.hashCode());
		result = prime * result + ((prezzoPerGiorno == null) ? 0 : prezzoPerGiorno.hashCode());
		result = prime * result + ((targa == null) ? 0 : targa.hashCode());
		result = prime * result + ((tipoCarburante == null) ? 0 : tipoCarburante.hashCode());
		result = prime * result + ((tipologiaAuto == null) ? 0 : tipologiaAuto.hashCode());
		result = prime * result + ((urlImg == null) ? 0 : urlImg.hashCode());
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
		Auto other = (Auto) obj;
		if (cambio == null) {
			if (other.cambio != null)
				return false;
		} else if (!cambio.equals(other.cambio))
			return false;
		if (cilindrata == null) {
			if (other.cilindrata != null)
				return false;
		} else if (!cilindrata.equals(other.cilindrata))
			return false;
		if (colore == null) {
			if (other.colore != null)
				return false;
		} else if (!colore.equals(other.colore))
			return false;
		if (idAuto == null) {
			if (other.idAuto != null)
				return false;
		} else if (!idAuto.equals(other.idAuto))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modello == null) {
			if (other.modello != null)
				return false;
		} else if (!modello.equals(other.modello))
			return false;
		if (noleggio == null) {
			if (other.noleggio != null)
				return false;
		} else if (!noleggio.equals(other.noleggio))
			return false;
		if (numeroPosti == null) {
			if (other.numeroPosti != null)
				return false;
		} else if (!numeroPosti.equals(other.numeroPosti))
			return false;
		if (prezzoPerGiorno == null) {
			if (other.prezzoPerGiorno != null)
				return false;
		} else if (!prezzoPerGiorno.equals(other.prezzoPerGiorno))
			return false;
		if (targa == null) {
			if (other.targa != null)
				return false;
		} else if (!targa.equals(other.targa))
			return false;
		if (tipoCarburante == null) {
			if (other.tipoCarburante != null)
				return false;
		} else if (!tipoCarburante.equals(other.tipoCarburante))
			return false;
		if (tipologiaAuto == null) {
			if (other.tipologiaAuto != null)
				return false;
		} else if (!tipologiaAuto.equals(other.tipologiaAuto))
			return false;
		if (urlImg == null) {
			if (other.urlImg != null)
				return false;
		} else if (!urlImg.equals(other.urlImg))
			return false;
		return true;
	}
	
	
	
}