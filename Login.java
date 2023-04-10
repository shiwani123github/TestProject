package com.miniproject2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	public void getLogin() throws SQLException {
		System.out.println("********************************Welcome to Login Page**************************");
		System.out.println("Enter your Username");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.next();
		System.out.println("Enter your Password");
		String password = scanner.next();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			ConnectionTest connectionTest = new ConnectionTest();
			connection = connectionTest.getConnection();
			preparedStatement = connection
					.prepareStatement("select * from registration where username= ? and password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			String username1 = " ";
			String password1 = " ";
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				username1 = resultSet.getString("username");
				password1 = resultSet.getString("password");
			}
			if (username.equals(username1) && password.equals(password1)) {
				System.out.println("You have successfully login.....");
				Product product=new Product();
				product.getProduct();
			} else {
				System.out.println("Invalid username or password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}

}
