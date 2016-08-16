package Lesson5;

public class RunInterfaceEx {

	public static void main(String[] args) {
		BMW mady = new BMW("Pink", "M350", 50000);
		BMW will = new BMW("Black", "E300", 45000);
		
		System.out.println("Mady's Car: "+mady.toString());
		System.out.println("Will's Car: "+will.toString());
		
		int ts = mady.signalTurn(1.5, 0);
		if( ts == 1) {
			System.out.println("Mady is turning left");			
		} else if(ts == 2) {
			System.out.println("Mady is turning right");						
		} else {
			System.out.println("Mady is not turning");			
		}
	}

}
