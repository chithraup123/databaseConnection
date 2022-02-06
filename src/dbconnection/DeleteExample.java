package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteExample {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");

		Statement stmnt = connection.createStatement();
		ResultSet result = stmnt.executeQuery("select * from eproduct");

		System.out.println("******Before Delete*********");
		while (result.next()) {
			System.out.println(result.getInt("ID") + " " + result.getString("name") + " " + result.getInt("price"));
		}

		System.out.println("******After Delete*********");
		//execteupdate for delete
		stmnt.executeUpdate("delete from eproduct where name='Tablet'");
		result = stmnt.executeQuery("select * from eproduct");
		while (result.next()) {
			System.out.println(result.getInt("ID") + " " + result.getString("name") + " " + result.getInt("price"));
		}
	}

}
