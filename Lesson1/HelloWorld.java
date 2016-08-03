package Lesson1;

import acm.graphics.*;
import acm.program.*;

public class HelloWorld extends GraphicsProgram {
	
	
	public void init() {
		setSize(400,300);
		setTitle("Hello World");
	}
	
	public void run() {
		GLabel hw = new GLabel("Hello World!");
		hw.setFont("TimesNewRoman-30");
		double x = (getWidth() - hw.getWidth())/2;
		double y = (getHeight() - hw.getHeight())/2;
		
		add(hw, x, y);
	}

}
