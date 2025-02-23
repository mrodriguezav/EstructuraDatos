package co.edu.unbosque.controller;

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

	}

	public void solve10579() {

	}

	public void solve11068() {

	}

	public void solve12696() {

	}

}
