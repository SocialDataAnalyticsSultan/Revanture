package com.app.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.app.dao.EmployeeLoanSearchDAO;
import com.app.model.customer.loan.LoanApplication;
import com.app.model.customer.loan.LoanPayment;

public class EmployeeLoanSearchDAOImpl implements EmployeeLoanSearchDAO{

	@Override
	public LoanApplication getLoanApplicationByApplicationId(String loanApplicationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanApplication getLoanApplicationByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanApplication> getLoanApplicationByLoanType(String loanType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanApplication> getLoanApplicationByApprovingEmployeeId(String approvingEmployeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanApplication> getLoanApplicationByDateOfLoanApplicationRange(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanApplication> getLoanApplicationByLoanAmountRange(BigDecimal minLoanAmount,
			BigDecimal maxLoanAmount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanApplication> getLoanApplicationByDurationInMonthRange(int minLoanDurationInMonth,
			int maxLoanDurationInMonth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanPayment> getCustomerLoanPayment(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
