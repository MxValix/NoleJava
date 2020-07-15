package com.comunenapoli.progetto.utils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.comunenapoli.progetto.businessLogic.BusinessLogicAuto;
import com.comunenapoli.progetto.businessLogic.BusinessLogicNoleggio;
import com.comunenapoli.progetto.model.Auto;

public class BusinessLogicAutoNoleggioUtils {

	//dorebbe avere un model con cui comunicare, non così
	/*public static void filtroRicerca(Date dataInizioNoleggio, Date dataFineNoleggio, String tipologiaAuto, String marcaAuto,
			String cambio, Integer numeroPosti, Double prezzoAutoPerGiorno, BusinessLogicNoleggio businessLogicNoleggio, BusinessLogicAuto businessLogicAuto) {
		List<Integer> idAutoNonDisponibili = businessLogicNoleggio.getIdAutoNonDisponibili(dataInizioNoleggio, dataFineNoleggio);
		List<Auto> autoDisponibili = businessLogicAuto.getAutoDisponibili(idAutoNonDisponibiliList)
		
	}
	*/
	
	public static List<Auto> filtroRicerca(Date dataInizioNoleggio, Date dataFineNoleggio, String tipologiaAuto, BusinessLogicAuto businessLogicAuto, BusinessLogicNoleggio businessLogicNoleggio) {
		List <Integer> idAutoNonDisponibili = businessLogicNoleggio.getIdAutoNonDisponibili(dataInizioNoleggio, dataFineNoleggio);
		List <Auto> autoDisponibili = businessLogicAuto.getAutoDisponibili(idAutoNonDisponibili);
		List <Auto> risultati = new ArrayList<Auto>();
		
		if (tipologiaAuto.isEmpty() || tipologiaAuto.equals("")) {
			return autoDisponibili;
		}else {
			for (Auto auto: autoDisponibili) {
				if (auto.getTipologiaAuto() == tipologiaAuto) {
					risultati.add(auto);
				}
			}
		}
		
		return risultati;
	}
	

}
