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
	    SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");  
		Date date = (Date) formatter.parse(dataString);
	    return date;
	}
	
	
	
	
	
}
