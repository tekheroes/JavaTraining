import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class ConnectionDemo {

	public static void main(String[] args) {
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			DriverManager.registerDriver(new OracleDriver());
			Connection conn = DriverManager.getConnection(url, "zubair", "oracle");
			System.out.println("Connected successfully!");
			
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println("DB Name: " + meta.getDatabaseProductName());
			System.out.println("DB Ver: " + meta.getDatabaseProductVersion());
			System.out.println("Driver Name: " + meta.getDriverName());
			System.out.println("Driver Ver: " + meta.getDriverVersion());
		} catch (SQLException e) {
			System.out.println("Connection failed due to...");
			e.printStackTrace();
		}
	}
}
