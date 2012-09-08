import acm.program.*;

/** */
public class Student {

	// Keeps track of info to be stored as instance variables.
	public Student (String name, int id) {
		studentName = name;
		studentID = id;
	}
	
	public String getName() {
		return studentName;
	}
	
	public int getID() {
		return studentID;
	}
	
	/** 
	 * Sets the number of units earned.
	 * @param units The new number of units earned.
	 */
	public void setUnits(double units) {
		unitsEarned = units;
	}
	
	/** 
	 * Gets the name of this student.
	 * @return The number of units this student has earned.
	 */
	public double getUnits() {
		return unitsEarned;
	}
	
	/**
	 * Increments the number of units earned.
	 * @param additionalUnits The additional number of units earned.
	 */
	public void incrementUnits(double additionalUnits) {
		unitsEarned += additionalUnits;
	}
	
	/** Gets the number of units earned
	 * @return Whether the student has enough units to graduate.
	 */
	public boolean hasEnoughUnits() {
		return (unitsEarned >= UNITS_TO_GRADUATE);
	}
	
	/** */
	public String toString() {
		return studentName + " (" + studentID + ").";
	}

// PUBLIC CONSTANTS	
// The number of units required to graduate
private static final double UNITS_TO_GRADUATE = 180;
	
// Private instance variables
private String studentName;
private int studentID;
private double unitsEarned;

}
