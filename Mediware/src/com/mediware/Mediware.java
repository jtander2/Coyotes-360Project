package com.mediware;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import com.mediware.gui.LoginPanel;

public class Mediware {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mediware Health Services");
        
		LoginPanel pnlLogin = new LoginPanel();
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(pnlLogin);
        frame.setVisible(true);
	}

}
