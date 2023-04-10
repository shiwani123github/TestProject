package com.miniproject2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//select registration.id,firstName,lastName,city,product.name,price,quantity
//from registration inner join product on registration.id=product.productid
public class CheckHistory {
	public void getCheckHistory(String userName) {
		try {
			System.out.println("User History");

			ConnectionTest connectionTest = new ConnectionTest();
			Connection connection = connectionTest.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from registration,product where username= ?");
			// String firstName = " ";
			String username = userName;
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(" User Id :" + resultSet.getInt("id"));
				System.out.println(" User First Name :" + resultSet.getString("firstName"));
				System.out.println(" User Last Name : " + resultSet.getString("lastName"));
				 System.out.println(" User-name : " + resultSet.getString("username"));
				 System.out.println("Password :" + resultSet.getString("password"));
				System.out.println(" City:" + resultSet.getString("city"));
				System.out.println(" User Mobile Number : " + resultSet.getString("mobilenumber"));
				System.out.println(" Product Name : " + resultSet.getString("name"));
				System.out.println(" Product Description : " + resultSet.getString("description"));
				System.out.println(" Product price : " + resultSet.getInt("price"));
				System.out.println(" Product Quantity : " + resultSet.getInt("quantity"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
