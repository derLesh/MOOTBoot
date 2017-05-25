package de.lesh.mootboot;

import de.lesh.mootboot.commands.*;

import java.util.HashMap;
import java.util.Map;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandUser implements Command{
  private static Map<User, Integer> map = new HashMap<>();
  
  public void execute(String commandline, String[] args, MessageReceivedEvent event) {
				event.getChannel().sendMessage("Generating Infocard for: " + event.getAuthor().getName())
						.queue(msg->event.getChannel().sendMessage(new EmbedBuilder()
									.setAuthor("Infocard for: " + event.getAuthor().getName(), null, event.getJDA().getSelfUser().getAvatarUrl())
									.addField("Member", event.getAuthor().getAsMention(), true)
									.addBlankField(true)
									.addField("Sent Messages", String.valueOf(
										map.getOrDefault(event.getAuthor(),0))
										  , true)
									.setColor(java.awt.Color.GREEN)
									.build())
                  .queue());
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
