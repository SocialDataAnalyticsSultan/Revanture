package com.app.model.bank.employee;

import java.math.BigDecimal;
import java.util.Date;

import com.app.model.Address;

public class Secretary extends Employee{
	
	private int hoursWork;
	private BigDecimal hourlyPayment;
	
	public Secretary() {
		super();
	}
	
	public Secretary(String firstName, String lastName, Date dateOfBirth, String gender, String maritalStatus,
			String socialSecurityNumber, Address address, String email, String mobilePhone, String nationality,
			String employeeId, String branchId, String userName, String password, Date dateOfStart,
			String bankAccount, int hoursWork, BigDecimal hourlyPayment) {
		super(firstName, lastName, dateOfBirth, gender, maritalStatus, socialSecurityNumber, address, email, mobilePhone,
				nationality, employeeId, branchId, userName, password, dateOfStart, bankAccount);
		this.hoursWork = hoursWork;
		this.hourlyPayment = hourlyPayment;
	}

	public int getHoursWork() {
		return hoursWork;
	}

	public void setHoursWork(int hoursWork) {
		this.hoursWork = hoursWork;
	}

	public BigDecimal getHourlyPayment() {
		return hourlyPayment;
	}

	public void setHourlyPayment(BigDecimal hourlyPayment) {
		this.hourlyPayment = hourlyPayment;
	}

	@Override
	public String toString() {
		return "Secretary [hoursWork=" + hoursWork + ", hourlyPayment=" + hourlyPayment + ", toString()="
				+ super.toString() + "]";
	}
	
}
