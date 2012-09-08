import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;
import java.awt.event.*;
import acm.util.RandomGenerator;

public class TrueFalse1 extends ConsoleProgram {

// Initiates a random number generator
private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		
		for (int j = 1; j < 6; j++) {
			
			int i = rgen.nextInt(1, 10);
			println(j + ". The outer i is " + i + ".");
			println("The inner i is " + otherI());
			println("The outer i is still " + i + " after the method call.");
			println("");
			
		}
		
		println("");
		println("As you can see, the two random i's differ in each instance (disregarding random overlap).");
	}
	
	private int otherI() {
		int i = rgen.nextInt(1, 10);
		return(i);
	}

}
