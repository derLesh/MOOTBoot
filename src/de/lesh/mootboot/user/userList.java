package de.lesh.mootboot.user;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.core.events.ReadyEvent;

public class userList {

	public static final String mootLesh = "<@!155704314638106624> - https://twitter.com/Gamelesh";
	public static final String mootReiniee = "<@!208999661262995457> - https://twitter.com/reiniiiee";
	public static final String mootCAnders = "<@!141602927084044288> - https://twitter.com/CAnders_10";
	public static final String adminNoah = "<@!136604967904477185> - https://twitter.com/halbzwilling";
	
	public static List<String> mootList = new ArrayList<>();
	
	public void onReady(ReadyEvent e){
		mootList.add(mootLesh);
		mootList.add(mootCAnders);
		mootList.add(mootReiniee);
	}
	
	public static String allMoots = ">> Alle Moots:\n" + mootLesh + "\n " + mootReiniee + "\n " + mootCAnders;
}
