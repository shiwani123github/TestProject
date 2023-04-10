package com.miniproject2;

import java.sql.SQLException;
import java.util.Scanner;

public class UserOperation {
	public void getUserOperation() throws SQLException {
		System.out.println("****************************Welcome to User Operation*******************");
		System.out.println("1. User Registration");
		System.out.println("2.User Login");
		System.out.println("3. View Products");
		System.out.println("4. Buy Products");
		System.out.println("Enter your choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		if (choice == 1) {
			Registration registration = new Registration();
			registration.getRegistration();
		} else if (choice == 2) {
			Login login = new Login();
			login.getLogin();
		} else if (choice == 3) {
			Product product = new Product();
			product.getProduct();
		} else if (choice == 4) {
			BuyProduct buyProduct = new BuyProduct();
			buyProduct.getBuyProduct();
		}
	}
}
