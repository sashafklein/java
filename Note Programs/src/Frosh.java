import acm.program.*;

public class Frosh extends Student {

	public Frosh(String name, int id) {
		super(name, id); // Calls Student constructor.
		setUnits(0);
	}
	
	// Override toString method of Student.
	public String toString() {
		// student ID and studentName are private,
		// so they are not directly accessible, even
		// in subclass! We must use public "getters."
		return ("Frosh: " + getName() + " (#" + getID() + ")");
	}

}
