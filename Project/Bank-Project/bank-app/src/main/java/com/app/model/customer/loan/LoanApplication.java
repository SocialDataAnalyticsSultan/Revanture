package com.app.model.customer.loan;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class LoanApplication {
	private String loanApplicationId;
	private String customerId;
	private String loanType;
	private Date dateOfLoanApplication;
	private String status;
	private BigDecimal loanAmount;
	private int durationInMonth;
	private String approvingEmployeeId;
	
	public LoanApplication() {
		super();
	}
	
	public LoanApplication(String loanApplicationId, String customerId, String loanType, Date dateOfLoanApplication,
			String status, BigDecimal loanAmount, int durationInMonth, String approvingEmployeeId) {
		super();
		this.loanApplicationId = loanApplicationId;
		this.customerId = customerId;
		this.loanType = loanType;
		this.dateOfLoanApplication = dateOfLoanApplication;
		this.status = status;
		this.loanAmount = loanAmount;
		this.durationInMonth = durationInMonth;
		this.approvingEmployeeId = approvingEmployeeId;
	}

	public String getLoanApplicationId() {
		return loanApplicationId;
	}

	public void setLoanApplicationId(String loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Date getDateOfLoanApplication() {
		return dateOfLoanApplication;
	}

	public void setDateOfLoanApplication(Date dateOfLoanApplication) {
		this.dateOfLoanApplication = dateOfLoanApplication;
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

	public int getDurationInMonth() {
		return durationInMonth;
	}

	public void setDurationInMonth(int durationInMonth) {
		this.durationInMonth = durationInMonth;
	}

	public String getApprovingEmployeeId() {
		return approvingEmployeeId;
	}

	public void setApprovingEmployeeId(String approvingEmployeeId) {
		this.approvingEmployeeId = approvingEmployeeId;
	}
	
	@Override
	public boolean equals(Object anObject) {
		if(anObject == this) {
			return true;
		}
		
		if (anObject == null) {
			return false;
		}
		
		if(!(anObject instanceof LoanApplication)) {
			return false;
		}
		
		LoanApplication aLoanApplication = (LoanApplication) anObject;
		if (aLoanApplication.loanApplicationId != loanApplicationId || aLoanApplication.customerId != customerId ||
				aLoanApplication.loanType != loanType || aLoanApplication.dateOfLoanApplication != dateOfLoanApplication ||
				aLoanApplication.status != status || aLoanApplication.loanAmount != loanAmount || 
				aLoanApplication.durationInMonth != durationInMonth || aLoanApplication.approvingEmployeeId != approvingEmployeeId) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(loanApplicationId);
	}

	@Override
	public String toString() {
		return "LoanApplication [loanApplicationId=" + loanApplicationId + ", customerId=" + customerId + ", loanType="
				+ loanType + ", dateOfLoanApplication=" + dateOfLoanApplication + ", status=" + status + ", loanAmount="
				+ loanAmount + ", durationInMonth=" + durationInMonth + ", approvingEmployeeId=" + approvingEmployeeId
				+ "]";
	}

}
