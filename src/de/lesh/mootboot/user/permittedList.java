package de.lesh.mootboot.user;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.core.events.ReadyEvent;

public class permittedList {

	public static List<Long> perm = new ArrayList<>();
	
	public static void onReady(ReadyEvent e){
		perm.add(155704314638106624L);
	}
	
}
