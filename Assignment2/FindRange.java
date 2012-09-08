/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static final int SENTINEL = 0;
	
	public void run() {
		
		println("This program finds the largest and smallest numbers.");
		
		int first = readInt("?");
		int smallest = first; // The first number is the smallest at first.
		int largest = first; // The first number is the largest at first.
		
		if (first == SENTINEL) {
			println("This is not a valid first number.");
		}
		
		// Continues prompting until sentinel entered.
		while(true) {
			int val = readInt("?");
			if (val == SENTINEL) break;
			
			// Detects current smallest.
			if (smallest > val) {
				smallest = val;
			}
			
			// Detects current largest.
			if (largest < val) {
				largest = val;
			}
		}
		
	println("The largest number is " + largest);
	println("The smallest number is " + smallest);
	}
}

