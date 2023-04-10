package com.miniproject2;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) throws SQLException {
		System.out.println("---------------*Welcome to E-Commerce Based Application*---------------");
		System.out.println("1. User Operation");
		System.out.println("2. Admin Operation");
		System.out.println("3. Guest Operation");
		//System.out.println("2. User Login");
		//System.out.println("3. View Products");
		//System.out.println("4. Buy Products");
		//System.out.println("5. Check History");
		//System.out.println("6. Check Quantity");

		System.out.println("Enter your choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		/*if (choice == 1) {
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
		} else if (choice == 5) {
			CheckHistory checkHistory = new CheckHistory();
			checkHistory.getCheckHistory(null);
		} else if (choice == 6) {
			CheckQuantity checkQuantity = new CheckQuantity();
			checkQuantity.getCheckQuantity(null, choice);
		}*/
		if(choice ==1) {
			UserOperation userOperation=new UserOperation();
			userOperation.getUserOperation();
		}else if(choice ==2) {
			AdminOperation adminOperation=new AdminOperation();
			adminOperation.getAdminOperation();
		}else if(choice==3) {
			GuestOperation guestOperation=new GuestOperation();
			guestOperation.getGuestOperation();
		}

	}
}
