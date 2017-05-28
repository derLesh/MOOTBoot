package de.lesh.mootboot.commands.info;


import java.util.List;
import java.util.stream.Collectors;

import de.lesh.mootboot.user.bannedList;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class userInfo extends ListenerAdapter{

	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		User author = e.getAuthor();
		
		//List<Role>.stream().map(Role::getName).collect(Collectors.join(", "))
		
		if(!msg.getRawContent().startsWith("-user") || bannedList.black.contains(e.getAuthor().getIdLong())) {
			return;
		}
		
		String userName = e.getMessage().getRawContent().split("\\s+",2)[1];
		EmbedBuilder eB = new EmbedBuilder();
		
		eB.setAuthor("Infocard >> " + author.getName(), null, author.getEffectiveAvatarUrl());
		eB.addField("**User**:", author.getAsMention(), true);
		eB.addField("**ID**:", "" + author.getIdLong(), true);
		eB.addField("**Sent messages**:", "__Coming soon__", true);
		eB.addField("**Creted**:", "" + author.getCreationTime(), true);
		eB.addField("**Roles**:", "" + e.IrgendwasHELp, true);
		
		eB.setThumbnail(author.getEffectiveAvatarUrl());
		eB.setColor(java.awt.Color.CYAN);
		e.getChannel().sendMessage(eB.build()).queue();
	}
	
}
