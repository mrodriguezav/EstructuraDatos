package co.edu.unbosque.controller;

import java.math.BigInteger;

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

	/*
	 * 
	 * 
	 * 
	 * PROBLEM 623
	 * 
	 * 
	 * 
	 */
	public void solve623() {

		String entrada = vf.getCon().readLine();
		if (entrada.equals("") || entrada == null) {
			return;
		}

		BigInteger num = new BigInteger(entrada);
		BigInteger n = new BigInteger("1");
		BigInteger incremento = new BigInteger("1");
		BigInteger conta = new BigInteger("1");
		BigInteger ans = ciclarProblem623(conta, num, n, incremento);

		System.out.println(entrada + '!');
		System.out.println(ans);
		solve623();
	}

	public BigInteger ciclarProblem623(BigInteger conta, BigInteger limite, BigInteger num, BigInteger incremento) {

		if (conta.compareTo(limite) >= 0) {
			return num;
		}

		conta = conta.add(incremento);
		num = num.multiply(conta);

		return ciclarProblem623(conta, limite, num, incremento);

	}

	/*
	 * 
	 * 
	 * PROBLEM 10093
	 * 
	 * 
	 */

	public void solve10093() {

		String in = vf.getCon().readLine();
		if (in == null || in.equals("")) {
			return;
		}

		int max = hallarMax(in, 0, 0);
		int sum = sumar(in, 0, 0);

		if (sum == 0) {
			System.out.println("2");
			solve10093();
			return;
		}

		if (!hallarBase(sum, max + 1)) {
			System.out.println("such number is impossible!");
		}

		solve10093();

	}

	public int hallarMax(String in, int index, int max) {
		if (index >= in.length()) {
			return max;
		}

		int n = charToNum(in.charAt(index));
		return hallarMax(in, index + 1, Math.max(max, n));
	}

	public int sumar(String in, int index, int sum) {
		if (index >= in.length()) {
			return sum;
		}

		int n = charToNum(in.charAt(index));
		return sumar(in, index + 1, sum + n);
	}

	public int charToNum(char c) {
		if (c >= '0' && c <= '9') {
			return c - '0';
		} else if (c >= 'A' && c <= 'Z') {
			return c - 'A' + 10;
		} else if (c >= 'a' && c <= 'z') {
			return c - 'a' + 36;
		}
		return 0;
	}

	private boolean hallarBase(int sum, int base) {
		if (base > 62) {
			return false;
		}

		if (sum % (base - 1) == 0) {
			System.out.println(base);
			return true;
		}

		return hallarBase(sum, base + 1);
	}

	/*
	 * 
	 * 
	 * PROBLEM 10579
	 * 
	 * 
	 * 
	 */

	public void solve10579() {

		String in = vf.getCon().readLine();

		if (in == null || in.isEmpty()) {
			return;
		}

		BigInteger num = new BigInteger(in);
		BigInteger suma = BigInteger.ZERO;
		BigInteger inicio = BigInteger.ZERO;
		BigInteger siguiente = BigInteger.ONE;
		BigInteger increment = BigInteger.ONE;
		BigInteger conta = BigInteger.ONE;
		System.out.println(ciclarProblem10579(conta, suma, num, increment, inicio, siguiente));

		solve10579();

	}

	public BigInteger ciclarProblem10579(BigInteger conta, BigInteger suma, BigInteger lim, BigInteger increment,
			BigInteger start, BigInteger next) {

		if (conta.compareTo(lim) >= 0) {
			return suma;
		}

		suma = start.add(next);
		start = next;
		next = suma;

		conta = conta.add(increment);
		return ciclarProblem10579(conta, suma, lim, increment, start, next);

	}

	/*
	 * 
	 * 
	 * PROBLEM 11068
	 * 
	 * 
	 * 
	 * 
	 */

	public void solve11068() {
		double a1, b1, c1, a2, b2, c2;
		a1 = vf.getCon().readInt();
		b1 = vf.getCon().readInt();
		c1 = vf.getCon().readInt();
		a2 = vf.getCon().readInt();
		b2 = vf.getCon().readInt();
		c2 = vf.getCon().readInt();

		if (a1 == 0 && b1 == 0 && c1 == 0 && a2 == 0 && b2 == 0 && c2 == 0) {
			return;
		}

		if (a1 * b2 == a2 * b1) {
			System.out.println("No fixed point exists.");
		} else {

			double x = ((b2 * c1) - (b1 * c2)) / ((a1 * b2) - (a2 * b1));
			double y = ((a2 * c1) - (a1 * c2)) / ((a2 * b1) - (a1 * b2));

			System.out.printf("The fixed point is at %.2f %.2f\n", x, y);
		}
		solve11068();
	}

	public void solve12696() {

		int caso = vf.getCon().readInt();
		int allowed = ciclarProblem12696(0, caso, 0);
		System.out.println(allowed);

	}

	public int ciclarProblem12696(int conta, int lim, int sum) {

		if (conta >= lim) {
			return sum;
		}

		double lenght, width, depth, weight;
		lenght = vf.getCon().readDouble();
		width = vf.getCon().readDouble();
		depth = vf.getCon().readDouble();
		weight = vf.getCon().readDouble();

		if (lenght > 56 && width > 45 && depth > 25 || weight > 7 || (lenght + width + depth) > 125) {
			System.out.println(0);
		} else {
			System.out.println(1);
			sum += 1;
		}

		return ciclarProblem12696(conta + 1, lim, sum);

	}

}
