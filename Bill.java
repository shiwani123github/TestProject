package com.miniproject2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bill {
String Pname;
int Proprice;
String proDesc;
float total;
int pquantity;
float overAllprice;
	public Bill(String pname, int proprice, String proDesc, float total, int pquantity ,float overAllprice) {

	Pname = pname;
	Proprice = proprice;
	this.proDesc = proDesc;
	this.total = total;
	this.pquantity = pquantity;
}
	public Bill() {
		
	}

	public void getBill(int id, int quantity, int price) {
		int pId = id;
		int quant = quantity;
		int pPrice = price;
		float totalPrice=0;
		float overAllprice = 0;
		try {
			ConnectionTest connectionTest = new ConnectionTest();
			Connection connection = connectionTest.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from product where productid=?");
			preparedStatement.setInt(1, pId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Pname=resultSet.getString("name");
				proDesc=resultSet.getString("description");
				Proprice=resultSet.getInt("price");
				pquantity=resultSet.getInt("quantity");
				total=totalPrice;
				overAllprice=overAllprice;
				System.out.println(" Your Bill ");      
				System.out.println("Product Name : " + resultSet.getString("name"));
				System.out.println("Product Description : " + resultSet.getString("description"));
				pPrice = resultSet.getInt("price");
				System.out.println("Product Price :" + pPrice);
				System.out.println("Quantity :" + quant);
			}
			totalPrice = pPrice * quant;
            overAllprice=overAllprice+totalPrice;
			System.out.println("Total Amount : " + totalPrice);
			
             List< Bill> list = new  ArrayList<Bill>();
             list.add(new Bill( Pname,Proprice,proDesc,total,pquantity,overAllprice));
		    System.out.println(" Do you want to do some more shopping.....(yes/no) ");
			Scanner scanner = new Scanner(System.in);
			String string = scanner.next();
			

			if (string.contains("yes")) {
				Product product = new Product();
				product.getProduct();
			} else if (string.contains("no")) {
				for(Bill b:list) {
			    	 System.out.println("Product Name : " + b.Pname);
			    	 System.out.println("Product Dicription : " + b.proDesc);
			    	 System.out.println("prodcut price:" + b.Proprice);
			    	 System.out.println("Product quntity:" + b.pquantity);
			    	 System.out.println("Total: " +b.total);
			    	 System.out.println("Overall Amount:"+b.overAllprice);
			    	 
			     }
                   Bill bill=new Bill();
                   bill.getBill(pPrice, pPrice, pPrice);
                   System.out.println(" Thank you for shopping ! ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
