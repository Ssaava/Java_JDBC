package com.jdbc.main;
import java.sql.*;

public class Miles {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establishe a connnection
			String url = "jdbc:mysql://localhost/My_Bank?user = root&password= ";
			Connection conn = DriverManager.getConnection(url);
			System.out.println("connection successfull");

		} catch (ClassNotFoundException e) {
			System.out.println("Unable to register the drivers " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("database connection error " + e.getMessage());
		}

	}
}
