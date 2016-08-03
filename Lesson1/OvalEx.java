package Lesson1;

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class OvalEx extends GraphicsProgram {

	private GOval clockFace;
	private GRect clockFrame;
	private double radius;
	private GPoint c;
	
	public void init() {
		setSize(400,300);
		setTitle("Show me Ovel");
	}
	
	public void run() {
		radius = Math.min(getWidth(), getHeight())*0.45;
		clockFace = new GOval(50, 50, 50+radius, 50+radius);  //
		clockFrame = new GRect(45,45, 60+radius, 60+radius);
		c = new GPoint( 50+clockFace.getWidth()/2, 50+clockFace.getHeight()/2);
		
		clockFrame.setFilled(true);
		clockFrame.setFillColor(Color.CYAN);
		clockFace.setFilled(true);
		clockFace.setFillColor(Color.YELLOW);
		
		double x = c.getX() + radius;
		
		add(clockFrame);
		add(clockFace);
	}
}
