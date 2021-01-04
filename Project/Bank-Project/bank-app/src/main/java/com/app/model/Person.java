package com.app.model;

import java.util.Date;
import java.util.Objects;

public abstract class Person {
	
	protected String firstName;
	protected String lastName;
	protected Date dateOfBirth;
	protected String gender;
	protected String maritalStatus;
	protected String socialSecurityNumber;
	protected Address address;
	protected String email;
	protected String mobilePhone;
	protected String nationality;
	
	public Person() {
		super();
	}

	public Person(String firstName, String lastName, Date dateOfBirth, String gender, String maritalStatus,
			String socialSecurityNumber, Address address, String email, String mobilePhone, String nationality) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.socialSecurityNumber = socialSecurityNumber;
		this.address = address;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.nationality = nationality;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Override
	public boolean equals(Object anObject) {
		if(anObject == this) {
			return true;
		}
		
		if (anObject == null) {
			return false;
		}
		
		if(!(anObject instanceof Person)) {
			return false;
		}
		
		Person aPerson = (Person) anObject;
		if (aPerson.firstName != firstName || aPerson.lastName != lastName || aPerson.gender != gender || 
				aPerson.dateOfBirth != dateOfBirth || aPerson.socialSecurityNumber != socialSecurityNumber) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(socialSecurityNumber);
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus + ", socialSecurityNumber="
				+ socialSecurityNumber + ", address=" + address + ", email=" + email + ", mobilePhone=" + mobilePhone
				+ ", nationality=" + nationality + "]";
	}
	
	
}
