package com.miniproject2;

import java.util.Scanner;

public class BuyProduct {

	public void getBuyProduct() {
		int price = 0;
		System.out.println("***************************Welcome to Shopping***************************");
		System.out.println(" Enter Product Id>> ");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		System.out.println("Enter the quantity of Product to buy >> ");
		int quantity = scanner.nextInt();
		System.out.println("Product Id>>" + id);
		System.out.println("Quantity>>" + quantity);
		System.out.println(" One Product item has been added to cart");
		System.out.println("Do you want to view cart...(yes/no)");
		String string = scanner.next();
		if (string.contains("yes")) {
			ViewCart viewCart = new ViewCart();
			viewCart.getCart(id, quantity);

		} else if (string.contains("no")) {
			Bill bill = new Bill();
			bill.getBill(id, quantity, price);

		}
	}

}
