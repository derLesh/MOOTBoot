package de.lesh.mootboot;

import java.util.HashMap;
import java.util.Map;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandUser implements Command{
  private static Map<User, Integer> map = new HashMap<>();
  
  public void execute(String commandline, String[] args, MessageReceivedEvent event) {
    // Do some stuff.
  }
  public String getName() {
    return "user";
  }
}
