package Lesson1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Calendar;

import acm.graphics.*;
import acm.program.*;
import acm.util.SwingTimer;

public class MyClock extends GraphicsProgram {
	
	private final int CW = 400;
	private final int CH = 300;
	private final int TIMER_RATE = 1000;
	
	private GOval clockFace;
	private GRect clockFrame;
	private GRect clockCenter;
	private GPoint c;
	private double radius;
	private GLabel tick[];
	private double hourRadius;
	private double minuteRadius;
	private double secondRadius;
	private GLine hrHand;
	private GLine minHand;
	private GLine secHand;
	
	public void init() {
		setSize(CW, CH);
		setTitle("My Awesome Clock");
		radius = Math.min(getWidth(), getHeight())*0.4;
		c = new GPoint(getWidth()/2, getHeight()/2);
		
		hourRadius = radius/2;
		minuteRadius = radius*0.7;
		secondRadius = radius*0.95;
	}
	
	private void SetupClockFace() {
		clockFrame = new GRect(c.getX()-radius-5, c.getY()-radius-5, 2*radius+10, 2*radius+10);
		clockFace = new GOval(c.getX()-radius, c.getY()-radius, 2*radius, 2*radius);
		clockCenter = new GRect(c.getX()-5, c.getY()-5, 10, 10);

		clockFrame.setFilled(true);
		clockFrame.setFillColor(Color.ORANGE);
		
		clockFace.setFilled(true);
		clockFace.setColor(Color.YELLOW);

		clockCenter.setFilled(true);
		clockCenter.setColor(Color.RED);

		add(clockFrame);
		add(clockFace);
		
		tick = new GLabel [12];
		double x;
		double y;
		for(int i = 1; i <= 12; i++) {
			tick[i-1] = new GLabel(Integer.toString(i));
			tick[i-1].setFont("TimesNewRoman-11");
			x = c.getX() + 0.9*radius*Math.sin(i*Math.PI/6);
			y = c.getY() - 0.9*radius*Math.cos(i*Math.PI/6) + 5;
			add(tick[i-1], x, y);
		}
		
		add(clockCenter);
	}
	
	public void CreateHands() {
		hrHand = new GLine(c.getX(), c.getY(), c.getX(), c.getY());
		hrHand.setColor(Color.BLUE);
		add(hrHand);
		minHand = new GLine(c.getX(), c.getY(), c.getX(), c.getY());
		minHand.setColor(Color.GREEN);
		add(minHand);
		secHand = new GLine(c.getX(), c.getY(), c.getX(), c.getY());
		secHand.setColor(Color.RED);
		add(secHand);
	}
	

	
	@SuppressWarnings("deprecation")
	public void run() {
		SetupClockFace();
		CreateHands();
		
		
		
	}
	

}
