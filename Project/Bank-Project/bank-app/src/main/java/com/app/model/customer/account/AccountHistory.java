package com.app.model.customer.account;

import java.math.BigDecimal;
import java.util.Date;

public class AccountHistory {
	
	private String accountNumber;
	private BigDecimal amount;
	private String depositOrWithdraw;
	private Date date;
	private BigDecimal balance;
	
	public AccountHistory() {
		super();
	}
	
	public AccountHistory(String accountNumber, BigDecimal amount, String depositOrWithdraw, Date date,
			BigDecimal balance) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.depositOrWithdraw = depositOrWithdraw;
		this.date = date;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDepositOrWithdraw() {
		return depositOrWithdraw;
	}

	public void setDepositOrWithdraw(String depositOrWithdraw) {
		this.depositOrWithdraw = depositOrWithdraw;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountHistory [accountNumber=" + accountNumber + ", amount=" + amount + ", depositOrWithdraw="
				+ depositOrWithdraw + ", date=" + date + ", balance=" + balance + "]";
	}

}
