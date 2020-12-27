package com.app.model;

import java.util.Date;

public class Employee extends Person {

	private int employeeId;
	private Date dateOfBirth;
	private String street;
	private String city;
	private String state;
	private String country;
	private int departmentId;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String gender, String phoneNumber, String email,
			int employeeId, Date dateOfBirth, String street, String city, String state, String country,
			int departmentId) {
		super(firstName, lastName, gender, phoneNumber, email);
		this.employeeId = employeeId;
		this.dateOfBirth = dateOfBirth;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.departmentId = departmentId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId= " + employeeId + ", firstName= " + firstName + ", lastName= " + lastName 
				+ "\n\tgender= " + gender + ", phoneNumber= " + phoneNumber + ", email= " + email + ", dateOfBirth= " + dateOfBirth 
				+ "\n\tstreet= " + street + ", city= " + city + ", state= " + state + ", country= " + country 
				+ "\n\tdepartmentId= " + departmentId + "]";
	}
	
	
	

}
