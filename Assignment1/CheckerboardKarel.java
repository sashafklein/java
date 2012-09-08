/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		
		// Checking for 1x? type worlds.
		if (frontIsClear()) {
			// Go through rows filling and turning until last row.
			while (leftIsClear()) {
				fillRow();
				turnE();
				fillRow();
				turnW();
			}
			
			// Check to see if last row filled. If not, fill it.
			move();
			if (noBeepersPresent()) {
				moveBackwards();
				fillRow();
			} else {
				moveBackwards();
			}
		} 
		
		// In 1x? worlds, fill column as row. 
		else {
			turnLeft();
			fillRow();
		}
	}
	
	// Alternate beepers until row complete
	private void fillRow() {
		
		putBeeper();
		while (frontIsClear()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			} 
		}
	}
	
	// U-turn against an east wall, resetting Karel correctly.
	private void turnE() {		
		
		// Turn while facing east. If ceiling above, loop stops.
		if (facingEast()) {
			if (leftIsClear()) {
				
				// Presence of beeper indicates odd-columned world.
				if (beepersPresent()) { 
					turnLeft();
					move();
					turnLeft();
					move();
				} else {
					turnLeft();
					move();
					turnLeft();
				}
			}
		}
	}
	
	// U-turn against a west wall, resetting Karel correctly.
	private void turnW() {
		
		// Turn while facing west, if no ceiling.
		if (facingWest()) {
			if (rightIsClear()) {
				
				// Presence of beeper indicates odd-columned world.
				if (beepersPresent()) {
					turnRight();
					move();
					turnRight();
					move();
				} else {
					turnRight();
					move();
					turnRight();
				}
			} 
			
			// If ceiling, turn around to end run's While loop.
			else {
				turnAround();
			}
		}
	}
	
	private void moveBackwards() {
		turnAround();
		move();
		turnAround();
	}
}