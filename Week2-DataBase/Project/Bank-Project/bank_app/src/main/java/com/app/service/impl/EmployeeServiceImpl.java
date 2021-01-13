package com.app.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.exception.BankException;
import com.app.main.BankMain;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;
import com.app.model.customer.CustomerLoan;
import com.app.model.customer.CustomerTransaction;
import com.app.service.EmployeeService;

public class EmployeeServiceImpl  implements EmployeeService{

	private static Logger log=Logger.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public int employeeLogIn() throws BankException, ClassNotFoundException, SQLException {
		
		int employeeId = 0;
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
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeId = employeeDAO.employeeLogIn(userName, password);
		
		return employeeId;
	}
	
	@Override
	public Customer getCustomerInformationById(int customerId) throws BankException, ClassNotFoundException, SQLException {
		Customer customer = null;
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		if (customerId<0) {
			throw new BankException("Invalid Customer Identification Number.");
		}else {
			customer = employeeDAO.getCustomerInformationById(customerId);
		}
		if (customer != null) {
			System.out.println(customer);
			System.out.println("\n\n");
		}else {
			log.info("There is no customer with identification number " + customerId);
		}
		return customer;
	}
	
	@Override
	public Customer getCustomerInformationByAccountNumber(String accountNumber) throws BankException, ClassNotFoundException, SQLException {
		Customer customer = null;
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		if(!accountNumber.matches("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}")) {
			throw new BankException("Invalid Account Number.");
		}else {
			customer = employeeDAO.getCustomerInformationByAccountNumber(accountNumber);
		}
		if (customer != null) {
			System.out.println(customer);
			System.out.println("\n\n");
		}else {
			log.info("There is no customer with an account number " + accountNumber);
		}
		return customer;
	}
	
	@Override
	public List<Customer> getCustomerInformationByFirstName(String customerFirstName) throws BankException, ClassNotFoundException, SQLException {
		List <Customer> customerList = null;
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		if(customerFirstName.matches("[0-9]{1,}") || customerFirstName.matches("[^a-zA-Z]")) {
			throw new BankException("Invalid First Name");
		}else {
			customerList = employeeDAO.getCustomerInformationByFirstName(customerFirstName);
		} 
		if(!customerList.isEmpty()) {
			System.out.println("\n\nThere are " + customerList.size() + " customers:  ");
			for (Customer customer:customerList) {
				System.out.println(customer);
			}
		}else {
			log.info("There is no customer with a first name " + customerFirstName);
		}
		return customerList;
	}
	
	@Override
	public List<Customer> getCustomerInformationByLastName(String customerLastName) throws BankException, ClassNotFoundException, SQLException {
		List <Customer> customerList = null;
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		if(customerLastName.matches("[0-9]{1,}") || customerLastName.matches("[^a-zA-Z]")) {
			throw new BankException("Invalid Last Name");
		}else {
			customerList = employeeDAO.getCustomerInformationByLastName(customerLastName);
		}
		if(!customerList.isEmpty()) {
			System.out.println("\n\nThere are " + customerList.size() + " customers:  ");
			for (Customer customer:customerList) {
				System.out.println(customer);
			}
		}else {
			log.info("There is no customer with a last name " + customerLastName);
		}
		return customerList;
	}
	
	@Override
	public List<Customer> getCustomerInformationByBankBranchId(int bankBranchId) throws BankException, ClassNotFoundException, SQLException {
		List <Customer> customerList = null;
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		if(bankBranchId < 100 || bankBranchId > 110) {
			throw new BankException("Invalid Bank Branch Identification Number");
		}else{
			customerList = employeeDAO.getCustomerInformationByBankBranchId(bankBranchId);
		}
		if(!customerList.isEmpty()) {
			System.out.println("\n\nThere are " + customerList.size() + " customers:  ");
			for (Customer customer:customerList) {
				System.out.println(customer);
			}
		}else {
			log.info("There is no customer at bank branch with identification number " + bankBranchId);
		}
		return customerList;
	}
	
	@Override
	public List<Customer> getCustomerByDateOfBirthRange(Date dateStart, Date dateEnd) throws BankException, ClassNotFoundException, SQLException {
		Date dateNow = new Date();
		List<Customer> customerList = null;
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		if (dateEnd.before(dateStart)|| dateNow.before(dateStart) || dateNow.before(dateEnd) ) {
			throw new BankException("Invalid Date.");
		}else {
			customerList = employeeDAO.getAllCustomerByDateOfBirthRange(dateStart, dateEnd);
			if (!customerList.isEmpty()) {
				System.out.println("\n\nThere are " + customerList.size() + " customers : ") ;
				for (Customer customer:customerList) {
					System.out.println(customer);
				}
			}else {
				SimpleDateFormat ftdate = new SimpleDateFormat ("MM/dd/yyyy");
				log.info("There is no customer with a date of birth between  " + ftdate.format(dateStart) + " and " + ftdate.format(dateEnd));
			}
		}
		return customerList;
	}
	
	@Override
	public CustomerAccount getCustomerAccountById(int customerId) throws ClassNotFoundException, SQLException, BankException {
		CustomerAccount customerAccount = null;
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		if (customerId<0) {
			throw new BankException("Invalid Customer Identification Number.");
		}else {
			customerAccount = employeeDAO.getCustomerAccountById(customerId);
			if (customerAccount != null) {
				System.out.println(customerAccount);
				System.out.println("\n\n");
			}else {
				log.info("There is no customer with identification number " + customerId);
			}
		}
		return customerAccount;
	}
	
	@Override
	public CustomerAccount getCustomerAccountByAccountNumber(String accountNumber) throws ClassNotFoundException, SQLException, BankException {
		CustomerAccount customerAccount = null;
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		if(!accountNumber.matches("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}")) {
			throw new BankException("Invalid Customer Account.");
		}else {
			customerAccount = employeeDAO.getCustomerAccountByAccountNumber(accountNumber);
			if (customerAccount != null) {
				System.out.println(customerAccount);
				System.out.println("\n\n");
			}else {
				log.info("There is no customer with an account number " + accountNumber);
			}
		}
		return customerAccount;
	}
	
	@Override
	public List<CustomerAccount> getCustomerAccountByBankBranchId(int bankBranchId) throws ClassNotFoundException, SQLException, BankException {
		List<CustomerAccount> customerAccountList = new ArrayList<>();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		if(bankBranchId < 100 || bankBranchId > 110) {
			throw new BankException("Invalid Bank Branch Identification Number");
		}else {
			customerAccountList = employeeDAO.getCustomerAccountByBankBranchId(bankBranchId);
			if(!customerAccountList.isEmpty()) {
				System.out.println("\n\nThere are " + customerAccountList.size() + " customers in the bank with branch ID:  " + bankBranchId);
				for (CustomerAccount customerAccount:customerAccountList) {
					System.out.println(customerAccount);	
				}
				System.out.println("\n\n");	
			}else {
				log.info("There is no customer at bank branch with identification number " + bankBranchId);
			}	
		}
		return customerAccountList;
	}
	
	@Override
	public List<CustomerTransaction> getCustomerTransactionByCustomerId(int customerId) throws ClassNotFoundException, SQLException, BankException {
		List<CustomerTransaction> customerTransactionList = new ArrayList<>();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		if (customerId<0) {
			throw new BankException("Invalid Customer Identification Number.");
		}else {
			customerTransactionList = employeeDAO.getCustomerTransactionByCustomerId(customerId);
			if (!customerTransactionList.isEmpty()) {
				Collections.sort(customerTransactionList, (CustomerTransaction customerTransaction1, CustomerTransaction customerTransaction2) -> {
					Date date1 = customerTransaction1.getTransactionTime();
					Date date2 = customerTransaction2.getTransactionTime();
					return date1.compareTo(date2);
				});
				System.out.println("\n\nThere are " + customerTransactionList.size() + " transactions:  ") ;
				for (CustomerTransaction customerTransaction:customerTransactionList) {
					System.out.println(customerTransaction);
				}
			}else {
				log.info("There is no transaction of a customer with identification number " + customerId);
			}
		}
		return customerTransactionList;
	}
	
	@Override
	public List<CustomerTransaction> getCustomerTransactionByAccountNumber(String accountNumber) throws BankException, ClassNotFoundException, SQLException {
		List<CustomerTransaction> customerTransactionList = new ArrayList<>();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		if(!accountNumber.matches("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}")) {
			throw new BankException("Invalid Customer Account.");
		}else {
			customerTransactionList = employeeDAO.getCustomerTransactionByAccountNumber(accountNumber);
			if (!customerTransactionList.isEmpty()) {
				Collections.sort(customerTransactionList, (CustomerTransaction customerTransaction1, CustomerTransaction customerTransaction2) -> {
					Date date1 = customerTransaction1.getTransactionTime();
					Date date2 = customerTransaction2.getTransactionTime();
					return date1.compareTo(date2);
				});
				System.out.println("\n\nThere are " + customerTransactionList.size() + " transactions:  ") ;
				for (CustomerTransaction customerTransaction:customerTransactionList) {
					System.out.println(customerTransaction);
				}
			}else {
				log.info("There is no transaction of a customer with an account number " + accountNumber);
			}
		}
		return customerTransactionList;
	}
	
	@Override
	public List<CustomerTransaction> getAllCustomerTransactionByDate(Date date) throws ClassNotFoundException, SQLException, ParseException, BankException{
		List<CustomerTransaction> customerTransactionList = new ArrayList<>();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dateStart = sdf.parse("2019-01-01");  //Bank establishment date
		Date dateEnd = new Date();
		if (date.before(dateStart)|| date.after(dateEnd)) {
			throw new BankException("Invalid Date.");
		}else {
			customerTransactionList = employeeDAO.getAllCustomerTransactionByStartDate(date);
			if (!customerTransactionList.isEmpty()) {
				Collections.sort(customerTransactionList, (CustomerTransaction customerTransaction1, CustomerTransaction customerTransaction2) -> {
					Date date1 = customerTransaction1.getTransactionTime();
					Date date2 = customerTransaction2.getTransactionTime();
					return date1.compareTo(date2);
				});
				SimpleDateFormat ftdate = new SimpleDateFormat ("dd/MM/yyyy");
				System.out.println("\n\nThere are " + customerTransactionList.size() + " transactions since : " + ftdate.format(date)) ;
				for (CustomerTransaction customerTransaction:customerTransactionList) {
					System.out.println(customerTransaction);
				}
			}else {
				SimpleDateFormat ftdate = new SimpleDateFormat ("dd/MM/yyyy");
				log.info("There is no transaction of a customer after the date " + ftdate.format(date));
			}
		}
		return customerTransactionList;
	}

	@Override
	public List<CustomerLoan> getAllCustomerLoanApplication() throws ClassNotFoundException, SQLException {
		List<CustomerLoan> allCustomerLoanList = new ArrayList<>();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		allCustomerLoanList = employeeDAO.getAllCustomerLoanApplication();
		if (!allCustomerLoanList.isEmpty()) {
			Collections.sort(allCustomerLoanList, (CustomerLoan customerLoan1, CustomerLoan customerLoan2) -> {
				Date date1 = customerLoan1.getDateOfApplication();
				Date date2 = customerLoan2.getDateOfApplication();
				return date1.compareTo(date2);
			});
			for (CustomerLoan customerLoan:allCustomerLoanList) {
				System.out.println(customerLoan);
			}
		}else {
			log.info("There is no loan application");
		}
		
		return allCustomerLoanList;
	}
	
}
