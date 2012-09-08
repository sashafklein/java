import acm.graphics.*;
import acm.program.*;
import java.awt.*;

	public class Euler1 extends ConsoleProgram {	
		
		// Declares the input number up to which the program will run.
		private static final int INPUT_LIMIT = 1000;

		public void run() {
			
			println("This program calculates the sum of all the 3- and 5- divisible numbers up to " + INPUT_LIMIT + ".");
			
			int total = 0;
				
			for (int i = 0; i < INPUT_LIMIT; i++) {
				if (i % 3 == 0 || i % 5 == 0) {
					total = total + i;
				}
				
			}
			
			println("The sum is: " + total + ".");
		}
	}
