package de.lesh.mootboot.info;

import java.util.HashMap;
import java.util.Map;

import de.lesh.mootboot.lib;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.User;
//import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class userInfo extends ListenerAdapter {
	
	  private static Map<User, Integer> map = new HashMap<>();
	  
	  public void execute(String commandline, String[] args, MessageReceivedEvent event) {
				event.getChannel().sendMessage(new MessageBuilder().append("Generating Infocard for: " + event.getAuthor().getName()).setEmbed(new EmbedBuilder()
										.setAuthor("Infocard for: " + event.getAuthor().getName(), null, event.getJDA().getSelfUser().getAvatarUrl())
										.addField("Member", event.getAuthor().getAsMention(), true)
										.addBlankField(true)
										.addField("Sent Messages", String.valueOf(
											map.getOrDefault(event.getAuthor(),0))
											  , true)
										.setColor(java.awt.Color.GREEN)
										.build()).build()).queue();
	  }
	  
	  public void onMessageAnyReceived(MessageReceivedEvent event){
	          if(!event.getMessage().getRawContent().startsWith(lib.prefix)){
				      User m = event.getAuthor();
	            map.put(m, map.getOrDefault(m,0)+1);//increment message count
	          }
	  }
	  
	  public String getName() {
	    return "user";
	  }
}
