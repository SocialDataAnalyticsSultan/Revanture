package com.app.model;

public class EmployeePrivate {
	
	private int employeeId;
	private String socialSecurityNumber;
	private String accountNumber;
	private String userName;
	private String password;
	
	public EmployeePrivate() {
		super();
	}
	
	public EmployeePrivate(int employeeId, String socialSecurityNumber, String accountNumber, String userName,
			String password) {
		super();
		this.employeeId = employeeId;
		this.socialSecurityNumber = socialSecurityNumber;
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.password = password;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
		return "EmployeePrivate [employeeId=" + employeeId + ", socialSecurityNumber=" + socialSecurityNumber
				+ ", accountNumber=" + accountNumber + ", userName=" + userName + ", password=" + password + "]";
	}
	

}
