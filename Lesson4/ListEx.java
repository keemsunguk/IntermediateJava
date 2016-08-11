package Lesson4;

import java.util.*;

public class ListEx {

	public static void main(String[] args) {

		List <Double> data = new ArrayList <Double>();
		
		data.add(3.2);
		
		for(int i = 0; i < 10; i++) {
			data.add(Math.random());
		}

		System.out.format("\n\n\n\n\n");
		System.out.println(data);
			
		data.remove(6);
		data.add(5, 10.5);

		FileReadList f = new FileReadList("test.txt");
		f.ReadInput();
		f.CheckContents();
		
		double [] myData = new double[f.data.size()];
//		Double [] myData = new Double[f.data.size()];

		int i = 0;
		for(double x:f.data) {
			myData[i++] = x;
		}

		//myData = (Double[])f.data.toArray();
		//myData[0].doubleValue()
		MinMax minmax = new MinMax(myData);
		System.out.println("Max is "+minmax.FindMax());
		minmax.BubbleSort();
		
		for(double x:myData) {
			System.out.println(x);
		}
	}

}
