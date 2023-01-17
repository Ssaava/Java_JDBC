package JDBC;

import java.util.*;

public class Main {
	Bank bank = new Bank();
	DataBaseServices service = new DataBaseServices();

	public static void main(String args[]) throws Exception {
		Main m = new Main();
		m.BankMenu();
	}

	public void BankMenu() throws Exception {
		Main m = new Main();
		boolean isRunning = true;
		System.out.println("|------*****************-------|");
		System.out.println("|                              |");
		System.out.println("| 1: Open Bank Account         |");
		System.out.println("| 2: ATM services              |");
		System.out.println("| 3: Exit Services             |");
		System.out.println("|                              |");
		System.out.println("|------*****************-------|");
		while (isRunning) {
			try (Scanner scan = new Scanner(System.in)) {
				int choice = Integer.parseInt(scan.nextLine());
				switch (choice) {
				case 1:
					m.bank.addClients();
					m.clientMenu();
					break;
				case 2:
					System.out.println("Enter user ID to access ATM services");
					m.service.getUserDetails(Integer.parseInt(scan.nextLine()));
					m.clientMenu();
					break;
				case 3:
					isRunning = false;
					System.out.println("Thank you for choosing our services");
					break;
				default:
					break;
				}
			}
		}

	}

	public void clientMenu() throws Exception {
		Main m = new Main();
		boolean isRunning = true;
		System.out.println("|------*****************-------|");
		System.out.println("|                              |");
		System.out.println("| 1: Withdraw Some Cash        |");
		System.out.println("| 2: Deposit some Cash         |");
		System.out.println("| 3: Request Account Details   |");
		System.out.println("| 4: Exit Services             |");
		System.out.println("|                              |");
		System.out.println("|------*****************-------|");
		while (isRunning) {
			try (Scanner scan = new Scanner(System.in)) {
				int choice = Integer.parseInt(scan.nextLine());
				switch (choice) {
				case 1:
					clientMenu();
					break;
				case 2:
					System.out.println("Enter Amount you want to deposit");
					clientMenu();
					break;
				case 3:
					m.service.displayUserDetails();

					clientMenu();
					break;
				case 4:
					isRunning = false;
					System.out.println("Thank you for choosing our services");
					m.BankMenu();
					break;
				default:
					break;
				}
			}
		}

	}
}
