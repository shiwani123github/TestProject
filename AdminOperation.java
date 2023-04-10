package com.miniproject2;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminOperation {
	public void getAdminOperation() throws SQLException {
		System.out.println("***********************Welcome to Admin Operation*********************");
		System.out.println("1.Add product item");
		System.out.println("2. Calculate Bill");
		System.out.println("3. Display amount to End User");
		System.out.println("4. Check the particular user history");
		System.out.println("5.Check the Quantiyt of Product");
		System.out.println("Enter your choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		if(choice==1) {
			Product product=new Product();
			product.getProduct();
		}else if(choice==2) {
			Bill bill=new Bill();
			bill.getBill(choice, choice, choice);
		}else if(choice==3) {
			Bill bill=new Bill();
			bill.getBill(choice, choice, choice);

		}else if(choice==4) {
			CheckHistory checkHistory=new CheckHistory();
			checkHistory.getCheckHistory(null);
		}else if(choice==5) {
			CheckQuantity checkQuantity=new CheckQuantity();
			checkQuantity.getCheckQuantity(null, 0);
		}

	}
}
