package de.lesh.mootboot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface Command {
  String getName();
  void execute(String commandline, String[] args, MessageReceivedEvent event);
}
