package com.app.model.customer;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class CustomerTransaction {
	
	private String transactionId;
	private int customerId;
	private Timestamp transactionTime;
	private String transactionType;
	private BigDecimal transactionAmount;
	private BigDecimal balance;
	
	public CustomerTransaction() {
		super();
	}
	
	public CustomerTransaction(String transactionId, int customerId, Timestamp transactionTime, String transactionType,
			BigDecimal transactionAmount, BigDecimal balance) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.transactionTime = transactionTime;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.balance = balance;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Timestamp getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Timestamp transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "CustomerTransaction [transactionId=" + transactionId + ", customerId=" + customerId
				+ ", transactionTime=" + transactionTime + ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, transactionId, transactionTime, transactionType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CustomerTransaction)) {
			return false;
		}
		CustomerTransaction other = (CustomerTransaction) obj;
		return customerId == other.customerId && Objects.equals(transactionId, other.transactionId)
				&& Objects.equals(transactionTime, other.transactionTime)
				&& Objects.equals(transactionType, other.transactionType);
	}
	
	
}
