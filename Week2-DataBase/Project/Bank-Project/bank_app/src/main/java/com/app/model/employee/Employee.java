package com.app.model.employee;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import com.app.model.Address;
import com.app.model.Person;

public class Employee extends Person{
	
	private int employeeId;
	private BigDecimal yearlyIncome;
	private int creditScore;
	private String userName;
	private String password;
	private String accountNumber;
	private Date dateOfStart;
	private int branchId;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, Date dateOfBirth, String gender, String maritalStatus,
			String nationality, String socialSecurityNumber, Address address, String email, String phoneNumber,
			int employeeId, BigDecimal yearlyIncome, int creditScore, String userName, String password,
			String accountNumber, Date dateOfStart, int branchId) {
		super(firstName, lastName, dateOfBirth, gender, maritalStatus, nationality, socialSecurityNumber, address, email,
				phoneNumber);
		this.employeeId = employeeId;
		this.yearlyIncome = yearlyIncome;
		this.creditScore = creditScore;
		this.userName = userName;
		this.password = password;
		this.accountNumber = accountNumber;
		this.dateOfStart = dateOfStart;
		this.branchId = branchId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	@Override
	public String toString() {
		return "Employee [toString()=" + super.toString() + ", employeeId=" + employeeId + ", yearlyIncome="
				+ yearlyIncome + ", creditScore=" + creditScore + ", userName=" + userName + ", password=" + password
				+ ", accountNumber=" + accountNumber + ", dateOfStart=" + dateOfStart + ", branchId=" + branchId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(employeeId, password, userName);
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
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		return employeeId == other.employeeId && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName);
	}

}
