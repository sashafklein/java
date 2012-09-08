import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class RegularPolygon extends GraphicsProgram {

	public void run() {
		
		double length = getHeight()/5;
		
		for (int sides = 20; sides > 2; sides--) {
			
			double x = rgen.nextDouble(length, getWidth() - 1.5* length);
			double y = rgen.nextDouble(length, getHeight() - 1.5* length);
			
			add(createPolygon(rgen.nextInt(3, 10), length), x, y);
			length *= .9;
		}
		
	}

	private GPolygon createPolygon (int sides, double length) {
		GPolygon polygon = new GPolygon();
		
		double angle = 360/sides;
		double theta = angle;
		
		polygon.addVertex(-length, 0);
		
		for (int i = 0; i < sides; i++) {
			polygon.addPolarEdge(length, theta);
			theta -= angle;
		}
		
		polygon.setFillColor(rgen.nextColor());
		polygon.setFilled(true);
		return polygon;
		
	}
	
	RandomGenerator rgen = RandomGenerator.getInstance();
	
}
