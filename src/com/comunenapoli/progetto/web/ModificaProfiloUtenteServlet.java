package com.comunenapoli.progetto.web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comunenapoli.progetto.businessLogic.BusinessLogicUtente;
import com.comunenapoli.progetto.model.Utente;
import com.comunenapoli.progetto.utils.Costanti;

/**
 * Servlet implementation class ModificaProfiloUtente
 */
@WebServlet("/modificaProfiloUtente")
public class ModificaProfiloUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModificaProfiloUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setHeader("Last-modified", LocalDateTime.now().toString());
		response.setHeader("Cache-control", "no-store");
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setHeader("Last-modified", LocalDateTime.now().toString());
		response.setHeader("Cache-control", "no-store");
		BusinessLogicUtente businessLogicUtente = (BusinessLogicUtente)getServletContext().getAttribute(Costanti.BUSINESS_LOGIC_UTENTE);
		Utente utente = (Utente)request.getSession().getAttribute(Costanti.USER_IN_SESSION);
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Integer effettuaModifica = businessLogicUtente.updateDatiPersonali(utente, email, password, nome, cognome);
		if (effettuaModifica == Costanti.MODIFICA_FALLITA) {
			//TODO modifica non avvenuta, non ho aggiornato nessun campo
		}
		else {
			//TODO mi passo quanti campi ho aggiornato e li mostro
		}
	
	}
}
