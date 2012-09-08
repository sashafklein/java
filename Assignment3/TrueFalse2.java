import acm.program.*;
import acm.util.RandomGenerator;

public class TrueFalse2 extends ConsoleProgram {

	public void run() {
	
		for (int i = 0; i < 5; i++) {
			int x = rgen.nextInt(0, 10);
			println("x is " + x + ".");
			println("method x is " + multByTwo(x) + ".");
			println("x is still " + x + ".");
		}
		
	}

	private int multByTwo(int multiplier) {
		int x = 2 * multiplier;
		return x;
	}
	
	RandomGenerator rgen = RandomGenerator.getInstance();
	
}
