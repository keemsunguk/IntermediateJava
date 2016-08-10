package Lesson3;

public class RecursiveEx {

	public double f1(double x) {
		double y = x;
		if( y < 1) {
			y = 0;
		} else {
			//System.out.println(y);
			y = 1+f1(y-1);
		}
		return y;
	}
	
	public double f2(double x) {
		double y = x;
		if( y < 1) {
			y = 0;
		} else {
			//System.out.println(y);
			y = y+f2(y-1);
		}
		return y;
	}

	public double f3(double x) {
		double y = x;
		if( y < 2) {
			y = 1;
		} else {
			//System.out.println(y);
			y = y*f3(y-1);
		}
		return y;
	}
}
