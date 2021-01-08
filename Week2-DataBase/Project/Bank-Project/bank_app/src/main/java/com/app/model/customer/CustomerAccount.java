package com.app.model.customer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class CustomerAccount {

	private int customerId;
	private String accountType;
	private String accountNumber;
	private Date openDate;
	private BigDecimal balance;
	private int branchId;
	private int approvingEmployeeId;
	
	public CustomerAccount() {
		super();
	}

	public CustomerAccount(int customerId, String accountType, String accountNumber, Date openDate, BigDecimal balance,
			int branchId, int approvingEmployeeId) {
		super();
		this.customerId = customerId;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.openDate = openDate;
		this.balance = balance;
		this.branchId = branchId;
		this.approvingEmployeeId = approvingEmployeeId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getApprovingEmployeeId() {
		return approvingEmployeeId;
	}

	public void setApprovingEmployeeId(int approvingEmployeeId) {
		this.approvingEmployeeId = approvingEmployeeId;
	}

	@Override
	public String toString() {
		return "CustomerAccount [customerId=" + customerId + ", accountType=" + accountType + ", accountNumber="
				+ accountNumber + ", openDate=" + openDate + ", balance=" + balance + ", branchId=" + branchId
				+ ", approvingEmployeeId=" + approvingEmployeeId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, approvingEmployeeId, branchId, customerId, openDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CustomerAccount)) {
			return false;
		}
		CustomerAccount other = (CustomerAccount) obj;
		return Objects.equals(accountNumber, other.accountNumber) && approvingEmployeeId == other.approvingEmployeeId
				&& branchId == other.branchId && customerId == other.customerId
				&& Objects.equals(openDate, other.openDate);
	}
	
}
