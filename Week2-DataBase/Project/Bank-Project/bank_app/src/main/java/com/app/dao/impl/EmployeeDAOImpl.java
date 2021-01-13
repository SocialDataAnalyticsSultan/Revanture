package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeDAO;
import com.app.dao.dbutil.PostgresSqlConnection;
import com.app.exception.BankException;
import com.app.model.Address;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;
import com.app.model.customer.CustomerLoan;
import com.app.model.customer.CustomerTransaction;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static Logger log=Logger.getLogger(EmployeeDAOImpl.class);

	@Override
	public int employeeLogIn(String userName, String password) throws ClassNotFoundException, SQLException, BankException {
		
		int employeeId = 0;
		String employeeFirstName = null;
		String employeeLastName = null;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			
			String sql = "SELECT employee_id, first_name, last_name "
					+ "FROM asya_bank.employee "
					+ "WHERE username = ? AND password = ?; ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				employeeId = resultSet.getInt("employee_id");
				employeeFirstName = resultSet.getString("first_name");
				employeeLastName = resultSet.getString("last_name");
				System.out.println("\nWellcome " + employeeFirstName.toUpperCase() + " " + employeeLastName.toUpperCase());
			}else {
				throw new BankException("Wrong Login Credentials");
			}
			
		}
		return employeeId;
	}
	
	
	@Override
	public Customer getCustomerInformationById(int customerId) throws ClassNotFoundException, SQLException {
		Customer customer = null;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT customer_id, first_name, last_name, date_of_birth, gender, "
					+ "marital_status, social_security_number, nationality, phone_number, email, "
					+ "street, city, state, country, zipcode, occupation, yearly_income, "
					+ "credit_score,username, password  "
					+ "FROM asya_bank.customer "
					+ "WHERE customer_id = ? ; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer = new Customer();
				customer.setCustomerId(resultSet.getInt("customer_id"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setDateOfBirth(resultSet.getDate("date_of_birth"));
				customer.setGender(resultSet.getString("gender"));
				customer.setMaritalStatus(resultSet.getString("marital_status"));
				customer.setSocialSecurityNumber(resultSet.getString("social_security_number"));
				customer.setNationality(resultSet.getString("nationality"));
				customer.setPhoneNumber(resultSet.getString("phone_number"));
				customer.setEmail(resultSet.getString("email"));
				customer.setAddress(new Address(resultSet.getString("street"), resultSet.getString("city"), 
						resultSet.getString("state"), resultSet.getString("country"), resultSet.getString("zipcode")));
				customer.setOccupation(resultSet.getString("occupation"));
				customer.setYearlyIncome(resultSet.getBigDecimal("yearly_income"));
				customer.setCreditScore(resultSet.getInt("credit_score"));
				customer.setUserName(resultSet.getString("username"));
				customer.setPassword(resultSet.getString("password"));
			}
		}
		return customer;
	}
	
	@Override
	public Customer getCustomerInformationByAccountNumber(String accountNumber) throws ClassNotFoundException, SQLException {
		Customer customer = null;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT c.customer_id, first_name, last_name, date_of_birth, gender, "
					+ "marital_status, social_security_number, nationality, phone_number, email, "
					+ "street, city, state, country, zipcode, occupation, yearly_income, "
					+ "credit_score,username, password  "
					+ "FROM asya_bank.customer AS c "
					+ "JOIN asya_bank.customer_account AS ca "
					+ "ON c.customer_id = ca.customer_id "
					+ "WHERE account_number = ? ; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, accountNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer = new Customer();
				customer.setCustomerId(resultSet.getInt("customer_id"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setDateOfBirth(resultSet.getDate("date_of_birth"));
				customer.setGender(resultSet.getString("gender"));
				customer.setMaritalStatus(resultSet.getString("marital_status"));
				customer.setSocialSecurityNumber(resultSet.getString("social_security_number"));
				customer.setNationality(resultSet.getString("nationality"));
				customer.setPhoneNumber(resultSet.getString("phone_number"));
				customer.setEmail(resultSet.getString("email"));
				customer.setAddress(new Address(resultSet.getString("street"), resultSet.getString("city"), 
						resultSet.getString("state"), resultSet.getString("country"), resultSet.getString("zipcode")));
				customer.setOccupation(resultSet.getString("occupation"));
				customer.setYearlyIncome(resultSet.getBigDecimal("yearly_income"));
				customer.setCreditScore(resultSet.getInt("credit_score"));
				customer.setUserName(resultSet.getString("username"));
				customer.setPassword(resultSet.getString("password"));
			}
		}
		return customer;
	}
	
	@Override
	public List<Customer> getCustomerInformationByFirstName(String customerFirstName) throws ClassNotFoundException, SQLException, BankException {
		List<Customer> customerList = new ArrayList<>();
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT customer_id, first_name, last_name, date_of_birth, gender, "
					+ "marital_status, social_security_number, nationality, phone_number, email, "
					+ "street, city, state, country, zipcode, occupation, yearly_income, "
					+ "credit_score,username, password  "
					+ "FROM asya_bank.customer "
					+ "WHERE first_name = ? ; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customerFirstName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				Customer customerTemp = new Customer();
				customerTemp.setCustomerId(resultSet.getInt("customer_id"));
				customerTemp.setFirstName(resultSet.getString("first_name"));
				customerTemp.setLastName(resultSet.getString("last_name"));
				customerTemp.setDateOfBirth(resultSet.getDate("date_of_birth"));
				customerTemp.setGender(resultSet.getString("gender"));
				customerTemp.setMaritalStatus(resultSet.getString("marital_status"));
				customerTemp.setSocialSecurityNumber(resultSet.getString("social_security_number"));
				customerTemp.setNationality(resultSet.getString("nationality"));
				customerTemp.setPhoneNumber(resultSet.getString("phone_number"));
				customerTemp.setEmail(resultSet.getString("email"));
				customerTemp.setAddress(new Address(resultSet.getString("street"), resultSet.getString("city"), 
						resultSet.getString("state"), resultSet.getString("country"), resultSet.getString("zipcode")));
				customerTemp.setOccupation(resultSet.getString("occupation"));
				customerTemp.setYearlyIncome(resultSet.getBigDecimal("yearly_income"));
				customerTemp.setCreditScore(resultSet.getInt("credit_score"));
				customerTemp.setUserName(resultSet.getString("username"));
				customerTemp.setPassword(resultSet.getString("password"));
				customerList.add(customerTemp);
			}
		}
		return customerList;
	}
	
	@Override
	public List<Customer> getCustomerInformationByLastName(String customerLastName) throws ClassNotFoundException, SQLException, BankException {
		List<Customer> customerList = new ArrayList<>();
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT customer_id, first_name, last_name, date_of_birth, gender, "
					+ "marital_status, social_security_number, nationality, phone_number, email, "
					+ "street, city, state, country, zipcode, occupation, yearly_income, "
					+ "credit_score,username, password  "
					+ "FROM asya_bank.customer "
					+ "WHERE last_name = ? ; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customerLastName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customerTemp = new Customer();
				customerTemp.setCustomerId(resultSet.getInt("customer_id"));
				customerTemp.setFirstName(resultSet.getString("first_name"));
				customerTemp.setLastName(resultSet.getString("last_name"));
				customerTemp.setDateOfBirth(resultSet.getDate("date_of_birth"));
				customerTemp.setGender(resultSet.getString("gender"));
				customerTemp.setMaritalStatus(resultSet.getString("marital_status"));
				customerTemp.setSocialSecurityNumber(resultSet.getString("social_security_number"));
				customerTemp.setNationality(resultSet.getString("nationality"));
				customerTemp.setPhoneNumber(resultSet.getString("phone_number"));
				customerTemp.setEmail(resultSet.getString("email"));
				customerTemp.setAddress(new Address(resultSet.getString("street"), resultSet.getString("city"), 
						resultSet.getString("state"), resultSet.getString("country"), resultSet.getString("zipcode")));
				customerTemp.setOccupation(resultSet.getString("occupation"));
				customerTemp.setYearlyIncome(resultSet.getBigDecimal("yearly_income"));
				customerTemp.setCreditScore(resultSet.getInt("credit_score"));
				customerTemp.setUserName(resultSet.getString("username"));
				customerTemp.setPassword(resultSet.getString("password"));
				customerList.add(customerTemp);
			}
		}
		return customerList;
	}
	
	@Override
	public List<Customer> getCustomerInformationByBankBranchId(int bankBranchId) throws ClassNotFoundException, SQLException, BankException {
		List<Customer> customerList = new ArrayList<>();
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT c.customer_id, first_name, last_name, date_of_birth, gender, "
					+ "marital_status, social_security_number, nationality, phone_number, email, "
					+ "street, city, state, country, zipcode, occupation, yearly_income, "
					+ "credit_score,username, password  "
					+ "FROM asya_bank.customer AS c "
					+ "JOIN asya_bank.customer_account AS ca "
					+ "ON c.customer_id = ca.customer_id "
					+ "WHERE ca.branch_id = ? ; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bankBranchId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customerTemp = new Customer();
				customerTemp.setCustomerId(resultSet.getInt("customer_id"));
				customerTemp.setFirstName(resultSet.getString("first_name"));
				customerTemp.setLastName(resultSet.getString("last_name"));
				customerTemp.setDateOfBirth(resultSet.getDate("date_of_birth"));
				customerTemp.setGender(resultSet.getString("gender"));
				customerTemp.setMaritalStatus(resultSet.getString("marital_status"));
				customerTemp.setSocialSecurityNumber(resultSet.getString("social_security_number"));
				customerTemp.setNationality(resultSet.getString("nationality"));
				customerTemp.setPhoneNumber(resultSet.getString("phone_number"));
				customerTemp.setEmail(resultSet.getString("email"));
				customerTemp.setAddress(new Address(resultSet.getString("street"), resultSet.getString("city"), 
						resultSet.getString("state"), resultSet.getString("country"), resultSet.getString("zipcode")));
				customerTemp.setOccupation(resultSet.getString("occupation"));
				customerTemp.setYearlyIncome(resultSet.getBigDecimal("yearly_income"));
				customerTemp.setCreditScore(resultSet.getInt("credit_score"));
				customerTemp.setUserName(resultSet.getString("username"));
				customerTemp.setPassword(resultSet.getString("password"));
				customerList.add(customerTemp);
			}
		}
		return customerList;
	}
	
	@Override
	public List<Customer> getAllCustomerByDateOfBirthRange(Date dateStart, Date dateEnd) throws ClassNotFoundException, SQLException {
		List<Customer> customerList = new ArrayList<>();
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT customer_id, first_name, last_name, date_of_birth,gender, "
					+ "marital_status, social_security_number, nationality, phone_number, email, "
					+ "street, city, state, country, zipcode, occupation, yearly_income, "
					+ "credit_score, username, password  "
					+ "FROM asya_bank.customer "
					+ "WHERE date_of_birth  BETWEEN ? AND ?; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, new java.sql.Date(dateStart.getTime()));
			preparedStatement.setDate(2, new java.sql.Date(dateEnd.getTime()));
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customerTemp = new Customer();
				customerTemp.setCustomerId(resultSet.getInt("customer_id"));
				customerTemp.setFirstName(resultSet.getString("first_name"));
				customerTemp.setLastName(resultSet.getString("last_name"));
				customerTemp.setDateOfBirth(resultSet.getDate("date_of_birth"));
				customerTemp.setGender(resultSet.getString("gender"));
				customerTemp.setMaritalStatus(resultSet.getString("marital_status"));
				customerTemp.setSocialSecurityNumber(resultSet.getString("social_security_number"));
				customerTemp.setNationality(resultSet.getString("nationality"));
				customerTemp.setPhoneNumber(resultSet.getString("phone_number"));
				customerTemp.setEmail(resultSet.getString("email"));
				customerTemp.setAddress(new Address(resultSet.getString("street"), resultSet.getString("city"), 
						resultSet.getString("state"), resultSet.getString("country"), resultSet.getString("zipcode")));
				customerTemp.setOccupation(resultSet.getString("occupation"));
				customerTemp.setYearlyIncome(resultSet.getBigDecimal("yearly_income"));
				customerTemp.setCreditScore(resultSet.getInt("credit_score"));
				customerTemp.setUserName(resultSet.getString("username"));
				customerTemp.setPassword(resultSet.getString("password"));
				
				customerList.add(customerTemp);
			}
		}
		return customerList;
	}

	@Override
	public CustomerAccount getCustomerAccountById(int customerId) throws ClassNotFoundException, SQLException, BankException {
		CustomerAccount customerAccount = null;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT customer_id, account_type, account_number, "
					+ "open_date, balance, branch_id, approving_employee_id "
					+ "FROM asya_bank.customer_account "
					+ "WHERE customer_id = ?; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				customerAccount = new CustomerAccount();
				customerAccount.setCustomerId(resultSet.getInt("customer_id"));
				customerAccount.setAccountType(resultSet.getString("account_type"));
				customerAccount.setAccountNumber(resultSet.getString("account_number"));
				customerAccount.setOpenDate(resultSet.getDate("open_date"));
				customerAccount.setBalance(resultSet.getBigDecimal("balance"));
				customerAccount.setBranchId(resultSet.getInt("branch_id"));
				customerAccount.setApprovingEmployeeId(resultSet.getInt("approving_employee_id"));
				
			}
		}
		return customerAccount;
	}
	
	@Override
	public CustomerAccount getCustomerAccountByAccountNumber(String accountNumber) throws ClassNotFoundException, SQLException, BankException {
		CustomerAccount customerAccount = null;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT customer_id, account_type, account_number, "
					+ "open_date, balance, branch_id, approving_employee_id "
					+ "FROM asya_bank.customer_account "
					+ "WHERE account_number = ?; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, accountNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				customerAccount = new CustomerAccount();
				customerAccount.setCustomerId(resultSet.getInt("customer_id"));
				customerAccount.setAccountType(resultSet.getString("account_type"));
				customerAccount.setAccountNumber(resultSet.getString("account_number"));
				customerAccount.setOpenDate(resultSet.getDate("open_date"));
				customerAccount.setBalance(resultSet.getBigDecimal("balance"));
				customerAccount.setBranchId(resultSet.getInt("branch_id"));
				customerAccount.setApprovingEmployeeId(resultSet.getInt("approving_employee_id"));
				
			}
		}
		return customerAccount;
	}
	
	@Override
	public List<CustomerAccount> getCustomerAccountByBankBranchId(int bankBranchId) throws ClassNotFoundException, SQLException {
		List<CustomerAccount> customerAccountList = new ArrayList<>();
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT customer_id, account_type, account_number, "
					+ "open_date, balance, branch_id, approving_employee_id "
					+ "FROM asya_bank.customer_account "
					+ "WHERE branch_id = ?; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bankBranchId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				CustomerAccount customerAccountTemp = new CustomerAccount();
				customerAccountTemp.setCustomerId(resultSet.getInt("customer_id"));
				customerAccountTemp.setAccountType(resultSet.getString("account_type"));
				customerAccountTemp.setAccountNumber(resultSet.getString("account_number"));
				customerAccountTemp.setOpenDate(resultSet.getDate("open_date"));
				customerAccountTemp.setBalance(resultSet.getBigDecimal("balance"));
				customerAccountTemp.setBranchId(resultSet.getInt("branch_id"));
				customerAccountTemp.setApprovingEmployeeId(resultSet.getInt("approving_employee_id"));
				customerAccountList.add(customerAccountTemp);
			}
		}
		return customerAccountList;
	}
	
	@Override
	public List<CustomerTransaction> getCustomerTransactionByCustomerId(int customerId) throws ClassNotFoundException, SQLException {
		List<CustomerTransaction> customerTransactionList = new ArrayList<>();
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT transaction_id, customer_id, transaction_time, transaction_type, "
					+ "transaction_amount, balance "
					+ "FROM asya_bank.customer_transaction "
					+ "WHERE customer_id = ?; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				CustomerTransaction customerTransactionTemp = new CustomerTransaction();
				customerTransactionTemp.setTransactionId(resultSet.getString("transaction_id"));
				customerTransactionTemp.setCustomerId(resultSet.getInt("customer_id"));
				customerTransactionTemp.setTransactionTime(resultSet.getTimestamp("transaction_time"));
				customerTransactionTemp.setTransactionType(resultSet.getString("transaction_type"));
				customerTransactionTemp.setTransactionAmount(resultSet.getBigDecimal("transaction_amount"));
				customerTransactionTemp.setBalance(resultSet.getBigDecimal("balance"));
				customerTransactionList.add(customerTransactionTemp);
			}
		}
		return customerTransactionList;
	}
	
	@Override
	public List<CustomerTransaction> getCustomerTransactionByAccountNumber(String accountNumber) throws ClassNotFoundException, SQLException {
		List<CustomerTransaction> customerTransactionList = new ArrayList<>();
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT transaction_id, ct.customer_id, transaction_time, transaction_type, "
					+ "transaction_amount, ct.balance "
					+ "FROM asya_bank.customer_transaction AS ct "
					+ "JOIN asya_bank.customer_account AS ca "
					+ "ON ct.customer_id = ca.customer_id "
					+ "WHERE account_number = ?; ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, accountNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				CustomerTransaction customerTransactionTemp = new CustomerTransaction();
				customerTransactionTemp.setTransactionId(resultSet.getString("transaction_id"));
				customerTransactionTemp.setCustomerId(resultSet.getInt("customer_id"));
				customerTransactionTemp.setTransactionTime(resultSet.getTimestamp("transaction_time"));
				customerTransactionTemp.setTransactionType(resultSet.getString("transaction_type"));
				customerTransactionTemp.setTransactionAmount(resultSet.getBigDecimal("transaction_amount"));
				customerTransactionTemp.setBalance(resultSet.getBigDecimal("balance"));
				customerTransactionList.add(customerTransactionTemp);
			}
		}
		return customerTransactionList;
	}
	
	@Override
	public List<CustomerTransaction> getAllCustomerTransactionByStartDate(Date date) throws ClassNotFoundException, SQLException {
		List<CustomerTransaction> customerTransactionList = new ArrayList<>();
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT transaction_id, customer_id, transaction_time, transaction_type, "
					+ "transaction_amount, balance "
					+ "FROM asya_bank.customer_transaction "
					+ "WHERE transaction_time  >= ?; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				CustomerTransaction customerTransactionTemp = new CustomerTransaction();
				customerTransactionTemp.setTransactionId(resultSet.getString("transaction_id"));
				customerTransactionTemp.setCustomerId(resultSet.getInt("customer_id"));
				customerTransactionTemp.setTransactionTime(resultSet.getTimestamp("transaction_time"));
				customerTransactionTemp.setTransactionType(resultSet.getString("transaction_type"));
				customerTransactionTemp.setTransactionAmount(resultSet.getBigDecimal("transaction_amount"));
				customerTransactionTemp.setBalance(resultSet.getBigDecimal("balance"));
				customerTransactionList.add(customerTransactionTemp);
			}
		}
		return customerTransactionList;
	}


	@Override
	public List<CustomerLoan> getAllCustomerLoanApplication() throws ClassNotFoundException, SQLException {
		List<CustomerLoan> allCustomerLoanList = new ArrayList<>();
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT loan_application_id, customer_id, loan_id, date_of_application, status, "
					+ "loan_amount, duration_year, approving_employee_id, total_payment_amount, monthly_payment_amount "
					+ "FROM asya_bank.customer_loan ;";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				CustomerLoan customerLoanTemp = new CustomerLoan();
				customerLoanTemp.setLoanApplicationId(resultSet.getString("loan_application_id"));
				customerLoanTemp.setCustomerId(resultSet.getInt("customer_id"));
				customerLoanTemp.setLoanId(resultSet.getInt("loan_id"));
				customerLoanTemp.setDateOfApplication(resultSet.getDate("date_of_application"));
				customerLoanTemp.setStatus(resultSet.getString("status"));
				customerLoanTemp.setLoanAmount(resultSet.getBigDecimal("loan_amount"));
				customerLoanTemp.setDurationYear(resultSet.getInt("duration_year"));
				customerLoanTemp.setApprovingEmployeeId(resultSet.getInt("approving_employee_id"));
				customerLoanTemp.setTotalPaymentAmount(resultSet.getBigDecimal("total_payment_amount"));
				customerLoanTemp.setMonthlyPaymentAmount(resultSet.getBigDecimal("monthly_payment_amount"));
				allCustomerLoanList.add(customerLoanTemp);
			}
		}
		return allCustomerLoanList;
	}	

}