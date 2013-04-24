package com.mediware.gui.patient;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class PatientHealthData extends JPanel{
    
    int max = 0;
    int[] data = {0};
    
    public void addData(int[] data, int max) {
	
	this.data = data;
	this.max = max;
	
    }
    
    @Override
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Dimension size = this.getSize();
	
	for(int i = 0; i < data.length-1; i++) {
	    int x1 = (i*size.width)/(data.length-1);
	    int y1 = size.height - (data[i]*size.height)/max;
	    int x2 = ((i+1)*size.width)/(data.length-1);
	    int y2 = size.height - (data[i+1]*size.height)/max;
	    g.drawLine(x1, y1, x2, y2);
	    
	}
	
	for(int i = 0; i < data.length-1; i++) {
	    int x1 = (i*size.width)/(data.length-1);
	    int y1 = size.height - (data[i]*size.height)/max;
	    
	    g.drawOval(x1-5, y1-5, 10, 10);
	}
	
    }

}
