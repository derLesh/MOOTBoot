package de.lesh.mootboot.user;

import java.util.ArrayList;
import java.util.List;

public class bannedList {

	public static List<Long> black = new ArrayList<>();
	
	//Blacklisted User -- Cant use the bot
	
	public void onReady(){
		black.add(292371799604461568L);
	}
	
}
