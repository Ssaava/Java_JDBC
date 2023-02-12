package com.jdbc.services;

public class Query {
	public String Register() {
		return "INSERT INTO Bank(first_name, second_name, address, pin) VALUES(?, ?, ?, ?)";
	}
	public String displayClients(int Id, int pin) {
		return "SELECT * FROM Bank WHERE account_no = "+ Id + " AND pin = " +  pin ;
	}
	public String desppositCash() {
		return "UPDATE Bank SET ";
	}
	public String showUsers() {
		return "SELECT * FROM Bank";
	}
	public String withdraw() {
		return "UPDATE Bank SET salary = ? WHERE account_no = ?";
	}
	public String getLastUser() {
		return "SELECT * FROM Bank ORDER BY account_no DESC LIMIT 1";
	}
}
