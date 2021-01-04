package com.app.model.customer.account;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Account {
	
	private String accountNumber;
	private int customerId;
	private int branchId;
	private Date dateOfOpen;
	private int approvingEmployeeId;
	private BigDecimal balance;
	private String accountType;
	final static BigDecimal overdraftFee = new BigDecimal(50.0);
	final static double interestRate = 0.01;
	
	public Account() {
		super();
	}

	public Account(String accountNumber, int customerId, int branchId, Date dateOfOpen,
			int approvingEmployeeId, BigDecimal balance, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.branchId = branchId;
		this.dateOfOpen = dateOfOpen;
		this.approvingEmployeeId = approvingEmployeeId;
		this.balance = balance;
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public Date getDateOfOpen() {
		return dateOfOpen;
	}

	public void setDateOfOpen(Date dateOfOpen) {
		this.dateOfOpen = dateOfOpen;
	}

	public int getApprovingEmployeeId() {
		return approvingEmployeeId;
	}

	public void setApprovingEmployeeId(int approvingEmployeeId) {
		this.approvingEmployeeId = approvingEmployeeId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public static BigDecimal getOverdraftfee() {
		return overdraftFee;
	}

	public static double getInterestrate() {
		return interestRate;
	}

	@Override
	public boolean equals(Object anObject) {
		if(anObject == this) {
			return true;
		}
		
		if (anObject == null) {
			return false;
		}
		
		if(!(anObject instanceof Account)) {
			return false;
		}
		
		Account anAccount = (Account) anObject;
		if (anAccount.accountNumber != accountNumber || anAccount.customerId != customerId || anAccount.branchId != branchId || 
				anAccount.dateOfOpen != dateOfOpen || anAccount.approvingEmployeeId != approvingEmployeeId ||
				anAccount.accountType != accountType ) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(accountNumber);
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customerId=" + customerId + ", branchId=" + branchId
				+ ", dateOfOpen=" + dateOfOpen  + ", approvingEmployeeId=" + approvingEmployeeId + ", balance=" + balance + "]";
	}

}
