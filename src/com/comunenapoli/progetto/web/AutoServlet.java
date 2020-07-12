package com.comunenapoli.progetto.web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comunenapoli.progetto.businessLogic.BusinessLogicAuto;
import com.comunenapoli.progetto.model.Auto;
import com.comunenapoli.progetto.utils.Costanti;



@WebServlet("/autoServlet")
public class AutoServlet extends HttpServlet {

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
		BusinessLogicAuto businessLogicAuto = (BusinessLogicAuto) getServletContext().getAttribute(Costanti.BUSINESS_LOGIC_AUTO);
		String idAutoString = request.getParameter("bottone");
		Integer idAuto = Integer.valueOf(idAutoString);
		Auto auto = businessLogicAuto.getAutoByIdAuto(idAuto);
		request.getSession().setAttribute(Costanti.AUTO_IN_SESSION, auto);
	}
	

}

