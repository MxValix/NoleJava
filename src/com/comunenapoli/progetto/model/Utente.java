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



}
