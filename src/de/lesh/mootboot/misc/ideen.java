package de.lesh.mootboot.misc;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ideen extends ListenerAdapter{

	public static List<String> ideas = new ArrayList<>(); 
	
	public void onReady(ReadyEvent e){
		ideas.add("+ Add logfiles");
	}
}
