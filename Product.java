package com.miniproject2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Product {
	 int pId;
	 String pName;
	 String pdescp;
     int price;
	 int quantity;
	 public Product(){
		 
	 }

	public Product(int pId, String pName, String pdescp, int price, int quantity) {

		this.pId = pId;
		this.pName = pName;
		this.pdescp = pdescp;
		this.price = price;
		this.quantity = quantity;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getPdescp() {
		return pdescp;
	}

	public void setPdescp(String pdescp) {
		this.pdescp = pdescp;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public  void getProduct() throws SQLException {
		System.out.println("------------List of Products------------");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			ConnectionTest connectionTest = new ConnectionTest();
			connection = connectionTest.getConnection();
			preparedStatement = connection.prepareStatement("select * from product");
			resultSet = preparedStatement.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while (resultSet.next()) {
				pId = resultSet.getInt("productid");
				pName = resultSet.getString("name");
				pdescp = resultSet.getString("description");
				price = resultSet.getInt("price");
				quantity = resultSet.getInt("quantity");
				list.add(new Product(pId, pName, pdescp, price, quantity));
			}
			Collections.sort(list, new NameComparator());
			for (Product p : list) {
				System.out.println("****************************************");
				System.out.println("Product Id : " + p.getpId());
				System.out.println("Product Name : " + p.getpName());
				System.out.println("Product Description : " + p.getPdescp());
				System.out.println("Product Price : " + p.getPrice());
				System.out.println("Product Quantity : " + p.getQuantity());
				System.out.println("****************************************");

			}
			BuyProduct buyProduct = new BuyProduct();
			buyProduct.getBuyProduct();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}

}
