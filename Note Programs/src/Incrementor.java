import acm.graphics.GLine;


public class Incrementor {

	public Incrementor(int startValue) {
		counter = startValue;
	}
	
	public Incrementor() {
		counter = 1;
	}
	
	public int nextValue() {
		int temp = counter;
		counter++;
		return temp;
	}
	
	// Private instance variable.
	private int counter;
}
