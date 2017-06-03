package de.lesh.mootboot.gui;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUUID = 1l;
	
	public MainFrame (JDA jda) {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(120,240);
		this.setTitle("MOOTBoot - (C) Lesh");
		JButton b;
		try {
			ImageIcon gitHub = new ImageIcon(MainFrame.class.getResource("/de/lesh/mootboot/gui/github.png"),"GitHub");
			b = new JButton("GitHub",gitHub);
		} catch(IOException ignored) {
			b = new JButton("GitHub");
		}
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
