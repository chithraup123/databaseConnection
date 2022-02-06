package dbconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
		Statement stmnt = con.createStatement();
		ResultSet result = stmnt.executeQuery("select * from eproduct");
		while (result.next()) {
			System.out.println(result.getInt("ID") + " " + result.getString("name"));
		}

		// insert query
		System.out.println("******After Inertion*********");
		stmnt.executeUpdate("INSERT INTO eproduct(name, price, date_added) values('Tablet', 7800.00, now())");
		result = stmnt.executeQuery("select * from eproduct");
		while (result.next()) {
			System.out.println(result.getInt("ID") + " " + result.getString("name"));
		}

		// update query
		System.out.println("******After Update*********");
		stmnt.executeUpdate("update eproduct set price=5000.00 where ID=4");
		result = stmnt.executeQuery("select * from eproduct");
		while (result.next()) {
			System.out.println(result.getInt("ID") + " " + result.getString("name")+ " "+ result.getInt("price"));
		}
		con.close();
		
		// delete query
		System.out.println("******After Delete*********");
	}
}
