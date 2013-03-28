package com.mediware;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mediware.gui.LoginPanel;

public class Mediware {
	private static JFrame frame;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		frame = new JFrame("Mediware Health Services");
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout()); 

        JPanel pnlLogin = new LoginPanel(frame);
		frame.getContentPane().add(pnlLogin);
        
        frame.setVisible(true);
	}
}
