package de.lesh.mootboot.commands.stats;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Stats extends ListenerAdapter{
	
	public String info = "https://stackoverflow.com/questions/5490789/json-parsing-using-gson-for-java";

	public String path = "stats.json";
	GsonBuilder builder = new GsonBuilder();
	Gson gson = new Gson();
	
	public void onMessageReceived(MessageReceivedEvent e){
		Template uInfo = new Template();
		Message msg = e.getMessage();
		User u = e.getAuthor();
//		Random rdm = new Random();
		//int idGen = rdm.nextInt(999999);
		
		
		if(!msg.getRawContent().startsWith("-stats") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()) {
			return;
		}
		
		//JsonElement jelement = new JsonParser().parse(jsonLine);
		
		//if()
		uInfo.name = u.getName();
		uInfo.id = u.getId();
		uInfo.lvl = 0;
		
		try (Writer writer = new FileWriter(path)){
			builder.create();
			gson.toJson(uInfo, writer);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(gson.toJson(uInfo));
	
	}
}
