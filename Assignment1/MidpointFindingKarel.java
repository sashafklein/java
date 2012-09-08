/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * Karel fills the row with beepers, then removes them one at a time
 * from the outside in. Once Karel removes the final beeper, it is
 * at the center of the row, and adds one last beeper in the center.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public void run() {
		
		// find center of bottom row
		coverWithBeepers();
		removeAllBeepers();
		
		// Turn to find center of column
		if (facingEast()) {
			turnLeft();
		} else {
			turnRight();
		}
		
		// find center of central column
		coverWithBeepers();
		removeAllBeepers();
		putBeeper(); // In center
	}

	/* Fill the whole row/column with beepers.
	 */
	private void coverWithBeepers() {
		while (frontIsClear()) {
			putBeeper();
			move();
		}
		putBeeper();
		turnAround();
	}
	
	// Remove all beepers from outside in, ending at center.
	private void removeAllBeepers() {
		removeWallBeepers();
		
		// Keep removing outer beeper until all beepers gone.
		while (beepersPresent()) {
			removeOuterBeeper();
		}
	}
	
	/* Removes the two beepers against the wall.
	 * This allows removeOuterBeeper to ignore boundaries.
	 */
	private void removeWallBeepers() {
		pickBeeper();
		while (frontIsClear()) {
			move();
		}
		pickBeeper();
		turnAround();
		move();
	}
	
	// Removes beeper on one side of string and finds other end.
	private void removeOuterBeeper() {
		pickBeeper();
		move();
		while (beepersPresent()) {
			move();
		}
		turnAround();
		move();
	}
}