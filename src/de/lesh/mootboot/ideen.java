package de.lesh.mootboot;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.core.events.ReadyEvent;

public class ideen {

	public static List<String> ideas = new ArrayList<>(); 
	
	public void onReady(ReadyEvent e){
		ideas.add("+ Adding clock");
	}
	
}
