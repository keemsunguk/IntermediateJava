package Lesson4;

public class MinMax {

	private double [] d;
	
	MinMax() {
		d = null;
	}
	
	MinMax(double[] myData) {
		d = myData;
	}
	
	public double FindMax() {
		double max = -Double.MAX_VALUE;
		
		for(int i = 0; i < d.length;i++) {
			if(d[i] > max) {
				max = d[i];
			}
		}
		return max;
	}
	
	public double FindMin() {
		double min = Double.MAX_VALUE;

		for(int i = 0; i < d.length;i++) {
			if(d[i] < min) {
				min = d[i];
			}
		}
		return min;
		
	}
	
	public void BubbleSort() {
		int SZ = d.length;
		double temp;
		for(int i = 0; i < SZ; i++) {
			for(int j = i+1; j < SZ; j++) {
				if(d[j] > d[i]) {
					temp = d[i];
					d[i] = d[j];
					d[j] = temp;
				}
			}
		}
		
	}
}
