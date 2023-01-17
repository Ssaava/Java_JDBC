package JDBC;

import java.sql.*;

public class DataBaseServices {
	DataBaseConnection base = new DataBaseConnection();
	Query query = new Query();

	public void getUserDetails(int id) throws Exception {
		Clients client = new Clients();
		try (Connection con = base.connect();
				Statement stmt = con.createStatement();
				ResultSet result = stmt.executeQuery(query.showUser(id))) {
			boolean rows = result.next();
			if (rows == true) {
				client.setUserId(result.getInt("user_id"));
				client.setFirstName(result.getString("first_name"));
				client.setSecondName(result.getString("second_name"));
				client.setUserBalance(result.getDouble("account_balance"));
//				System.out.println(result.getString("second_name"));

			} else {
				System.out.println(
						"There is no bank account associated with that account id \nTry opening up a new account");
				new Main().BankMenu();
				;
			}

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong " + e);
		}
	}// end of get user details

	public void displayUserDetails() {
		Clients client = new Clients();
		System.out.println("User ID: " + client.getUserId());
		System.out.println("Client Name: " + client.getFirstName() + " " + client.getSecondName());
		System.out.println("Client Account Balance: " + client.getUserBalance());
	}

}
