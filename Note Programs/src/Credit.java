import acm.program.*;

public class Credit extends ConsoleProgram {

	public void run() {
	
		input = readLine("Enter a credit card number.");
		length = input.length();
		
		// Make sure that the number entered is 16-digits (and all numbers).
		if (checkType()) {
		
			// Return the sum of every other digit's individual sum after multiplication by two.
			alternates = sumAlternates(input);
			
			// Return the sum of every other digit (than the digits above).
			others = sumOthers();
			
			// Adds the two above to reach a final sum.
			int total = alternates + others;
			
			// Checks the final sum for validity to credit card algorithm.
			if (checkValidity(total)) {
				println("That is a valid credit card number!");
			} else {
				println("That credit card number is invalid!");
			}
		} else { // If the user did not enter a 16-digit number.
			println("The string you entered was not all digits.");
		}
		
	}
	
	// Returns true if the user-entered a 16-digit number.
	private boolean checkType() {
		
		// Checks for length. If not 16, returns false.
		if (length < 16 && length > 14) {
			
			// Returns false if any of the chars is not a number.
			for (int i = 0; i < length; i++) {
				if (input.charAt(i) < '0' || input.charAt(i) > '9') {
					return false;
				}
			}
			return true; // Only returns true if both conditions satisfied.
		} else return false;
	}
	
	// Returns the sum of the digits of the products by 2 of every other digit in the input.
	private int sumAlternates(String str) {
		int sum = 0;
		
		// Iterates backwards by two from the second to last digit.
		for (int i = 0; i < length; i+=2) {
			char ch = str.charAt((length - 2) - (i));
			int mult = Character.getNumericValue(ch);
			sum += multAndSum(mult);
			println("sum:" + sum);
		}
		return sum;
	}
	
	// When fed a number (a digit from sumAlternates), multiplies it by two and returns 
	// those digits' sum.
	private int multAndSum(int digit) {
		int multiple = (digit * 2);
		println("multiple: " + multiple);
		int sum;
		
		// If the multiple is two-digit, add its digits.
		if (multiple > 9) {
			sum = (multiple % 10) + (multiple / 10);
		} else sum = multiple;
		return sum;
	}
	
	// Adds up all the other digits in the number, iterating back by two from the 
	// last digit.
	private int sumOthers() {
		int sum = 0;
		for (int i = 0; i < length; i += 2) {
			sum += input.charAt((length - 1) - (i));
		}
		return sum;
	}
	
	// Checks to see if the result fits with the validity algorithm.
	private boolean checkValidity(int number) {
		if (number % 10 == 0) {
			return true;
		} else return false;
	}
	
	// Private instance variables.
	private int length;
	private int others;
	private int alternates;
	private String input;
}
