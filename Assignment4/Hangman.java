/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}
	
    public void run() {
		
    	println("Welcome to Hangman!");
    	println("");
    	canvas.scaffolding();
    	
    	word = pickWord();
		current = displayBlanks();
		
		// While the player has neither won nor loss, game continues.
    	while (gameWon() == 3) {   		
    		
    		// Prints out information for user. Then asks for new guess.
    		printStuff();
			getInput();
    		println("");
    		
    		// Hits (correct guesses) reset before every round.
    		hits = 0;
    		
    		// Compares the guess character to each character of the secret word, updating the current word as necessary.
    		for (int i = 0; i < word.length(); i++) {
    			if (word.charAt(i) == guess ){
    				hits++;
    				current = current.substring(0,i) + guess + current.substring(i+1);
    			}
    		}
    		
    		// If the guess didn't hit anything, the player loses a guess.
    		if (hits == 0) {
    			println("There are no " + guess + "\'s in the word.");
    			guesses--;
    			canvas.noteIncorrectGuess(guess);
    		} else println("That guess is correct."); // If the player got hit(s), she is given a single notification.
    	
    	}
    	
    	if (gameWon() == 2) {
    		println("You're completely hung. The word was \"" + word + ".\"");
    	} else { 
    		canvas.displayWord(current);
    		println("Congrats. You guessed the word \"" + word + ".\"  You win!");
    	}
    }
    
    // Picks a random word from the Hangman Lexicon.
    private String pickWord() {
    	
    	int lexLength = lexiconLength();
    	
    	HangmanLexicon wordList = new HangmanLexicon();
    	
    	// Asks for a word randomly chosen based on the length of the lexical list.
    	return wordList.getWord(rgen.nextInt(0, lexLength));
    }
    
    // Determines the length of the lexicon.
    private int lexiconLength() {
    	HangmanLexicon words = new HangmanLexicon();
    	return (words.getWordCount());
    }
    
    // Returns integers signifying various states of gameplay. 
    private int gameWon() {
    	
    	// If the current word equals the original word, the player has won.
    	if (word.equals(current)) {
    		return 1;
    	} 
    	
    	// If out of guesses, the player has lost.
    	if (guesses == 0) {
    		return 2;
    	} 
    	
    	// Otherwise, the game continues.
    	else {
    	return 3;
    	}
    }
    
    // Prints a string of blanks as long as the word.
    private String displayBlanks() {
    	
    	String blanks = "";
    	for (int i = 0; i < word.length(); i++) {
    		blanks += "-";
    	}
    	return blanks;
    			
    }
    
    // Makes sure that the user inputs a single character. If so, updates that character as the "guess".
    private void getInput() {
		input = readLine("Your guess: ");
		if (input.length() == 1) {
			if (Character.isLetter(input.charAt(0))) {
				guess = Character.toUpperCase(input.charAt(0));
			} else tryAgain(); 
			
		} else tryAgain();
    }
    
    // Prompts the user for correct input if incorrect.
    private void tryAgain() {
    	println ("Please input a single letter.");
		getInput();
    }
    
    // Prints the recurrent updates.
    private void printStuff() {
    	println("The word currently looks like this: " + current + ".");
		println("You have " + guesses + " guesses left.");
		canvas.displayWord(current);
    }
    
    public String getCurrent() {
    	return current;
    }
    
    public int getGuesses() {
    	return guesses;
    }
    
    // Private instance variables and initializations.
    private String word;
    private String input;
    private String current;
    private char guess;
    private int hits = 0;
    private int guesses = 8;
    
    private HangmanCanvas canvas;
    
    RandomGenerator rgen = RandomGenerator.getInstance(); 

}
