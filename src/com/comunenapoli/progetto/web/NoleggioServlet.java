package com.comunenapoli.progetto.web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comunenapoli.progetto.businessLogic.BusinessLogicCarta;
import com.comunenapoli.progetto.businessLogic.BusinessLogicPatente;
import com.comunenapoli.progetto.model.Utente;
import com.comunenapoli.progetto.utils.Costanti;


@WebServlet("/noleggioServlet")
public class NoleggioServlet extends HttpServlet {

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
		Utente utente = (Utente) request.getSession().getAttribute(Costanti.USER_IN_SESSION);
		Integer idUtente = utente.getIdUtente();
		BusinessLogicPatente businessLogicPatente = (BusinessLogicPatente) getServletContext().getAttribute(Costanti.BUSINESS_LOGIC_PATENTE);
		BusinessLogicCarta businessLogicCarta = (BusinessLogicCarta) getServletContext().getAttribute(Costanti.BUSINESS_LOGIC_CARTA);
		try {
			Integer responsoPatente = businessLogicPatente.responsoPatente(idUtente);
			Integer responsoCarta = businessLogicCarta.responsoCarta(idUtente);
			if (responsoPatente == 1) {
				//TODO patente valida, vai form carta
				if (responsoCarta == 1) {
					//TODO manda al form finale di noleggio
				}
				else if (responsoCarta == 0) {
					//TODO carta scaduta, vai form aggiorna dati	
				}
				else if (responsoCarta == -1) {
					//TODO carta mai inserita, vai al form di inserimento dati carta
				}
			}
			else if (responsoPatente == 0) {
				//TODO patente scaduta, vai form aggiorna dati
			}
			else if (responsoPatente == -1) {
				//TODO patente mai inserita, vai al form di inserimento dati patente
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}

