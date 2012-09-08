/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 4;
	
/** Various instance variables and object declarations. */
	
	
	// Delay variable (for pausing and animation).
	private static final int DELAY = 10;

	// Ball velocity and original location variables.
	double bx = APPLICATION_WIDTH/2 - BALL_RADIUS;
	double by = APPLICATION_HEIGHT/2 - BALL_RADIUS;
	double vx, vy = 3;

	// Object initialization
	private GRect brick;
	private GRect paddle;
	private GOval ball;
	
	// Declares instance variable for unchanging y value of the paddle.	
	double paddleY = HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
	
	// Declares brick counter variable, to determine when game is won.
	private int brickCounter = 100;
	
	// Declares countable integer to monitor turns.
	private int turns = NTURNS;
	

	// Declares a randomly generated instance variable, to alter ball's velocity at impact.
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	// Banner Object declarations.
	private GLabel turnBanner;
	private GRect turnBox;
	private GLabel startBanner;
	private GRect startBox;
	private GLabel ggBanner;
	private GRect ggBox;
	private GLabel winBanner;
	private GRect winBox;
	private GLabel brickBanner;
	private GRect brickBox;
	
	
/** PROGRAM BELOW */	

	// Runs Breakout.
	public void run() {
		setUp();
		play();
	}
	
	// Sets up game components.
	private void setUp() {
		drawBricks();
		drawPaddle();
		drawBall();
		turnBanner();
		brickBanner();
		startBanner();
	}
	
	// Starts game at mouse click.
	private void play() {
			
		// Checks for victory or loss before beginning new game loop.
		if (turns > 0 && brickCounter > 0) {
			
			waitForClick();	
	
			// Removes start banner.
			remove(startBanner);
			remove(startBox);
			
			// Pauses before releasing ball
			pause(25*DELAY);
			
			// Keeps game going until all bricks are gone or the player is out of turns.
			while (brickCounter > 0 && turns > 0) {
				getVelocity();
				
				// If a turn is lost or a brick hit, status checked. Otherwise, keeps moving.
				while (true) {
					if (ball.getY() + 2 * BALL_RADIUS < APPLICATION_HEIGHT) {
						moveBall();
						if (brickCounter == 0)
							break;
						pause(DELAY);
						}
					else if (turns > 1) {
						remove(ball);
						turns--;
						turnBanner();
						reset();
						}
					else if (turns == 1 || brickCounter == 0) {
						break;
					}
				}
				
				// Determine if game won or lost.
				winOrLose();
			}
		} 
	}
			
	// Sets up the bricks for gameplay. 
	private void drawBricks(){
		
		// Determines parameters for brick coloring, based on vertical location
		double lineHeight = (2 * (BRICK_SEP + BRICK_HEIGHT));
		double redLine = (BRICK_Y_OFFSET + BRICK_SEP + (2 * BRICK_HEIGHT));
		double orangeLine = redLine + lineHeight;
		double yellowLine = orangeLine + lineHeight;
		double greenLine = yellowLine + lineHeight;
		
		for (int v = 0; v < NBRICK_ROWS; v++) {
			for (int h = 0; h < NBRICKS_PER_ROW; h++) {
				
				// Determines x and y location for brick.
				double startX = (WIDTH - (NBRICKS_PER_ROW * (BRICK_WIDTH + BRICK_SEP) - BRICK_SEP)) / 2;
				double x = startX + (h * (BRICK_WIDTH + BRICK_SEP));
				double y = BRICK_Y_OFFSET + (v * (BRICK_HEIGHT + BRICK_SEP));
				brick = new GRect (x, y, BRICK_WIDTH, BRICK_HEIGHT);
				
				// Colors brick according to color "line."
				if (y < redLine) {
					brick.setColor(Color.RED);
				} else if (y < orangeLine) {
					brick.setColor(Color.ORANGE);
				} else if (y < yellowLine) {
					brick.setColor(Color.YELLOW);
				} else if (y < greenLine) {
					brick.setColor(Color.GREEN);
				} else {
					brick.setColor(Color.CYAN);
				}
				
				brick.setFilled(true);
				add(brick);
			}
		}
							
	}
	
	// Draws paddle.
	private void drawPaddle() {
		
		double paddleX = WIDTH / 2 - PADDLE_WIDTH / 2;
		paddle = new GRect (paddleX, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
		addMouseListeners();
	
	}
	
	// Makes paddle respond to mouse movement.
	public void mouseMoved(MouseEvent e) {
		
		// Ensures that paddle only follows mouse within application boundaries.
		if (e.getX() < (APPLICATION_WIDTH - PADDLE_WIDTH/2) && (e.getX() > PADDLE_WIDTH/2)) 
			paddle.setLocation(e.getX() - PADDLE_WIDTH/2, paddleY);
	
	}
	
	private void drawBall() {
		
		ball = new GOval (bx, by, BALL_RADIUS, BALL_RADIUS);
		ball.setFilled(true);
		add(ball);
		
	}
	
	// Manages a single ball movement based on current vx and vy, including a check for collisions.
	private void moveBall() {
		
		// Moves the ball.
		ball.move(vx, vy);
		
		// Reverses x direction if the ball hits a side wall.
		if (ball.getX() + BALL_RADIUS > APPLICATION_WIDTH || ball.getX() < 0)
			vx = -vx;
		
		// Reverses y direction if the ball hits a top or bottom wall.
		if (ball.getY() < 0 || ball.getY() > APPLICATION_HEIGHT - BALL_RADIUS)
			vy = -vy;
		
		// Checks to see if the ball has hit anything and calls proper response.
		collisionCheck();
		
	}
	
	// Resets vx to a reasonable randomly generated double. Called when brick hit or game reset.
	private void getVelocity() {
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5)) vx = -vx;
		
	}
	
	// Checks to see if the ball has collided with an object. If so, determines object type and acts accordingly.
	private void collisionCheck() {
		
		GObject collider = collidingObject();
		
		// Paddle case (reverse vy).
		if (collider == paddle) {
			
			if (ball.getY() <= (APPLICATION_HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT)
			  && ball.getY() > (APPLICATION_HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT - 2*BALL_RADIUS)) {
				vy = -vy;
			}
			
		} 
		
		// Non-object cases. If the ball "hits" a banner, nothing happens.
		else if (collider == turnBox || collider == turnBanner) {
		} 
		else if (collider == brickBox || collider == brickBanner) {
		} 
		
		// If the collider hits something that isn't any of the above, it's a brick, and the program resets the counter,
		// alters velocities, and removes the brick accordingly.
		else if (collider != null) {
			remove(collider);	
			vy = -vy;
			getVelocity();
			brickCounter--;
			remove(brickBanner);
			remove(brickBox);
			brickBanner();
		}
		
	}
	
	// A method for the above collisionCheck. Calls getElementAt method to determine what element has been hit.
	private GObject collidingObject(){
		
		// Check for object at all four corners. Return null if no collision, else return object type.
		if (getElementAt(ball.getX(), ball.getY()) != null)
			return getElementAt(ball.getX(), ball.getY());
		
		if (getElementAt(ball.getX(), ball.getY()) != null)
			return getElementAt(ball.getX() + 2*BALL_RADIUS, ball.getY());;
		
		if (getElementAt(ball.getX(), ball.getY()) != null)
			return getElementAt(ball.getX(), ball.getY() + 2*BALL_RADIUS);;
		
		if (getElementAt(ball.getX(), ball.getY()) != null)
			return getElementAt(ball.getX() + 2*BALL_RADIUS, ball.getY() + 2*BALL_RADIUS);
		
		// (If no collision), return null.
		return null;
		
	}
	
	// Resets ball and turn counter. (When turn lost).
	private void reset() {
		drawBall();
		startBanner();

		// Replaces existing banner
		remove(turnBanner);
		remove(turnBox);
		turnBanner();
		
		play();
	}
	
	// Determines if game won or lost. (Called if bricks or turns == 0).
	private void winOrLose() {
		if (brickCounter == 0) {
			win();
		} else {
			loss();
		}
	}
	

/** MESSAGE BANNERS BELOW */
	
	// Displays a start banner in center screen, which goes away at mouse click.
	private void startBanner() {
		
		// Locates and specifies startBanner text.
		startBanner = new GLabel("Click to Start!");
		startBanner.setFont("Helvetica-40");
		double startBannerX = APPLICATION_WIDTH/2 - startBanner.getWidth()/2;
		double startBannerY = APPLICATION_HEIGHT/2 + startBanner.getAscent()/2;
		startBanner.setLocation(startBannerX, startBannerY);
		startBanner.setColor(Color.BLACK);
		
		// Locates startBox.
		double width = startBanner.getWidth() + 3;
		double height = startBanner.getAscent() + 3;
		double startBoxX = startBannerX - 1.5;
		double startBoxY = startBannerY - 1.5 - startBanner.getAscent();
		startBox = new GRect (startBoxX, startBoxY, width, height);
		startBox.setColor(Color.BLACK);
		startBox.setFillColor(Color.WHITE);
		startBox.setFilled(true);
		
		// Prints startBanner on top of startBox.
		add(startBox);
		add(startBanner);
	}

	// Prints the turn display to show current turn count.
	private void turnBanner() {
	turnBanner = new GLabel("Turns: " + turns);
	turnBanner.setFont("Helvetica-10");
	double turnBannerX = APPLICATION_WIDTH - turnBanner.getWidth() - 3;
	double turnBannerY = 2 + turnBanner.getAscent();
	turnBanner.setLocation(turnBannerX, turnBannerY);
	turnBanner.setColor(Color.BLACK);
	
	// Locates turn display.
	double width = turnBanner.getWidth() + 2;
	double height = turnBanner.getAscent() + 2;
	double turnBoxX = turnBannerX - 1;
	double turnBoxY = 2;
	turnBox = new GRect (turnBoxX, turnBoxY, width, height);
	turnBox.setColor(Color.BLACK);
	turnBox.setFillColor(Color.YELLOW);
	turnBox.setFilled(true);
	
	add(turnBox);
	add(turnBanner);
	}
	
	// Prints the brick display to show current brick count.
	private void brickBanner() {
	
	brickBanner = new GLabel("Bricks left: " + brickCounter);
	brickBanner.setFont("Helvetica-10");
	double brickBannerX = 2;
	double brickBannerY = APPLICATION_HEIGHT - 2;
	brickBanner.setLocation(brickBannerX, brickBannerY);
	brickBanner.setColor(Color.BLACK);
	
	// Locates brick display.
	double width = brickBanner.getWidth() + 2;
	double height = brickBanner.getAscent() + 2;
	double brickBoxX = 1;
	double brickBoxY = brickBannerY - brickBanner.getAscent() - 1;
	brickBox = new GRect(brickBoxX, brickBoxY, width, height);
	brickBox.setColor(Color.BLACK);
	brickBox.setFillColor(Color.RED);
	brickBox.setFilled(true);
	
	add(brickBox);
	add(brickBanner);
	}
		
	// Displays a gg banner.
	private void loss() {
		
		// Loser-consolation banner.
		ggBanner = new GLabel ("You lose. Nice try.");
		ggBanner.setFont("Helvetica-40");
		double ggBannerX = APPLICATION_WIDTH/2 - ggBanner.getWidth()/2;
		double ggBannerY = APPLICATION_HEIGHT/2 - ggBanner.getAscent()/2;
		ggBanner.setLocation(ggBannerX, ggBannerY);
		ggBanner.setColor(Color.RED);
		
		// Loser-consolation banner box.
		double width = ggBanner.getWidth() + 2;
		double height = ggBanner.getAscent() + 2;
		double boxX = ggBannerX - 1;
		double boxY = ggBannerY - 1 - ggBanner.getAscent();
		ggBox = new GRect(boxX, boxY, width, height);
		ggBox.setFillColor(Color.BLACK);
		ggBox.setFilled(true);
		
		add(ggBox);
		add(ggBanner);
		
	}
	
	// Displays a congratulatory banner.
	private void win() {
		winBanner = new GLabel ("Congrats! You win!");
		winBanner.setFont("Helvetica-40");
		double winBannerX = APPLICATION_WIDTH/2 - winBanner.getWidth()/2;
		double winBannerY = APPLICATION_HEIGHT/2 - winBanner.getAscent()/2;
		winBanner.setLocation(winBannerX, winBannerY);
		winBanner.setColor(Color.BLACK);
		
		double width = winBanner.getWidth() + 2;
		double height = winBanner.getAscent() + 2;
		double boxX = winBannerX - 1;
		double boxY = winBannerY - 1 - winBanner.getAscent();
		winBox = new GRect(boxX, boxY, width, height);
		winBox.setColor(Color.BLACK);
		winBox.setFillColor(Color.WHITE);
		winBox.setFilled(true);
		
		add(winBox);
		add(winBanner);
	}
}
