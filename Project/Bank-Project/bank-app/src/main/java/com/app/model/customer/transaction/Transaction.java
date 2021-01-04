package com.app.model.customer.transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Transaction {
	
	private int transactionId;
	private int customerId;
	private String transferAccountNumber;
	private BigDecimal transferAmount; 
	private Date dateOfTransfer;
	
	public Transaction() {
		super();
	}
	
	public Transaction(int transactionId, int customerId, String transferAccountNumber, BigDecimal transferAmount,
			Date dateOfTransfer) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.transferAccountNumber = transferAccountNumber;
		this.transferAmount = transferAmount;
		this.dateOfTransfer = dateOfTransfer;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getTransferAccountNumber() {
		return transferAccountNumber;
	}

	public void setTransferAccountNumber(String transferAccountNumber) {
		this.transferAccountNumber = transferAccountNumber;
	}

	public BigDecimal getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(BigDecimal transferAmount) {
		this.transferAmount = transferAmount;
	}

	public Date getDateOfTransfer() {
		return dateOfTransfer;
	}

	public void setDateOfTransfer(Date dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}

	@Override
	public boolean equals(Object anObject) {
		if(anObject == this) {
			return true;
		}
		
		if (anObject == null) {
			return false;
		}
		
		if(!(anObject instanceof Transaction)) {
			return false;
		}
		
		Transaction aTransaction = (Transaction) anObject;
		if (aTransaction.transactionId != transactionId || aTransaction.customerId != customerId || 
				aTransaction.transferAccountNumber != transferAccountNumber || 
				aTransaction.transferAmount != transferAmount || aTransaction.dateOfTransfer != dateOfTransfer) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(transactionId);
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customerId=" + customerId + ", transferAccountNumber="
				+ transferAccountNumber + ", transferAmount=" + transferAmount + ", dateOfTransfer=" + dateOfTransfer
				+ "]";
	}
	
}