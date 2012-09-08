import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Euler2 extends ConsoleProgram {	
	
	// Declares the input number up to which the program will run.
	private static final int LIMIT = 4000000;

	public void run() {
		
		println("This program calculates the sum of all even Fibonacci's under " + LIMIT + ".");
		
		int sum = 0;
		int first = 1;
		int second = 1;
		int temp = 0;
			
		while (true) {
			
			if (second > LIMIT) break;
			
			if (second % 2 == 0)
				sum += second;
			
			temp = second;
			second += first;
			first = temp;
				
		}
		
		println("The sum is " + sum + ".");
	}
}