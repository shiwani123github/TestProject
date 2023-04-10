package com.miniproject2;

import java.util.Comparator;

public class NameComparator implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {

		return product1.pName.compareTo(product2.pName);
	}

}
