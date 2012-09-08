/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		
		// Define variables. Original number, the number that changes, and the counter,
		// which increases each time the "hailstone" is altered.
		int first = readInt("Enter a number:");
		int hailstone = first;
		int counter = 0;
		
		// Continues loop until hailstone is one.
		while (hailstone != 1) {
			
			// New variable for printing purposes.
			int previousHailstone = hailstone;
			
			// Odd condition. Resets hailstone as 3h + 1, and prints new hailstone.
			if (hailstone % 2 != 0) {
				hailstone = (3 * hailstone + 1);
				println(previousHailstone + " is odd, so I make 3n + 1: " + hailstone);
				
			// Even condition. Resets hailstone as h/2, and prints new hailstone.
			// Only occurs if hailstone entered this round was not odd.
			} else {
				hailstone = (hailstone / 2);
				println(previousHailstone + " is even, so I take half: " + hailstone);
			}
			
			// Each round that hailstone is altered, counts up.
			counter++;
		}
		
		println("The process took " + counter + " to reach 1.");
	}
}

