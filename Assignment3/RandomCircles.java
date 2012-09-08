
// This program generates ten circles of random color that fit within the canvas.
import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class RandomCircles extends GraphicsProgram {

private RandomGenerator rgen = RandomGenerator.getInstance();

/** Width and height of application window in pixels */
public static final int APPLICATION_WIDTH = 400;
public static final int APPLICATION_HEIGHT = 600;

	public void run() {
		for (int i = 0; i < 10; i++) {
			createCircle();
		}
		
	}
	
	private void createCircle() {
		int R = circleRadius();
		int X = circleX(R);
		int Y = circleY(R);
		Color circleColor = rgen.nextColor();
		drawCircle(R, X, Y, circleColor);
	}
	
	private int circleRadius() {
		int R = rgen.nextInt(0, APPLICATION_WIDTH/5);
		return R;
	}
	
	private void drawCircle(int R, int X, int Y, Color circleColor) {
		GOval circle = new GOval(X, Y, 2*R, 2*R);
		circle.setColor(circleColor);
		circle.setFilled(true);
		add(circle);
	}
	
	private int circleX(int R) {
		int X = rgen.nextInt(0, APPLICATION_WIDTH - 2*R);
		return X;
	}
	
	private int circleY(int R) {
		int Y = rgen.nextInt(0, APPLICATION_HEIGHT - 2*R);
		return Y;
	}
}
