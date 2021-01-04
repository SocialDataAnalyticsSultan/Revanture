package com.app.model.bank.employee;

import java.math.BigDecimal;
import java.util.Date;

import com.app.model.Address;

public class Officer extends Employee{
	
	private int officeNumber;
	private int managerId;
	private BigDecimal salary;
	
	public Officer() {
		super();
	}
	
	public Officer(String firstName, String lastName, Date dateOfBirth, String gender, String maritalStatus,
			String socialSecurityNumber, Address address, String email, String mobilePhone, String nationality,
			String employeeId, String branchId, String userName, String password, Date dateOfStart,
			String bankAccount, int officeNumber, int managerId, BigDecimal salary) {
		super(firstName, lastName, dateOfBirth, gender, maritalStatus, socialSecurityNumber, address, email, mobilePhone,
				nationality, employeeId, branchId, userName, password, dateOfStart, bankAccount);
		this.officeNumber = officeNumber;
		this.managerId = managerId;
		this.salary = salary;
	}

	public int getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(int officeNumber) {
		this.officeNumber = officeNumber;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Officer [officeNumber=" + officeNumber + ", managerId=" + managerId + ", salary=" + salary
				+ ", toString()=" + super.toString() + "]";
	}
	
}
