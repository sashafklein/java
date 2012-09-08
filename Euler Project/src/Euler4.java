import acm.program.*;
import java.awt.*;

public class Euler4 extends ConsoleProgram {
	
	public void run() {
		
		for (n = 100; n < 1000; n++) {
			for (m = 100; m < 1000; m++) {
				
				number = n * m;
				
				if (number >= 100000) {
					
					// Six Digit.
					compareSix();
					
				} 
				else {
					
					//Five Digit. 
					compareFive();
				}
			}
		}
		
		println("The largest palindrome with two three-digit factors is " + largest + ".");
		println("Its factors are " + factorOne + " and " + factorTwo + ".");
		

	}
	
	private void compareSix() {
		
		int last = number % 10;
		int first = (number % 1000000) / 100000;
		int penultimate = (number % 100) / 10;
		int second = (number % 100000) / 10000;
		int middleRight = (number % 1000) / 100;
		int middleLeft = (number % 10000) / 1000;
		
		if (last == first) {
			if (penultimate == second) {
				if (middleRight == middleLeft) {
					if (number > largest) {
						largest = number;
						factorOne = n;
						factorTwo = m;
					}
				}
			}
		}
	}
	
	private void compareFive() {
		
		int last = number % 10;
		int first = (number % 1000000) / 100000;
		int penultimate = (number % 100) / 10;
		int second = (number % 100000) / 10000;
		
		if (last == first) {
			if (penultimate == second) {
				if (number > largest) {
					largest = number;
					factorOne = n;
					factorTwo = m;
				}
				
			}
		} 
		
	}
	
	// Private instance variables.
	private int number;
	private int largest = 0;
	private int m;
	private int n;
	private int factorOne;
	private int factorTwo;
}
