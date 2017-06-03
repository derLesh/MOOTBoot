package de.lesh.mootboot.gui;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
	public MainFrame (JDA jda) {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(120,240);
		this.setTitle("MOOTBoot - (C) Lesh");
		ImageIcon gitHub = new ImageIcon(MainFrame.class.getResource("/de/lesh/mootboot/gui/github.png"),"GitHub");
		JButton b = new JButton("GitHub",gitHub);
		b.addActionListener(e->{
			Runtime.getRuntime().exec("start \"\" \"https://github.com/LeshDev/MOOTBoot/tree/master/src/de/lesh/mootboot\"");
		});//Linux compatibility kommt später... zu faul
		this.add(b);
		this.setVisible(true);
	}
}
