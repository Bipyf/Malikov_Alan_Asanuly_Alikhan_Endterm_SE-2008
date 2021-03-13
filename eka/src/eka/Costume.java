package eka;

import java.util.Scanner;

public class Costume implements Product {//
	protected connect co = new connect();// object of connect class that execute all things about connection with sql
	protected Scanner sc = new Scanner(System.in);
	protected int lim = 0;
	protected int client_id = 0;

	@Override
	public void show() {// this method for showing all table rows and columns
		if (lim >= 10) {
			lim = 0;
		} // it is using for showing table by 5 rows
		lim += 5;
		String sql = "SELECT* FROM costume ORDER BY costume_id ASC LIMIT " + 5 + " OFFSET " + (lim - 5);
		co.costumeselect(sql);
		aftershow();
	}

	@Override
	public void aftershow() {// it will execute if client push a 1 button

		while (true) {
			System.out.println("1. Buy by id");
			System.out.println("2. Show next 5 items");
			System.out.println("3.Back");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Insert id:");// Client choose a product which actually they want
				int id = sc.nextInt();
				client_id++;
				buy(id);
				break;
			case 2:// show next page of table
				show();
				break;
			case 3:
				Main main = new Main();// calling main and it works like a back button
				main.main(null);
				break;
			default:
				System.out.println("Choose between 1 and 3");
			}
		}
	}

	@Override
	public void buy(int id) {
		System.out.println("Insert your name:");
		String name = sc.next();
		System.out.println("Insert your phone:");
		String phone = sc.next();
		System.out.println("Insert your amount:");
		int amount = sc.nextInt();
		co.cclientinsert(name, phone, id, amount);// adding all information to the sql table
	}
}
