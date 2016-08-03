package Lesson1;

public class RunOverloadingEx {

	public static void main(String[] args) {
		OverloadingEx will = new OverloadingEx();
		
		System.out.println(will.GetSum(3, 5));
		System.out.println(will.GetSum(3.2, 5.4));

	}

}
