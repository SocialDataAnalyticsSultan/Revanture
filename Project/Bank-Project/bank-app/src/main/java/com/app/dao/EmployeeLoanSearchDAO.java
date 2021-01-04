package com.app.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.app.model.customer.loan.LoanApplication;
import com.app.model.customer.loan.LoanPayment;

public interface EmployeeLoanSearchDAO {
	
	public abstract LoanApplication getLoanApplicationByApplicationId(String loanApplicationId);
	public abstract LoanApplication getLoanApplicationByCustomerId(String customerId);
	
	public abstract List<LoanApplication> getLoanApplicationByLoanType(String loanType);
	public abstract List<LoanApplication> getLoanApplicationByApprovingEmployeeId(String approvingEmployeeId);
	public abstract List<LoanApplication> getLoanApplicationByDateOfLoanApplicationRange(Date start, Date end);
	public abstract List<LoanApplication> getLoanApplicationByLoanAmountRange(BigDecimal minLoanAmount, BigDecimal maxLoanAmount);
	public abstract List<LoanApplication> getLoanApplicationByDurationInMonthRange(int minLoanDurationInMonth, int maxLoanDurationInMonth);
	
	public abstract List<LoanPayment> getCustomerLoanPayment(String customerId);

}
