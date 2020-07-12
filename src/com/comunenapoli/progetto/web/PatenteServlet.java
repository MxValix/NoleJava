package com.comunenapoli.progetto.web;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comunenapoli.progetto.businessLogic.BusinessLogicPatente;
import com.comunenapoli.progetto.model.Utente;
import com.comunenapoli.progetto.utils.Costanti;



@WebServlet("/patenteServlet")
public class PatenteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

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
		Utente utente = (Utente) getServletContext().getAttribute(Costanti.USER_IN_SESSION);
		Integer idUtente = utente.getIdUtente();
		BusinessLogicPatente businessLogicPatente = (BusinessLogicPatente) getServletContext().getAttribute(Costanti.BUSINESS_LOGIC_PATENTE);
		String dataScadenza = request.getParameter("datascadenza");
		String numeroPatente = request.getParameter("numeropatente");
		try {
			 businessLogicPatente.operazionePatente(idUtente, dataScadenza, numeroPatente);
			 //TODO vai a noleggioServlet e verifica carta
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

