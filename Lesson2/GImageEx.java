package Lesson2;

import acm.graphics.GImage;
import acm.program.*;

public class GImageEx extends GraphicsProgram {
	
	private GImage myPic;
	
	public void init() {
		setSize(300,400);
		setTitle("GImage Example");
	}
	
	public void run() {
		myPic = new GImage("C:\\Users\\Public\\Pictures\\Sample Pictures\\Hydrangeas.jpg");
		
		myPic.setSize(200, 300);
		
		add(myPic, 10,10);
	}
}
