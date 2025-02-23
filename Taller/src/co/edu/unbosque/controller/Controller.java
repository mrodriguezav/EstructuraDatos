package co.edu.unbosque.controller;
import java.util.Scanner;
import co.edu.unbosque.view.ViewFacade;

public class Controller {

	private ViewFacade vf;

	public Controller() {
		vf = new ViewFacade();
	}

	public void run() {

		mainloop: while (true) {

			String menu = """

					1. 623
					2. 10093
					3. 10579
					4. 11068
					5. 12696

					6. Close

					""";
			System.out.println(menu);
			int op = vf.getCon().readInt();
			vf.getCon().burnLine();

			switch (op) {
			case 1:
				solve623();
				break;

			case 2:
				solve10093();
				break;

			case 3:
				solve10579();
				break;

			case 4:
				solve11068();
				break;

			case 5:
				solve12696();
				break;

			case 6:
				vf.getCon().printLine("BYE BYE");
				break mainloop;

			default:
				vf.getCon().printLine("Invalid option");
				break;
			}
		}
	}

	public void solve623() {

	}

	public void solve10093() {
		
		        String[] inputs = {"3", "5", "A"}; // Sample inputs

		        for (String number : inputs) {
		        	findSmallestBase(number);
		            System.out.println();
		        }
		    
		}

	public static String findSmallestBase(String number) {
        String symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int maxDigitValue = 2;

        // Find the maximum digit value in the number
        for (char c : number.toCharArray()) {
            int digitValue = symbols.indexOf(c);
            if (digitValue > maxDigitValue) {
                maxDigitValue = digitValue;
            }
        }

        // Minimum base must be greater than the highest digit
        int minBase = maxDigitValue + 1 + 1;

        // Check for each base from minBase to 62
        for (int base = minBase; base <= 62; base++) {
            try {
                long value = Long.parseLong(number, base);
                if (value % (base - 1) == 0) {
                    return String.valueOf(base);
                }
            } catch (NumberFormatException e) {
                // Ignore invalid base conversions
            }
        }

        return "such number is impossible!";
    }	
		
	

	public void solve10579() {

	}

	public void solve11068() {

	}

	public void solve12696() {

	}

}
