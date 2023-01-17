package JDBC;

import java.sql.*;
import java.util.*;

public class Bank {
	DataBaseConnection base = new DataBaseConnection();
	Query query = new Query();

	public void addClients() {

		try (Connection con = base.connect();
				PreparedStatement stmt = con.prepareStatement(query.insertClient());
				Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter first name");
			String fName = scan.nextLine();
			System.out.println("Enter second name");
			String sName = scan.nextLine();
			stmt.setString(1, fName);
			stmt.setString(2, sName);
			stmt.setInt(3, 0);
			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Account successfully created");

			} else {
				System.out.println("Something went wrong");
			}

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong" + e);
		}

	}
}
