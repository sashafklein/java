/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	public void run() {
		moveToNewspaper();
		pickUpPaper();
		returnToStart();
	}
	
	// Moves Karel to the beeper.
	private void moveToNewspaper() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	// Checks for beeper and picks it up, if present.
	private void pickUpPaper() {
		if (beepersPresent()) {
			pickBeeper();
		}
	}
	
	// Returns to starting point and re-orients (for kicks).
	private void returnToStart() {
		turnAround();
		move();
		turnRight();
		move();
		turnLeft();
		move();
		move();
		turnAround();
	}
}

