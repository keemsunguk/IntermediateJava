package Lesson5;

public class BMW implements OperateCar, CharacterCar {
	private double turnRad;
	private double currSpeed;
	private double dir;
	private String myColor;
	private String myModel;
	private double currPrice;
	
	BMW() {
		turnRad = 0;
		currSpeed = 0;
		dir = Math.PI/2;
		myColor ="";
		myModel = "";
		currPrice = 0;
	}
	
	BMW(String c, String m, double p) {
		turnRad = 0;
		currSpeed = 0;
		dir = Math.PI/2;
		myColor =c;
		myModel = m;
		currPrice = p;
	}
	
	public String toString() {
		String temp = "Color:"+myColor+", Model:"+myModel+", "+"Price:"+Double.toString(currPrice);
		return temp;
	}
	
	//implementation of OperateCar
	public int turn(double radius, double speed) {
		currSpeed = speed;
		if(radius < 0.1) {
			return 0;
		}
		turnRad = radius;
		return 1;
	}
	public int changeLanes(double direction, double speed) {
		if (dir < 0) {
			return 0;
		}
		dir = direction;
		currSpeed = speed;
		return 1;
	}
	
	public int signalTurn(double direction, double speed) {
		// 0: no turn signal
		// 1: Left turn signal
		// 2: Right turn signal
		if( direction > 0 && direction < Math.PI/2) {
			return 2;
		} else if (direction > Math.PI/2 && direction < Math.PI) {
			return 1;
		} else {
			return 0;
		}
	}

	public String GetColor() {
		return myColor;
	}
	public String GetModel() {
		return myModel;
	}
	public double GetPrice() {
		return currPrice;
	}


}
