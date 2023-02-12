package com.jdbc.main;

import com.jdbc.services.*;
import com.jdbc.Details.ClientDetails;
import java.util.*;

public class Main {
	DataBaseServices service = new DataBaseServices();

	public static String fName;
	public static String sName;
	public static int account_no;
	public static String Address;
	public static double Salary;
	public static int Pin_code;

//	Main class credentials
	private static int pin = 1212;
	static int count = 3;
	static int Pin = 0;
	boolean validate = false;

	public static void main(String[] args) throws Exception {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Welcome to My_Bank we are ready to serve you\n");
			System.err.println("|-------*****MENU****-------|");
			System.err.println("|                           |");
			System.out.println("|1). Bank Services          |");
			System.out.println("|2). ATM Services           |");
			System.out.println("|3). Exit                   |");
			System.err.println("|                           |");
			System.err.println("|---------------------------|\n");
			int num = Integer.parseInt(scan.nextLine());
			switch (num) {
			case 1:
				count = 3;
				validatePin();
				break;
//				End of Registration of new Client
			case 2:
				ClientDetails client = new ClientDetails();
				System.out.println("Enter account_no and Pin");
				
				boolean pass = new Main().service.userLogin(Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()),
						client);
				if (pass) {
					fName = client.get_first_name();
					sName = client.get_second_name();
					account_no = client.getAccount_no();
					Address = client.getAddress();
					Salary = client.getSalary();
					Pin_code = client.getPin();
					AtmMenu();
				} else {
					System.out.println("Account doesnot exist\n");
					main(args);
				}
				break;
//				This is the case for the user login into the Bank
			case 3:
				System.out.println("Thank you for choosing our services");
				break;
			default:
				System.out.println("Wrong option try again\n");
				main(args);
			}

		} catch (Exception e) {
			System.err.println("Something went wrong" + e);

		}

	}// End of main method

	public void BankMenu() {
		try (Scanner scan = new Scanner(System.in)) {

			System.out.println("Welcome to My_Bank Client Services\n");
			System.out.println("|-------*****BANK MENU****-------|");
			System.out.println("|                                |");
			System.out.println("|1). Register Client             |");
			System.out.println("|2). Display Clients Details     |");
			System.out.println("|3). Exit                        |");
			System.out.println("|                                |");
			System.out.println("|--------------------------------|\n");
			int num = Integer.parseInt(scan.nextLine());

			switch (num) {
			case 1:
				ClientDetails client = new ClientDetails();
				System.out.println("Please enter first name, second name, address and account pin code\n");
				service.registerClient(scan.nextLine(), scan.nextLine(), scan.nextLine(),
						Integer.parseInt(scan.nextLine()));
				new Main().service.userRegister(client);
				fName = client.get_first_name();
				sName = client.get_second_name();
				account_no = client.getAccount_no();
				Address = client.getAddress();
				Salary = client.getSalary();
				Pin_code = client.getPin();
				
				System.out.println("Below are your account details");
				System.out.println();
				System.out.println("Name: " + fName + " " + sName);
				System.out.println("Address: " + Address);
				System.out.println("Account No.: " + account_no);
				System.out.println("Salary: " + Salary);
				System.out.println();
				
				BankMenu();
				break;
			case 2:
				service.showUsers();
				BankMenu();
				break;
			case 3:
				System.out.println("Thank you for choosing our services\n");
				main(null);
				break;
			default:
				System.out.println("Wrong choise!!\n");

				BankMenu();
			}

		} catch (Exception e) {
			System.err.println("Something went wrong" + e);
		}
	}// End of bank Menu

	public static void AtmMenu() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Welcome to My_Bank ATM Services\n");
			System.out.println("|-------*****ATM MENU****-------|");
			System.out.println("|                               |");
			System.out.println("|1). Account Details            |");
			System.out.println("|2). Withdraw Funds             |");
			System.out.println("|3). Deposit Funds              |");
			System.out.println("|4). Delete User Account        |");
			System.out.println("|5). Update Pin                 |");
			System.out.println("|6). Exit                       |");
			System.out.println("|                               |");
			System.out.println("|-------------------------------|\n");
			int num = Integer.parseInt(scan.nextLine());

			switch (num) {
			case 1:
				System.out.println();
				System.out.println("Name: " + fName + " " + sName);
				System.out.println("Address: " + Address);
				System.out.println("Account No.: " + account_no);
				System.out.println("Salary: " + Salary);
				System.out.println();
				AtmMenu();
				break;
			case 2:
				System.out.println("Please enter amount");
				Double amount = Double.parseDouble(scan.nextLine());
				if (amount <= Salary && amount >= 0) {
					
					Salary = Salary - amount;
					System.out.println("Cash Withdraw of " + amount
							+ " has been successfully processed. Your new Account Balance is " + Salary + "\n");
					new Main().service.Withdraw(Salary, account_no);
					AtmMenu();
				}else if(amount < 0) {
					System.out.println("Input amount greater than 0\n");
					AtmMenu();
				}else {
				
					System.out.println("Insuficient Funds Please deposit on your account and try again later\n");
					AtmMenu();
				}
				break;
			case 3:
				System.out.println("Please enter amount");
				Double deposit = Double.parseDouble(scan.nextLine());
				if (deposit >= 0) {
					
					Salary = Salary + deposit;
					System.out.println("Cash deposit of " + deposit
							+ " has been successfully processed. Your new Account Balance is " + Salary + "\n");
					new Main().service.Withdraw(Salary, account_no);
					AtmMenu();
				}else if(deposit < 0) {
					System.out.println("Input amount greater than 0\n");
					AtmMenu();
				}else {
				
					System.out.println("Please input a number\n");
					AtmMenu();
				}
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.out.println("Thank you for choosing our services\n");
				main(null);
				break;
			default:
				System.out.println("Wrong choise!!\n");
				new Main().BankMenu();
			}

		} catch (Exception e) {
			System.err.println("Something went wrong" + e);
		}
	}// End of ATM Menu

	public static void validatePin() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Please enter pin to access Bank Menu\n");
			Pin = Integer.parseInt(scan.nextLine());
			if (Pin == pin && count != 0) {
				new Main().BankMenu();
			} else if (count != 0) {
				System.out.println("Invalid pin you now have --" + count + "-- trials" + "\n");
				count--;
				validatePin();
			} else {
				System.out.println("You have Exceeded three tries please try again\n\n");
				main(null);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}// End of validate password

}
