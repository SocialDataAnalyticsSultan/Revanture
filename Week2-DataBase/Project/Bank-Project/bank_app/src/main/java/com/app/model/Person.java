package com.app.model;

import java.util.Date;
import java.util.Objects;

public class Person {
	
	protected String firstName;
	protected String lastName;
	protected Date dateOfBirth;
	protected String gender;
	protected String maritalStatus;
	protected String nationality;
	protected String socialSecurityNumber;
	protected Address address;
	protected String email;
	protected String phoneNumber;
	
	protected Person() {
		super();
	}
	
	protected Person(String firstName, String lastName, Date dateOfBirth, String gender, String maritalStatus,
			String nationality, String socialSecurityNumber, Address address, String email, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.nationality = nationality;
		this.socialSecurityNumber = socialSecurityNumber;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus + ", nationality=" + nationality
				+ ", socialSecurityNumber=" + socialSecurityNumber + ", address=" + address + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, firstName, lastName, socialSecurityNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName)
				&& Objects.equals(socialSecurityNumber, other.socialSecurityNumber);
	}
	
}
