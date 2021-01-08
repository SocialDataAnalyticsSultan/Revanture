package model;

import java.util.List;

public class Customer {
	
	private String name;
	private List<Item> listOfItems;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, List<Item> listOfItems) {
		super();
		this.name = name;
		this.listOfItems = listOfItems;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Item> getListOfItems() {
		return listOfItems;
	}
	
	public void setListOfItems(List<Item> listOfItems) {
		this.listOfItems = listOfItems;
	}

	public int calculateBill() {
		
		int total = 0;
		for (Item item:listOfItems) {
			total+=item.getPrice(item.getName());
		}
		return total;
		
	}
	
	
	
}
