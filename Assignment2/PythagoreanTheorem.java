/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		
		// Requests integers a and b.
		println("Please enter an integer for a.");
		int a = readInt();
		println("Please enter an integer for b.");
		int b = readInt();
		
		// Calculates and prints c.
		double c = Math.sqrt((double)(a * a + b * b));
		println("c = " + c);
	}
}
