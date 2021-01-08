package com.app.model;

import java.util.Objects;

public class Address {
	
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	
	public Address() {
		super();
	}
	
	public Address(String street, String city, String state, String country, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", zipcode=" + zipcode + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, country, state, street, zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(state, other.state) && Objects.equals(street, other.street)
				&& Objects.equals(zipcode, other.zipcode);
	}
	
}
