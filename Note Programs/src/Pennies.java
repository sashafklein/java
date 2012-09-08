import acm.program.*;

/** Pennies calculates how much money is made over a specified period of time
 * by doubling the number of pennies given each day. That money is formatted
 * as dollars and cents, with commas separating each three digits.
 * @author sashafklein
 *
 */
public class Pennies extends ConsoleProgram {

	public void run() {
		
		int days = readInt("Over how many days are you given pennies?");
		int pennies = 1;
		
		// Counts how many pennies the user would make over the time period.
		for (int i = 0; i < days; i++) {
			pennies *= 2;
		}
		
		String doubleString = Double.toString((double)pennies);
		println(doubleString);
		
		
		String pennyString = "";
		
		// Truncate doubleString, removing the decimal and zero.
		// It is now pennyString.
		for (int i = 0; i < doubleString.length() - 2; i++) {
			pennyString = pennyString + doubleString.charAt(i);
		}
		
		println(pennyString);
		
		String withCommas = "";
		int j = 0;
		int length = pennyString.length();
		
		// Add commas to pennyString, making a new string withCommas.
		for (int i = 1; i < length + 1; i += 0) {
			
			// Copies three characters of pennyString.
			for (j = 0; j < 3; j++){
				
				// Makes sure there's a character there first.
				// If there is, both 'i' and the string are not updated.
				if (i < length + 1) {
					withCommas = pennyString.charAt(length - i) + withCommas;
					i++;
				}
				println("ok");
			}
			
			// If it isn't the last character, add a comma before it.
			// This happens every three characters.
			if (length - i >= 0) {
				withCommas = ',' + withCommas;
			}
		}
		
		println(withCommas);
			
	}
			
	
}
