package com.app.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BankException;
import com.app.model.Address;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;
import com.app.model.customer.CustomerTransaction;
import com.app.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	private static Logger log=Logger.getLogger(CustomerServiceImpl.class);
	
	@Override
	public int customerLogIn() throws NumberFormatException, BankException, ClassNotFoundException, SQLException {
		int customerId = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Username: ");
		String userName = sc.nextLine();
		
		if(userName.isBlank() || userName.length()<4) {
			throw new BankException("Invalid Username.");
		}
		System.out.print("Password: ");
		String password = sc.nextLine();
		
		if(password.isBlank() || password.length()<4) {
			throw new BankException("Invalid Password.");
		}
		
		CustomerDAO customerDAO = new CustomerDAOImpl();
		customerId = customerDAO.customerLogIn(userName, password);
		
		return customerId;
	}

	@Override
	public Customer getCustomerInformation(int customerId) throws ClassNotFoundException, SQLException, BankException {
		Customer customer = null;
		CustomerDAO customerDAO = new CustomerDAOImpl(); 
		customer = customerDAO.getCustomerInformation(customerId);
		if (customer != null) {
			System.out.println("Your Personal Information:");
			System.out.println(customer);
		}
		return customer;
	}

	@Override
	public CustomerAccount getCustomerAccount(int customerId) throws ClassNotFoundException, SQLException {
		CustomerAccount customerAccount = null;
		CustomerDAO customerDAO = new CustomerDAOImpl(); 
		customerAccount = customerDAO.getCustomerAccount(customerId);
		if (customerAccount != null) {
			System.out.println("Your Account Information:");
			System.out.println(customerAccount);
		}
		return customerAccount;
	}

	@Override
	public List<CustomerTransaction> getCustomerTransaction(int customerId) throws ClassNotFoundException, SQLException {
		List <CustomerTransaction> customerTransactionList = new ArrayList<>();
		CustomerDAO customerDAO = new CustomerDAOImpl(); 
		customerTransactionList = customerDAO.getCustomerTransaction(customerId);
		if (!customerTransactionList.isEmpty()) {
			for (CustomerTransaction customerTransaction:customerTransactionList) {
				System.out.println(customerTransaction);
			}
		}else {
			log.info("There is no transaction");
		}
		return customerTransactionList;
	}

	@Override
	public boolean updateCustomerAddress(int customerId, String street, String city, String state, String country, String zipcode) throws BankException, ClassNotFoundException, SQLException {
		boolean isAddressUpdate = false;
		if(!zipcode.matches("[0-9]{4}")) {
			throw new BankException("Invalid Zipcode.");	
		}else {
			Address address = new Address(street, city, state, country, zipcode);
			CustomerDAO customerDAO = new CustomerDAOImpl();
			isAddressUpdate = customerDAO.updateCustomerAddress(customerId, address);
		}
		return isAddressUpdate;
	}

	@Override
	public boolean updateCustomerPhoneNumber(int customerId, String phoneNumber) throws BankException, ClassNotFoundException, SQLException {
		boolean isPhoneNumberUpdate = false;
		if(!phoneNumber.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")) {
			throw new BankException("Invalid Phone Number.");
		}else {
			CustomerDAO customerDAO = new CustomerDAOImpl();
			isPhoneNumberUpdate = customerDAO.updateCustomerPhoneNumber(customerId, phoneNumber);
		}
		return isPhoneNumberUpdate;
	}

	@Override
	public boolean updateCustomerEmail(int customerId, String email) throws BankException, ClassNotFoundException, SQLException {
		boolean isEmailUpdate = false;
		if(!email.matches("[^\s]{1,}@[^\s]{1,}")) {
			throw new BankException("Invalid Email.");
		}else {
			CustomerDAO customerDAO = new CustomerDAOImpl();
			isEmailUpdate = customerDAO.updateCustomerEmail(customerId, email);
		}
		return isEmailUpdate;
	}

	@Override
	public boolean updateCustomerPassword(int customerId, String password) throws BankException, ClassNotFoundException, SQLException {
		boolean isPasswordUpdate = false;
		if(password.isBlank() || password.length()<4) {
			throw new BankException("Invalid Password.");
		}else {
			CustomerDAO customerDAO = new CustomerDAOImpl();
			isPasswordUpdate = customerDAO.updateCustomerPassword(customerId, password);
		}
		return isPasswordUpdate;
	}

	@Override
	public boolean makeCustomerDeposit(int customerId, BigDecimal deposit) throws BankException, ClassNotFoundException, SQLException {
		boolean isDeposit = false;
		if(deposit.doubleValue() <= 0){
			throw new BankException("Invalid Deposit Amount.");
		}else {
			CustomerDAO customerDAO = new CustomerDAOImpl();
			isDeposit = customerDAO.makeCustomerDeposit(customerId, deposit);
		}
		return isDeposit;
	}

	@Override
	public boolean makeCustomerWithDraw(int customerId, BigDecimal withDraw) throws BankException, ClassNotFoundException, SQLException {
		boolean isWithDraw = false;
		if(withDraw.doubleValue() <= 0){
			throw new BankException("Invalid Withdraw Amount.");
		}else {
			CustomerDAO customerDAO = new CustomerDAOImpl();
			isWithDraw = customerDAO.makeCustomerWithDraw(customerId, withDraw);
		}
		return isWithDraw;
	}

	@Override
	public boolean makeCustomerTransfer(int customerId, BigDecimal transfer, String transferAccountNumber) throws BankException, ClassNotFoundException, SQLException {
		boolean isTransfer = false;
		if(transfer.doubleValue() <= 0){
			throw new BankException("Invalid Transfer Amount.");
		}else if(!transferAccountNumber.matches("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}")){
			throw new BankException("Invalid Transfer Account Number.");
		}else {
			CustomerDAO customerDAO = new CustomerDAOImpl();
			isTransfer = customerDAO.makeCustomerTransfer(customerId, transfer, transferAccountNumber);
		}
		return isTransfer;
	}

	@Override
	public boolean makeLoanApplication(int customerId, int loanTypeId, BigDecimal loanAmount, int loanDurationYear) throws BankException, ClassNotFoundException, SQLException {
		boolean isLoanApplication = false;
		if(loanTypeId < 100 ||  loanTypeId > 104 ) {
			throw new BankException("Invalid Loan Type Idendification Number.");
		} else if(loanAmount.doubleValue()<0) {
			throw new BankException("Invalid Loan Amount.");
		} else if(loanDurationYear<0) {
			throw new BankException("Invalid Loan Payment Duration.");
		}else {
			CustomerDAO customerDAO = new CustomerDAOImpl();
			isLoanApplication = customerDAO.makeLoanApplication(customerId, loanTypeId, loanAmount, loanDurationYear);
		}
		return isLoanApplication;
	}

	@Override
	public boolean makeCustomerLoanPayment(int customerId, BigDecimal loanPayment) throws BankException, ClassNotFoundException, SQLException {
		boolean isLoanPayment = false;
		if(loanPayment.doubleValue() <= 0){
			throw new BankException("Invalid Payment Amount.");
		}else {
			CustomerDAO customerDAO = new CustomerDAOImpl();
			isLoanPayment = customerDAO.makeCustomerLoanPayment(customerId, loanPayment);
		}
		
		return isLoanPayment;
	}
	
	

}
