/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		
		// Removes hangman, piece by piece.
		removeHangman();
		
		// Removes other tracked elements.
		remove(current);
		remove(incorrect);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		
		// Removes any existing word before adding new one.
		if (current != null) {
			remove(current);
		}
		
		// Displays the current word in the graphics window.
		current = new GLabel(word);
		current.setFont("Sans Serif-40");
		add(current, 50, getHeight() - 50);
		
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {

		// Displays the upper case character among other incorrect characters in the graphics window.
		letter = Character.toUpperCase(letter);
		letterString = letterString + letter;
		incorrect = new GLabel(letterString);
		incorrect.setFont("Sans Serif-30");
		add(incorrect, 50, getHeight() - 25);
		
		// Determines what to add based on the number of guesses left. Adds it.
		addWhat(letterString);
	
	}
	
	// Draws scaffolding.
	public void scaffolding() {
		
		neckX = getWidth()/2;
		
		GLine scaffold = new GLine(neckX - BEAM_LENGTH, top + SCAFFOLD_HEIGHT, neckX - BEAM_LENGTH, top);
		GLine beam = new GLine(neckX, top, neckX - BEAM_LENGTH, top);
		GLine rope = new GLine(neckX, top, neckX, top + ROPE_LENGTH);
		
		// Adds the three components to the canvas.
		add(scaffold);
		add(beam);
		add(rope);
		
	}
	
	// Removes hangman for game reset.
	private void removeHangman() {
		remove(head);
		remove(body); 
		remove(upperLeftArm);
		remove(lowerLeftArm);
		remove(upperRightArm);
		remove(lowerRightArm);
		remove(leftLeg);
		remove(leftHip);
		remove(rightLeg);
		remove(rightHip);
		remove(leftFoot);
		remove(rightFoot);
	} 
	
	// Adds whichever body part is called for (in two parts if necessary).
	private void addWhat(String str) {
		
		 // Determines picture based on # of letters missed.
		int index = str.length();
		
		if (index == 1) drawHead();
		if (index == 2) drawBody(); 
		if (index == 3) drawLArm();
		if (index == 4) drawRArm();
		if (index == 5) drawLLeg();
		if (index == 6) drawRLeg();
		if (index == 7) drawLFoot();
		if (index == 8)	drawRFoot();
	}

	private void drawHead() {
		head = new GOval(getWidth()/2 - HEAD_RADIUS, top + ROPE_LENGTH, 2*HEAD_RADIUS, 2*HEAD_RADIUS);
		add(head);
	}
	
	private void drawBody() {
		neckY = top + ROPE_LENGTH + 2 * HEAD_RADIUS;
		body = new GLine(neckX, neckY, neckX, neckY + BODY_LENGTH);
		add(body);
	}
	
	private void drawLArm() {
		armStart = neckY + ARM_OFFSET_FROM_HEAD;
		upperLeftArm = new GLine(neckX, armStart, neckX - UPPER_ARM_LENGTH, armStart);
		add(upperLeftArm);
		handStart = armStart + LOWER_ARM_LENGTH;
		lowerLeftArm = new GLine(neckX - UPPER_ARM_LENGTH, armStart, neckX - UPPER_ARM_LENGTH, handStart);
		add(lowerLeftArm);
	}
	
	private void drawRArm() {
		upperRightArm = new GLine(neckX, armStart, neckX + UPPER_ARM_LENGTH, armStart);
		add(upperRightArm);
		lowerRightArm = new GLine(neckX + UPPER_ARM_LENGTH, armStart, neckX + UPPER_ARM_LENGTH, handStart);
		add(lowerRightArm);
	}
	
	private void drawLLeg() {
		legStart = neckY + BODY_LENGTH;
		leftHip = new GLine(neckX, legStart, neckX - HIP_WIDTH, legStart);
		add(leftHip);
		footStart = legStart + LEG_LENGTH;
		leftLeg = new GLine(neckX - HIP_WIDTH, legStart, neckX - HIP_WIDTH, footStart);
		add(leftLeg);
	}
	
	private void drawRLeg() {
		rightHip = new GLine(neckX, legStart, neckX + HIP_WIDTH, legStart);
		add(rightHip);
		rightLeg = new GLine(neckX + HIP_WIDTH, legStart, neckX + HIP_WIDTH, footStart);
		add(rightLeg);
	}
	
	private void drawLFoot() {
		leftFoot = new GLine(neckX - HIP_WIDTH, footStart, neckX - HIP_WIDTH - FOOT_LENGTH, footStart);
		add(leftFoot);
	}
	
	private void drawRFoot() {
		rightFoot = new GLine(neckX + HIP_WIDTH, footStart, neckX + HIP_WIDTH + FOOT_LENGTH, footStart);
		add(rightFoot);
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

	
	// Private instance variables.
	
	// Coordinate variables.
	private int top = 20; // The top of the scaffolding. The beam lies along this.
	private int neckX; // This and the below are defined based on each other in the drawing process.
	private int neckY;
	private int armStart;
	private int handStart;
	private int legStart;
	private int footStart;
	
	private String letterString = "";
	
	// Object variables.
	private GLabel current;
	private GLabel incorrect;

	// Defined here to be removed by separate methods from those which called them.
	private GOval head;
	private GLine body;
	private GLine upperLeftArm;
	private GLine upperRightArm;
	private GLine lowerLeftArm;
	private GLine lowerRightArm;	
	private GLine leftHip;
	private GLine leftLeg;
	private GLine rightHip;
	private GLine rightLeg;
	private GLine leftFoot;
	private GLine rightFoot;
	
}
