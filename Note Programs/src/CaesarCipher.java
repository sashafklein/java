import acm.program.*;

public class CaesarCipher extends ConsoleProgram {

		public void run() {
			println("This program uses a Caesar cipher for encryption.");
			int key = readInt("Enter encryption key: ");
			String plaintext = readLine("Plaintext: ");
			String ciphertext = encryptCaesar(plaintext, key);
			println("Ciphertext: " + ciphertext);
		}
	
		private String encryptCaesar(String orig, int key) {
			String result = "";
			for (int i = 0; i < orig.length(); i++) {
				char ch = orig.charAt(i);
				result = result += encryptChar(ch, key);
			}
			return result;
		}
		
		private char encryptChar(char letter, int key) {
			if (Character.isUpperCase(letter)) {
				return (char)('A' + (letter - 'A' + key) % 26);
			}
			return letter;
		}
}
