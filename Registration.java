package com.miniproject2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {
	public void getRegistration() throws SQLException {
		String firstName;
		String lastName;
		String username;
		String password;
		String city;
		String mail_id;
		String mobilenumber;
		System.out.println("***************************Welcome to Registration************************* ");
		System.out.println("Enter the first name");
		Scanner scanner = new Scanner(System.in);
		String fName = scanner.next();
		System.out.println("Enter the last name");
		String lName = scanner.next();
		System.out.println("Enter the username");
		String uName = scanner.next();
		System.out.println("Enter the password");
		String pass = scanner.next();
		System.out.println("Enter the city");
		String cityName = scanner.next();
		System.out.println("Enter the mailId");
		String mailId = scanner.next();
		System.out.println("Enter the mobile number");
		String mobile = scanner.next();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			ConnectionTest connectionTest = new ConnectionTest();
			connection = connectionTest.getConnection();
			preparedStatement = connection.prepareStatement(
					"insert into registration (firstName,lastName,username,password,city,mail_id,mobilenumber) values (?,?,?,?,?,?,?)");
			preparedStatement.setString(1, fName);
			preparedStatement.setString(2, lName);
			preparedStatement.setString(3, uName);
			preparedStatement.setString(4, pass);
			preparedStatement.setString(5, cityName);
			preparedStatement.setString(6, mailId);
			preparedStatement.setString(7, mobile);
			int c = preparedStatement.executeUpdate();
			System.out.println("You have successfully registered.....");
			Login login=new Login();
			login.getLogin();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
		}
	}
}
