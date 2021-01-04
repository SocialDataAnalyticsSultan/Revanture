package com.app.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BankException;
import com.app.model.customer.Customer;
import com.app.model.customer.account.Account;
import com.app.service.CustomerApplicationService;
import com.app.service.CustomerService;
import com.app.model.customer.account.AccountHistory;

public class CustomerServiceImpl implements CustomerService {
	
	private static Logger logBank =Logger.getLogger(CustomerServiceImpl.class);
	
	@Override
	public boolean customerLogIn() throws BankException {
		System.out.println();
		System.out.println("Please enter your account.");
		
		String username = null;
		String password = null;
		int logInAttempt = 0;
		boolean userLogInValidCohice = false;
		
		Scanner sc = new Scanner(System.in);
		do {
			logInAttempt++;
			
			try {
				System.out.println("Username: ");
				username = sc.nextLine();
				System.out.println("Password: ");
				password = sc.nextLine();
				
				userLogInValidCohice = true;
						
			}catch(NullPointerException e) {
				logBank.error(e.getMessage());
			}
			
			if (logInAttempt==3) {
				System.out.println();
				System.out.println("Please try to enter your account later...");
				System.out.println("HAVE NICE DAY!!!!");
			}
			
		}while(logInAttempt<3 && !userLogInValidCohice);
		
		sc.close();
		//Check database for username and password
		if (userLogInValidCohice)
			try {
				{
					CustomerDAO validateCustomer = new CustomerDAOImpl();
					return validateCustomer.validateLogInInformation(username, password);
				}
			} catch (BankException e) {
				logBank.error(e.getMessage());
			}
		
		return false;
	}

	
	@Override
	public Customer customerRegistration() throws ParseException, ClassNotFoundException, SQLException {
		Customer newCustomer = new Customer();
		newCustomer = null;
		
		try {
			CustomerApplicationService customerApplication = new CustomerApplicationServiceImpl();
			newCustomer = customerApplication.customerApplication();
		}catch (BankException e) {
			logBank.error(e.getMessage());
		}
		
		return newCustomer;
	}
	
	public void customerAccountInformation() throws BankException, ClassNotFoundException, SQLException{
		
		CustomerDAO customerDao = new CustomerDAOImpl();
		Account customerAccount= null;
		
		int customerId  = 0;
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Please Enter Your Customer Identification Number: ");
			customerId  = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
		}
		
		try {
			if (customerId>0) {
				customerAccount = customerDao.getAccountInformation(customerId);
			}else {
				throw new BankException("Invalid Customer Identification Number");
			}
		} catch (ClassNotFoundException | SQLException | BankException e) {
			e.printStackTrace();
		}
		
		if(customerAccount != null) {
			customerAccount.toString();
		}else {
			System.out.println("There is no customer checking accout with Customer Identification Number " + customerId);
		}
		sc.close();
	}

	
	@Override
	public void customerMakeDeposit() throws BankException, ClassNotFoundException, SQLException {
		CustomerDAO customerDao = new CustomerDAOImpl();
		int customerId  = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Please Enter Your Customer Identification Number: ");
			customerId  = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
		}
		
		if (customerId>0) {
			System.out.print("Please Enter the Amount You Want to Deposit: ");
			Double damount = Double.parseDouble(sc.nextLine());
			if (damount<0) {
				throw new BankException("Invalid Amount to Deposit");
			}else {
				try {
					BigDecimal amount = BigDecimal.valueOf(damount);
					customerDao.makeDeposit(amount, customerId);
				}catch (NumberFormatException e) {
				}
			}
		}else {
			throw new BankException("Invalid Customer Identification Number");
		}
		
		sc.close();
	}


	@Override
	public void customerMakeWithDraw() throws BankException, ClassNotFoundException, SQLException {
		CustomerDAO customerDao = new CustomerDAOImpl();
		int customerId  = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Please Enter Your Customer Identification Number: ");
			customerId  = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			throw e;
		}
		
		if (customerId>0) {
			System.out.print("Please Enter the Amount You Want to Withdraw: ");
			Double wamount = Double.parseDouble(sc.nextLine());
			if (wamount<0) {
				throw new BankException("Invalid Amount to Deposit");
			}else {
				try {
					BigDecimal amount = BigDecimal.valueOf(wamount);
					customerDao.makeWithDraw(amount, customerId);
				}catch (NumberFormatException e) {
				}
			}
		}else {
			throw new BankException("Invalid Customer Identification Number");
			}
		}


	@Override
	public void customerAccountHistory() throws BankException, ClassNotFoundException, SQLException {
		CustomerDAO customerDao = new CustomerDAOImpl();
		int customerId  = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Please Enter Your Customer Identification Number: ");
			customerId  = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			throw e;
		}
		if (customerId>0) {
			List<AccountHistory> customerHistory = customerDao.getAccountHistory(customerId);
			for (AccountHistory hist: customerHistory) {
				hist.toString();
			}
			
		}else {
			throw new BankException("Invalid Customer Identification Number");
			}
	}


	@Override
	public void customerMakeTransaction() throws BankException, ClassNotFoundException, SQLException, ParseException {
		CustomerDAO customerDao = new CustomerDAOImpl();
		int customerId  = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Please Enter Your Customer Identification Number: ");
			customerId  = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			throw e;
		}
		
		String transferAccount = null;
		System.out.println("Enter the Transfer Account Number: ");
		transferAccount = sc.nextLine();
		if (!transferAccount.matches("[0-9]{12}")) {
			throw new BankException("Invalid Account Number");
		}	
		
		BigDecimal transferAmonth = BigDecimal.ZERO;
		
		try {
			System.out.println("Enter the Transer Amounth: ");
			double dtransfer = Double.parseDouble(sc.nextLine());
			transferAmonth  = BigDecimal.valueOf(dtransfer);
		} catch (NumberFormatException e) {
			throw e;
		}
		customerDao.makeTransansaction(customerId, transferAccount, transferAmonth);
		
	}
}


