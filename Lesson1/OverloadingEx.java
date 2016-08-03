package Lesson1;

public class OverloadingEx {

	private int intSum;
	private double douSum;
	
	OverloadingEx() {
		intSum = 0;
		douSum = 0;
	}
	
	public int GetSum(int a, int b) {
		intSum = a+b;
		return intSum;
	}
	
	public double GetSum(double a, double b) {
		douSum = a + b;
		return douSum;
	}
	
	
	
}
