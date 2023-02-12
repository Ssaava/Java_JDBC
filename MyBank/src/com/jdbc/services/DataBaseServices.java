package com.jdbc.services;

import java.sql.*;
import com.jdbc.connect.*;
import com.jdbc.Details.*;

public class DataBaseServices {

	DataBaseConnection base = new DataBaseConnection();
	Query query = new Query();

	public void registerClient(String first_name, String second_name, String address, int pin) {
		try (Connection con = base.connect();) {
			PreparedStatement stmt = con.prepareStatement(query.Register());
			stmt.setString(1, first_name);
			stmt.setString(2, second_name);
			stmt.setString(3, address);
			stmt.setInt(4, pin);

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Client registered successfully\n");
				
			} else {
				System.out.println("Try again!!\n");
			}
			System.out.println("Done");
		} catch (Exception e) {

		}

	}
	public void userRegister(ClientDetails client) {

		try (Connection con = base.connect(); Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery(query.getLastUser());
			if (result.next()) {
				client.set_first_name(result.getString("first_name"));
				client.set_second_name(result.getString("second_name"));
				client.setAccount_no(result.getInt("account_no"));
				client.setAddress(result.getString("address"));
				client.setPin(result.getInt("pin"));
				client.setSalary(result.getDouble("salary"));
			}

		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		

	}

	public void Withdraw(Double salary, int account) {
		try (Connection con = base.connect();
				PreparedStatement stmt = con.prepareStatement(query.withdraw())) {
			stmt.setDouble(1, salary);
			stmt.setInt(2, account);
			stmt.executeUpdate();
			

		} catch (Exception e) {
			System.out.println("Error occured " + e);
		}

	}

	public static void DeleteClient() {

	}

	public static void updatePin() {

	}

	public void showUsers() {
		try (Connection con = base.connect(); Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery(query.showUsers());
			while (result.next()) {
				System.out.println("Name: " + result.getString("first_name") + " " + result.getString("second_name"));
				System.out.println("Address: " + result.getString("address"));
				System.out.println("Account No: " + result.getInt("account_no"));
				System.out.println("Pin: " + result.getInt("pin"));
				System.out.println("Salary: " + result.getDouble("salary"));
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("Error occured \n");
		}
	}

	public boolean userLogin(int account_number, int pin, ClientDetails client) {
		boolean isTrue = false;

		try (Connection con = base.connect(); Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery(query.displayClients(account_number, pin));
			if (result.next()) {
				client.set_first_name(result.getString("first_name"));
				client.set_second_name(result.getString("second_name"));
				client.setAccount_no(result.getInt("account_no"));
				client.setAddress(result.getString("address"));
				client.setPin(result.getInt("pin"));
				client.setSalary(result.getDouble("salary"));
				isTrue = true;
			}

		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		return isTrue;

	}
}
