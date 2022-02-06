package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExample {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "ROOT");

		Statement stm = con.createStatement();

		stm.executeUpdate("insert into eproduct (name, price, date_added) values ('Tablet', 1500, now())");

		ResultSet result = stm.executeQuery("Select * from eproduct");
		while (result.next()) {

			System.out.println(result.getInt("ID") + " " + result.getString("name") + " " + result.getString("Price"));
		}
	}
}
