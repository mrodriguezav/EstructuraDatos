package co.edu.unbosque.controller;

import co.edu.unbosque.view.ViewFacade;

public class Controller {

	private ViewFacade vf;

	public Controller() {
		vf = new ViewFacade();
		run();
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
		ciclarProblem10093(false);
	}

	public void ciclarProblem10093(boolean continuar) {

		continuar = true;
		String in = vf.getCon().readLine();
		if (in.equals("") || in == null) {
			continuar = false;
		}

		if (!continuar) {
			return;
		}

		ciclarComplemento10093(0, in);

		ciclarProblem10093(continuar);
	}

	public void ciclarComplemento10093(int i, String txt) {

		int max = 0, sum = 0, n = 0;
		char c = txt.charAt(i);

		if (c >= '0' && c <= '9') {
			n = c - '0';
		} else if (c >= 'A' && c <= 'Z') {
			n = c - 'A' + 10;
		} else if (c >= 'a' && c <= 'z') {
			n = c - 'a' + 36;
		} else {
			ciclarComplemento10093(i + 1, txt);
		}

		if (n > max)
			max = n;
		sum += n;
		if (sum == 0) {
			System.out.println("2");
			ciclarComplemento10093(i + 1, txt);
		}

		ciclarComplemento210093(0, max, sum);

	}

	public void ciclarComplemento210093(int j, int max, int sum) {
		boolean found = false;

		int base = max + 1;
		if (base >= 62) {
			return;
		}
		if (sum % (base - 1) == 0) {
			System.out.println(base);
			found = true;
			if (!found) {
				System.out.println("such number is impossible!");
			}
			return;
		}

	}

//	public void solutionM() {
//		String[] inputs = { "3", "5", "A" }; 
//
//		for (String number : inputs) {
//			System.out.println(findSmallestBase(number));
//		}
//	}
//
//	public static String findSmallestBase(String number) {
//		String symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//		int maxDigitValue = 2;
//
//		for (char c : number.toCharArray()) {
//			int digitValue = symbols.indexOf(c);
//			if (digitValue > maxDigitValue) {
//				maxDigitValue = digitValue;
//			}
//		}
//
//		int minBase = maxDigitValue + 1 + 1;
//
//		for (int base = minBase; base <= 62; base++) {
//			long value = Long.parseLong(number, base);
//			if (value % (base - 1) == 0) {
//				return String.valueOf(base);
//			}
//		}
//
//		return "such number is impossible!";
//	}

	public void solve10579() {

	}

	public void solve11068() {

	}

	public void solve12696() {

	}

}
