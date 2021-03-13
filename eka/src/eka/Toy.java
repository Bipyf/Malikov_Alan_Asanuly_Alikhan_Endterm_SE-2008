package eka;

import java.util.Scanner;

public class Toy implements Product {
	protected connect co = new connect();// object for connect with sql
	protected Scanner sc = new Scanner(System.in);
	protected int lim = 0;
	public int client_id = 0;

	@Override
	public void show() {// this method for showing all table rows and columns
		if (lim >= 20) {
			lim = 0;
		} // it is using for showing table by 5 rows
		lim += 5;
		String sql = "SELECT* FROM toys ORDER BY toy_id ASC LIMIT " + 5 + " OFFSET " + (lim - 5);
		co.toysselect(sql);
		aftershow();
	}

	@Override
	public void aftershow() {// it will execute if client push a 1 button

		while (true) {
			System.out.println("1. Buy by id");
			System.out.println("2. Show next 5 items");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Insert id:");// Client choose a product which actually they want
				int id = sc.nextInt();
				client_id++;
				buy(id);
				break;
			case 2:
				show();// show next page of table
			case 3:
				Main main = new Main();
				main.main(null);// calling main and it works like a back button

			default:
				System.out.println("Choose between 1 and 3");
			}
		}
	}

	@Override
	public void buy(int id) {// adding all information to the sql table
		System.out.println("Insert your name:");
		String name = sc.next();
		System.out.println("Insert your phone");
		PhoneChecker phc = new PhoneChecker();
		String phone = phc.checkPhone();
		System.out.println("Insert your amount");
		int amount = sc.nextInt();
		co.tclientinsert(name, phone, id, amount);// method for adding to the sql
	}

}
