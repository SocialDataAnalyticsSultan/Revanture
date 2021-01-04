package com.app.model.bank;

import java.util.Objects;

public class LoanInformation {
	
	private String loanType;
	private double interestRate;
	
	public LoanInformation() {
		super();
	}
	public LoanInformation(String loanType, double interestRate) {
		super();
		this.loanType = loanType;
		this.interestRate = interestRate;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
	public boolean equals(Object anObject) {
		if(anObject == this) {
			return true;
		}
		
		if (anObject == null) {
			return false;
		}
		
		if(!(anObject instanceof LoanInformation)) {
			return false;
		}
		
		LoanInformation aLoanInformation = (LoanInformation) anObject;
		if (aLoanInformation.loanType != loanType || aLoanInformation.interestRate != interestRate) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(loanType);
	}
	
	@Override
	public String toString() {
		return "LoanInformation [loanType=" + loanType + ", interestRate=" + interestRate + "]";
	}
	
}
