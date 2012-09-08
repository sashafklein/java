import acm.program.*;

/** This program calculates how to most efficiently break 
 * a given amount of money into change.
 * @author sashafklein
 *
 */

public class ChangeCounter extends ConsoleProgram {

	public void run() {
		println("This program calculates change.");
		println("");
		println("Please input an amount of money (including cents).");
		origAmount = readDouble();
		
		convertUp();
		numBills();
		numCoins();
		answer();
	}
	
	private void numBills() {

		numHundreds();
		numFifties();
		numTwenties();
		numTens();
		numFives();
		numOnes();
	}
	
	private void numCoins() {
		numQuarters();
		numDimes();
		numNickles();
		numPennies();
	}
	
	private void convertUp() {
		
		double temp = origAmount * 100;
		calcAmount = (int)temp;
	}
	
	private void numHundreds() {
		if (calcAmount > 10000) {
			hundreds = calcAmount/10000;
			calcAmount = calcAmount - 10000 * hundreds;
		}
	}
	
	private void numFifties() {
		if (calcAmount > 5000) {
			fifties = calcAmount/5000;
			calcAmount = calcAmount - 5000 * fifties;
		}
	}
	
	private void numTwenties() {
		if (calcAmount > 2000) {
			twenties = calcAmount/2000;
			calcAmount = calcAmount - 2000 * twenties;
		}
	}
	
	private void numTens() {
		if (calcAmount > 1000) {
			tens = calcAmount/1000;
			calcAmount = calcAmount - 1000 * tens;
		}
	}
	
	private void numFives() {
		if (calcAmount > 500) {
			fives = calcAmount/500;
			calcAmount = calcAmount - 500 * fives;
		}
	}
	
	private void numOnes() {
		if (calcAmount > 100) {
			ones = calcAmount/100;
			calcAmount = calcAmount - ones * 100;
		}
	}
	
	private void numQuarters() {
		if (calcAmount > 25) {
			quarters = (calcAmount/25);
			calcAmount = calcAmount - (25 * quarters);		
			}
	}
	
	private void numDimes() {
		if (calcAmount > 10) {
			dimes = (calcAmount/10);
			calcAmount = calcAmount - 10 * dimes;
		}
	}
	
	private void numNickles() {
		if (calcAmount > 0.05) {
			nickles = (calcAmount/5);
			calcAmount = calcAmount - 5 * nickles;	
		}
	}
	
	private void numPennies() {
		if (calcAmount > 1) {
			pennies = (calcAmount);
			calcAmount = calcAmount - pennies;
		}
	}
	
	private void answer() {
	
		println("");
		println("The most efficient change for $" + origAmount + " is: "); 
				println(hundreds + " hundreds, ");
				println(fifties + " fifties, ");
				println(twenties + " twenties, ");
				println(tens + " tens, ");
				println(fives + " fives, ");
				println(ones + " ones");
				println(quarters + " quarters, ");
				println(dimes + " dimes, ");
				println(nickles + " nickles");
				println("AND...");
				println(pennies + " pennies.");
	}	
	
	
/** Change types (instance variables). */
	// Declares change types.
	double origAmount;
	int calcAmount;
	private int hundreds = 0;
	private int fifties = 0;
	private int twenties = 0;
	private int tens = 0;
	private int fives = 0;
	private int ones = 0;
	private int quarters = 0;
	private int dimes = 0;
	private int nickles = 0;
	private int pennies = 0;
	
	
	
}

