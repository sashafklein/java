/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		
		/** Define x coordinate variable (constant, really) for bottom right brick. 
		 * This is the total width, minus the pyramid base width, divided by 2, 
		 * plus 13 (or BRICKS_IN_BASE - 1) bricks.
		 */
		int brick1X = (getWidth() + (BRICK_WIDTH * BRICKS_IN_BASE) - (2 * BRICK_WIDTH)) / 2;
		
		/** Define y coordinate constant for bottom right brick.
		 * This is the height of the screen minus brick height.
		 * (Because screen height is positive downwards).
		 */
		int brick1Y = getHeight() - BRICK_HEIGHT; 
		
		/** Iterates through the pyramid one row at a time. Shifts the x coordinate ("x")
		 * of each block based on the row iterator and the number of column, divided
		 * by two and multiplied by block width (as each block is split above those below).
		 * The inner loop is j + i to ensure that each row has one less brick.
		 * 
		 * The outer loop counts up each row, altering x and y coordinates (and inner loop
		 * length) accordingly.
		 */
		for (double i = 0; i < BRICKS_IN_BASE; i++) {
			for (int j = 0; j + i < BRICKS_IN_BASE; j++) {
				double x = brick1X - (j * BRICK_WIDTH) - ((i / 2) * BRICK_WIDTH); 
				double y = brick1Y - (i * BRICK_HEIGHT); 
				GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT); 
				brick.setFilled((j % 2) != 0 && (i % 2) != 0); 
				add(brick);  
			}
		}
	}
}

