package com.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PruductMain {

	public static void main(String[] args) {


		List<Product> productList = new ArrayList<>();
		productList.add(new Product(100, "TV", 100.11, 4.2F, true));
		productList.add(new Product(200, "TV", 200.11, 3.2F, false));
		productList.add(new Product(300, "TV", 150.11, 4.2F, true));
		productList.add(new Product(400, "TV", 110.11, 5.2F, false));
		productList.add(new Product(500, "TV", 510.11, 6.2F, true));
		productList.add(new Product(600, "TV", 160.11, 4.2F, false));
		
		Collections.sort(productList, new ProductOfAvalibityComparator());
		System.out.println("Printing Sorted Products by Avalibitiy");
		printProductList(productList);
		
		
		Collections.sort(productList, (Product p1, Product p2) -> {
			Double d1 = p1.getCost();
			Double d2 = p2.getCost();
			return d1.compareTo(d2);
			
		});
		System.out.println("Printing Products by Cost");
		printProductList(productList);
		

		Collections.sort(productList, (Product p1, Product p2) -> {
			int x =0;
			Float f1 = p1.getRating();
			Float f2 = p2.getRating();
			x = f1.compareTo(f2);
			
			Double d1 = p1.getCost();
			Double d2 = p2.getCost();
			
			if (x == 0) {
				x = d1.compareTo(d2);
			}
			
			return x;
		});
		
		System.out.println("Printing Sorted Products by Rating then Cost");
		printProductList(productList);
	}
	
	public static void printProductList(List<Product> productList) {
		for(Product p: productList) {
			System.out.println(p);
		}
	}

}
