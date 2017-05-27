package de.lesh.mootboot;

import de.lesh.mootboot.commands.*;
import de.lesh.mootboot.info.userInfo;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

import java.lang.Exception;

public class Main {
	
	public static JDA jda;
	public static JDABuilder jdaB = new JDABuilder(AccountType.BOT);
	public static int sentMSG = 0;
	
	public static void main(String[] args) throws Exception {
		
		jdaB.setToken(bot_token.BOT_TOKEN).setGame(Game.of("-help")).setAutoReconnect(true);
		jdaB.addEventListener(new botInfo());
		jdaB.addEventListener(new pingPongGame());
		jdaB.addEventListener(new userInfo());
		jdaB.addEventListener(new changeGame());
		
		jda = jdaB.buildBlocking();
		
	}
	public static JDA getSetup(){
		return jda;
	}
}
	

