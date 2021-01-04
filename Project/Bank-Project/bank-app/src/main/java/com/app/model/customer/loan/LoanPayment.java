package com.app.model.customer.loan;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class LoanPayment {
	
	private String paymentId;
	private String customerId;
	private BigDecimal paymentAmount;
	private Date dateOfPayment;
	private BigDecimal remainingAmount;
	
	public LoanPayment() {
		super();
	}
	
	public LoanPayment(String paymentId, String customerId, BigDecimal paymentAmount, Date dateOfPayment,
			BigDecimal remainingAmount) {
		super();
		this.paymentId = paymentId;
		this.customerId = customerId;
		this.paymentAmount = paymentAmount;
		this.dateOfPayment = dateOfPayment;
		this.remainingAmount = remainingAmount;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Date getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public BigDecimal getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(BigDecimal remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	@Override
	public boolean equals(Object anObject) {
		if(anObject == this) {
			return true;
		}
		
		if (anObject == null) {
			return false;
		}
		
		if(!(anObject instanceof LoanPayment)) {
			return false;
		}
		
		LoanPayment aLoanPayment = (LoanPayment) anObject;
		if (aLoanPayment.paymentId != paymentId || aLoanPayment.customerId != customerId ||
				aLoanPayment.paymentAmount != paymentAmount || aLoanPayment.dateOfPayment != dateOfPayment ||
				aLoanPayment.remainingAmount != remainingAmount) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(paymentId);
	}
	
	@Override
	public String toString() {
		return "LoanPayment [paymentId=" + paymentId + ", customerId=" + customerId + ", paymentAmount=" + paymentAmount
				+ ", dateOfPayment=" + dateOfPayment + ", remainingAmount=" + remainingAmount + "]";
	}

}
