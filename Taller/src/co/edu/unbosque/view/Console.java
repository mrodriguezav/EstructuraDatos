package co.edu.unbosque.view;

import java.util.Scanner;

public class Console {

	private Scanner sc;

	public Console() {
		sc = new Scanner(System.in);
	}

	public int readInt() {
		return sc.nextInt();
	}

	public long readLong() {
		return sc.nextLong();
	}

	public String readLine() {
		return sc.nextLine();
	}

	public void printLine(String txt) {
		System.out.println(txt);
	}

	public void print(String txt) {
		System.out.print(txt);
	}

	public void burnLine() {
		sc.nextLine();
	}

}
