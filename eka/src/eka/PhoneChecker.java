package eka;

import java.util.Scanner;

public class PhoneChecker {// That class is using for checking correctness of the inputted numbers
	public Scanner sc = new Scanner(System.in);

	public String checkPhone() {
		System.out.println("Enter the phone number (6-13 characters)");
		while (true) {
			String phone = sc.next();
			if (phone.length() > 13) {
				System.out.println("Too big to be a number!");
				continue;
			}
			if (phone.length() < 6) {
				System.out.println("Too small to be a number!");
				continue;
			}
			return phone;
		}
	}
}
