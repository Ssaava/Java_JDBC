package com.jdbc.Details;

public class ClientDetails {
	public String fName;
	public String sName;
	public int account_no;
	public String Address;
	public double Salary;
	public int Pin;
	public ClientDetails() {}
	public ClientDetails(int account_no, String first_name,String second_name, String address, double salary, int pin) {
		// super();
		this.account_no = account_no;
		this.fName = first_name;
		Address = address;
		Salary = salary;
		Pin = pin;
	}

	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public String get_first_name() {
		return fName;
	}

	public void set_first_name(String name) {
		fName = name;
	}
	public String get_second_name() {
		return sName;
	}

	public void set_second_name(String name) {
		sName = name;
	}
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}

	public int getPin() {
		return Pin;
	}

	public void setPin(int pin) {
		Pin = pin;
	}
}
