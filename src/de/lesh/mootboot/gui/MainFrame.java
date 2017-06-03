package de.lesh.mootboot.gui;

import javax.swing.*;
import de.lesh.mootboot.lib;
import java.io.IOException;
import net.dv8tion.jda.core.JDA;

public class MainFrame extends JFrame {
	
	// THIS CLASS IS ONLY FOR CLIENT SIDED USERS - ALSO THIS ISNT WORKING IN THE SERVER VERSION - DEVELOPMENT BUILDS ALSO DISABLE THIS GUI
	
	private static final long serialVersionUUID = 1l;
	
	public MainFrame (JDA jda) {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(560,360);
		this.setTitle("kuhlBot - Made by Lesh - a" + lib.version);
		JButton b;
		ImageIcon kB = new ImageIcon(MainFrame.class.getResource("/de/lesh/mootboot/gui/kuhlProgramming3mini.png"),"kuhlBot");
		b = new JButton("Source code",kB);
		b.addActionListener(e->{
			try{
				Runtime.getRuntime().exec("start \"\" \"https://github.com/LeshDev/MOOTBoot/tree/master/src/de/lesh/mootboot\"");
			}catch(IOException ignored) {
				JOptionPane.showMessageDialog(this, "https://github.com/LeshDev/MOOTBoot/tree/master/src/de/lesh/mootboot");
			}
		});//Linux compatibility kommt später... zu faul
		this.add(b);
		this.setVisible(true);
	}
}
