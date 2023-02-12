package com.jdbc.connect;

import java.sql.*;

public class DataBaseConnection {
	private String url = "jdbc:mysql://localhost/My_Bank";
	private String user = "root";
	private String password = "";

	public DataBaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public Connection connect() throws Exception {
		return DriverManager.getConnection(url, user, password);
	}
}
