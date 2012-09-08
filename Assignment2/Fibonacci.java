import acm.program.*;

public class Fibonacci extends ConsoleProgram {	
	
	// Declares the input number up to which the program will run.
	private static final int LIMIT = 10000;

	public void run() {
		
		println("This program calculates and prints the fibonacci numbers up to " + LIMIT + ".");
		
		// Initiates the sequence variables (and temporary holder for values during switch).
		int first = 0;
		int second = 1;
		int holder;
		
		// Runs until limit exceeded by second (not printed first) number.
		while(true) {
			
			// Prints first number in sequence as long as limit not exceeded.
			if (first < LIMIT) {
			println(first);
			} 
			else break;
			
			// Reassigns values using a holder.
			holder = second;
			second = first + second;
			first = holder;
		}
		
	}
}