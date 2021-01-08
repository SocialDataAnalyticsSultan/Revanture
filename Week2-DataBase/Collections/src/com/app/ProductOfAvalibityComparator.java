package com.app;

import java.util.Comparator;

public class ProductOfAvalibityComparator  implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		Boolean b1 = o1.isAvalibility();
		Boolean b2 = o2.isAvalibility();
		
		
		return b2.compareTo(b1);
	}
	

}
