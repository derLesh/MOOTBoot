package de.lesh.mootboot.commands.stats;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Stats extends ListenerAdapter{

	public String path = "stats.json";
	GsonBuilder builder = new GsonBuilder();
	Gson gson = new Gson();
	MapperConfig mapper = new MapperConfig<MapperConfig<T>>() {
	};();
	// THIS IS A TEST PLACE -- DONT COMMAND THIS
	
	public void onMessageReceived(MessageReceivedEvent e){
		Template uInfo = new Template();
		Message msg = e.getMessage();
		User u = e.getAuthor();
		
		if(!msg.getRawContent().startsWith("-stats") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()) {
			return;
		}
		
		uInfo.name = u.getName();
		
		try (Writer writer = new FileWriter(path)){
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			builder.create();
			gson.toJson(uInfo, writer);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(gson.toJson(uInfo));
	
	}
}
