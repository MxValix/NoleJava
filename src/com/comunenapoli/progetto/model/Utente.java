package com.comunenapoli.progetto.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	Integer idUtente= null;

	private String username = null;
	private String password = null;
	private String nome = null;
	private String cognome = null;
	private Date dataNascita = null;
	private Boolean isVerificato = false;

	@ManyToOne
	@JoinColumn(name="ruoloUtente")
	private Ruolo ruolo;

	@ManyToMany(mappedBy="utente")
	private Set<Noleggio> noleggi = null;
	
	@OneToOne(mappedBy="utente")
	@NotFound(action=NotFoundAction.IGNORE)
	Patente patente = null;
	
	@OneToOne(mappedBy="utente")
	@NotFound(action=NotFoundAction.IGNORE)
	CartaDiCredito cartaDiCredito = null;


    @PrePersist
    public void prePersist() {
       if (ruolo == null) {
           ruolo = new Ruolo(3,"cliente");
       }
    }
	
	
	public Utente () {
		this(null,null, null, null, null, null);
	}
	
	public Utente(String username, String password, String nome, String cognome, Date dataNascita, Ruolo ruolo) {
		setUsername(username);
		setPassword(password);
		setNome(nome);
		setCognome(cognome);
		setDataNascita(dataNascita);
		setRuolo(ruolo);
	}


	public Utente(String username, String password, String nome, String cognome, Date dataNascita, Ruolo ruolo,
			Set<Noleggio> noleggi) {
		setUsername(username);
		setPassword(password);
		setNome(nome);
		setCognome(cognome);
		setDataNascita(dataNascita);
		setRuolo(ruolo);
		noleggi = new HashSet<Noleggio>();
		
	}

	public Integer getIdUtente() {
		return idUtente;
	}




	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getCognome() {
		return cognome;
	}




	public void setCognome(String cognome) {
		this.cognome = cognome;
	}




	public Date getDataNascita() {
		return dataNascita;
	}




	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}




	public Boolean getIsVerificato() {
		return isVerificato;
	}




	public void setIsVerificato(Boolean isVerificato) {
		this.isVerificato = isVerificato;
	}




	public Ruolo getRuolo() {
		return ruolo;
	}




	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}




	public Set<Noleggio> getNoleggi() {
		return noleggi;
	}

	public void setNoleggi(Set<Noleggio> noleggi) {
		this.noleggi = noleggi;
	}

	



	public Patente getPatente() {
		return patente;
	}




	public void setPatente(Patente patente) {
		this.patente = patente;
	}




	public CartaDiCredito getCartaDiCredito() {
		return cartaDiCredito;
	}




	public void setCartaDiCredito(CartaDiCredito cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartaDiCredito == null) ? 0 : cartaDiCredito.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataNascita == null) ? 0 : dataNascita.hashCode());
		result = prime * result + ((idUtente == null) ? 0 : idUtente.hashCode());
		result = prime * result + ((isVerificato == null) ? 0 : isVerificato.hashCode());
		result = prime * result + ((noleggi == null) ? 0 : noleggi.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((patente == null) ? 0 : patente.hashCode());
		result = prime * result + ((ruolo == null) ? 0 : ruolo.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Utente other = (Utente) obj;
		if (cartaDiCredito == null) {
			if (other.cartaDiCredito != null)
				return false;
		} else if (!cartaDiCredito.equals(other.cartaDiCredito))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataNascita == null) {
			if (other.dataNascita != null)
				return false;
		} else if (!dataNascita.equals(other.dataNascita))
			return false;
		if (idUtente == null) {
			if (other.idUtente != null)
				return false;
		} else if (!idUtente.equals(other.idUtente))
			return false;
		if (isVerificato == null) {
			if (other.isVerificato != null)
				return false;
		} else if (!isVerificato.equals(other.isVerificato))
			return false;
		if (noleggi == null) {
			if (other.noleggi != null)
				return false;
		} else if (!noleggi.equals(other.noleggi))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (patente == null) {
			if (other.patente != null)
				return false;
		} else if (!patente.equals(other.patente))
			return false;
		if (ruolo == null) {
			if (other.ruolo != null)
				return false;
		} else if (!ruolo.equals(other.ruolo))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}




	



}
