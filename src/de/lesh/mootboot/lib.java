package de.lesh.mootboot;

import java.awt.Color;
import java.util.Random;

public class lib {

	public static final String bot_name = "kuhlBot";
	public static final String version = "0.1.3";
	
	public static final String bot_image = "https://github.com/LeshDev/MOOTBoot/blob/master/src/de/lesh/mootboot/gui/kuhlProgramming3.png";
	
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
