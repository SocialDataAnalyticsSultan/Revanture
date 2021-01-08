package com.app.model.bank;

import java.util.Objects;

public class Loan {
	
	private int loanId;
	private String loanType;
	private double interestRate;
	
	public Loan() {
		super();
	}
	
	public Loan(int loanId, String loanType, double interestRate) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.interestRate = interestRate;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
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
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanType=" + loanType + ", interestRate=" + interestRate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(loanId, loanType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Loan)) {
			return false;
		}
		Loan other = (Loan) obj;
		return loanId == other.loanId && Objects.equals(loanType, other.loanType);
	}
	
}
