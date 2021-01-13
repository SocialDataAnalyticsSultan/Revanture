package com.app.model.customer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import com.app.model.Address;
import com.app.model.Person;

public class Customer extends Person{
	
	private int customerId;
	private String occupation;
	private BigDecimal yearlyIncome;
	private int creditScore;
	private String userName;
	private String password;
	
	public Customer() {
		super();
	}
	
	
	public Customer(String firstName, String lastName, Date dateOfBirth, String gender, String maritalStatus,
			String nationality, String socialSecurityNumber, Address address, String email, String phoneNumber,
			int customerId, String occupation, BigDecimal yearlyIncome, int creditScore, String userName,
			String password) {
		super(firstName, lastName, dateOfBirth, gender, maritalStatus, nationality, socialSecurityNumber, address, email,
				phoneNumber);
		this.customerId = customerId;
		this.occupation = occupation;
		this.yearlyIncome = yearlyIncome;
		this.creditScore = creditScore;
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

	public BigDecimal getYearlyIncome() {
		return yearlyIncome;
	}

	public void setYearlyIncome(BigDecimal yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
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


	@Override
	public String toString() {
		return "Customer [" + super.toString() + ", customerId=" + customerId + ", occupation=" + occupation
				+ ", yearlyIncome=" + yearlyIncome + ", creditScore=" + creditScore + ", userName=" + userName
				+ ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(customerId, password, userName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) obj;
		return customerId == other.customerId && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName);
	}
	
}
