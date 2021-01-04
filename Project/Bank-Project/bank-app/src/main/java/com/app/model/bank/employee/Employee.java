package com.app.model.bank.employee;

import java.util.Date;
import java.util.Objects;

import com.app.model.Address;
import com.app.model.Person;

public abstract class Employee extends Person{
	
	protected String employeeId;
	protected String branchId;
	protected String userName;
	protected String password;
	protected Date dateOfStart;
	protected String bankAccount;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, Date dateOfBirth, String gender, String maritalStatus,
			String socialSecurityNumber, Address address, String email, String mobilePhone, String nationality,
			String employeeId, String branchId, String userName, String password, Date dateOfStart,
			String bankAccount) {
		super(firstName, lastName, dateOfBirth, gender, maritalStatus, socialSecurityNumber, address, email, mobilePhone,
				nationality);
		this.employeeId = employeeId;
		this.branchId = branchId;
		this.userName = userName;
		this.password = password;
		this.dateOfStart = dateOfStart;
		this.bankAccount = bankAccount;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
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

	public Date getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(employeeId);
	}

	@Override
	public boolean equals(Object anObject) {
		if(anObject == this) {
			return true;
		}
		
		if (anObject == null) {
			return false;
		}
		
		if(!(anObject instanceof Employee)) {
			return false;
		}
		
		Employee aEmployee = (Employee) anObject;
		if (aEmployee.firstName != firstName || aEmployee.lastName != lastName || aEmployee.gender != gender || 
				aEmployee.dateOfBirth != dateOfBirth || aEmployee.socialSecurityNumber != socialSecurityNumber ||
						aEmployee.employeeId != employeeId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", branchId=" + branchId + ", userName=" + userName
				+ ", password=" + password + ", dateOfStart=" + dateOfStart + ", bankAccount=" + bankAccount
				+ ", toString()=" + super.toString() + "]";
	}
	

}
