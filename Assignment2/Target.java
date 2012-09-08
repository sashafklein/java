/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file paints three concentric circular ovals on top of one another. 
 * The largest is opaque red, the middle opaque white, and the smallest
 * opaque red. The end result is a Target (like the brand's).
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	
	// The widths/heights of the circles in the target.
	private static final double OUTER_SIZE = 72;
	private static final double MID_SIZE = 46.8;
	private static final double INNER_SIZE = 21.6;
	
	public void run() {
		
		// Coordinates for center of screen.
		int centerX = getWidth() / 2;
		int centerY = getHeight() / 2;
		
		// Coordinates for placement of outer circle.
		double outerX = centerX - (OUTER_SIZE / 2);
		double outerY = centerY - (OUTER_SIZE / 2);
		
		// Place a red outer circle in the right place.
		GOval outerOval = new GOval (outerX, outerY, OUTER_SIZE, OUTER_SIZE);
		outerOval.setColor(Color.RED);
		outerOval.setFilled(true);
		add(outerOval);
		
		// Coordinates for placement of middle circle.
		double midX = centerX - (MID_SIZE / 2);
		double midY = centerY - (MID_SIZE / 2);
		
		// Place a white circle in the right place.
		GOval midOval = new GOval (midX, midY, MID_SIZE, MID_SIZE);
		midOval.setColor(Color.WHITE);
		midOval.setFilled(true);
		add(midOval);

		// Coordinates for placement of middle circle.
		double innerX = centerX - (INNER_SIZE / 2);
		double innerY = centerY - (INNER_SIZE / 2);
		
		// Place a red circle in the right place.
		GOval innerOval = new GOval (innerX, innerY, INNER_SIZE, INNER_SIZE);
		innerOval.setColor(Color.RED);
		innerOval.setFilled(true);
		add(innerOval);
	}
}
