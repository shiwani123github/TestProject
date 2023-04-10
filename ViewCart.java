package com.miniproject2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ViewCart {
	public void getCart(int id, int quantity) {
		int pId = id;
		int quty = quantity;
		int price;
		try {
			ConnectionTest connectionTest = new ConnectionTest();
			Connection connection = connectionTest.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from product where productid=? ");
			preparedStatement.setInt(1, pId);
			ResultSet resultSet = preparedStatement.executeQuery();
			// String productname=" ";
			// String productDescription=" ";
			// int productprice=0;

			while (resultSet.next()) {
				System.out.println("Product name :" + resultSet.getString("name"));
				System.out.println("Description :" + resultSet.getString("description"));
				price = resultSet.getInt("price");
				System.out.println("Price :" + price);
				System.out.println("Quantity : " + quty);

				System.out.println("Want to  Proceed .....(yes/no) ");
				Scanner scanner = new Scanner(System.in);
				String string = scanner.next();
				if (string.contains("yes")) {
					Bill bill = new Bill();   
					bill.getBill(id, quantity, price);

				} else if (string.contains("no")) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
