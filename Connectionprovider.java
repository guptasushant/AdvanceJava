package Advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionprovider {
private static Connection conn;
public static Connection getConnection() {
	if(conn==null) {
		String url="jdbc:mysql://localhost:3306/sushant";
		String Username="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,Username,password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return conn;
}
	
}
