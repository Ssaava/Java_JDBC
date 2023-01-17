package JDBC;

public class Query {
	public String insertClient() {
		return "INSERT INTO BankAccounts (first_name, second_name, account_balance) VALUES(?, ?, ?)";
	}
	public String showUser(int id) {
		return "SELECT * FROM BankAccounts WHERE user_id = " + id;
	}
	public String updateAccount(int id) {
		
		return "UPDATE BankAccounts SET account_balance = ? WHERE user_id = " + id;
	}
}
