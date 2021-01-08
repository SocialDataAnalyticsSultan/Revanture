package com.app.model.customer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class CustomerLoan {
	
	private String loanApplicationId;
	private int customerId;
	private int loanId;
	private Date dateOfApplication;
	private String status;
	private BigDecimal loanAmount;
	private int durationYear;
	private int approvingEmployeeId;
	private BigDecimal totalPaymentAmount;
	private BigDecimal monthlyPaymentAmount;
	
	public CustomerLoan() {
		super();
	}
	
	public CustomerLoan(String loanApplicationId, int customerId, int loanId, Date dateOfApplication, String status,
			BigDecimal loanAmount, int durationYear, int approvingEmployeeId, BigDecimal totalPaymentAmount,
			BigDecimal monthlyPaymentAmount) {
		super();
		this.loanApplicationId = loanApplicationId;
		this.customerId = customerId;
		this.loanId = loanId;
		this.dateOfApplication = dateOfApplication;
		this.status = status;
		this.loanAmount = loanAmount;
		this.durationYear = durationYear;
		this.approvingEmployeeId = approvingEmployeeId;
		this.totalPaymentAmount = totalPaymentAmount;
		this.monthlyPaymentAmount = monthlyPaymentAmount;
	}

	public String getLoanApplicationId() {
		return loanApplicationId;
	}

	public void setLoanApplicationId(String loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public Date getDateOfApplication() {
		return dateOfApplication;
	}

	public void setDateOfApplication(Date dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getDurationYear() {
		return durationYear;
	}

	public void setDurationYear(int durationYear) {
		this.durationYear = durationYear;
	}

	public int getApprovingEmployeeId() {
		return approvingEmployeeId;
	}

	public void setApprovingEmployeeId(int approvingEmployeeId) {
		this.approvingEmployeeId = approvingEmployeeId;
	}

	public BigDecimal getTotalPaymentAmount() {
		return totalPaymentAmount;
	}

	public void setTotalPaymentAmount(BigDecimal totalPaymentAmount) {
		this.totalPaymentAmount = totalPaymentAmount;
	}

	public BigDecimal getMonthlyPaymentAmount() {
		return monthlyPaymentAmount;
	}

	public void setMonthlyPaymentAmount(BigDecimal monthlyPaymentAmount) {
		this.monthlyPaymentAmount = monthlyPaymentAmount;
	}

	@Override
	public String toString() {
		return "customerLoan [loanApplicationId=" + loanApplicationId + ", customerId=" + customerId + ", loanId="
				+ loanId + ", dateOfApplication=" + dateOfApplication + ", status=" + status + ", loanAmount="
				+ loanAmount + ", durationYear=" + durationYear + ", approvingEmployeeId=" + approvingEmployeeId
				+ ", totalPaymentAmount=" + totalPaymentAmount + ", monthlyPaymentAmount=" + monthlyPaymentAmount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(approvingEmployeeId, customerId, dateOfApplication, loanAmount, loanApplicationId, loanId,
				status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CustomerLoan)) {
			return false;
		}
		CustomerLoan other = (CustomerLoan) obj;
		return approvingEmployeeId == other.approvingEmployeeId && customerId == other.customerId
				&& Objects.equals(dateOfApplication, other.dateOfApplication)
				&& Objects.equals(loanAmount, other.loanAmount)
				&& Objects.equals(loanApplicationId, other.loanApplicationId) && loanId == other.loanId
				&& Objects.equals(status, other.status);
	}
	
	
}
