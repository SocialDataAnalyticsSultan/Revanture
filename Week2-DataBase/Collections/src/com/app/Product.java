package com.app;

public class Product implements Comparable
{
	
	private int id;
	private String name;
	private double cost;
	private float rating;
	private boolean avalibility;
	
	
	public Product() {
		super();
	}


	public Product(int id, String name, double cost, float rating, boolean avalibility) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.rating = rating;
		this.avalibility = avalibility;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public boolean isAvalibility() {
		return avalibility;
	}


	public void setAvalibility(boolean avalibility) {
		this.avalibility = avalibility;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", rating=" + rating + ", avalibility="
				+ avalibility + "]";
	}


	@Override
	public int compareTo(Object o) {
		Product obj = (Product)o;
		Integer id1=this.id;
		Integer id2 = obj.id;
		return id1.compareTo(id2);
	}

}
