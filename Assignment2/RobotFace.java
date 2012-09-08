import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class RobotFace extends GraphicsProgram {	
	
	// Dimensions of boxes and spacing in between.
	private static final double HEAD_WIDTH = 250;
	private static final double HEAD_HEIGHT = 350;
	private static final double MOUTH_WIDTH = 150;
	private static final double MOUTH_HEIGHT = 75;
	private static final double EYE_RADIUS = 35;

	public void run () {
		
		createHead();
		createEyes();
		createMouth();
	}
	
	private void createHead() {
		
		// Locate upper left of rectangle for starting coordinates.
		double x = (getWidth() - HEAD_WIDTH) / 2;
		double y = (getHeight() - HEAD_HEIGHT) / 2;
		
		// Declare, style, and add head.
		GRect head = new GRect(x, y, HEAD_WIDTH, HEAD_HEIGHT);
		head.setColor(Color.BLACK);
		head.setFillColor(Color.GRAY);
		head.setFilled(true);
		add(head);
		
	}
	
	private void createEyes() {
		
		// Eye center coordinates. (A quarter head in from sides and top).
		double leftCenterX = (getWidth() / 2) - (HEAD_WIDTH / 4);
		double CenterY = (getHeight() / 2) - (HEAD_HEIGHT / 4);
		double rightCenterX = (getWidth() / 2) + (HEAD_WIDTH / 4);
		
		// Eye corner coordinates.
		double leftX = leftCenterX - EYE_RADIUS;
		double eyeY = CenterY - EYE_RADIUS;
		double rightX = rightCenterX - EYE_RADIUS;
		
		// Declare, style, and add eyes.
		GOval leftEye = new GOval(leftX, eyeY, 2 * EYE_RADIUS, 2 * EYE_RADIUS);
		leftEye.setColor(Color.YELLOW);
		leftEye.setFilled(true);
		add(leftEye);
		
		GOval rightEye = new GOval(rightX, eyeY, 2 * EYE_RADIUS, 2 * EYE_RADIUS);
		rightEye.setColor(Color.YELLOW);
		rightEye.setFilled(true);
		add(rightEye);
	}
	
	private void createMouth() {
		
		// Mouth center coordinates.
		double centerX = ((getWidth() - HEAD_WIDTH) / 2) + (HEAD_WIDTH / 2);
		double centerY = ((getHeight() / 2) + (HEAD_HEIGHT / 4));
		
		// Upper left coordinates for mouth.
		double x = centerX - (MOUTH_WIDTH / 2);
		double y = centerY - (MOUTH_HEIGHT / 2);
		
		// Declare, style, and print mouth.
		GRect mouth = new GRect(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setColor(Color.WHITE);
		mouth.setFilled(true);
		add(mouth);
		
	}
}