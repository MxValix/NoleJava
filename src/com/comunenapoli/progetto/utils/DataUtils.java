package com.comunenapoli.progetto.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DataUtils {
	
	public static Date convertiDataFromLocalDate(LocalDate localDate) {
		Date date = Date.valueOf(localDate);
		return date;
	}
	
	public static Date convertiDataFromString(String dataString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = formatter.parse(dataString);
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
	    return date;
	}
	
	public static String convertiDataFromSqlDate(Date dataSql) throws ParseException {
	    SimpleDateFormat formatter= new SimpleDateFormat("dd-MMM-yyyy");  
		String date = (String) formatter.format(dataSql);
		return date;
	}
	
	public static boolean dataDiNascita(String dataNascitaString) throws Exception {
		java.util.Date dateOggi = new java.util.Date();
	    SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");  
	    java.util.Date dataNascita = formatter.parse(dataNascitaString);
		Integer confrontaAnno = dateOggi.getYear() - dataNascita.getYear();
		if (confrontaAnno<18) {
			return false;
		}
		else if (confrontaAnno>18) {
			return true;
		}
		else if (confrontaAnno==18) {
			boolean mesePassato = dateOggi.getMonth() > dataNascita.getMonth();
			boolean meseCorrente = dateOggi.getMonth() == dataNascita.getMonth();
			boolean meseFuturo = dateOggi.getMonth() < dataNascita.getMonth();

			if (mesePassato) {
				return true;
			}
			else if (meseCorrente) {
				boolean giornoPassato = dateOggi.getMonth() >= dataNascita.getMonth();
				boolean giornoFuturo = dateOggi.getMonth() < dataNascita.getMonth();
				if (giornoPassato) {
					return true;
				}
				else if (giornoFuturo) {
					return false;
				}
			} else if (meseFuturo){
				return false;
			}
		}
		return false;
	}
	
	public static boolean dataScadenza(Date dataScadenzaCorrente) throws Exception {
		java.util.Date dateOggi = new java.util.Date();
	    java.util.Date dataScadenza = dataScadenzaCorrente;
		Integer confrontaAnno = dateOggi.getYear() - dataScadenza.getYear();
		if (confrontaAnno<0) {
			return false;
		}
		else if (confrontaAnno>0) {
			return true;
		}
		else if (confrontaAnno==0) {
			boolean mesePassato = dateOggi.getMonth() > dataScadenza.getMonth();
			boolean meseCorrente = dateOggi.getMonth() == dataScadenza.getMonth();
			boolean meseFuturo = dateOggi.getMonth() < dataScadenza.getMonth();

			if (mesePassato) {
				return false;
			}
			else if (meseCorrente) {
				boolean giornoPassato = dateOggi.getMonth() >= dataScadenza.getMonth();
				boolean giornoFuturo = dateOggi.getMonth() < dataScadenza.getMonth();
				if (giornoPassato) {
					return false;
				}
				else if (giornoFuturo) {
					return true;
				}
			} else if (meseFuturo){
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
