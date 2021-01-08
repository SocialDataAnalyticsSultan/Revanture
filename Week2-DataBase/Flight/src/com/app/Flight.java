package com.app;

public class Flight implements Comparable{
	
	private int id;
	private String name;
	private String manufactureName;
	private double cost;
	private float rating;
	private boolean availibity;
	
	public Flight() {
		super();
	}

	public Flight(int id, String name, String manufactureName, double cost, float rating, boolean availibity) {
		super();
		this.id = id;
		this.name = name;
		this.manufactureName = manufactureName;
		this.cost = cost;
		this.rating = rating;
		this.availibity = availibity;
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

	public String getManufactureName() {
		return manufactureName;
	}

	public void setManufactureName(String manufactureName) {
		this.manufactureName = manufactureName;
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

	public boolean isAvailibity() {
		return availibity;
	}

	public void setAvailibity(boolean availibity) {
		this.availibity = availibity;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", name=" + name + ", manufactureName=" + manufactureName + ", cost=" + cost
				+ ", rating=" + rating + ", availibity=" + availibity + "]";
	}

	@Override
	public int compareTo(Object o) {
		Flight obj = (Flight)o;
		Double d1 = this.cost;
		Double d2 = obj.cost;
		return d1.compareTo(d2);
	}
	
}
