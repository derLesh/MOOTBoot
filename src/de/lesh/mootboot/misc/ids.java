package de.lesh.mootboot.misc;

import java.util.*;
import java.io.*;

public class ids {

	public static final String BOT_TOKEN = readFileContents(new File("C:\\bot\\MOOTBOOT\bot.token"), true);
	public static final String TWITCH_TOKEN = readFileContents(new File("C:\\bot\\MOOTBOOT\twitch.token"), true);
	
	public static final String readFileContents(File file, boolean required) {
		try(Scanner s = new Scanner(file)){
			StringBuilder sb = new StringBuilder();
			while(s.hasNextLine()){
				sb.append(s.nextLine()).append(System.lineSeperator());
			}
			return sb.toString();
		}catch(IOException e) {
			System.err.println(e);
			if(required){
				System.exit(1);
			}
		}
		return null;
	}
}
