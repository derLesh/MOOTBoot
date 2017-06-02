package de.lesh.mootboot;

import java.awt.Color;
import java.util.Random;

public class lib {

	public static final String bot_name = "kuhlBot";
	public static final String version = "0.0.1";
	
	public static final String bot_image = "http://leshdev.tk/bot/img/kuhlProgramming.png";
	
	public static final String server_reg = "Frankfurt";
	
	public static final String prefix = "-";
	public static int sentMSG = 0;
	
	public static Random rand = new Random();
	
	public static Color randomColor() {
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		return  new Color(r, g, b);
	}
}
