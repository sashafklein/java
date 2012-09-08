import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Fibonacci extends ConsoleProgram {	
	
	// Declares the input number up to which the program will run.
	private static final int LIMIT = 4000000;

	public void run() {
		
		println("This program calculates the sum of all even Fibonacci's under " + LIMIT + ".");
		
		int sum = 0;
		int first = 1;
		int second = 1;
		int i = 0;
			
		while (true) {
			
			if (second > 99) break;
			
			if (second % 2 == 0)
				sum += second;
			
			i = second;
			second += first;
			first = i;
				
		}
		
		println("The sum is " + sum + ".");
	}
}