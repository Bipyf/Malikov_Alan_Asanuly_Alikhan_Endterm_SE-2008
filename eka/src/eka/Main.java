package eka;

import java.util.Scanner;

public class Main {
	protected static Scanner sc = new Scanner(System.in);// for inputting

	public static void main(String[] args) {
		System.out.println("Welcome to our Shop for kids!!!");
		while (true) {// infinite loop that shows interface of console
			System.out.println("1. Show toys");
			System.out.println("2. Show costume");
			System.out.println("3. Quit");
			int ch = sc.nextInt();
			Product t = new Toy();// Fabric Method which works for creating Toy object
			Product c = new Costume();// Fabric Method which works for creating Costume object
			switch (ch) {
			case 1:
				t.show();// Show toys
				break;
			case 2:
				c.show();// Show costume
				break;
			case 3:
				System.out.println("Bye!!!");// end of the code
				System.exit(0);
			default:
				System.out.println("Please choose between 1 and 3!");
			}

		}
	}

}
