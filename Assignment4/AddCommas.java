import acm.program.*;


public class AddCommas extends ConsoleProgram {
	
	public void run() {
		while (true) {
		String digits = readLine("Enter a numeric string: ");
		if (digits.length() == 0) break;
		println(addCommasToNumericString(digits));
		}
	}

	private String addCommasToNumericString(String number) {
		
		wCommas = "";
			
		if (number.length() < 4) {
			return number;
		}
		
		int i = number.length() - 1;
		
		while (i > -1) {
			for (int a = 0; a < 3; a++) {
				if (i > -1) {
					wCommas = number.charAt(i) + wCommas;
					i--;
				}
			}
			
			if (i > -1) {
				wCommas = ',' + wCommas;
			}
		
		}
		return wCommas;
		
	}
	
	String wCommas;
}
