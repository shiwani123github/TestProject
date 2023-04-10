package com.miniproject2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckQuantity {
	public void getCheckQuantity(String name, int quant) {
		String productName=name;
		int quantity =quant;
		try {
			ConnectionTest connectionTest=new ConnectionTest();
			Connection connection=connectionTest.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("select productid,name,quantity from product ");
			//int productid =0;
			//preparedStatement.setInt(1, productid );
		//	preparedStatement.setInt(2, quantity);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Product Id :" + resultSet.getInt("productid"));
				System.out.println("Product name : " + resultSet.getString("name"));
				System.out.println("Product Quantity : " + resultSet.getInt("quantity"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
