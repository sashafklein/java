import acm.program.*;

public class RemoveCharacter extends ConsoleProgram {
	
	public void run () {
		println("This program removes all occurences of a given character in a given string.");
		str = readLine("Enter the string you want searched: ");
		ch = readLine("Enter the character you want to remove: ").charAt(0);
		println("The new string is: " + removeAllOccurrences(str, ch));
		
	}
	
	// Removes all instances of the given character from the given string. Returns new string
	public String removeAllOccurrences(String input, char toRemove) {
		
		String newStr = "";
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != toRemove) {
				newStr = newStr + input.charAt(i);
			} 
		}
		
		return newStr;
	}
	
	// Private instance variables.
	String str;
	char ch;
}
