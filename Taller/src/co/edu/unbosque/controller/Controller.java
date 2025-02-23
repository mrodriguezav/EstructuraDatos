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

		int num = vf.getCon().readInt();

	}

	public void solve10093() {

		while (vf.getCon().checkCase()) {
			String in = vf.getCon().readLine();
			int max = 0, sum = 0, n = 0;

			for (int i = 0; i < in.length(); i++) {
				char c = in.charAt(i);

				if (c >= '0' && c <= '9') {
					n = c - '0';
				} else if (c >= 'A' && c <= 'Z') {
					n = c - 'A' + 10;
				} else if (c >= 'a' && c <= 'z') {
					n = c - 'a' + 36;
				} else {
					continue;
				}

				if (n > max)
					max = n;
				sum += n;
				if (sum == 0) {
					System.out.println("2");
					continue;
				}

				boolean found = false;
				for (int base = max + 1; base <= 62; base++) {
					if (sum % (base - 1) == 0) {
						System.out.println(base);
						found = true;
						break;
					}
				}

				if (!found) {
					System.out.println("such number is impossible!");
				}

			}

		}

	}

	public void solve10579() {

	}

	public void solve11068() {

	}

	public void solve12696() {

	}

}
