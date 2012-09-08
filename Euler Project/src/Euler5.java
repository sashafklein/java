import acm.program.*;
import java.awt.*;
import java.math.*;

public class Euler5 extends ConsoleProgram {

	public void run() {
		
		// Assigns a variable for the solution's upper bound calculated on the number's factorial.
		for (int i = number; i > 0; i--) 
			upperBound *= i;
		
		// Iterate through possible solutions, up from the number to the upper bound (20!).
		for (int possible = number; possible < upperBound; possible++) {
			
			// Iterate divisors from the number down to check for even division.
			for (int divisor = number; divisor > 0; divisor--) {
			
				
				// If the divisor has reached 1 without breaking, possible is a solution.
				if (possible % divisor == 0) {	
					if (divisor == 1) {
							smallest = possible;
							break;
					}
				
				// If a single divisor does not divide evenly, the loop exits to move onto next possible.
				} else break;
			}
			
			// If a solution has been found, exit loop.
			if (smallest != 0)
				break;
				
		}
				
		
		println("The smallest number divisible by all numbers 1-20 is " + smallest + ".");
		
	}
	
// Private instance variables.
private int smallest = 0;
private int number = 20;
private long upperBound = 1;

}
