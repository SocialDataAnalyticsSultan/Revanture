package com.app.model.bank.employee;

import java.math.BigDecimal;
import java.util.Date;

import com.app.model.Address;

public class Teller extends Employee{
	
	private int stationNumber;
	private int hoursWork;
	private BigDecimal hourlyPayment;
	
	public Teller() {
		super();
	}
	
	
	public Teller(String firstName, String lastName, Date dateOfBirth, String gender, String maritalStatus,
			String socialSecurityNumber, Address address, String email, String mobilePhone, String nationality,
			String employeeId, String branchId, String userName, String password, Date dateOfStart,
			String bankAccount, int stationNumber, int hoursWork, BigDecimal hourlyPayment) {
		super(firstName, lastName, dateOfBirth, gender, maritalStatus, socialSecurityNumber, address, email, mobilePhone,
				nationality, employeeId, branchId, userName, password, dateOfStart, bankAccount);
		this.stationNumber = stationNumber;
		this.hoursWork = hoursWork;
		this.hourlyPayment = hourlyPayment;
	}


	public int getStationNumber() {
		return stationNumber;
	}


	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
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
		return "Teller [stationNumber=" + stationNumber + ", hoursWork=" + hoursWork + ", hourlyPayment="
				+ hourlyPayment + ", toString()=" + super.toString() + "]";
	}
	
}
