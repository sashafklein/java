/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		
		/** Turns left to look up column, invokes fillColumn to
		 * go up the column adding beepers. Then moveToBase
		 * and moves onto nextColumn once column is complete.
		 */
		while (frontIsClear()) {
			turnLeft();
			fillColumn();
			moveToBase();
			nextColumn(); 
		} 
		
		// Fills last column. Returns to base. Celebrates.	
		turnLeft();
		fillColumn();
		moveToBase();
		celebrate();
		
	}

	/** Goes up column, checking for beepers and filling in 
	* when they're not present. Stops at top of column.
	*/
	private void fillColumn() {
		
		/** Checks front. If clear, checks for (and adds) beeper, 
		 * then moves on. If not, just checks for and adds beeper.
		 */
		while (frontIsClear()) {
			if (noBeepersPresent()) {
				putBeeper();	
			}	
			move();
		}
		
		if (noBeepersPresent()) {
			putBeeper();
		}	
	}
	
	/** Returns Karel to the base of the column and reset to face
	 * to the east.
	 */
	private void moveToBase() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
	
	// Moves Karel onto next column. Leaves it facing east. 
	private void nextColumn() {
		for (int i = 0; i < 4; i++) {
			move();
		}	
	}
	
	// Makes Karel perform a celebratory dance.
	private void celebrate() {
		for (int i = 0; i < 12; i++) {
			turnLeft();
		}
			
	}
}
