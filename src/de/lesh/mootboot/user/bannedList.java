package de.lesh.mootboot.user;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class bannedList extends ListenerAdapter{

	public static List<Long> black = new ArrayList<>();
	
	//Blacklisted User -- Cant use the bot
	
	public void onReady(){
		black.add(292371799604461568L);
	}
}
