package Lesson3;

public class MinMax {

	public static void main(String[] args) {
		FileRead myRead = new FileRead("test.txt");
		
		myRead.ReadInput();
//		myRead.CheckContents();
//		myRead.WhatAmI();
		
		double[] d = myRead.data;
		
		double max = FindMax(d);
		double min = FindMin(d);

		System.out.format("Max: %8.2f\n", max);
		System.out.format("Min: %8.2f\n", min);
		System.out.format("Data size: %d\n", myRead.GetSize());
		
		
		BubbleSort(d);
		myRead.CheckContents();
	}

	
	static double FindMax(double [] d) {
		double max = -Double.MAX_VALUE;
		
		for(int i = 0; i < d.length;i++) {
			if(d[i] > max) {
				max = d[i];
			}
		}
		return max;
	}
	
	static double FindMin(double [] d) {
		double min = Double.MAX_VALUE;

		for(int i = 0; i < d.length;i++) {
			if(d[i] < min) {
				min = d[i];
			}
		}
		return min;
		
	}
	
	static void BubbleSort(double [] d) {
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
