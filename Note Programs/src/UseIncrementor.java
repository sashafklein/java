import acm.program.*;

public class UseIncrementor extends ConsoleProgram {
	
	public void run() {
		
		Incrementor count1 = new Incrementor();
		Incrementor count2 = new Incrementor(1000);
		
		println("five values for count1:");
		countFiveTimes(count1);
		
		println("five values for count2:");
		countFiveTimes(count2);
		
		println("another five values for count1:");
		countFiveTimes(count1);
		
		println("another five values for count2:");
		countFiveTimes(count2);
		
	}
	
	private void countFiveTimes(Incrementor counter) {
	
		for (int i = 0; i < 5; i++) {
			println(counter.nextValue());
		}
	}
}