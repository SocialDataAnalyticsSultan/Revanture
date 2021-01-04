package com.app.model.customer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import com.app.model.Address;
import com.app.model.Person;

public class Customer extends Person {
	
	private int customerId;
	private String occupation;
	private int creaditScore;
	private BigDecimal yearlyIncome;
	private String userName;
	private String password;
	
	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, Date dateOfBirth, String gender, String maritalStatus,
			String socialSecurityNumber, Address address, String email, String mobilePhone, String nationality,
			int customerId, String occupation, int creaditScore, BigDecimal yearlyIncome, String userName,
			String password) {
		super(firstName, lastName, dateOfBirth, gender, maritalStatus, socialSecurityNumber, address, email, mobilePhone,
				nationality);
		this.customerId = customerId;
		this.occupation = occupation;
		this.creaditScore = creaditScore;
		this.yearlyIncome = yearlyIncome;
		this.userName = userName;
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getCreaditScore() {
		return creaditScore;
	}

	public void setCreaditScore(int creaditScore) {
		this.creaditScore = creaditScore;
	}

	public BigDecimal getYearlyIncome() {
		return yearlyIncome;
	}

	public void setYearlyIncome(BigDecimal yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public boolean equals(Object anObject) {
		if(anObject == this) {
			return true;
		}
		
		if (anObject == null) {
			return false;
		}
		
		if(!(anObject instanceof Customer)) {
			return false;
		}
		
		Customer aCustomer = (Customer) anObject;
		if (aCustomer.firstName != firstName || aCustomer.lastName != lastName || aCustomer.gender != gender || 
				aCustomer.dateOfBirth != dateOfBirth || aCustomer.socialSecurityNumber != socialSecurityNumber ||
						aCustomer.customerId != customerId) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		return Objects.hashCode(customerId);
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", occupation=" + occupation + ", creaditScore=" + creaditScore
				+ ", yearlyIncome=" + yearlyIncome + ", userName=" + userName + ", password=" + password
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
