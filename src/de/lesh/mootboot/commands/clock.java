package de.lesh.mootboot.commands;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class clock {

	public static String currentTime(){
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("EE dd.MM.YYYY, HH:mm:ss | KK:mm:ss a");
		//Date currentDate = new Date();
		String clockTime = OffsetDateTime.now().format( DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm:ss"));
		return clockTime;
	}
	
	public static String getDescription(){
		return "Zeigt die aktuelle Zeit an";
		
	}
	
}
