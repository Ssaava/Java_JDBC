package JDBC;
import java.sql.*;

public class DataBaseConnection {
	private final String url = "jdbc:mysql://localhost/My_Bank";
	private final String user = "root";
	private final String password = "";
	DataBaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("Class not found");
		}
	}
	public Connection connect() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
}
