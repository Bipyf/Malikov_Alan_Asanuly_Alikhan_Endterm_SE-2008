package eka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class connect {
	// that was a prototype how we made a connection
	/*
	 * public static void main(String args[]) { Connection co = null; try { co =
	 * DriverManager.getConnection("jdbc:postgresql://localhost:5432/jvpr",
	 * "postgres", "qwerty123");
	 * Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance()
	 * ; if (co!=null) { System.out.println("ok"); }
	 * 
	 * else { System.out.println("no"); } ResultSet rs; Statement
	 * st=co.createStatement(); rs = st.executeQuery("SELECT toy_name FROM toys");
	 * rs.next(); String alan = rs.getString("toy_name"); System.out.println(alan);
	 * } catch (Exception e) { System.out.println(e); } }
	 */
	public void toysselect(String sql) {
		try {
			Connection co = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jvpr", "postgres",
					"qwerty123");// connection with sql language
			Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();// it is using for accessing
																							// to the sql
			ResultSet rs;// it is field for data entries from sql
			Statement st = co.createStatement();// it is field for organizing queries
			rs = st.executeQuery(sql);// result of Query
			int id = 0, price = 0, amount = 0;
			String type = "", name = "";

			while (rs.next()) {// it is using for executing all rows one by one
				id = rs.getInt("toy_id");
				name = rs.getString("toy_name");
				price = rs.getInt("toy_price");
				amount = rs.getInt("toy_amount");
				type = rs.getString("toy_type");
				System.out.println("ID:" + id + " Toy name: " + name + " Price: " + price + "tg The amount: " + amount
						+ " The type:" + type);
			}

		} catch (Exception e) {// printing reasons of error
			System.out.println(e);
		}
	}

	public void costumeselect(String sql) {// Same with toys
		try {
			Connection co = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jvpr", "postgres",
					"qwerty123");// connection with sql language
			Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();// it is using for accessing
																							// to the sql
			ResultSet rs;
			Statement st = co.createStatement();
			rs = st.executeQuery(sql);
			int id = 0, price = 0, amount = 0;
			String name = "";

			while (rs.next()) {
				id = rs.getInt("costume_id");
				name = rs.getString("costume_name");
				price = rs.getInt("costume_price");
				amount = rs.getInt("costume_amount");
				System.out.println(
						"ID:" + id + " Costume name: " + name + " Price: " + price + "tg The amount: " + amount);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	public int idinc() {
//		int res = 0;
//		try {
//			Connection co = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jvpr", "postgres",
//					"qwerty123");// connection with sql language
//			Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();// it is using for accessing
//																							// to the sql
//			String sql = "SELECT * FROM client;";
//			Statement st = co.createStatement();
//			ResultSet rs;
//			rs = st.executeQuery(sql);
//			int id = 0;
//			while (rs.next()) {
//				id = rs.getInt("client_id");
//			}
//
//			res = id++;
//			return res;
//		} catch (Exception e) {
//			System.out.println();
//		}
//		return res;
//	}

	public int tfindprice(int id) {// method finding price for sum
		int price = 0;
		try {// it is a piece of code which can give a error in execution part
			Connection co = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jvpr", "postgres",
					"qwerty123");// connection with sql language
			Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();// it is using for accessing
																							// to the sql
			String sql = "Select toy_price From toys where toy_id = " + id;
			Statement st = co.createStatement();
			ResultSet rs;
			rs = st.executeQuery(sql);
			rs.next();
			price = rs.getInt(1);// getting number from row
			return price;
		} catch (Exception e) {
			System.out.println();
		}
		return price;
	}

	public int cfindprice(int id) {// same with toys
		int price = 0;
		try {
			Connection co = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jvpr", "postgres",
					"qwerty123");// connection with sql language
			Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();// it is using for accessing
																							// to the sql
			String sql = "Select costume_price From costume where costume_id = " + id;
			Statement st = co.createStatement();
			ResultSet rs;
			rs = st.executeQuery(sql);
			rs.next();
			price = rs.getInt(1);
			return price;
		} catch (Exception e) {
			System.out.println();
		}
		return price;
	}

	public void tclientinsert(String name, String phone, int toy_id, int toy_amount) {// this method is for insertin
																						// clients info into database

		try {
			Connection co = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jvpr", "postgres",
					"qwerty123");// connection with sql language
			Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();// it is using for accessing
																							// to the sql
			String sql = "INSERT INTO client(client_id, client_phone, client_fname, toy_id, product_amount, client_sum) VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement st = co.prepareStatement(sql);
			st.setString(2, phone);
			st.setString(3, name);
			st.setInt(4, toy_id);
			Random r = new Random();
			int upper = 999;
			int client_id = r.nextInt(upper);
			st.setInt(1, client_id);
			st.setInt(5, toy_amount);
			tamountreduce(toy_amount, toy_id);
			int price = tfindprice(toy_id);
			int client_sum = price * toy_amount;
			st.setInt(6, client_sum);
			int rows = st.executeUpdate();
			System.out.println("Your order was taken.");
			System.out.println("Your sum is:" + client_sum + " tenge." + "You ordered " + toy_amount + " of toys.");
			Main m = new Main();
			m.main(null);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void cclientinsert(String name, String phone, int costume_id, int costume_amount) {// same with toys

		try {
			Connection co = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jvpr", "postgres",
					"qwerty123");// connection with sql language
			Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();// it is using for accessing
																							// to the sql
			String sql = "INSERT INTO client(client_id, client_phone, client_fname, costume_id, product_amount, client_sum) VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement st = co.prepareStatement(sql);
			st.setString(2, phone);
			st.setString(3, name);
			st.setInt(4, costume_id);
			Random r = new Random();
			int upper = 999;
			int client_id = r.nextInt(upper);
			st.setInt(1, client_id);
			st.setInt(5, costume_amount);
			camountreduce(costume_amount, costume_id);
			int price = cfindprice(costume_id);
			int client_sum = price * costume_amount;
			st.setInt(6, client_sum);
			int rows = st.executeUpdate();
			System.out.println(rows + " were affected.");
			System.out.println(
					"Your sum is:" + client_sum + " tenge." + "You ordered " + costume_amount + " of costumes.");
			Main m = new Main();
			m.main(null);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void tamountreduce(int amount, int id) {// it is updating amount value for toys
		try {
			Connection co = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jvpr", "postgres",
					"qwerty123");// connection with sql language
			Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();// it is using for accessing
																							// to the sql
			String sql = "UPDATE toys set toy_amount = toy_amount - " + amount + "Where toy_id = " + id;
			String sql2 = "Select toy_amount from toys where toy_id = " + id;
			ResultSet rs;
			PreparedStatement st = co.prepareStatement(sql);
			Statement st2 = co.createStatement();
			rs = st2.executeQuery(sql2);
			rs.next();
			int sql_amount = rs.getInt(1);
			if (amount <= 0) {
				System.out.println("You can't order negatively or 0 amount of toys!");
				Main m = new Main();
				m.main(null);
			}
			if (sql_amount < amount) {
				System.out.println("You can't order more than we have!");
				Main m = new Main();
				m.main(null);
			}
			if (sql_amount > 0) {
				st.executeQuery();
			} else {
				System.out.println("There is no such toys left! Sorry!");
				Main m = new Main();
				m.main(null);
			}
		} catch (Exception e) {
		}
	}

	public void camountreduce(int amount, int id) {// same with toys
		try {
			Connection co = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jvpr", "postgres",
					"qwerty123");// connection with sql language
			Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();// it is using for accessing
																							// to the sql
			String sql = "UPDATE costume set costume_amount = costume_amount - " + amount + "Where costume_id = " + id;
			String sql2 = "Select costume_amount from costume where costume_id = " + id;
			ResultSet rs;
			PreparedStatement st = co.prepareStatement(sql);
			Statement st2 = co.createStatement();
			rs = st2.executeQuery(sql2);
			rs.next();
			int sql_amount = rs.getInt(1);
			if (amount <= 0) {
				System.out.println("You can't order negatively or 0 amount of costumes!");
				Main m = new Main();
				m.main(null);
			}
			if (sql_amount < amount) {
				System.out.println("You can't order more than we have!");
				Main m = new Main();
				m.main(null);
			}
			if (sql_amount > 0) {
				st.executeQuery();
			} else {
				System.out.println("There is no such costumes left! Sorry!");
				Main m = new Main();
				m.main(null);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
