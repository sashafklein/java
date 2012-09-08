import acm.program.*;
import java.math.*;
import java.awt.*;
import java.lang.*;

public class Euler3 extends ConsoleProgram{
	
	/** Finds the largest prime factor of a number by finding every factor up to that number's
	 * square root and then checking that factor and its complementary factor for primacy. Any 
	 * prime factor is then compared to (and can replace) the largest existing prime factor.
	 */
	public void run() {
		
		// Calculates the square root of the number.
		int squareRoot = Math.abs((int)Math.sqrt(NUMBER));
		
		for (int i = 2; i < squareRoot; i++) {
			
			// If the number in question is a factor of NUMBER.
			if (NUMBER % i == 0) {
				
				// Check it for primacy, and if it's prime, check to see if it's the biggest yet.
				if (isPrime(i)) {
					if (i > biggestPrime)
						biggestPrime = i;
				}
				
				// Then do the same for its complement.
				if (isPrime((int)(NUMBER/i))) {
					if ((int)(NUMBER/i) > biggestPrime) 
						biggestPrime = (int)(NUMBER/i);
				}
				
			}
		}
		
		println("The greatest prime factor of " + NUMBER + " is " + biggestPrime + ".");
		
	}
	
	// Determines if a number is prime by brute force: going through 2 and that number's square root
	// in search of a factor. 
	private boolean isPrime (int x) {
		for (int a = 2; a < Math.sqrt(x); a++) {
				if (x % a == 0) {
					return false;
				}
		}
		return true;
	}
	
	// Private instance variables.
	private static final long NUMBER = 600851475143L;
	private int biggestPrime = 0;

}
