package com.app.model;

import java.util.Objects;

public class Address {
	
	protected String street;
	protected String city;
	protected String state;
	protected String zipcode;
	protected String country;
	
	public Address() {
		super();
	}
	
	public Address(String street, String city, String state, String zipcode, String country) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public boolean equals(Object anObject) {
		if(anObject == this) {
			return true;
		}
		
		if (anObject == null) {
			return false;
		}
		
		if(!(anObject instanceof Address)) {
			return false;
		}
		
		Address anAddress = (Address) anObject;
		if(anAddress.street != this.street || anAddress.city != this.city || 
				anAddress.state != this.state || anAddress.country != this.country || 
				anAddress.zipcode != this.zipcode) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(street, city, state, zipcode, country);
    }
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode
				+ ", country=" + country + "]";
	}
	
}
